package main.vista.clientes;

import main.statico.JCTable;
import main.statico.Metodos;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;

public class JDClientesGuardar extends JDClientes {

    public JDClientesGuardar(JFrame jf, JCTable JTAClientes) {
        super(jf);
        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarMouseClicked(JTAClientes);
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

    protected void JBTerminarMouseClicked(JCTable JTAClientes) {
        if (!((JTNum_dni.getText().equals("")) || (JTNum_cuit.getText().equals("")))) {
            if (conn.Comprobar(conn.getNumDni(), JTNum_dni.getText())) {
                String[] valores = new String[]{
                        JTNum_dni.getText(),
                        (JTNum_cuit_izq.getText().equals("") || JTNum_cuit_der.getText().equals("")) ? JTNum_cuit.getText() : JTNum_cuit_izq.getText() + "-" + JTNum_cuit.getText() + "-" + JTNum_cuit_der.getText(),
                        JTNombre.getText(),
                        JTApellido.getText(),
                        Metodos.getDate(JRSFecha_nacimiento),
                        JTEstado_civil.getText(),
                        JTNacionalidad.getText(),
                        JTLocalidad.getText(),
                        JTCalle.getText(),
                        JTNumero_calle.getText(),
                        JTTel_fijo.getText(),
                        JTTel_movil.getText()
                };
                conn.insertDate(valores);
                JTAClientes.addRow(valores);

                JOptionPane.showMessageDialog(null, "Se Han Cargado los datos Correctamente");
                Enabled(false);
                JPFooter.next();
            } else
                JOptionPane.showMessageDialog(null, "Ese numero de dni ya esta ingresado en la base de datos... por favor ingrese otro");

        } else JOptionPane.showMessageDialog(null, "La Casilla de DNI o de Cuit esta vacia");
    }

    protected void JBAgregarMouseClicked() {
        JTNum_dni.setText("");
        JTNum_cuit_izq.setText("");
        JTNum_cuit.setText("");
        JTNum_cuit_der.setText("");
        JTNombre.setText("");
        JTApellido.setText("");
        JTEstado_civil.setText("");
        JTNacionalidad.setText("");
        JTLocalidad.setText("");
        JTCalle.setText("");
        JTNumero_calle.setText("");
        JTTel_fijo.setText("");
        JTTel_movil.setText("");
        JRSFecha_nacimiento.setDatoFecha(null);

        Enabled(true);

        JPFooter.next();
    }

    protected void JBLimpiarMouseClicked() {
        JTNum_dni.setText("");
        JTNum_cuit.setText("");
        JTNombre.setText("");
        JTApellido.setText("");
        JTEstado_civil.setText("");
        JTNacionalidad.setText("");
        JTLocalidad.setText("");
        JTCalle.setText("");
        JTNumero_calle.setText("");
        JTTel_fijo.setText("");
        JTTel_movil.setText("");
    }


}
