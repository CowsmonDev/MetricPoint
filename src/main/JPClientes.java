
package main;

import java.awt.*;

import static java.awt.Font.PLAIN;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import main.statico.JLButtonGestoria;
import main.statico.JCTable;
import main.statico.Generales;

public class JPClientes extends javax.swing.JPanel implements Generales {
    private final main.conexion.clientesConexion conn = main.conexion.clientesConexion.getInstance();

    public JPClientes(JFrame jf){ initComponent(jf); }

    //<editor-fold desc="@Generated Code">
    private void initComponent(JFrame jf){

        conn.connopen();

        setOpaque(false);
        GroupLayout GJPClientes = new GroupLayout(this);
        setLayout(GJPClientes);

        //<editor-fold desc="Elementos">

        JLTitle = new JLabel("Clientes");

        JLTitle.setFont(new Font("Dialog", PLAIN, 20));
        JLTitle.setForeground(DarkGreen);
        JLTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Green),
                BorderFactory.createEmptyBorder(0, 8, 0, 0)));

        JBAgregarCliente = new JLButtonGestoria("Agregar Cliente") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBAgregarClienteMouseClicked(evt, jf);
            }
        };

        JCSearch = new JComboBox<>(new String[]{
                conn.getTituloCliente(0),
                conn.getTituloCliente(1),
                conn.getTituloCliente(2),
                conn.getTituloCliente(3),
                conn.getTituloCliente(4),
                conn.getTituloCliente(5),
                conn.getTituloCliente(6),
                conn.getTituloCliente(7),
                conn.getTituloCliente(8),
                conn.getTituloCliente(9),
                conn.getTituloCliente(10),
                conn.getTituloCliente(11)
        });

        JCSearch.setBackground(WhiteGreen);
        JCSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JCSearch.addItemListener(this::JCSeachItemListener);

        JTSearch = new JTextField();
        JTSearch.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2,2,2,2,Green),
                BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        JTSearch.setOpaque(false);
        JTSearch.setFont(JFLabel);
        JTSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (JTSearch.getText().equals("")))
                    JTSeachKeyReleased(evt);
            }
        });

        //<editor-fold desc="Tabla y Elementos">

        JSTClientes = new JScrollPane();

        JTAClientes = new JCTable(conn.llenarTabla(), conn.getTitulosClientes(), new DefaultTableCellRenderer[]{
                JCTable.getGestionID(),
                JCTable.getGestionID(),
                JCTable.getGestionImportante(),
                JCTable.getGestionImportante(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto(),
                JCTable.getGestionTexto()
        });

        JBEditar = new JLButtonGestoria("Editar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBEditarMouseClicked(evt, jf);
            }
        };
        JBEditar.setBorder(BorderFactory.createMatteBorder(0,0,1,0, BorderLightGray));
        JBEditar.setHorizontalAlignment(SwingConstants.CENTER);

        JBDependencias = new JLButtonGestoria("Ver Datos Dependencia") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBDependenciasMouseClicked(jf);
            }
        };


        JBBancos = new JLButtonGestoria("Ver Datos Bancarios", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBBancosMouseClicked(evt, jf);
            }
        };
        JBBancos.setBorder(BorderFactory.createMatteBorder(0,0,1,0, BorderLightGray));
        JBBancos.setHorizontalAlignment(SwingConstants.CENTER);

        JBReferencias = new JLButtonGestoria("Ver Datos De Referencia", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBReferenciasMouseClicked(evt, jf);
            }
        };
        JBReferencias.setBorder(BorderFactory.createMatteBorder(0,0,1,0, BorderLightGray));
        JBReferencias.setHorizontalAlignment(SwingConstants.CENTER);

        JBEliminar = new JLButtonGestoria("Eliminar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JLEliminarMouseClicked();
            }
        };
        JBEliminar.setBorder(null);
        JBEliminar.setHorizontalAlignment(SwingConstants.CENTER);

        JTAClientes.addJCPopupMenu(new JLButtonGestoria[]{
                JBEditar,
                JBBancos,
                JBReferencias,
                JBEliminar
        });


        JSTClientes.setViewportView(JTAClientes);

        //</editor-fold>

        //<editor-fold desc="Posicionamiento de Elementos">
        GJPClientes.setHorizontalGroup(GJPClientes.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPClientes.createSequentialGroup()
                        .addContainerGap(10, 10)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPClientes.createSequentialGroup()
                        .addContainerGap(10, 10)
                        .addComponent(JBAgregarCliente, GroupLayout.PREFERRED_SIZE, JButtonLargo, GroupLayout.PREFERRED_SIZE)
                        .addGap(20)
                        .addComponent(JBDependencias, GroupLayout.PREFERRED_SIZE, JButtonLargo, GroupLayout.PREFERRED_SIZE)
                        .addGap(465)
                        .addComponent(JCSearch, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(JTSearch, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(JSTClientes, GroupLayout.PREFERRED_SIZE, JFrameWidth,GroupLayout.PREFERRED_SIZE)
        );
        GJPClientes.setVerticalGroup(GJPClientes.createSequentialGroup()
                .addGap(7)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addGroup(GJPClientes.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JBAgregarCliente, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBDependencias, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCSearch, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTSearch, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addComponent(JSTClientes, GroupLayout.PREFERRED_SIZE,570, GroupLayout.PREFERRED_SIZE)
        );
        //</editor-fold>

        //</editor-fold>

    }

    //</editor-fold>

    private void JBAgregarClienteMouseClicked(MouseEvent evt, JFrame jf){
        new main.vista.clientes.JDClientesGuardar(jf, JTAClientes).setVisible(true);
    }

    private void JBDependenciasMouseClicked(JFrame jf){
        new main.vista.dependencias.JDDependencias(jf).setVisible(true);
    }

    private void JBReferenciasMouseClicked(MouseEvent evt, JFrame jf){
        new main.vista.referencias.JDReferencias(
                jf,
                    new String[]{
                            JTAClientes.getColumnSelectedAt(0),
                            JTAClientes.getColumnSelectedAt(2),
                            JTAClientes.getColumnSelectedAt(4)
                    }
        ).setVisible(true);
    }

    private void JBBancosMouseClicked(MouseEvent evt, JFrame jf){
        new main.vista.bancos.JDBancos(
                jf,
                new String[]{
                        JTAClientes.getColumnSelectedAt(0),
                        JTAClientes.getColumnSelectedAt(3) + ", " + JTAClientes.getColumnSelectedAt(2),
                        JTAClientes.getColumnSelectedAt(4)
                }

        ).setVisible(true);
    }

    private void JBEditarMouseClicked(MouseEvent evt, JFrame jf){
        new main.vista.clientes.JDClientesEditar(jf, JTAClientes).setVisible(true);
    }

    /** {@code Procedimiento sin retorno} el cual ejecutara un eliminado a un registro de la base de datos */
    private void JLEliminarMouseClicked(){
        if (JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0) {
            conn.deleteDate(
                    JTAClientes.getValueAt(JTAClientes.getSelectedRow(), 0).toString()
            );
            JTAClientes.removeRow(JTAClientes.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void JCSeachItemListener(ItemEvent evt){
        if(!JTSearch.getText().equals("")){
            JTSearch.setText("");
            JTAClientes.filterDate(conn.llenarTabla());
        }
    }

    private void filterDate(String campo){
        JTAClientes.filterDate(
                conn.getFilterDate(JTSearch.getText(), campo)
        );
    }

    private void JTSeachKeyReleased(KeyEvent evt){
        switch (JCSearch.getSelectedIndex()){
            case 0 :
                filterDate(conn.getNumDni());
            break;
            case 1 :
                filterDate(conn.getNumCuit());
            break;
            case 2 :
                filterDate(conn.getNombre());
            break;
            case 3 :
                filterDate(conn.getApellido());
            break;
            case 4 :
                filterDate(conn.getFechaNacimiento());
            break;
            case 5 :
                filterDate(conn.getEstadoCivil());
            break;
            case 6 :
                filterDate(conn.getNacionalidad());
            break;
            case 7 :
                filterDate(conn.getLocalidad());
            break;
            case 8 :
                filterDate(conn.getCalle());
            break;
            case 9 :
                filterDate(conn.getNumCalle());
            break;
            case 10 :
                filterDate(conn.getTelFijo());
            break;
            case 11 :
                filterDate(conn.getTelMovil());
            break;
        }
    }

    private JLabel JLTitle;

    private JLButtonGestoria JBEditar;
    private JLButtonGestoria JBAgregarCliente;
    private JTextField JTSearch;
    
    private JComboBox<String> JCSearch;

    private JCTable JTAClientes;

    private JScrollPane JSTClientes;

    private JLButtonGestoria JBDependencias;
    private JLButtonGestoria JBEliminar;
    private JLButtonGestoria JBBancos;
    private JLButtonGestoria JBReferencias;

}
