package main.statico;

import javax.swing.*;
import java.awt.*;

public class JCPopupMenu extends javax.swing.JPopupMenu {

    Dimension dimension = new Dimension(150,30);

    public JCPopupMenu(){
        initComponent();
    }

    public JCPopupMenu(JLButtonGestoria[] Elementos){
        initComponent();
        for (JLButtonGestoria Elemento : Elementos){
            JPElemento = new JPanel();
            JPElemento.add(Elemento);
            addPanel(JPElemento);
        }

    }

    private void initComponent(){
        JPPrincipal = new JPanel();
        JPPrincipal.setLayout(new BoxLayout(JPPrincipal, BoxLayout.Y_AXIS));
        add(JPPrincipal);
    }


    public void addElement(JLButtonGestoria Elemento){
        JPElemento = new JPanel();
        JPElemento.add(Elemento);
        addPanel(JPElemento);

    }

    public void addPanel(JPanel JPElemento){
        JPElemento.setPreferredSize(dimension);
        JPElemento.setLayout(new CardLayout());
        JPPrincipal.add(JPElemento);
    }

    private JPanel JPPrincipal;
    private JPanel JPElemento;


}
