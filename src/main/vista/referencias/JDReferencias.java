package main.vista.referencias;

import main.statico.JCTable;
import main.statico.JLButtonGestoria;
import main.statico.Metodos;
import main.statico.Generales;
import main.vista.JDTabla;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class JDReferencias extends JDTabla {

    private final main.conexion.referenciasConexion conn = main.conexion.referenciasConexion.getInstance();

    private final String[] Valores;

    public JDReferencias(JFrame jf, String[] Valores){
        super(jf, "Referencias", new Dimension(900,580));
        this.Valores = Valores;
        initComponent();
    }

    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }


    private void initComponent(){
        conn.connopen();
        JTATable = new JCTable(conn.llenarTabla(Valores[0]) , conn.getTitulosReferencias(), new DefaultTableCellRenderer[]{
                JCTable.getGestionID(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto()
        });
        JBEditar = new JLButtonGestoria("Editar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBEditarMouseClicked(Valores);
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
                "Nombre",
                "Telefono Movil",
                "Telefono Fijo"
        });
        JCBusqueda.addItemListener(this::JCBusquedaItemListener);

        addJCtable(JTATable);

    }


    @Override
    protected void JBAgregarMouseClicked() {
        if (JPReferencias != null) JPPrincipal.remove(JPReferencias);

        JPReferencias = new main.vista.referencias.JDReferenciasGuardar(
                Valores,
                JTATable,
                () -> CJPPrincipal.next(JPPrincipal)
        );

        JPPrincipal.add(JPReferencias, "JPReferencias");
        CJPPrincipal.next(JPPrincipal);
    }

    private void JBEditarMouseClicked(String[] Valores){
        if (JPReferencias != null) JPPrincipal.remove(JPReferencias);

        JPReferencias = new main.vista.referencias.JDReferenciasEditar(
                Valores,
                JTATable,
                () -> CJPPrincipal.next(JPPrincipal)
        );

        JPPrincipal.add(JPReferencias, "JPReferencias");

        CJPPrincipal.next(JPPrincipal);
    }

    private void JBEliminarMouseClicked(){
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){
            conn.deleteDate(
                    Valores[0],
                    JTATable.getColumnSelectedAt(0)
            );
            JTATable.removeSelectedRow();
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void filterDate(String campo){
        JTATable.filterDate(
                conn.getFilterDate(getTextBusqueda(), campo, Valores[0])
        );
    }

    @Override
    protected void JTBusquedaKeyReleased(KeyEvent evt) {
        switch (Metodos.getItem(JCBusqueda)){
            case "Nombre" : filterDate(conn.getNombre());
            break;
            case "Telefono Movil" : filterDate(conn.getTelMovil());
            break;
            case "Telefono Fijo" : filterDate(conn.getTelFijo());
            break;
        }
    }

    private void JCBusquedaItemListener(ItemEvent evt){
        if(!getTextBusqueda().equals("")){
            setTextBusqueda("");
            JTATable.filterDate(conn.llenarTabla(Valores[0]));
        }
    }

    private JPReferencias JPReferencias;

    private JLButtonGestoria JBEliminar;
    private JLButtonGestoria JBEditar;


}
