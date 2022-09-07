package main.vista.referencias;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Change;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;

public class JDReferenciasGuardar extends JPReferencias {

    public JDReferenciasGuardar(String[] Valores, JCTable JTATable, Change change) {
        super();
        initComponent(Valores, JTATable, change);
    }

    private void initComponent(String[] Valores,JCTable JTATable, Change change){
        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarMouseClicked(JTATable, Valores[0]);
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

    private void JBTerminarMouseClicked(JCTable JTATAble, String Dni) {
        if(conn.Comprobar(new String[][]{
                { conn.getNumDni(), Dni },
                { conn.getNombre(), JTNombre_ref.getText() }
        })){
            conn.insertDate(new String[]{
                    JLNum_dni.getText(),
                    JTNombre_ref.getText(),
                    JTTel_movil.getText(),
                    JTTel_fijo.getText()
            });

            JTATAble.addRow(new String[]{
                    JTNombre_ref.getText(),
                    JTTel_movil.getText(),
                    JTTel_fijo.getText()
            });

            JOptionPane.showMessageDialog(null, "Se han cargado los datos exitosamente");
            Enabled(false);

            JPFooter.next();
        }else JOptionPane.showMessageDialog(null, "Ese Registro ya se encuentra en la Base De Datos");
    }

    private void JBAgregarMouseClicked() {
        Enabled(true);

        JTNombre_ref.setText("");
        JTTel_movil.setText("");
        JTTel_fijo.setText("");

        JPFooter.next();
    }

    private void JBLimpiarMouseClicked() {
        JTNombre_ref.setText("");
        JTTel_movil.setText("");
        JTTel_fijo.setText("");
    }
}
