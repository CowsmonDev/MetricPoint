package main;

import main.statico.JCTable;
import main.conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class JPEmpresas extends JPCreditosPadre{
    private final main.conexion.empresaConexion conn = main.conexion.empresaConexion.getInstance();

    public JPEmpresas(JFrame jf){ initComponent(jf); }

    //<editor-fold desc="@Generated Code">
    protected void initComponent(JFrame jf){

        conn.connopen();

        JCSearch = new JComboBox<>(new String[]{
                conn.getTituloEmpresa(0),
                conn.getTituloEmpresa(1),
                conn.getTituloEmpresa(4),
                conn.getTituloEmpresa(5),
        });

        JTATable = new JCTable(conn.llenarTabla(), conn.getTitulosEmpresas(), new DefaultTableCellRenderer[]{
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto()
        });

        super.initComponent(jf,"Empresas");

    }
    //</editor-fold>

    @Override
    protected void JBAgregarMouseClicked(MouseEvent evt, JFrame jf) {
        new main.vista.empresas.JDEmpresasGuardar(jf, JTATable).setVisible(true);
    }

    @Override
    protected void JBEditarMouseClicked(MouseEvent evt, JFrame jf) {
        new main.vista.empresas.JDEmpresasEditar(jf, JTATable).setVisible(true);
    }

    @Override
    protected void JBEliminarMouseClicked() {
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0){// Pregunta si esta seguro de eliminar el registro
            conn.deleteDate(// Ejecutas el eliminado a la base de datos pasando el nombre de la empresa y mayorista como valor
                    JTATable.getColumnSelectedAt(0),
                    JTATable.getColumnSelectedAt(1)
            );
            JTATable.removeSelectedRow();
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    protected void JTSearchKeyReleased(KeyEvent evt) {
        switch (JCSearch.getSelectedIndex()){
            case 0 :
                filterDate(conn.getNombreEmpresa());
            break;
            case 1 :
                filterDate(conn.getMayorista());
            break;
            case 2 :
                filterDate(conn.getComisionLocal());
            break;
            case 3 :
                filterDate(conn.getComisionVendedores());
            break;
        }
    }

    @Override
    protected Conexion getConexion() {
        return conn;
    }
}
