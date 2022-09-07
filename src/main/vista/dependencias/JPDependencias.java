package main.vista.dependencias;

import main.statico.Metodos;
import main.statico.Generales;

import javax.swing.*;

public class JPDependencias extends JPanel implements Generales {

    protected main.conexion.dependenciasConexion conn = main.conexion.dependenciasConexion.getInstance();

    protected JPDependencias(){ }

    protected void initComponent(){
        conn.connopen();

        JLTitle = new JLabel("Dependencias");
        Metodos.setDesignTitle(JLTitle);

        JLDependencias = new JLabel("Dependencia");
        Metodos.setDesignTitle(JLDependencias);

        JLActividad = new JLabel("Actividad");
        Metodos.setDesignTitle(JLActividad);

        JTDependencias = Metodos.getTextGestoria("Dependencias");

        JTActividad = Metodos.getTextGestoria("Actividad");

        GroupLayout GJPDependencias = new GroupLayout(this);
        setLayout(GJPDependencias);
        GJPDependencias.setHorizontalGroup(GJPDependencias.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GJPDependencias.createSequentialGroup()
                        .addGap(300)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPDependencias.createSequentialGroup()
                        .addGap(125)
                        .addGroup(GJPDependencias.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLDependencias, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTDependencias, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(50)
                        .addGroup(GJPDependencias.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JTActividad, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLActividad, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        )

                )
                .addGroup(GJPDependencias.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                )
        );
        GJPDependencias.setVerticalGroup(GJPDependencias.createSequentialGroup()
                .addGap(30)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(90)
                .addGroup(GJPDependencias.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLDependencias, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLActividad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPDependencias.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTDependencias, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTActividad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(120)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        );

    }

    protected void Enabled(boolean Bandera){
        JTDependencias.setEnabled(Bandera);
        JTActividad.setEnabled(Bandera);
    }

    protected main.vista.JPFooter JPFooter;

    private JLabel JLTitle;

    private JLabel JLDependencias;
    private JLabel JLActividad;

    protected JTextField JTDependencias;
    protected JTextField JTActividad;

}

