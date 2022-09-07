package main.statico;


import main.statico.Generales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

public abstract class JLButtonGestoria extends javax.swing.JLabel implements MouseListener, Generales {

    private Color BorderColor = Green;
    private Color BackGroundColor;
    private Color BackColorHover;
    private Color BackColorPressed;


    public JLButtonGestoria(String texto, Color BackGroundColor, Color BackColorHover, Color BackColorPressed){
        this.BackGroundColor = BackGroundColor;
        this.BackColorHover = BackColorHover;
        this.BackColorPressed = BackColorPressed;
        setText(texto);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(getBorderColor(), 2),
                BorderFactory.createEmptyBorder(0, 10, 0, 0)));

        setBackground(getBackGroundColor());

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(true);

        addMouseListener(this);
    }

    public JLButtonGestoria(String texto, String Icono){
        this(texto, WhiteGreen, WhiteGreenON, new Color(237,149,20));
        setIcon(new javax.swing.ImageIcon(getClass().getResource(Icono)));
    }

    public JLButtonGestoria(String texto){
        this(texto, WhiteGreen, WhiteGreenON, new Color(237,149,20));
    }

    @Override
    public void mouseEntered(MouseEvent evt){
        setBackground(getBackColorHover());
    }

    @Override
    public void mouseExited(MouseEvent evt){
        setBackground(getBackGroundColor());
    }

    @Override
    public void mouseReleased(MouseEvent evt){
        setBackground(getBackGroundColor());
    }

    @Override
    public void mousePressed(MouseEvent evt){
        setBackground(getBackColorPressed());
    }

    public void setBorderColor(Color BorderColor) {
        this.BorderColor = BorderColor;
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(getBorderColor(), 2),
                BorderFactory.createEmptyBorder(0, 10, 0, 0)));
    }


    public void setBackGroundColor(Color BackGroundColor) {
        super.setBackground(BackGroundColor);
        this.BackGroundColor = BackGroundColor;
    }

    public void setBackColorHover(Color BackColorHover) {
        this.BackColorHover = BackColorHover;
    }

    public void setBackColorPressed(Color BackColorPressed) {
        this.BackColorPressed = BackColorPressed;
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public Color getBackGroundColor() {
        return BackGroundColor;
    }

    public Color getBackColorHover() {
        return BackColorHover;
    }

    public Color getBackColorPressed() {
        return BackColorPressed;
    }
}
