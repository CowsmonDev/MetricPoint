package main.vista.vendedores;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Editar;

import javax.swing.*;

public class JDVendedoresEditar extends JDVendedores {

    public JDVendedoresEditar(JFrame jf, JCTable JTAVendedores) {
        super(jf);
        initComponent(JTAVendedores);
        llenarText(JTAVendedores.getSelectedValueRow());
    }

    private void initComponent(JCTable JTAVendedores){
        JPFooter = main.vista.JPFooter.getInstance(new Editar() {
            @Override
            public void Guardar() {
                JBGuardarMouseClicked(JTAVendedores);
            }

            @Override
            public void Cancelar() {
                JLCruzMouseClicked();
            }

            @Override
            public void VolverEditar() {
                JPFooter.next();
                Enabled(true);
            }

            @Override
            public void Salir() { JLCruzMouseClicked(); }
        });
        super.initComponent();
    }

    private void llenarText(String[] valores) {
        String[] NombreYApellido = valores[1].split(",");

        JTDni.setText(valores[0]);
        JTApellido.setText(NombreYApellido[0].trim());
        JTNombre.setText(NombreYApellido[1].trim());
        JTDomicilio.setText(valores[2]);
        JTTel_fijo.setText(valores[3]);
        JTTel_movil.setText(valores[4]);
        JTZona.setText(valores[5]);
    }

    private void JBGuardarMouseClicked(JCTable JTAVendedores) {
        if (!((JTDni.getText().equals("")) || (JTNombre.getText().equals("")))) {
            if (JTDni.getText().equals(JTAVendedores.getColumnSelectedAt(0)) || conn.Comprobar(conn.getDniVendedor(), JTDni.getText())){
                conn.updateDate(new String[]{
                        JTDni.getText(),
                        JTApellido.getText() + ", " + JTNombre.getText(),
                        JTDomicilio.getText(),
                        JTTel_fijo.getText(),
                        JTTel_movil.getText(),
                        JTZona.getText(),
                        JTAVendedores.getColumnSelectedAt(0)
                });

                JTAVendedores.setSelectedValueRow(new String[]{
                        JTDni.getText(),
                        JTApellido.getText() + ", " + JTNombre.getText(),
                        JTDomicilio.getText(),
                        JTTel_fijo.getText(),
                        JTTel_movil.getText(),
                        JTZona.getText()
                });

                JOptionPane.showMessageDialog(null, "Los Datos Se Han Actualizados exitosamente", "Mensaje", JOptionPane.PLAIN_MESSAGE);
                Enabled(false);
                JPFooter.next();

            } else JOptionPane.showMessageDialog(null, "Ese Numero de Dni ya existe en la base de datos");
        } else JOptionPane.showMessageDialog(null, "El Dni o el Nombre del vendedores estan vacios");
    }
}
