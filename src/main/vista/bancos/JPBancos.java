package main.vista.bancos;

import main.statico.Metodos;
import main.statico.Generales;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class JPBancos extends JPanel implements Generales {

    protected ArrayList<String> ADependencias = new ArrayList<>();

    protected main.conexion.bancoConexion conn = main.conexion.bancoConexion.getInstance();

    protected JPBancos() { }

    protected void initComponent(String[] Valores){

        conn.connopen();

        JLTitle = new JLabel("Datos Bancarios");
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

        JLCbu = new JLabel("CBU");
        Metodos.setDesignTitle(JLCbu);

        JLBanco = new JLabel("Banco");
        Metodos.setDesignTitle(JLBanco);

        JLBeneficio = new JLabel("Beneficios");
        Metodos.setDesignTitle(JLBeneficio);

        JLDependencias = new JLabel("Dependencias");
        Metodos.setDesignTitle(JLDependencias);

        JLActividad = new JLabel("Actividad");
        Metodos.setDesignTitle(JLActividad);

        JLFecha_cobro = new JLabel("Fecha De Cobro");
        Metodos.setDesignTitle(JLFecha_cobro);

        JTCbu = Metodos.getTextGestoria("Ingrese El Cbu Del Cliente");

        JTBanco = Metodos.getTextGestoria("Ingrese El Nombre Del Banco");

        JTBeneficios = Metodos.getTextGestoria("Ingrese el Beneficio Del CLiente");

        JCDependencias = new JComboBox<>(conn.llenarArray("SELECT DISTINCT dependencia FROM dependencias","dependencia"));
        JCDependencias.addItemListener(this::JCDependenciasItemStateChanged);

        JCActividad = new JComboBox<>(conn.llenarArray( "SELECT DISTINCT actividad FROM dependencias WHERE dependencia = '" + Metodos.getItem(JCDependencias) + "'", conn.getActividad()));

        JTFecha_cobro = Metodos.getTextGestoria("Ingrese La Fecha De Cobro");

        //</editor-fold>

        GroupLayout GJPPrincipal = new GroupLayout(this);
        setLayout(GJPPrincipal);
        //<editor-fold desc="Posicionamiento Del JPBanco">

        GJPPrincipal.setHorizontalGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)

                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(300)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )

                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(45)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLNum_dni, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLCbu, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTCbu, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLBeneficio, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTBeneficios, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLNombreYApellido, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLBanco, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTBanco, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLDependencias, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCDependencias, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLFecha_nacimiento, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLFecha_cobro, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFecha_cobro, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLActividad, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCActividad, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)

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
                .addGap(30)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLCbu, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLBanco, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLFecha_cobro, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTCbu, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTBanco, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTFecha_cobro, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLDependencias, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLBeneficio, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLActividad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JCDependencias, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTBeneficios, GroupLayout.PREFERRED_SIZE,JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCActividad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(80)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)

        );

        //</editor-fold>

        //</editor-fold>

    }

    private void JCDependenciasItemStateChanged(ItemEvent evt) {
        Metodos.setItem(
                conn.llenarArray("SELECT DISTINCT " + conn.getActividad() + " FROM dependencias WHERE " + conn.getDependencia() + " = '" + Metodos.getItem(JCDependencias) + "'", conn.getActividad())
                , JCActividad
        );
    }

    protected void Enabled(Boolean bandera){
        JTCbu.setEditable(bandera);
        JTBanco.setEditable(bandera);
        JTFecha_cobro.setEditable(bandera);
        JCDependencias.setEnabled(bandera);
        JCActividad.setEnabled(bandera);
        JTBeneficios.setEditable(bandera);
    }


    protected main.vista.JPFooter JPFooter;

    protected JLabel JLTitle;
    protected JLabel JLNum_dni;
    protected JLabel JLNombreYApellido;
    protected JLabel JLFecha_nacimiento;

    private JLabel JLCbu;
    private JLabel JLBanco;
    private JLabel JLBeneficio;
    private JLabel JLDependencias;
    private JLabel JLActividad;
    private JLabel JLFecha_cobro;

    protected JTextField JTCbu;
    protected JTextField JTBanco;
    protected JTextField JTBeneficios;
    protected JTextField JTFecha_cobro;

    protected JComboBox<String> JCDependencias;
    protected JComboBox<String> JCActividad;
}

