package main.vista.empresas;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Editar;

import javax.swing.*;

public class JDEmpresasEditar extends JDEmpresas {

    public JDEmpresasEditar(JFrame jf, JCTable JTAEmpresas) {
        super(jf);
        initComponent(JTAEmpresas);
        llenarText(JTAEmpresas.getSelectedValueRow());
    }

    private void initComponent(JCTable JTAEmpresas) {
        JPFooter = main.vista.JPFooter.getInstance(new Editar() {
            @Override
            public void Guardar() {
                JBGuardarMouseClicked(JTAEmpresas);
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
        JTEmpresa.setText(valores[0]);
        JTMayorista.setText(valores[1]);
        JTDomicilio_mayorista.setText(valores[2]);
        JTTelefono_mayorista.setText(valores[3]);
        JTComision_local.setText(valores[4]);
        JTComision_vendedor.setText(valores[5]);
    }

    private void JBGuardarMouseClicked(JCTable JTAEmpresas) {
        if (!((JTEmpresa.getText().equals("")) || (JTMayorista.getText().equals("")))) {
            if (
                    (JTEmpresa.getText().equals(JTAEmpresas.getColumnSelectedAt(0)) &&
                    (JTMayorista.getText().equals(JTAEmpresas.getColumnSelectedAt(1))))
                    ||
                    (conn.Comprobar(new String[][]{
                        { conn.getNombreEmpresa(), JTEmpresa.getText() },
                        { conn.getMayorista(), JTMayorista.getText() }
                    }))
            ){
                conn.updateDate(new String[]{
                        JTEmpresa.getText(),
                        JTMayorista.getText(),
                        JTDomicilio_mayorista.getText(),
                        JTTelefono_mayorista.getText(),
                        JTComision_local.getText(),
                        JTComision_vendedor.getText(),
                        JTAEmpresas.getColumnSelectedAt(0),
                        JTAEmpresas.getColumnSelectedAt(1)
                });
                JTAEmpresas.setSelectedValueRow(new String[]{
                        JTEmpresa.getText(),
                        JTMayorista.getText(),
                        JTDomicilio_mayorista.getText(),
                        JTTelefono_mayorista.getText(),
                        JTComision_local.getText(),
                        JTComision_vendedor.getText()
                });

                JOptionPane.showMessageDialog(null, "Datos Modificados Exitosamente", "Mensaje", JOptionPane.PLAIN_MESSAGE);
                Enabled(false);
                JPFooter.next();

            }

        } else
            JOptionPane.showMessageDialog(null, "El nombre de la Empresa o el Mayorista esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
    }

}
