package main.vista.bancos;

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

public class JDBancos extends JDTabla {

    private final main.conexion.bancoConexion conn = main.conexion.bancoConexion.getInstance();;

    private final String[] Valores;

    public JDBancos(JFrame jf, String[] Valores) {
        super(jf, "Bancos", new Dimension(900, 620));
        this.Valores = Valores;
        initComponent();
    }

    private void initComponent(){
        conn.connopen();
        JTATable = new JCTable(conn.llenarTabla(Valores[0]), conn.getTitulosBancos(), new DefaultTableCellRenderer[]{
                JCTable.getGestionID(),
                JCTable.getGestionImportante(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto()
        });
        JBEditar = new JLButtonGestoria("Editar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBEditarMouseClicked();
            }
        };
        JBEditar.setBorder(null);
        JBEditar.setHorizontalAlignment(SwingConstants.CENTER);

        JBEliminar = new JLButtonGestoria("Eliminar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                "Cbu",
                "Banco",
                "Fecha De Cobro",
                "Dependencia",
                "Actividad",
                "Beneficio"
        });
        JCBusqueda.addItemListener(this::JCBusquedaItemListener);
        addJCtable(JTATable);
    }

    private void JBEditarMouseClicked(){

        if(JPBancos != null) JPPrincipal.remove(JPBancos);

        JPBancos = new main.vista.bancos.JDBancosEditar(
                Valores,
                JTATable,
                () -> CJPPrincipal.next(JPPrincipal)
        );

        JPPrincipal.add(JPBancos, "JPBancos");
        CJPPrincipal.next(JPPrincipal);
    }

    private void JBEliminarMouseClicked(){
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){
            conn.deleteDate(
                    Valores[0],
                    JTATable.getColumnSelectedAt(1),
                    JTATable.getColumnSelectedAt(4),
                    JTATable.getColumnSelectedAt(5)
            );
            JTATable.removeSelectedRow();
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    protected void JBAgregarMouseClicked() {
        if(JPBancos != null) JPPrincipal.remove(JPBancos);

        JPBancos = new main.vista.bancos.JDBancosGuardar(
                Valores,
                JTATable,
                () -> CJPPrincipal.next(JPPrincipal)
        );

        JPPrincipal.add(JPBancos, "JPGuardar");
        CJPPrincipal.next(JPPrincipal);
    }
    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }

    private void filterDate(String campo){
        JTATable.filterDate(
                conn.getFilterDate(getTextBusqueda(), campo, Valores[0])
        );
    }

    @Override
    protected void JTBusquedaKeyReleased(KeyEvent evt) {
        switch (Metodos.getItem(JCBusqueda)){
            case "Cbu" : filterDate(conn.getCbu());
            break;
            case "Banco" : filterDate(conn.getBanco());
            break;
            case "Fecha De Cobro" : filterDate(conn.getFechaCobro());
            break;
            case "Dependencia" : filterDate(conn.getDependencia());
            break;
            case "Actividad" : filterDate(conn.getActividad());
            break;
            case "Beneficio" : filterDate(conn.getBeneficios());
            break;
        }
    }

    private void JCBusquedaItemListener(ItemEvent evt){
        if(!getTextBusqueda().equals("")){
            setTextBusqueda("");
            JTATable.filterDate(conn.llenarTabla(Valores[0]));
        }
    }

    private JPBancos JPBancos;

    private JLButtonGestoria JBEditar;
    private JLButtonGestoria JBEliminar;

}
