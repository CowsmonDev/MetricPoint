package main.vista.creditos.editar;

import main.statico.JCTable;
import main.statico.Metodos;
import main.creditos.vista.creditos.JDCreditos;
import main.creditos.vista.interfaces.Editar;

import javax.swing.*;

public class JPCreditosEditar extends JDCreditos {

    public JPCreditosEditar(JFrame jf, JCTable JTACreditos) {
        super(jf);
        initComponent(JTACreditos);
    }


    private void initComponent(JCTable JTACreditos){

        JLDni = new JLabel(JTACreditos.getColumnSelectedAt(0));
        JLNombreYApellido = new JLabel(JTACreditos.getColumnSelectedAt(2) + ", " + JTACreditos.getColumnSelectedAt(1));
        JLFNacimiento = new JLabel(JTACreditos.getColumnSelectedAt(3));

        JPFooter = main.vista.JPFooter.getInstance(new Editar() {
            @Override
            public void Guardar() {
                JBGuardarMouseClicked(JTACreditos);
            }

            @Override
            public void Cancelar() { JLCruzMouseClicked(); }

            @Override
            public void VolverEditar() {
                setEditable(true);
                JPFooter.next();
            }

            @Override
            public void Salir() {
                JLCruzMouseClicked();
            }
        });

        super.initComponent();

        Metodos.setDatoFecha(JRSDFechaCredito, JTACreditos.getColumnSelectedAt(3));

        String[] EmpresaMayorista = JTACreditos.getColumnSelectedAt(4).split(" - ");
        JCEmpresa.setSelectedItem(EmpresaMayorista[0]);
        JCMayorista.setSelectedItem(EmpresaMayorista[1]);

        JTMonto.setText(JTACreditos.getColumnSelectedAt(5));

        if(JTACreditos.getColumnSelectedAt(6).contains(" - ")){
            String[] DependenciaActividad = JTACreditos.getColumnSelectedAt(6).split(" - ");
            JCDependencias.setSelectedItem(DependenciaActividad[0]);
            JCActividad.setSelectedItem(DependenciaActividad[1]);
        }else{
            JCDependencias.setSelectedItem(JTACreditos.getColumnSelectedAt(6));
            JCActividad.setSelectedItem(-1);
            JCHActividad.setSelected(false);
        }

        JTCantidadCuotas.setText(JTACreditos.getColumnSelectedAt(7));
        JTImporteCuota.setText(JTACreditos.getColumnSelectedAt(8));
        JTComisionLocal.setText(JTACreditos.getColumnSelectedAt(9));

        if(!JTACreditos.getColumnSelectedAt(10).equals(""))
            JCVendedor.setSelectedItem(JTACreditos.getColumnSelectedAt(10));
        else
            JCHVendedor.setSelected(false);

        JTComisionVendedor.setText(JTACreditos.getColumnSelectedAt(11));
        JTComisionTotal.setText(JTACreditos.getColumnSelectedAt(12));
    }

    private void JBGuardarMouseClicked(JCTable JTACreditos) {
        if (!JTMonto.getText().equals("")) {
            String actividad = (!JCHActividad.isSelected() || JCActividad.getSelectedIndex() == -1) ?
                    Metodos.getItem(JCDependencias) :
                    Metodos.getItem(JCDependencias) + " - " + Metodos.getItem(JCActividad);

            if (
                    (Metodos.getDate(JRSDFechaCredito).equals(JTACreditos.getColumnSelectedAt(3)) &&
                    Metodos.getItem(JCMayorista).equals(JTACreditos.getColumnSelectedAt(4)) &&
                    JTMonto.getText().equals(JTACreditos.getColumnSelectedAt(5)) &&
                    actividad.equals(JTACreditos.getColumnSelectedAt(6))
                    )
                    ||
                    (conn.Comprobar(new String[][]{
                    { conn.getNumDni(), JLDni.getText() },
                    { conn.getFechaCredito(), Metodos.getDate(JRSDFechaCredito) },
                    { conn.getMayorista(), Metodos.getItem(JCMayorista) },
                    { conn.getMonto(), JTMonto.getText() },
                    { conn.getActividad(), actividad }
                    }))
            ) {

                conn.updateDate(new String[]{
                        Metodos.getDate(JRSDFechaCredito),
                        Metodos.getItem(JCEmpresa) + " - " + Metodos.getItem(JCMayorista),
                        JTMonto.getText(),
                        actividad,
                        JTCantidadCuotas.getText(),
                        JTImporteCuota.getText(),
                        JTComisionLocal.getText(),
                        Metodos.getItem(JCVendedor),
                        JTComisionVendedor.getText(),
                        JTComisionTotal.getText(),
                        JTACreditos.getColumnSelectedAt(0),
                        JTACreditos.getColumnSelectedAt(3),
                        JTACreditos.getColumnSelectedAt(4),
                        JTACreditos.getColumnSelectedAt(5),
                        JTACreditos.getColumnSelectedAt(6),
                });

                JTACreditos.setSelectedValueRow(new String[]{
                        JTACreditos.getColumnSelectedAt(0),
                        JTACreditos.getColumnSelectedAt(1),
                        JTACreditos.getColumnSelectedAt(2),
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

                });

                JOptionPane.showMessageDialog(null, "Se Han Cargado los datos Correctamente");
                setEditable(false);
                JPFooter.next();

            } else
                JOptionPane.showMessageDialog(null, "Este registro ya se encuentra en la base de datos, por favor cambie alguno de los siguientes datos:\n" +
                        "~ Mayorista\n" +
                        "~ Fecha Del Credito\n" +
                        "~ Actividad / Dependencia");
        } else JOptionPane.showMessageDialog(null, "La casilla del Monto esta vacia");
    }

}
