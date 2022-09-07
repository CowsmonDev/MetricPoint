package main.vista.bancos;

import main.statico.JCTable;
import main.statico.Metodos;
import main.creditos.vista.interfaces.Change;
import main.creditos.vista.interfaces.Editar;

import javax.swing.*;

class JDBancosEditar extends JPBancos {

    public JDBancosEditar(String[] Valores, JCTable JTABancos, Change change) {
        super();
        initComponent(Valores, JTABancos, change);
    }


    private void initComponent(String[] Valores, JCTable JTABancos, Change change) {
        JPFooter = main.vista.JPFooter.getInstance(new Editar() {
            @Override
            public void Guardar() { JBGuardarMouseClicked(Valores[0], JTABancos); }

            @Override
            public void Cancelar() {
                change.change();
            }

            @Override
            public void VolverEditar() {
                Enabled(true);
                JPFooter.next();
            }

            @Override
            public void Salir() { change.change(); }
        });
        super.initComponent(Valores);

        llenarText(JTABancos.getSelectedValueRow());

    }

    protected void JBGuardarMouseClicked(String Dni, JCTable JTABancos) {
        if ((!(JTBanco.getText().equals(""))) && (!(JTBeneficios.getText().equals(""))) && (!(Metodos.getItem(JCActividad).equals("")))) {
            if(
                    ((JTBanco.getText().equals(JTABancos.getColumnSelectedAt(1)) &&
                    JTBeneficios.getText().equals(JTABancos.getColumnSelectedAt(5)) &&
                    Metodos.getItem(JCActividad).equals(JTABancos.getColumnSelectedAt(4))))
                    ||
                    conn.Comprobar(new String[][]{
                            { conn.getBanco(), JTBanco.getText() },
                            { conn.getBeneficios(), JTBeneficios.getText() },
                            { conn.getActividad(), Metodos.getItem(JCActividad) },
                            { conn.getNumDni(), Dni }
                    }))
            {
                conn.updateDate(new String[]{
                        JTCbu.getText(),
                        JTBanco.getText(),
                        JTFecha_cobro.getText(),
                        Metodos.getItem(JCDependencias),
                        Metodos.getItem(JCActividad),
                        JTBeneficios.getText(),
                        Dni,
                        JTBanco.getText(),
                        JTBeneficios.getText(),
                        Metodos.getItem(JCActividad)
                });

                JTABancos.setSelectedValueRow(new String[]{
                        JTCbu.getText(),
                        JTBanco.getText(),
                        JTFecha_cobro.getText(),
                        Metodos.getItem(JCDependencias),
                        Metodos.getItem(JCActividad),
                        JTBeneficios.getText(),
                });

                JOptionPane.showMessageDialog(null, "Se han modificado los datos exitosamente");
                Enabled(false);
                JPFooter.next();

            }else JOptionPane.showMessageDialog(null, "Ese Registro ya se encuentra en la Base De Datos");
        } else JOptionPane.showMessageDialog(null, "La Casilla de banco, beneficios o actividad esta vacia");
    }

    private void llenarText(String[] Valores){
        JTCbu.setText(Valores[0]);
        JTBanco.setText(Valores[1]);
        JTFecha_cobro.setText(Valores[2]);
        JCDependencias.setSelectedItem(Valores[3]);
        JCActividad.setSelectedItem(Valores[4]);
        JTBeneficios.setText(Valores[5]);
    }

}
