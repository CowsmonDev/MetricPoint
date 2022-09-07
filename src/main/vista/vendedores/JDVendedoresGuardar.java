package main.vista.vendedores;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Guardar;
import javax.swing.*;

public class JDVendedoresGuardar extends JDVendedores {

    public JDVendedoresGuardar(JFrame jf, JCTable JTAVendedores) {
        super(jf);
        initComponent(JTAVendedores);
    }

    private void initComponent(JCTable JTAVendedores){
        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarMouseClicked(JTAVendedores);
            }

            @Override
            public void Limpiar() {
                JBLimpiarMouseClicked();
            }

            @Override
            public void Cancelar() {
                JLCruzMouseClicked();
            }

            @Override
            public void Agregar() {
                JBAgregarMouseClicked();
            }
        });
        super.initComponent();
    }

    private void JBAgregarMouseClicked() {
        JTDni.setText("");
        JTNombre.setText("");
        JTApellido.setText("");
        JTDomicilio.setText("");
        JTTel_fijo.setText("");
        JTTel_movil.setText("");
        JTZona.setText("");

        Enabled(true);

        JPFooter.next();
    }

    private void JBTerminarMouseClicked(JCTable JTAVendedores) {
        if (!JTDni.getText().equals("")) {
            if (conn.Comprobar(conn.getDniVendedor(), JTDni.getText())) {
                String[] valores = new String[]{
                        JTDni.getText(),
                        JTApellido.getText() + ", " + JTNombre.getText(),
                        JTDomicilio.getText(),
                        JTTel_fijo.getText(),
                        JTTel_movil.getText(),
                        JTZona.getText()
                };
                conn.insertDate(valores);
                JOptionPane.showMessageDialog(null, "Se Han Cargado los datos Correctamente");

                Enabled(false);

                JTAVendedores.addRow(valores);
                JPFooter.next();
            } else JOptionPane.showMessageDialog(null, "Ese Numero de Dni ya existe en la base de datos");
        } else JOptionPane.showMessageDialog(null, "la casilla del DNI esta vacia");
    }

    private void JBLimpiarMouseClicked() {
        JTDni.setText("");
        JTNombre.setText("");
        JTApellido.setText("");
        JTDomicilio.setText("");
        JTTel_fijo.setText("");
        JTTel_movil.setText("");
        JTZona.setText("");
    }
}
