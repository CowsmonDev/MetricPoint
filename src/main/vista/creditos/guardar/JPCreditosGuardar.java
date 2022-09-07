package main.vista.creditos.guardar;

import main.statico.JCTable;
import main.statico.Metodos;
import main.creditos.vista.creditos.JDCreditos;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;

public class JPCreditosGuardar extends JDCreditos {

    protected JPCreditosGuardar(JFrame jf) {
        super(jf);
    }

    protected void initComponent(JCTable JTACreditos, String[] Valores) {

        JLDni = new JLabel(Valores[0]);
        JLNombreYApellido = new JLabel(Valores[1]);
        JLFNacimiento = new JLabel(Valores[2]);

        JPFooter = main.vista.JPFooter.getInstance(new Guardar() {
            @Override
            public void Terminar() {
                JBTerminarMouseClicked(JTACreditos);
            }

            @Override
            public void Limpiar() {
                JBLimpiarMouseClicked();
            }

            @Override
            public void Cancelar() {
                CJPPrincipal.next(JPPrincipal);
                JPPrincipal.remove(JPCreditos);
                JPCreditos = null;
            }

            @Override
            public void Agregar() {
                JBAgregarCreditoMouseClicked();
            }
        });

        super.initComponent();
    }

    private void JBTerminarMouseClicked(JCTable JTACreditos) {
        if (!JTMonto.getText().equals("")) {
            String actividad = (!JCHActividad.isSelected() || JCActividad.getSelectedIndex() == -1) ?
                    Metodos.getItem(JCDependencias) :
                    Metodos.getItem(JCDependencias) + " - " + Metodos.getItem(JCActividad);

            if (conn.Comprobar(new String[][]{
                    { conn.getNumDni(), JLDni.getText() },
                    { conn.getFechaCredito(), Metodos.getDate(JRSDFechaCredito) },
                    { conn.getMayorista(), Metodos.getItem(JCMayorista) },
                    { conn.getMonto(), JTMonto.getText() },
                    { conn.getActividad(), actividad}
            })) {
                String[] nombreYApellido = JLNombreYApellido.getText().split(",");
                String[] valores = new String[]{
                        JLDni.getText(),
                        nombreYApellido[1].trim(),
                        nombreYApellido[0].trim(),
                        Metodos.getDate(JRSDFechaCredito),
                        Metodos.getItem(JCEmpresa) + " - " + Metodos.getItem(JCMayorista),
                        JTMonto.getText(),
                        actividad,
                        JTCantidadCuotas.getText(),
                        JTImporteCuota.getText(),
                        JTComisionLocal.getText(),
                        Metodos.getItem(JCVendedor),
                        JTComisionVendedor.getText(),
                        JTComisionTotal.getText()
                };
                conn.insertDate(valores);
                JTACreditos.addRow(valores);

                JOptionPane.showMessageDialog(null, "Se Han Cargado los datos Correctamente");
                setEditable(false);

                JPFooter.next();

            } else
                JOptionPane.showMessageDialog(null, "Este registro ya se encuentra en la base de datos, por favor cambie alguno de los siguientes datos:\n" +
                        "~ Mayorista\n" +
                        "~ Monto\n" +
                        "~ Fecha Del Credito\n" +
                        "~ Actividad / Dependencia");
        } else JOptionPane.showMessageDialog(null, "La casilla del Monto esta vacia");
    }

    private void JBLimpiarMouseClicked() {
        JTMonto.setText("");
        JTCantidadCuotas.setText("");
        JTImporteCuota.setText("");
        JTComisionLocal.setText("");
        JTComisionVendedor.setText("");
        JTComisionTotal.setText("");
        JCDependencias.setSelectedIndex(-1);
        JCActividad.setSelectedIndex(-1);
        JCEmpresa.setSelectedIndex(-1);
        JCMayorista.setSelectedIndex(-1);
        JCVendedor.setSelectedIndex(-1);
    }

    private void JBAgregarCreditoMouseClicked() {
        setEditable(true);

        JTMonto.setText("");
        JTCantidadCuotas.setText("");
        JTImporteCuota.setText("");
        JTComisionLocal.setText("");
        JTComisionVendedor.setText("");
        JTComisionTotal.setText("");
        JCDependencias.setSelectedIndex(-1);
        JCActividad.setSelectedIndex(-1);
        JCEmpresa.setSelectedIndex(-1);
        JCMayorista.setSelectedIndex(-1);
        JCVendedor.setSelectedIndex(-1);

        JPFooter.next();
    }

}
