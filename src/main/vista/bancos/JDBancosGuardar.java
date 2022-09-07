package main.vista.bancos;

import main.statico.JCTable;
import main.statico.Metodos;
import main.creditos.vista.interfaces.Change;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;

class JDBancosGuardar extends JPBancos {

    public JDBancosGuardar(String[] Valores, JCTable JTATable, Change change) {
        super();
        initComponent(Valores,JTATable, change);
    }

    private void initComponent(String[] Valores,JCTable JTATable, Change change){
        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarBancoMouseClicked(JTATable, Valores[0]);
            }

            @Override
            public void Limpiar() {
                JBLimpiarMouseClicked();
            }

            @Override
            public void Cancelar() {
                change.change();
            }

            @Override
            public void Agregar() {
                JBAgregarMouseClicked();
            }
        });
        super.initComponent(Valores);
    }

    private void JBTerminarBancoMouseClicked(JCTable JTATable, String Dni) {
        if ((!(JTBanco.getText().equals(""))) && (!(JTBeneficios.getText().equals(""))) && (!(Metodos.getItem(JCActividad).equals("")))) {
            if(conn.Comprobar(new String[][]{
                    { conn.getBanco(), JTBanco.getText() },
                    { conn.getBeneficios(), JTBeneficios.getText() },
                    { conn.getActividad(), Metodos.getItem(JCActividad) },
                    { conn.getNumDni(), Dni }
            })){
                conn.insertDate(new String[]{
                        JLNum_dni.getText(),
                        JTCbu.getText(),
                        JTBanco.getText(),
                        JTFecha_cobro.getText(),
                        Metodos.getItem(JCDependencias),
                        Metodos.getItem(JCActividad),
                        JTBeneficios.getText()
                });

                JTATable.addRow(new String[]{
                        JTCbu.getText(),
                        JTBanco.getText(),
                        JTFecha_cobro.getText(),
                        Metodos.getItem(JCDependencias),
                        Metodos.getItem(JCActividad),
                        JTBeneficios.getText()
                });


                JOptionPane.showMessageDialog(null, "Se han cargado los datos exitosamente");

                Enabled(false);

                JPFooter.next();
            } else
                JOptionPane.showMessageDialog(null, "el nombre de banco, el beneficio o la actividad ya esta en la base de datos");
        } else JOptionPane.showMessageDialog(null, "La Casilla de banco, beneficios o actividad esta vacia");
    }

    private void JBAgregarMouseClicked() {
        Enabled(true);

        JTCbu.setText("");
        JTBanco.setText("");
        JTFecha_cobro.setText("");
        JTBeneficios.setText("");

        JPFooter.next();
    }

    private void JBLimpiarMouseClicked() {

    }

}
