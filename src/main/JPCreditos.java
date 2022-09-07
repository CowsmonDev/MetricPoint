package main;

import main.statico.JCTable;
import main.conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class JPCreditos extends JPCreditosPadre {

    private final main.conexion.creditoConexion conn = main.conexion.creditoConexion.getInstance();

    public JPCreditos(JFrame jf){ initComponent(jf); }

    //<editor-fold desc="@Generated Code">
    private void initComponent(JFrame jf) {

        conn.connopen();

        JCSearch = new JComboBox<>(new String[]{
                conn.getTituloCredito(0),
                conn.getTituloCredito(1),
                conn.getTituloCredito(2),
                conn.getTituloCredito(3),
                conn.getTituloCredito(4),
                conn.getTituloCredito(5),
                conn.getTituloCredito(6),
                conn.getTituloCredito(10),
        });

        JTATable = new JCTable(conn.llenarTabla(), conn.getTitulosCreditos(), new DefaultTableCellRenderer[]{
                JCTable.getGestionID(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionImportante(),
                JCTable.getGestionTexto(),
                JCTable.getGestionImportante(),
                JCTable.getGestionImportante()
        });

        super.initComponent(jf,"Creditos");

    }
    //</editor-fold>

    @Override
    protected void JBAgregarMouseClicked(MouseEvent evt, JFrame jf) {
        new main.vista.creditos.guardar.JPCreditosClientes(jf, JTATable).setVisible(true);
    }

    @Override
    protected void JBEditarMouseClicked(MouseEvent evt, JFrame jf) {
        new main.vista.creditos.editar.JPCreditosEditar(jf, JTATable).setVisible(true);
    }

    @Override
    protected void JBEliminarMouseClicked() {
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){//Pregunta si esta seguro de eliminar el registro
            conn.deleteDate( //Ejecuta el Eliminado a la base de datos pasando valores necesarios
                    JTATable.getColumnSelectedAt(0),
                    JTATable.getColumnSelectedAt(3),
                    JTATable.getColumnSelectedAt(4),
                    JTATable.getColumnSelectedAt(5),
                    JTATable.getColumnSelectedAt(6)
            );
            JTATable.removeSelectedRow();
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    protected void JTSearchKeyReleased(KeyEvent evt) {
        switch(JCSearch.getSelectedIndex()){
            case 0 :
                filterDate(conn.getNumDni());
            break;
            case 1 :
                filterDate(conn.getNombre());
            break;
            case 2 :
                filterDate(conn.getApellido());
            break;
            case 3 :
                filterDate(conn.getFechaCredito());
            break;
            case 4 :
                filterDate(conn.getMayorista());
            break;
            case 5 :
                filterDate(conn.getMonto());
            break;
            case 6 :
                filterDate(conn.getActividad());
            break;
            case 7 :
                filterDate(conn.getVendedor());
            break;
        }
    }

    @Override
    protected Conexion getConexion() { return conn; }

}
