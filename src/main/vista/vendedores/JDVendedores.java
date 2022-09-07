package main.vista.vendedores;

import main.statico.Metodos;
import main.vista.JDVista;

import javax.swing.*;
import java.awt.*;

public class JDVendedores extends JDVista {

    protected final main.conexion.vendedorConexion conn = main.conexion.vendedorConexion.getInstance();

    protected JDVendedores(JFrame jf) {
        super(jf, new Dimension(900, 660), "Vendedores");
    }

    protected void initComponent(){

        conn.connopen();

        JPVendedores = new JPanel();
        JPVendedores.setSize(900,540);
        JPVendedores.setOpaque(false);
        JPPrincipal.add(JPVendedores, "JPVendedores");

        JLTitleVendedores = new JLabel("Vendedores");
        Metodos.setDesignTitle(JLTitleVendedores);

        JLDni = new JLabel("Dni");
        Metodos.setDesignTitle(JLDni);

        JLNombre = new JLabel("Nombre Vendedor");
        Metodos.setDesignTitle(JLNombre);

        JLApellido = new JLabel("Apellido");
        Metodos.setDesignTitle(JLApellido);

        JLDomicilio = new JLabel("Domicilio");
        Metodos.setDesignTitle(JLDomicilio);

        JLTel_fijo = new JLabel("Telefono Fijo");
        Metodos.setDesignTitle(JLTel_fijo);

        JLTel_movil = new JLabel("Telefono Movil");
        Metodos.setDesignTitle(JLTel_movil);

        JLZona = new JLabel("Zona De Trabajo");
        Metodos.setDesignTitle(JLZona);

        JTDni = Metodos.getTextGestoria("Ingrese Dni Del Vendedor");

        JTNombre = Metodos.getTextGestoria("Ingrese Nombre");

        JTApellido = Metodos.getTextGestoria("Ingrese Apellido");

        JTDomicilio = Metodos.getTextGestoria("Ingrese Domicilio");

        JTTel_fijo = Metodos.getTextGestoria("Ingrese Telefono Fijo");

        JTTel_movil = Metodos.getTextGestoria("Ingrese Telefono Movil");

        JTZona = Metodos.getTextGestoria("Ingrese Zona De Trabajo");

        GroupLayout GJPPrincipal = new GroupLayout(JPVendedores);
        JPVendedores.setLayout(GJPPrincipal);

        GJPPrincipal.setHorizontalGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(300)
                        .addComponent(JLTitleVendedores, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(45)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLDni, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTDni, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLDomicilio, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTDomicilio, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLNombre, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNombre, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTel_fijo, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTel_fijo, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLZona, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTZona, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLApellido, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTApellido, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTel_movil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTel_movil, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                )
        );
        GJPPrincipal.setVerticalGroup(GJPPrincipal.createSequentialGroup()
                .addGap(30)
                .addComponent(JLTitleVendedores, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(35)

                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLDni, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNombre, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLApellido, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTDni, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTNombre, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTApellido, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLDomicilio, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTel_fijo, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTel_movil, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTDomicilio, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTTel_fijo, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTTel_movil, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addComponent(JLZona, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                .addComponent(JTZona, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)

                .addGap(60)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)

        );


    }

    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }

    private JPanel JPVendedores;
    protected main.vista.JPFooter JPFooter;

    protected JLabel JLTitleVendedores;

    private JLabel JLDni;
    private JLabel JLNombre;
    private JLabel JLApellido;
    private JLabel JLDomicilio;
    private JLabel JLTel_fijo;
    private JLabel JLTel_movil;
    private JLabel JLZona;

    protected JTextField JTDni;
    protected JTextField JTNombre;
    protected JTextField JTApellido;
    protected JTextField JTDomicilio;
    protected JTextField JTTel_fijo;
    protected JTextField JTTel_movil;
    protected JTextField JTZona;

    protected void Enabled(Boolean bandera){
        JTDni.setEnabled(bandera);
        JTNombre.setEnabled(bandera);
        JTApellido.setEnabled(bandera);
        JTDomicilio.setEnabled(bandera);
        JTTel_fijo.setEnabled(bandera);
        JTTel_movil.setEnabled(bandera);
        JTZona.setEnabled(bandera);
    }
}

