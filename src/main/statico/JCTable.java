package main.statico;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
    * Clase que contiene las caracteristicas y funcionamientos de la Tabla
    * Utilizadas a lo largo del programa
    * @author CowsmonDev 22 - 23
    * @since 2.0
**/
public class JCTable extends JTable implements Generales {

    private final String[] listaTitulos;
    private final DefaultTableCellRenderer[] columnsRenderer;

    public JCTable(ArrayList<String[]> Lista, String[] listaTitulos, DefaultTableCellRenderer[] columnsRenderer){
        this.listaTitulos = listaTitulos;
        GestionEncabezado = getGestionEncabezado();
        modelo = new DefaultTableModel();
        this.columnsRenderer = columnsRenderer;
        filterDate(Lista);
    }

    public void filterDate(ArrayList<String[]> Lista) {

        //Datos
        if (Lista != null)
            modelo.setDataVector(getInformacion(Lista), listaTitulos);
        else modelo.setDataVector(new String[][]{}, listaTitulos);
        super.setModel(modelo);

        //Estilos
        setBackground(Color.WHITE);
        setOpaque(false);

        for (int i = 0; i < columnsRenderer.length; i++)
            getColumnModel().getColumn(i).setCellRenderer(columnsRenderer[i]);

        setRowHeight(25);//tamaño de las celdas
        setGridColor(new Color(0, 0, 0));

        JTableHeader jtableHeader = getTableHeader();
        jtableHeader.setDefaultRenderer(getGestionEncabezado());
        setTableHeader(jtableHeader);
    }

    /** {@code Procedimiento sin retorno} En este procedimiento se agregara una fila a la interfaz de la tabla
     *  @param valores String[] que contiene cada celda de la fila a agregar
     */
    public void addRow(String[] valores){
        modelo.addRow(valores);
    }


    /**
     * {@code Procedimiento sin retorno} En este procedimiento se eliminara una fila de la interfaz de la tabla
     * @param i este describe el numero de fila que se necesita eliminar
     */
    public void removeRow(int i){ modelo.removeRow(i); }

    /**
     * {@code Procedimiento sin retorno} En este procedimiento se eliminara la fila que esta seleccionada de la interfaz de tabla
     */
    public void removeSelectedRow(){ removeRow(getSelectedRow()); }

    /**
     * {@code Procedimiento sin retorno} En este procedimiento se agregara un menu el cual aparecera al hacer click derecho sobre la tabla.
     * @param Elementos este arreglo contiene los botones que estaran dentro del menu.
     */
    public void addJCPopupMenu(JLButtonGestoria[] Elementos){
        Menu = new JCPopupMenu(Elementos);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                if (evt.getButton() == 3) {
                    int row = rowAtPoint(evt.getPoint());
                    int column = columnAtPoint(evt.getPoint());
                    if (!isRowSelected(row))
                        changeSelection(row, column, false, false);
                    Menu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        });
    }

    /**
     * {@code Procedimiento sin retorno} En este procedimiento se ocultara el menu conceptual
     */
    public void JCPopupHide(){
        Menu.setVisible(false);
    }

    /**
     * {@code funcion con retorno} En esta funcion se obtendra los valores de la fila seleccionada
     * @return String[] que contiene los elementos de cada celda
     */
    public String[] getSelectedValueRow(){
        String[] SelectedValueRow = new String[listaTitulos.length];
        for (int i = 0; i < listaTitulos.length; i++)
            SelectedValueRow[i] = getColumnSelectedAt(i);
        return SelectedValueRow;
    }

    /**
     * {@code Procedimiento sin retorno} En este procedimiento se modificara las celdas de la fila seleccionada.
     * @param valores este parametro contendra los valores que se necesita que contenga la fila seleccionada
     */
    public void setSelectedValueRow(String[] valores){
        for (int i = 0; i < valores.length; i++)
            modelo.setValueAt(valores[i],getSelectedRow(), i);
    }

    /**
     * {@code funcion con retorno} en esta funcion se obtendra el valor una de las celas de la fila seleccionada
     * @param column int que contiene el indice de la celda a obtener
     */
    public String getColumnSelectedAt(int column){
        return modelo.getValueAt(getSelectedRow(), column).toString();
    }

    private static DefaultTableCellRenderer getGestionCeldas(boolean BFocused, Font font){
        return new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
                Color colorFondo = (focused && BFocused)? WhiteGreenON : WhiteGreen;
                this.setBackground((selected)? colorFondo : Color.WHITE);

                this.setHorizontalAlignment( JLabel.LEFT );
                this.setText(value.toString());

                this.setFont(font);
                return this;
            }
        };
    }

    private String[][] getInformacion(ArrayList<String[]> Lista){
        return Lista.toArray(new String[Lista.size()][listaTitulos.length]);
    }

    public static DefaultTableCellRenderer  getGestionTexto(){
        return (GestionTexto == null)? GestionTexto = getGestionCeldas(false, new Font( "Verdana", Font.PLAIN ,12 )) : GestionTexto;
    }

    public static DefaultTableCellRenderer  getGestionID(){
        return (GestionID == null)? GestionID = getGestionCeldas(false, new Font("Times New Roman", Font.BOLD, 12)) : GestionID;
    }

    public static DefaultTableCellRenderer  getGestionImportante(){
        return (GestionImportante == null)? GestionImportante = getGestionCeldas(false, new Font("Times New Roman", PLAIN, 12)) : GestionImportante;
    }

    public TableCellRenderer getGestionEncabezado(){
        return (GestionEncabezado == null)?
                GestionEncabezado = (table, value, isSelected, hasFocus, row, column) -> {
                    JLabel jcomponent = null;

                    if ( value instanceof String){
                        jcomponent = new JLabel((String) value);
                        jcomponent.setHorizontalAlignment(SwingConstants.CENTER);
                        jcomponent.setSize(30, jcomponent.getWidth());
                        jcomponent.setPreferredSize(new Dimension(6,jcomponent.getWidth()));
                    }

                    assert jcomponent != null;
                    jcomponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, WhiteGreen));
                    jcomponent.setOpaque(true);
                    jcomponent.setBackground(Green);
                    jcomponent.setForeground(Color.WHITE);

                    return jcomponent;
                }
                :
                GestionEncabezado;
    }


    private final DefaultTableModel modelo;

    private JCPopupMenu Menu;

    private static TableCellRenderer GestionEncabezado;

    private static DefaultTableCellRenderer GestionTexto;
    private static DefaultTableCellRenderer GestionImportante;
    private static DefaultTableCellRenderer GestionID;

    @Override
    public boolean isCellEditable(int row, int column) { return false; }

}