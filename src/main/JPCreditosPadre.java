package main;

import main.statico.JCTable;
import main.statico.JLButtonGestoria;
import main.conexion.Conexion;
import main.statico.Generales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.Font.PLAIN;

public abstract class JPCreditosPadre extends javax.swing.JPanel implements main.statico.Generales{

    protected JPCreditosPadre(){};

    //<editor-fold desc="@Generated Code">
    protected void initComponent(JFrame jf, String Titulo){

        setOpaque(false);
        GroupLayout GJPCreditosPadre = new GroupLayout(this);
        setLayout(GJPCreditosPadre);

        //<editor-fold desc="Elementos">

        JLTitle = new JLabel(Titulo);

        JLTitle.setFont(new Font("Dialog", PLAIN, 20));
        JLTitle.setForeground(DarkGreen);
        JLTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Green),
                BorderFactory.createEmptyBorder(0, 8, 0, 0)));

        JBAgregar = new JLButtonGestoria("Agregar " + Titulo) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBAgregarMouseClicked(evt, jf);
            }
        };

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
                    JTSearchKeyReleased(evt);
            }
        });

        //<editor-fold desc="Tabla y Elementos">

        JSTable = new JScrollPane();

        JBEditar = new JLButtonGestoria("Editar", Generales.LightGray, Generales.WhiteGreen, Generales.WhiteGreenON) {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBEditarMouseClicked(evt, jf);
            }
        };
        JBEditar.setBorder(BorderFactory.createMatteBorder(0,0,1,0, BorderLightGray));
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


        JSTable.setViewportView(JTATable);

        //</editor-fold>

        //<editor-fold desc="Posicionamiento de Elementos">
        GJPCreditosPadre.setHorizontalGroup(GJPCreditosPadre.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPCreditosPadre.createSequentialGroup()
                        .addContainerGap(10, 10)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPCreditosPadre.createSequentialGroup()
                        .addContainerGap(10, 10)
                        .addComponent(JBAgregar, GroupLayout.PREFERRED_SIZE, JButtonLargo, GroupLayout.PREFERRED_SIZE)
                        .addGap(675)
                        .addComponent(JCSearch, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(JTSearch, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(JSTable, GroupLayout.PREFERRED_SIZE, JFrameWidth,GroupLayout.PREFERRED_SIZE)
        );
        GJPCreditosPadre.setVerticalGroup(GJPCreditosPadre.createSequentialGroup()
                .addGap(7)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addGroup(GJPCreditosPadre.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JBAgregar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCSearch, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTSearch, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addComponent(JSTable, GroupLayout.PREFERRED_SIZE,570, GroupLayout.PREFERRED_SIZE)
        );
        //</editor-fold>

        //</editor-fold>

    }



    //</editor-fold>

    private void JCSeachItemListener(ItemEvent evt){
        if(!JTSearch.getText().equals("")){
            JTSearch.setText("");
            JTATable.filterDate(getConexion().llenarTabla());
        }
    }

    protected void filterDate(String campo){
        JTATable.filterDate(
                getConexion().getFilterDate(getText(), campo)
        );
    }


    protected abstract void JBAgregarMouseClicked(MouseEvent evt, JFrame jf);
    protected abstract void JBEditarMouseClicked(MouseEvent evt, JFrame jf);

    /** {@code Procedimiento sin retorno} el cual Ejecutara un eliminado a un registro de la base de datos */
    protected abstract void JBEliminarMouseClicked();

    protected abstract void JTSearchKeyReleased(KeyEvent evt);
    protected abstract Conexion getConexion();

    protected String getText(){ return JTSearch.getText(); }
    protected void setText(String text){ JTSearch.setText(text); }

    private JLabel JLTitle;

    private JLButtonGestoria JBAgregar;
    private JTextField JTSearch;



    private JScrollPane JSTable;

    private JLButtonGestoria JBEditar;
    private JLButtonGestoria JBEliminar;

    protected JComboBox<String> JCSearch;
    protected JCTable JTATable;

}
