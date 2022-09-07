package main.vista.referencias;

import main.statico.Metodos;
import main.statico.Generales;

import javax.swing.*;

public class JPReferencias extends JPanel implements Generales {

    protected final main.conexion.referenciasConexion conn = main.conexion.referenciasConexion.getInstance();

    protected JPReferencias() { }

    protected void initComponent(String[] Valores){
        //<editor-fold desc="JPPrincipal">

        conn.connopen();

        GroupLayout GJPPrincipal = new GroupLayout(this);
        setLayout(GJPPrincipal);
        //<editor-fold desc="Componentes Del JPPrincipal">
        JLTitle = new JLabel("Referencias Del Cliente");
        Metodos.setPropTitle(JLTitle);

        JLNum_dni = new JLabel(Valores[0]);
        JLNum_dni.setBorder(JBLabel);
        JLNum_dni.setFont(JFText);
        JLNum_dni.setBackground(WhiteGreen);
        JLNum_dni.setOpaque(true);
        JLNum_dni.setHorizontalAlignment(SwingConstants.CENTER);

        JLNombreYApellido = new JLabel(Valores[1]);
        JLNombreYApellido.setBorder(JBLabel);
        JLNombreYApellido.setFont(JFText);
        JLNombreYApellido.setBackground(WhiteGreen);
        JLNombreYApellido.setOpaque(true);
        JLNombreYApellido.setHorizontalAlignment(SwingConstants.CENTER);

        JLFecha_nacimiento = new JLabel(Valores[2]);
        JLFecha_nacimiento.setBorder(JBLabel);
        JLFecha_nacimiento.setFont(JFText);
        JLFecha_nacimiento.setBackground(WhiteGreen);
        JLFecha_nacimiento.setOpaque(true);
        JLFecha_nacimiento.setHorizontalAlignment(SwingConstants.CENTER);

        JLNombre_ref = new JLabel("Nombre Referencia");
        Metodos.setDesignTitle(JLNombre_ref);

        JLTel_movil = new JLabel("Telefono Movil");
        Metodos.setDesignTitle(JLTel_movil);

        JLTel_fijo = new JLabel("Telefojo Fijo");
        Metodos.setDesignTitle(JLTel_fijo);

        JTNombre_ref = Metodos.getTextGestoria("Agregar Nombre De Referencia");

        JTTel_movil = Metodos.getTextGestoria("Agregue el Telefono Movil");

        JTTel_fijo = Metodos.getTextGestoria("Agregue el Telefono Fijo");

        //</editor-fold>
        //<editor-fold desc="Posicionamiento Del JPPrincipal">
        GJPPrincipal.setHorizontalGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(300)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )

                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(45)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLNum_dni, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLNombre_ref, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNombre_ref, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLNombreYApellido, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTel_movil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTel_movil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLFecha_nacimiento, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTel_fijo, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTel_fijo, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                )
        );

        GJPPrincipal.setVerticalGroup(GJPPrincipal.createSequentialGroup()
                .addGap(30)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(55)

                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLNum_dni, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNombreYApellido, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLFecha_nacimiento, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(40)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLNombre_ref, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTel_movil, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTel_fijo, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTNombre_ref, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTTel_movil, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTTel_fijo, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )

                .addGap(110)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        );
    }

    protected void Enabled(boolean Bandera){
        JTNombre_ref.setEnabled(Bandera);
        JTTel_movil.setEnabled(Bandera);
        JTTel_fijo.setEnabled(Bandera);
    }

    protected main.vista.JPFooter JPFooter;
    protected JLabel JLTitle;

    private JLabel JLNombre_ref;
    private JLabel JLTel_movil;
    private JLabel JLTel_fijo;

    protected JTextField JTNombre_ref;
    protected JTextField JTTel_movil;
    protected JTextField JTTel_fijo;

    protected JLabel JLNum_dni;
    protected JLabel JLNombreYApellido;
    protected JLabel JLFecha_nacimiento;

}




