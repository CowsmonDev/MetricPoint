package main.vista.dependencias;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Change;
import main.creditos.vista.interfaces.Editar;
import javax.swing.*;

class JDDependenciasEditar extends JPDependencias {

    public JDDependenciasEditar(Change change, JCTable JTADependencias) {
        super();
        initComponent(JTADependencias, change);

        JTDependencias.setText(JTADependencias.getColumnSelectedAt(0));
        JTActividad.setText(JTADependencias.getColumnSelectedAt(1));
    }

    private void initComponent(JCTable JTADependencias, Change change){
        JPFooter = main.vista.JPFooter.getInstance(new Editar() {
            @Override
            public void Guardar() { JBGuardarMouseClicked(JTADependencias); }

            @Override
            public void Cancelar() {
                change.change();
            }

            @Override
            public void VolverEditar() {
                JPFooter.next();
                Enabled(true);
            }

            @Override
            public void Salir() {
                change.change();
            }
        });
        super.initComponent();
    }

    private void JBGuardarMouseClicked(JCTable JTADependencias){
        if(
                (JTDependencias.getText().equals(JTADependencias.getColumnSelectedAt(0)) &&
                        JTActividad.getText().equals(JTADependencias.getColumnSelectedAt(1))
                )
                ||
                (conn.Comprobar(new String[][]{
                        { conn.getDependencias(), JTDependencias.getText() },
                        { conn.getActividad(), JTActividad.getText() }
                }))
        ){
            conn.updateDate(new String[]{
                    JTDependencias.getText(),
                    JTActividad.getText(),
                    JTADependencias.getColumnSelectedAt(0),
                    JTADependencias.getColumnSelectedAt(1)
            });

            JTADependencias.setSelectedValueRow(new String[]{
                    JTDependencias.getText(),
                    JTActividad.getText()
            });

            JOptionPane.showMessageDialog(null, "Datos Modificados Exitosamente");
            Enabled(false);
            JPFooter.next();

        }else JOptionPane.showMessageDialog(null, "Ese Registro ya se encuentra en la Base De Datos");
    }
}
