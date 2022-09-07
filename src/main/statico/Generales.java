package main.statico;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

public interface Generales {
    SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
    Color DarkGreen = new Color(0,115,0);
    Color Green = new Color(0,128,0);
    Color WhiteGreen =  new Color(171,220,171);
    Color WhiteGreenON = new Color(141,190,141);
    Color Blue = new Color(0,71,151);
    Color BlueON = new Color(43,80,150);
    Color LightGray = new Color(220,220,220);
    Color LightGrayOn = new Color(200,200,200);
    Color BorderLightGray = new Color(180,180,180);

    Border JBLabel = BorderFactory.createLineBorder(Green, 2);
    Font JFLTitle = new Font("Dialog", BOLD, 20);
    Font JFLabel = new Font("Calibri", PLAIN, 16);
    Font JFText = new Font("Calibri", PLAIN, 14);
    int JTextLargo = 250;
    int JButtonLargo = 190;
    int JButtonAlto = 40;

    int JFrameWidth = 1300;
    int JFrameHeight = 700;

    int JPNavBarWidth = JFrameWidth;
    int JPNavBarHeight = 40;

    int HeightMiddle= JFrameHeight - JPNavBarHeight;
}
