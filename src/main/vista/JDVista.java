package main.vista;

import main.statico.Generales;
import main.statico.JLButtonGestoria;

import javax.swing.*;
import java.awt.*;


public abstract class JDVista extends javax.swing.JDialog implements Generales {

    private int x,y;

    public JDVista(JFrame jf, Dimension size, String Title) {
        super(jf, true);
        setSize(size);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setBackground(new Color(255,255,255));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initComponent(Title, size);
    }

    private void initComponent(String Title, Dimension size){

        //<editor-fold desc="NavBar">

        JPNavBar = new JPanel();
        JPNavBar.setSize(size.width, 40);
        JPNavBar.setPreferredSize(new Dimension(size.width, 40));
        JPNavBar.setOpaque(false);
        JPNavBar.setBorder(BorderFactory.createMatteBorder(2,2,0,2, Green));
        JPNavBar.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        JPNavBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                setLocation(getLocation().x + evt.getX() - x, getLocation().y + evt.getY() - y);
            }
        });
        JPNavBar.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount() == 2)
                    setLocationRelativeTo(null);
            }
        });

        JLTitle = new JLabel(Title);

        JLTitle.setFont(new Font("Dialog", Font.PLAIN, 16));
        JLTitle.setOpaque(true);
        JLTitle.setBackground(Blue);
        JLTitle.setForeground(Color.WHITE);
        JLTitle.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0,0,2,2, Green),
                    BorderFactory.createEmptyBorder(0,15,0,0)
                )
        );
        JLTitle.setVerticalAlignment(SwingConstants.CENTER);

        JLCruz = new JLButtonGestoria("X") {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLCruzMouseClicked();
            }
        };

        GroupLayout GJPNaBar = new GroupLayout(JPNavBar);
        JPNavBar.setLayout(GJPNaBar);

        GJPNaBar.setHorizontalGroup(GJPNaBar.createSequentialGroup()
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap((size.width - 3) - (150 + 32))
                .addComponent(JLCruz, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        );
        GJPNaBar.setVerticalGroup(GJPNaBar.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addComponent(JLCruz, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        );

        // </editor-fold>

        //<editor-fold desc="JPPrincipal">

        JPPrincipal = new JPanel();
        JPPrincipal.setOpaque(true);
        JPPrincipal.setSize(new Dimension(900,540));
        JPPrincipal.setBorder(BorderFactory.createMatteBorder(0,2,2,2,Green));
        JPPrincipal.setLayout(CJPPrincipal);

        // </editor-fold>

        add(JPNavBar, BorderLayout.NORTH);
        add(JPPrincipal, BorderLayout.CENTER);

    }

    protected abstract void JLCruzMouseClicked();

    protected CardLayout CJPPrincipal = new CardLayout();

    private JPanel JPNavBar;

    protected JPanel JPPrincipal;

    private JLabel JLTitle;
    private JLButtonGestoria JLCruz;

}
