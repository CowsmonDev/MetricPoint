package main.vista.dependencias;

import main.statico.JCTable;
import main.statico.JLButtonGestoria;
import main.conexion.dependenciasConexion;
import main.statico.Generales;
import main.vista.JDTabla;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class JDDependencias extends JDTabla {

    private main.conexion.dependenciasConexion conn = dependenciasConexion.getInstance();

    public JDDependencias(JFrame jf) {
        super(jf,"Dependencias", new Dimension(900, 540));
        initComponent(jf);
    }

    private void initComponent(JFrame jf){
        JTATable = new JCTable(conn.llenarTabla(), conn.getTitulosDependencias(), new DefaultTableCellRenderer[]{
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto()
        });


        JBEditar = new JLButtonGestoria("Editar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBEditarMouseClicked(jf);
            }
        };
        JBEditar.setBorder(null);
        JBEditar.setHorizontalAlignment(SwingConstants.CENTER);

        JBEliminar = new JLButtonGestoria("Eliminar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBEliminarMouseClicked();
            }
        };
        JBEliminar.setBorder(null);
        JBEliminar.setHorizontalAlignment(SwingConstants.CENTER);

        JTATable.addJCPopupMenu(new JLButtonGestoria[]{
                JBEditar,
                JBEliminar

        });
        addElementCombo(new String[]{
                "Dependencias",
                "Actividad"
        });
        JCBusqueda.addItemListener(this::JCBusquedaItemListener);
        addJCtable(JTATable);

    }

    private void JBEliminarMouseClicked(){
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){
            conn.deleteDate(
                    JTATable.getColumnSelectedAt(0),
                    JTATable.getColumnSelectedAt(1)
            );
            JTATable.removeSelectedRow();
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    protected void JBAgregarMouseClicked() {
        if (JPDependencias != null) JPPrincipal.remove(JPDependencias);

        JPDependencias = new main.vista.dependencias.JDDependenciasGuardar(
                JTATable,
                () -> CJPPrincipal.next(JPPrincipal)
        );

        JPPrincipal.add( JPDependencias, "JPGuardar");
        CJPPrincipal.next(JPPrincipal);
    }

    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }

    private void filterDate(String campo){
        JTATable.filterDate(conn.getFilterDate(getTextBusqueda(), campo));
    }

    @Override
    protected void JTBusquedaKeyReleased(KeyEvent evt) {
        filterDate(
                (JCBusqueda.getSelectedIndex() == 1)? conn.getActividad() : conn.getDependencias()
        );
    }

    private void JBEditarMouseClicked(JFrame jf){
        if (JPDependencias != null) JPPrincipal.remove(JPDependencias);

        JPDependencias = new main.vista.dependencias.JDDependenciasEditar(
                () -> CJPPrincipal.next(JPPrincipal),
                JTATable
        );
        JTATable.JCPopupHide();

        JPPrincipal.add(JPDependencias, "JPDependencias");
        CJPPrincipal.next(JPPrincipal);
    }

    private void JCBusquedaItemListener(ItemEvent evt){
        if(!getTextBusqueda().equals("")){
            setTextBusqueda("");
            JTATable.filterDate(conn.llenarTabla());
        }
    }

    JPDependencias JPDependencias;

    private JLButtonGestoria JBEditar;
    private JLButtonGestoria JBEliminar;

}
