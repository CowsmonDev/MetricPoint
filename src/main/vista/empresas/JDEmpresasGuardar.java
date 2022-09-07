package main.vista.empresas;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;

public class JDEmpresasGuardar extends JDEmpresas {

    public JDEmpresasGuardar(JFrame jf, JCTable JTAEmpresas) {
        super(jf);
        initComponent(JTAEmpresas);
    }

    private void initComponent(JCTable JTAEmpresas){
        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarMouseClicked(JTAEmpresas);
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


    private void JBTerminarMouseClicked(JCTable JTAEmpresas) {
        if ((!JTEmpresa.getText().equals("")) && (!JTMayorista.getText().equals("")) && (!JTComision_local.getText().equals("")) && (!JTComision_vendedor.getText().equals(""))) {
            if (conn.Comprobar(new String[][]{
                    { conn.getNombreEmpresa(), JTEmpresa.getText() },
                    { conn.getMayorista(), JTMayorista.getText() }
            })) {
                String[] valores = new String[]{
                        JTEmpresa.getText(),
                        JTMayorista.getText(),
                        JTDomicilio_mayorista.getText(),
                        JTTelefono_mayorista.getText(),
                        JTComision_local.getText(),
                        JTComision_vendedor.getText()
                };
                conn.insertDate(valores);
                JTAEmpresas.addRow(valores);

                JOptionPane.showMessageDialog(null, "Se Han Cargado los datos Correctamente");
                Enabled(false);
                JPFooter.next();
            } else
                JOptionPane.showMessageDialog(null, "El Nombre De La Empresa y El Mayorista ya existe por favor ingrese otro");
        } else
            JOptionPane.showMessageDialog(null, "la casilla de empresa, mayorista, comision local o comision vendedor esta vacia");
    }

    private void JBAgregarMouseClicked() {
        JTEmpresa.setText("");
        JTMayorista.setText("");
        JTDomicilio_mayorista.setText("");
        JTTelefono_mayorista.setText("");
        JTComision_local.setText("");
        JTComision_vendedor.setText("");

        Enabled(true);

        JPFooter.next();
    }

    private void JBLimpiarMouseClicked() {
        JTEmpresa.setText("");
        JTMayorista.setText("");
        JTDomicilio_mayorista.setText("");
        JTTelefono_mayorista.setText("");
        JTComision_vendedor.setText("");
        JTComision_local.setText("");
    }
}
