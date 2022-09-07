package main.statico;

import placeholders.TextPrompt;
import rojeru_san.componentes.RSDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Metodos implements Generales {

    public static void setPropTitle(JLabel jl) {
        jl.setFont(JFLTitle);
        jl.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Green));
        jl.setHorizontalAlignment(0);
        jl.setVerticalAlignment(3);
        jl.setOpaque(false);
    }

    /**
     * {@code procedimiento sin retorno } que establece un formato y estilo determinado a un JLabel
     *
     * @param jl el label al que se le aplicara el estilo
     */
    public static void setDesignTitle(JLabel jl){
        jl.setOpaque(false);
        jl.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Green));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setFont(JFText);
    }

    public static String getDate(RSDateChooser jd) {
        return (jd.getDatoFecha() != null) ? Formato.format(jd.getDatoFecha()) : "";
    }

    public static <T> void setItem(T[] Elementos, JComboBox<T> jc){
        jc.removeAllItems();
        for (T Elemento : Elementos) jc.addItem(Elemento);
    }

    public static void setItemCombo(Map<String,String[]> datos, JComboBox<String> jc) {
        if (datos.size() != 0) {
            jc.removeAllItems();
            datos.forEach((k,v) -> jc.addItem(k));
        }
    }

    public static String getItem(JComboBox<String> jc) {
        return (jc.getSelectedItem() != null)? jc.getSelectedItem().toString() : "";
    }

    public static String[] ExistsDni(String Dni, ArrayList<String[]> Valor){
        for (String[] valor: Valor)
            if (Dni.equals(valor[0]))
                return new String[]{
                        valor[0],
                        valor[2] + ", " + valor[1],
                        valor[3]
                };

        JOptionPane.showMessageDialog(null, "Ese Numero De Dni no se encuentra en la Base De Datos...\nPor Favor Ingrese Uno Nuevo");
        return null;
    }

    public static JTextField getTextGestoria(String Texto){
        JTextField tx = new JTextField();
        tx.setFont(JFText);
        tx.setBorder(BorderFactory.createCompoundBorder(JBLabel, BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        tx.setBackground(Color.WHITE);
        tx.setOpaque(true);
        new TextPrompt(Texto, tx);
        return tx;
    }

    public static RSDateChooser getJRSDataChooser(String Texto){
        RSDateChooser rs = new RSDateChooser();
        rs.setColorBackground(Green);
        rs.setFormatoFecha("dd/MM/yyyy");
        rs.setColorButtonHover(WhiteGreen);
        rs.setColorForeground(DarkGreen);
        rs.setColorSelForeground(WhiteGreen);
        rs.setPlaceholder(Texto);
        rs.setFuente(JFText);
        return rs;
    }

    public static void setDatoFecha(RSDateChooser Fecha, String dato){
        int[] Date = Arrays.stream(dato.split("/")).mapToInt(Integer::parseInt).toArray();
        Calendar cd = Calendar.getInstance();
        cd.set(Date[2], Date[1] - 1, Date[0]);
        Fecha.setDatoFecha(cd.getTime());
    }

}
