package main.vista;

import main.statico.JLButtonGestoria;
import main.statico.Generales;
import main.creditos.vista.interfaces.Editar;
import main.creditos.vista.interfaces.Guardar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class JPFooter extends JPanel {

    protected JPFooter(){ }

    public static JPFooterEditar getInstance(main.creditos.vista.interfaces.Editar editar){
        return new JPFooterEditar(editar);
    }

    public static JPFooterGuardar getInstance(main.creditos.vista.interfaces.Guardar guardar){
        return new JPFooterGuardar(guardar);
    }

    public abstract void next();

}

class JPFooterEditar extends JPFooter implements Generales {

    protected JPFooterEditar(main.creditos.vista.interfaces.Editar editar) { initComponent(editar); }

    private void initComponent(Editar editar){

        JBGuardar = new JLButtonGestoria("Guardar") {
            @Override
            public void mouseClicked(MouseEvent e) {
                editar.Guardar();
            }
        };

        JBCancelar = new JLButtonGestoria("Cancelar") {
            @Override
            public void mouseClicked(MouseEvent e) {
                editar.Cancelar();
            }
        };

        JBVolverEditar = new JLButtonGestoria("Volver A Editar") {
            @Override
            public void mouseClicked(MouseEvent e) { editar.VolverEditar(); }
        };

        JBSalir = new JLButtonGestoria("Salir") {
            @Override
            public void mouseClicked(MouseEvent e) { editar.Salir(); }
        };

        CJPFooter = new CardLayout();
        setLayout(CJPFooter);

        JPEditar = new JPanel();
        GroupLayout GJPEditar = new GroupLayout(JPEditar);
        JPEditar.setLayout(GJPEditar);

        GJPEditar.setHorizontalGroup(GJPEditar.createSequentialGroup()
                .addGap(192)
                .addComponent(JBGuardar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(JBCancelar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        );
        GJPEditar.setVerticalGroup(GJPEditar.createSequentialGroup()
                .addGap(30)
                .addGroup(GJPEditar.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JBGuardar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBCancelar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(40)
        );

        JPEditado = new JPanel();
        GroupLayout GJPEditado = new GroupLayout(JPEditado);
        JPEditado.setLayout(GJPEditado);

        GJPEditado.setHorizontalGroup(GJPEditado.createSequentialGroup()
                .addGap(192)
                .addComponent(JBVolverEditar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(JBSalir, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        );

        GJPEditado.setVerticalGroup(GJPEditado.createSequentialGroup()
                .addGap(30)
                .addGroup(GJPEditado.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JBVolverEditar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBSalir, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(40)
        );

        add(JPEditar, "JPEditar");
        add(JPEditado, "JPEditado");

    }

    private CardLayout CJPFooter;
    private JPanel JPEditar;
    private JPanel JPEditado;

    private JLButtonGestoria JBGuardar;
    private JLButtonGestoria JBCancelar;
    private JLButtonGestoria JBVolverEditar;
    private JLButtonGestoria JBSalir;

    @Override
    public void next() {
        CJPFooter.next(this);
    }
}

class JPFooterGuardar extends JPFooter implements Generales {


    protected JPFooterGuardar(Guardar guardar) {
        initComponent(guardar);
    }

    private void initComponent(Guardar guardar){

        JBTerminar = new JLButtonGestoria("Terminar De Cargar") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                guardar.Terminar();
            }
        };

        JBCancelar = new JLButtonGestoria("Cancelar") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                guardar.Cancelar();
            }
        };

        JBLimpiar = new JLButtonGestoria("Limpiar") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                guardar.Limpiar();
            }
        };
        JBAgregarNuevo = new JLButtonGestoria("Agregar Nuevo Registro") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                guardar.Agregar();
            }
        };


        CJPFooter = new CardLayout();
        setLayout(CJPFooter);

        JPCargar = new JPanel();
        GroupLayout GJPCargar = new GroupLayout(JPCargar);
        JPCargar.setLayout(GJPCargar);

        JPCargado = new JPanel();
        GroupLayout GJPCargado = new GroupLayout(JPCargado);
        JPCargado.setLayout(GJPCargado);

        GJPCargar.setHorizontalGroup(GJPCargar.createSequentialGroup()
                .addGap(15)
                .addComponent(JBCancelar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(80)
                .addComponent(JBTerminar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(80)
                .addComponent(JBLimpiar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        );
        GJPCargar.setVerticalGroup(GJPCargar.createSequentialGroup()
                .addGap(10)
                .addComponent(JBTerminar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addGroup(GJPCargar.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JBCancelar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBLimpiar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
        );

        GJPCargado.setHorizontalGroup(GJPCargado.createSequentialGroup()
                .addGap(332)
                .addComponent(JBAgregarNuevo, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)

        );
        GJPCargado.setVerticalGroup(GJPCargado.createSequentialGroup()
                .addGap(30)
                .addComponent(JBAgregarNuevo, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
        );

        add(JPCargar, "JPCargar");
        add(JPCargado, "JPCargado");

    }

    protected CardLayout CJPFooter;

    private JPanel JPCargar;
    private JPanel JPCargado;

    private JLButtonGestoria JBTerminar;
    private JLButtonGestoria JBCancelar;
    private JLButtonGestoria JBLimpiar;
    private JLButtonGestoria JBAgregarNuevo;

    @Override
    public void next() {
        CJPFooter.next(this);
    }
}

