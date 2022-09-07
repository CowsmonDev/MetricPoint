package main.vista;

import main.statico.JCTable;
import main.statico.JLButtonGestoria;
import main.statico.Metodos;
import main.statico.Generales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class JDTabla extends JDVista implements Generales {

    public JDTabla(JFrame jf, String Title, Dimension size){
        super(jf, size, Title);
        initComponent(jf);
    }

    private void initComponent(JFrame jf){

        JPTabla = new JPanel();

        JLTitle = new JLabel();

        JTBusqueda = Metodos.getTextGestoria("Ingrese Busqueda");
        JTBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (getTextBusqueda().equals("")))
                    JTBusquedaKeyReleased(evt);
            }
        });

        JCBusqueda = new JComboBox<>();

        JScroll = new JScrollPane();

        JBAgregar = new JLButtonGestoria("Agregar Nuevo Registro") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBAgregarMouseClicked();
            }
        };
        JBAgregar.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout GJPTabla = new GroupLayout(JPTabla);
        JPTabla.setLayout(GJPTabla);
        GJPTabla.setHorizontalGroup(GJPTabla.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPTabla.createSequentialGroup()
                        .addGap(250)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPTabla.createSequentialGroup()
                        .addGap(125)
                        .addComponent(JTBusqueda, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addGap(20)
                        .addComponent(JCBusqueda, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPTabla.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JScroll, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPTabla.createSequentialGroup()
                        .addGap(310)
                        .addComponent(JBAgregar, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                )
        );

        GJPTabla.setVerticalGroup(GJPTabla.createSequentialGroup()
                .addGap(10)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addGroup(GJPTabla.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTBusqueda, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCBusqueda, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20)
                .addComponent(JScroll, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(JBAgregar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
        );

        JPPrincipal.add(JPTabla, "JPTabla");

    }

    protected JPanel JPTabla;
    private JLabel JLTitle;
    private JTextField JTBusqueda;
    protected JComboBox<String> JCBusqueda;
    protected JCTable JTATable;
    private JScrollPane JScroll;
    protected JLButtonGestoria JBAgregar;

    protected void addPopupMenu(JLButtonGestoria[] botones){ JTATable.addJCPopupMenu(botones); }

    protected void addJCtable(JCTable JTATable){ JScroll.setViewportView(JTATable); }

    protected abstract void JBAgregarMouseClicked();

    protected void JTBusquedaKeyReleased(KeyEvent evt){

    }

    protected void addElementCombo(String[] Lista){
        for (String element : Lista)
            JCBusqueda.addItem(element);
    }

    protected String getTextBusqueda(){ return JTBusqueda.getText(); }
    protected void setTextBusqueda(String text){ JTBusqueda.setText(text); }

}
