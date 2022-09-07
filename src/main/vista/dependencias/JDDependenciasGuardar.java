package main.vista.dependencias;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Change;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;

class JDDependenciasGuardar extends JPDependencias{

    public JDDependenciasGuardar(JCTable JTADependencias, Change change) {
        super();
        initComponent(JTADependencias, change);
    }

    private void initComponent(JCTable JTADependencias, Change change){
        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarMouseClicked(JTADependencias);
            }

            @Override
            public void Limpiar() {
                JTActividad.setText("");
                JTDependencias.setText("");
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
        super.initComponent();
    }

    private void JBTerminarMouseClicked(JCTable JTADependencias) {
        if (!(JTActividad.getText().equals("")) && (!(JTDependencias.getText().equals("")))) {
            if (conn.Comprobar(
                    "SELECT " + conn.getCampos() + " FROM " + conn.getTabla() + " WHERE " + conn.getDependencias() + " = '" + JTDependencias.getText() + "' AND " + conn.getActividad() + " = '" + JTActividad.getText() + "'"
            )){
                String[] valores = new String[]{
                        JTDependencias.getText().trim(),
                        JTActividad.getText().trim()
                };
                conn.Comprobar(new String[]{
                        conn.getDependencias(),
                        conn.getActividad()
                }, new String[]{
                        JTDependencias.getText(),
                        JTActividad.getText()
                });

                conn.insertDate(valores);
                JTADependencias.addRow(valores);

                JOptionPane.showMessageDialog(null, "Se Han Cargado Los Datos Correctamente");
                Enabled(false);
                JPFooter.next();
            } else
                JOptionPane.showMessageDialog(null, "Esa actividad Ya esta ingresada en la base de datos,\n Por favor ingrese otra o verifique sus datos");
        }
    }

    private void JBAgregarMouseClicked() {
        JTDependencias.setText("");
        JTActividad.setText("");

        Enabled(true);

        JPFooter.next();
    }

}
