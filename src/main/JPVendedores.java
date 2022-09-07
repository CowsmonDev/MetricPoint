
package main;

import main.statico.JCTable;
import main.conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class JPVendedores extends JPCreditosPadre {
    private final main.conexion.vendedorConexion conn = main.conexion.vendedorConexion.getInstance();

    public JPVendedores(JFrame jf){ initComponent(jf); }

    //<editor-fold desc="@Generated Code">
    private void initComponent(JFrame jf){

        conn.connopen();

        JCSearch = new JComboBox<>(new String[]{
                conn.getTituloVendedor(0),
                conn.getTituloVendedor(1),
                conn.getTituloVendedor(5)
        });

        JTATable = new JCTable(conn.llenarTabla(), conn.getTitulosVendedores(), new DefaultTableCellRenderer[]{
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto()
        });

        super.initComponent(jf, "Vendedores");

    }

    //</editor-fold>

    @Override
    protected void JBAgregarMouseClicked(MouseEvent evt, JFrame jf) {
        new main.vista.vendedores.JDVendedoresGuardar(jf, JTATable).setVisible(true);
    }

    @Override
    protected void JBEditarMouseClicked(MouseEvent evt, JFrame jf) {
        new main.vista.vendedores.JDVendedoresEditar(jf, JTATable).setVisible(true);
    }

    @Override
    protected void JBEliminarMouseClicked() {
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){ //Pregunta si esta seguro de eliminar el registro

            conn.deleteDate( //Ejecuta el Eliminado a la base de datos pasando el Dni como valor
                    JTATable.getColumnSelectedAt(0)
            );
            JTATable.removeSelectedRow();
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    protected void JTSearchKeyReleased(KeyEvent evt) {
        switch (JCSearch.getSelectedIndex()){
            case 0 :
                filterDate(conn.getDniVendedor());
            break;
            case 1 :
                filterDate(conn.getNombreApellido());
            break;
            case 2 :
                filterDate(conn.getZonaTrabajo());
            break;
        }
    }

    @Override
    protected Conexion getConexion() {
        return conn;
    }



}