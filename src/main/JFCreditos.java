package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

import main.statico.JLButtonGestoria;
import main.statico.JPanelFondo;
import main.statico.JTDesplegable;
import main.statico.Generales;

public class JFCreditos extends javax.swing.JFrame implements Generales {

    private int x,y;
    public JFCreditos(){
        setUndecorated(true);
        setSize(new Dimension(JFrameWidth,JFrameHeight));
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
        setBackground(new Color(149,168,149,240));
        initComponent();
    }


    //<editor-fold desc="@Generated Code">
    private void initComponent(){
        JPPrincipal = new JPanelFondo("/main/statico/img/fondo.png");
        JPPrincipal.setLayout(new BorderLayout());
        JPPrincipal.setOpaque(false);
        add(JPPrincipal, "JPPrincipal");

        JPNavBar = new JPanel();
        JPNavBar.setPreferredSize(new Dimension(JPPrincipal.getSize().width, 30));

        JPNavBar.setOpaque(false);
        JPNavBar.setBackground(DarkGreen);
        JPNavBar.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        JPNavBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                setLocation(getLocation().x + evt.getX() - x, getLocation().y + evt.getY() - y);
            }
        });
        JPNavBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                if (evt.getClickCount() == 2) {
                    setLocationRelativeTo(null);

                }
            }
        });

        JPConteinTitle = new JPanel();
        JPConteinTitle.setOpaque(false);
        JPConteinTitle.setLayout(null);

        JLCruz = new JLButtonGestoria("X") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                dispose();
            }
        };
        JLCruz.setBackGroundColor(Blue);
        JLCruz.setForeground(Color.WHITE);
        JLCruz.setBorderColor(Blue);
        JLCruz.setBackColorHover(BlueON);
        JLCruz.setBackColorPressed(new Color(237,149,20));

        JLMin = new JLButtonGestoria("-") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setState(ICONIFIED);
            }
        };
        JLMin.setBackGroundColor(Blue);
        JLMin.setForeground(Color.WHITE);
        JLMin.setBorderColor(Blue);
        JLMin.setBackColorHover(BlueON);
        JLMin.setBackColorPressed(new Color(237,149,20));


        GroupLayout GJPNavBar = new GroupLayout(JPNavBar);
        JPNavBar.setLayout(GJPNavBar);
        GJPNavBar.setHorizontalGroup(GJPNavBar.createSequentialGroup()
                .addComponent(JPConteinTitle, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(940)
                .addComponent(JLMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(JLCruz, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        );
        GJPNavBar.setVerticalGroup(GJPNavBar.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(JPConteinTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(JLMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(JLCruz, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        );

        JPTitle = new JPanel();
        JPTitle.setLocation(0,0);
        JPTitle.setSize(300,30);
        JPTitle.setOpaque(false);
        JPTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPTitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                JPClientes.setVisible(false);
                if (JPLateral.getX() >= 0) {
                    JPTimer = new JTDesplegable(10,10,0, -200 , JPLateral, null);
                    JPTimer.start();

                }else {
                    JPTimer = new JTDesplegable(10, 10,-200, 0, JPLateral, null);
                    JPTimer.start();
                }

            }
        });

        JLTitle = new JLabel("MetricPoint");
        JLTitle.setFont(new Font("Dialog", Font.BOLD, 16));
        JLTitle.setForeground(Color.WHITE);
        JLTitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                JPClientes.setVisible(false);
                if (JPLateral.getX() >= 0) {
                    JPTimer = new JTDesplegable(10,10,0, -200 , JPLateral, null);
                    JPTimer.start();

                }else {
                    JPTimer = new JTDesplegable(10, 10,-200, 0, JPLateral, null);
                    JPTimer.start();
                }

            }
        });

        GroupLayout GJPTitle = new GroupLayout(JPTitle);
        JPTitle.setLayout(GJPTitle);
        GJPTitle.setHorizontalGroup(GJPTitle.createSequentialGroup()
                .addGap(15)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );
        GJPTitle.setVerticalGroup(GJPTitle.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        );

        JPTitleC = new JPanel();
        JPTitleC.setBounds(0,0,200,30);
        JPTitleC.setBackground(Blue);


        JPConteinTitle.add(JPTitle);
        JPConteinTitle.add(JPTitleC);

        JPMiddle = new JPanel();
        JPMiddle.setLayout(null);
        JPMiddle.setOpaque(false);

        JPLateral = new JPLateral() {
            @Override
            protected void JBClientesMouseClicked(MouseEvent evt) {
                CJPMiddleDer.show(JPMiddleDer, "JPClientes");
            }

            @Override
            protected void JBEmpresasMouseClicked(MouseEvent evt) {
                CJPMiddleDer.show(JPMiddleDer, "JPEmpresas");
            }

            @Override
            protected void JBCreditosMouseClicked(MouseEvent evt) {
                CJPMiddleDer.show(JPMiddleDer, "JPCreditos");
            }

            @Override
            protected void JBVendedoresMouseClicked(MouseEvent evt) {
                CJPMiddleDer.show(JPMiddleDer, "JPVendedores");
            }
        };

        JPLateral.setBounds(-200, 0, 200, HeightMiddle);
        JPLateral.setBackground(new Color(0,71,151));

        JPMiddleDer = new JPanel();
        JPMiddleDer.setLocation(new Point(0,0));
        JPMiddleDer.setOpaque(false);
        JPMiddleDer.setSize(getSize().width, HeightMiddle);
        CJPMiddleDer = new CardLayout();
        JPMiddleDer.setLayout(CJPMiddleDer);

        JPClientes = new JPClientes(this);

        JPEmpresas = new JPEmpresas(this);

        JPCreditos = new JPCreditos(this);

        JPVendedores = new JPVendedores(this);

        JPMiddleDer.add(JPClientes,"JPClientes");
        JPMiddleDer.add(JPVendedores, "JPVendedores");
        JPMiddleDer.add(JPCreditos,"JPCreditos");
        JPMiddleDer.add(JPEmpresas, "JPEmpresas");


        JPMiddle.add(JPLateral);
        JPMiddle.add(JPMiddleDer);

        JPPrincipal.add(JPMiddle, BorderLayout.CENTER);
        JPPrincipal.add(JPNavBar, BorderLayout.NORTH);
    }
    //</editor-fold>

    public static void main(String[] args) {
       
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            JFCreditos JFCreditos = new JFCreditos(); JFCreditos.setVisible(true);
            //new JFLogin().setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCreditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    private JLabel JLTitle;
    private JLButtonGestoria JLCruz;
    private JLButtonGestoria JLMin;

    private JPanel JPTitleC;
    private JPanel JPConteinTitle;
    private JPanel JPTitle;

    private JPanel JPMiddle;
    private JPanel JPMiddleDer;
    private JPLateral JPLateral;
    private JPanel JPNavBar;
    private JPanelFondo JPPrincipal;

    private JPClientes JPClientes;
    private JPEmpresas JPEmpresas;
    private JPVendedores JPVendedores;
    private main.JPCreditos JPCreditos;


    private JTDesplegable JPTimer;

    private CardLayout CJPMiddleDer;
}

abstract class JPLateral extends JPanel implements Generales {

    public JPLateral(){
        initComponent();
    }

    private void setDesign(JLabel jl, Color color){
        jl.setBackground(color);
        jl.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(169,198,255)),
                BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        jl.setForeground(Color.WHITE);
        jl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jl.setFont(new Font("Dialog", java.awt.Font.PLAIN, 14));
        jl.setOpaque(true);
    }

    private void setDesign(JLabel jl){
        setDesign(jl, Blue);
    }

    private void setBackGround(Color Clientes, Color Empresas, Color Creditos, Color Vendedores){
        JBClientes.setBackground(Clientes);
        JBEmpresas.setBackground(Empresas);
        JBCreditos.setBackground(Creditos);
        JBVendedores.setBackground(Vendedores);
    }

    private void initComponent(){

        JBClientes = new JLabel("Clientes");
        setDesign(JBClientes, BlueON);
        JBClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                setBackGround(BlueON, Blue, Blue, Blue);
                JBClientesMouseClicked(evt);
            }
        });

        JBEmpresas = new JLabel("Empresas");
        setDesign(JBEmpresas);
        JBEmpresas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                setBackGround(Blue, BlueON, Blue, Blue);
                JBEmpresasMouseClicked(evt);
            }
        });

        JBCreditos = new JLabel("Creditos");
        setDesign(JBCreditos);
        JBCreditos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                setBackGround(Blue, Blue, BlueON, Blue);
                JBCreditosMouseClicked(evt);
            }
        });

        JBVendedores = new JLabel("Vendedores");
        setDesign(JBVendedores);
        JBVendedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                setBackGround(Blue, Blue, Blue, BlueON);
                JBVendedoresMouseClicked(evt);
            }
        });

        GroupLayout GJPLateral = new GroupLayout(this);
        setLayout(GJPLateral);
        GJPLateral.setHorizontalGroup(GJPLateral.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(JBClientes, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                .addComponent(JBEmpresas, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                .addComponent(JBCreditos, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                .addComponent(JBVendedores, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
        );
        GJPLateral.setVerticalGroup(GJPLateral.createSequentialGroup()
                .addComponent(JBClientes, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                .addComponent(JBEmpresas, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                .addComponent(JBCreditos, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                .addComponent(JBVendedores, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
        );

    }

    protected abstract void JBClientesMouseClicked(MouseEvent evt);
    protected abstract void JBEmpresasMouseClicked(MouseEvent evt);
    protected abstract void JBCreditosMouseClicked(MouseEvent evt);
    protected abstract void JBVendedoresMouseClicked(MouseEvent evt);

    private JLabel JBClientes;
    private JLabel JBEmpresas;
    private JLabel JBCreditos;
    private JLabel JBVendedores;

}