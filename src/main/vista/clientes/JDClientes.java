package main.vista.clientes;

import main.statico.Metodos;
import main.vista.JDVista;
import rojeru_san.componentes.RSDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JDClientes extends JDVista {

    protected main.conexion.clientesConexion conn = main.conexion.clientesConexion.getInstance();

    protected JDClientes(JFrame jf) { super(jf, new Dimension(900, 700), "Clientes"); }

    protected void initComponent(){
        JPClientes = new JPanel();
        JPPrincipal.add(JPClientes, "JPClientes");


        JLTitle = new JLabel("Clientes");
        Metodos.setPropTitle(JLTitle);

        JLNum_dni = new JLabel("Dni");
        Metodos.setDesignTitle(JLNum_dni);

        JLNum_cuit = new JLabel("Cuit");
        Metodos.setDesignTitle(JLNum_cuit);

        JLabel JLNum_cuit_izq = new JLabel();
        Metodos.setDesignTitle(JLNum_cuit_izq);

        JLabel JLNum_cuit_der = new JLabel();
        Metodos.setDesignTitle(JLNum_cuit_der);

        JLNombre = new JLabel("Nombre");
        Metodos.setDesignTitle(JLNombre);

        JLApellido = new JLabel("Apellido");
        Metodos.setDesignTitle(JLApellido);

        JLEstado_civil = new JLabel("Estado Civil");
        Metodos.setDesignTitle(JLEstado_civil);

        JLNacionalidad = new JLabel("Nacionalidad");
        Metodos.setDesignTitle(JLNacionalidad);

        JLLocalidad = new JLabel("Localidad");
        Metodos.setDesignTitle(JLLocalidad);

        JLCalle = new JLabel("Calle");
        Metodos.setDesignTitle(JLCalle);

        JLNumero_calle = new JLabel("Numero de Calle");
        Metodos.setDesignTitle(JLNumero_calle);

        JLTel_fijo = new JLabel("Telefono Fijo");
        Metodos.setDesignTitle(JLTel_fijo);

        JLTel_movil = new JLabel("Telefono Movil");
        Metodos.setDesignTitle(JLTel_movil);

        JLFecha_nacimiento = new JLabel("Fecha De Nacimiento");
        Metodos.setDesignTitle(JLFecha_nacimiento);

        JTNum_dni = Metodos.getTextGestoria("Ingrese El DNI");
        JTNum_dni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                JTNum_cuit.setText(JTNum_dni.getText());
            }
        });

        JTNum_cuit_izq = Metodos.getTextGestoria("");

        JTNum_cuit = Metodos.getTextGestoria("CUIT");
        JTNum_cuit.setEditable(false);

        JTNum_cuit_der = Metodos.getTextGestoria("");

        JTNombre = Metodos.getTextGestoria("Ingrese El Nombre Del CLiente");

        JTApellido = Metodos.getTextGestoria("Ingrese El Apellido Del CLiente");

        JTEstado_civil = Metodos.getTextGestoria("Ingrese El Estado Civil Del Cliente");

        JTNacionalidad = Metodos.getTextGestoria("Ingrese La Nacionalidad Del Cliente");

        JTLocalidad = Metodos.getTextGestoria("Ingrese La Localidad Del Cliente");

        JTCalle = Metodos.getTextGestoria("Ingrese La Calle Del CLiente");

        JTNumero_calle = Metodos.getTextGestoria("Ingrese El Numero De Calle Del Cliente");

        JTTel_fijo = Metodos.getTextGestoria("Ingrese El Telefono Fijo Del Cliente");

        JTTel_movil = Metodos.getTextGestoria("Ingrese El Telefono Movil Del Cliente");

        JRSFecha_nacimiento = Metodos.getJRSDataChooser("Ingrese Fecha De Nacimiento");


        GroupLayout GJPPrincipal = new GroupLayout(JPClientes);
        JPClientes.setLayout(GJPPrincipal);

        GJPPrincipal.setHorizontalGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(300)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(45)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLNum_dni, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNum_dni, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLNombre, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNombre, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLNacionalidad, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNacionalidad, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLNumero_calle, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNumero_calle, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GJPPrincipal.createSequentialGroup()
                                        .addComponent(JLNum_cuit_izq, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(JLNum_cuit, GroupLayout.PREFERRED_SIZE, JTextLargo - 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(JLNum_cuit_der, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(GJPPrincipal.createSequentialGroup()
                                        .addComponent(JTNum_cuit_izq, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(JTNum_cuit, GroupLayout.PREFERRED_SIZE, JTextLargo - 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(JTNum_cuit_der, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                )
                                .addComponent(JLApellido, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTApellido, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLLocalidad, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTLocalidad, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTel_fijo, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTel_fijo, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLFecha_nacimiento, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JRSFecha_nacimiento, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLEstado_civil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTEstado_civil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLCalle, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTCalle, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTel_movil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTel_movil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE /*900*/)
                )
        );

        GJPPrincipal.setVerticalGroup(GJPPrincipal.createSequentialGroup()
                .addGap(30)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(35)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLNum_dni, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNum_cuit_izq, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNum_cuit, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNum_cuit_der, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLFecha_nacimiento, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTNum_dni, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTNum_cuit_izq, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTNum_cuit, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTNum_cuit_der, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JRSFecha_nacimiento, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)

                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLNombre, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLApellido, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLEstado_civil, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTNombre, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTApellido, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTEstado_civil, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)

                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLNacionalidad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLLocalidad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLCalle, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTNacionalidad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTLocalidad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTCalle, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )

                .addGap(30)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLNumero_calle, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTel_fijo, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTel_movil, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTNumero_calle, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTTel_movil, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTTel_fijo, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        );

    }

    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }



    private JPanel JPClientes;
    protected main.vista.JPFooter JPFooter;

    private JLabel JLNum_dni;
    private JLabel JLNum_cuit;
    private JLabel JLNombre;
    private JLabel JLApellido;
    private JLabel JLEstado_civil;
    private JLabel JLNacionalidad;
    private JLabel JLLocalidad;
    private JLabel JLCalle;
    private JLabel JLNumero_calle;
    private JLabel JLTel_fijo;
    private JLabel JLTel_movil;

    private JLabel JLFecha_nacimiento;

    protected JTextField JTNum_dni;
    protected JTextField JTNum_cuit;
    protected JTextField JTNum_cuit_izq;
    protected JTextField JTNum_cuit_der;
    protected JTextField JTNombre;
    protected JTextField JTApellido;
    protected JTextField JTEstado_civil;
    protected JTextField JTNacionalidad;
    protected JTextField JTLocalidad;
    protected JTextField JTCalle;
    protected JTextField JTNumero_calle;
    protected JTextField JTTel_fijo;
    protected JTextField JTTel_movil;

    protected RSDateChooser JRSFecha_nacimiento;

    protected JLabel JLTitle;


    protected void Enabled(boolean bandera){
        JTNum_dni.setEnabled(bandera);
        JTNum_cuit_izq.setEnabled(bandera);
        JTNum_cuit.setEnabled(bandera);
        JTNum_cuit_der.setEnabled(bandera);
        JTNombre.setEnabled(bandera);
        JTApellido.setEnabled(bandera);
        JTEstado_civil.setEnabled(bandera);
        JTNacionalidad.setEnabled(bandera);
        JTLocalidad.setEnabled(bandera);
        JTCalle.setEnabled(bandera);
        JTNumero_calle.setEnabled(bandera);
        JTTel_fijo.setEnabled(bandera);
        JTTel_movil.setEnabled(bandera);
        JRSFecha_nacimiento.setEnabled(bandera);
    }

}

