package main.vista.empresas;

import main.statico.Metodos;
import main.vista.JDVista;

import javax.swing.*;
import java.awt.*;

public class JDEmpresas extends JDVista {

    protected main.conexion.empresaConexion conn = main.conexion.empresaConexion.getInstance();

    protected JDEmpresas(JFrame jf) {
        super(jf, new Dimension(900, 620), "Empresas");
        JLTitleEmpresa = new JLabel("Agregue Una Empresa");
        Metodos.setPropTitle(JLTitleEmpresa);

    }

    protected void initComponent(){

        conn.connopen();

        JPEmpresas = new JPanel();

        JPPrincipal.add(JPEmpresas, "JPEmpresas");

        JLEmpresa = new JLabel("Empresa");
        Metodos.setDesignTitle(JLEmpresa);

        JLMayorista = new JLabel("Mayorista");
        Metodos.setDesignTitle(JLMayorista);

        JLDomicilio_mayorista = new JLabel("Domicilio Mayorista");
        Metodos.setDesignTitle(JLDomicilio_mayorista);

        JLTelefono_mayorista = new JLabel("Telefono Mayorista");
        Metodos.setDesignTitle(JLTelefono_mayorista);

        JLComision_local = new JLabel("Comision Local");
        Metodos.setDesignTitle(JLComision_local);

        JLComision_vendedor = new JLabel("Comision Vendedor");
        Metodos.setDesignTitle(JLComision_vendedor);

        JTEmpresa = Metodos.getTextGestoria("Ingrese Nombre De Empresa");

        JTMayorista = Metodos.getTextGestoria("Ingrese Nombre De Mayorista");

        JTDomicilio_mayorista = Metodos.getTextGestoria("Ingrese Domicilio Del Mayorista");

        JTTelefono_mayorista = Metodos.getTextGestoria("Ingrese Telefono Del Mayorista");

        JTComision_local = Metodos.getTextGestoria("Ingrese La Comision Del Local");

        JTComision_vendedor = Metodos.getTextGestoria("Ingrese La Comision Del Vendedor");


        GroupLayout GJPPrincipal = new GroupLayout(JPEmpresas);
        JPEmpresas.setLayout(GJPPrincipal);

        GJPPrincipal.setHorizontalGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(300)
                        .addComponent(JLTitleEmpresa, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(45)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLEmpresa, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTEmpresa, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLTelefono_mayorista, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTTelefono_mayorista, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLMayorista, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTMayorista, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComision_local, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComision_local, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(30)
                        .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLDomicilio_mayorista, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTDomicilio_mayorista, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComision_vendedor, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComision_vendedor, GroupLayout.PREFERRED_SIZE, JTextLargo, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addGroup(GJPPrincipal.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                )
        );
        GJPPrincipal.setVerticalGroup(GJPPrincipal.createSequentialGroup()
                .addGap(60)
                .addComponent(JLTitleEmpresa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(45)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLEmpresa, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLMayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLDomicilio_mayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTEmpresa, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTMayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTDomicilio_mayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLTelefono_mayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLComision_local, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLComision_vendedor, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipal.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTTelefono_mayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTComision_local, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTComision_vendedor, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(120)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        );

    }


    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }

    protected void Enabled(boolean Bandera){
        JTEmpresa.setEnabled(Bandera);
        JTMayorista.setEnabled(Bandera);
        JTDomicilio_mayorista.setEnabled(Bandera);
        JTTelefono_mayorista.setEnabled(Bandera);
        JTComision_local.setEnabled(Bandera);
        JTComision_vendedor.setEnabled(Bandera);
    }

    private JPanel JPEmpresas;
    protected main.vista.JPFooter JPFooter;

    protected JLabel JLTitleEmpresa;

    private JLabel JLEmpresa;
    private JLabel JLMayorista;
    private JLabel JLDomicilio_mayorista;
    private JLabel JLTelefono_mayorista;
    private JLabel JLComision_local;
    private JLabel JLComision_vendedor;

    protected JTextField JTEmpresa;
    protected JTextField JTMayorista;
    protected JTextField JTDomicilio_mayorista;
    protected JTextField JTTelefono_mayorista;
    protected JTextField JTComision_local;
    protected JTextField JTComision_vendedor;

}

