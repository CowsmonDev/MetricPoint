package main.vista.creditos.guardar;

import main.statico.JCTable;
import main.statico.JLButtonGestoria;
import main.statico.Metodos;
import main.statico.Generales;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JPCreditosClientes extends JPCreditosGuardar implements Generales {

    private final main.conexion.conexionClientesCreditos conn = main.conexion.conexionClientesCreditos.getInstance();
    private ArrayList<String[]> ListaClientes = new ArrayList<>();

    public JPCreditosClientes(JFrame jf, JCTable JTACreditos) {
        super(jf);
        initComponent(JTACreditos);
    }

    private void initComponent(JCTable JTACreditos){

        JPCreditosClientes = new JPanel();

        conn.connopen();

        JTDni = Metodos.getTextGestoria("Ingrese El Dni Del Cliente");
        JTDni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || JTDni.getText().equals(""))
                    JTDniKeyReleased(evt);
            }
        });



        JLTitle = new JLabel("Ingrese Un Cliente Para El Credito");
        Metodos.setPropTitle(JLTitle);

        JBAceptar = new JLButtonGestoria("Aceptar") {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JBAceptarMouseClicked(JTACreditos);
            }
        };

        ListaClientes = conn.llenarTabla();

        JTAClientes = new JCTable(ListaClientes, conn.getTitulosClientes(), new DefaultTableCellRenderer[]{
                JCTable.getGestionID(),
                JCTable.getGestionImportante(),
                JCTable.getGestionTexto()
        });

        JTAClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JTAClientesMouseClicked(evt);
            }
        });
        JSClientes = new JScrollPane();
        JSClientes.setViewportView(JTAClientes);

        GroupLayout GJPPrincipalCliente = new GroupLayout(JPCreditosClientes);
        JPCreditosClientes.setLayout(GJPPrincipalCliente);

        GJPPrincipalCliente.setHorizontalGroup(GJPPrincipalCliente.createParallelGroup(GroupLayout.Alignment.LEADING)

                .addGroup(GJPPrincipalCliente.createSequentialGroup()
                        .addGap(250)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                )

                .addGroup(GJPPrincipalCliente.createSequentialGroup()
                        .addGap(125)
                        .addComponent(JTDni, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addGap(20)
                        .addComponent(JBAceptar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPPrincipalCliente.createSequentialGroup()
                        .addGap(10)
                        .addComponent(JSClientes, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                )
        );

        GJPPrincipalCliente.setVerticalGroup(GJPPrincipalCliente.createSequentialGroup()
                .addGap(30)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addGroup(GJPPrincipalCliente.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JTDni, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBAceptar, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(30)
                .addComponent(JSClientes, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
        );

        super.JPPrincipal.add(JPCreditosClientes, "JPPrincipal");

    }

    private void JTAClientesMouseClicked(MouseEvent evt){
        if (JTAClientes.getSelectedRow() != -1) JTDni.setText(JTAClientes.getColumnSelectedAt(0));
    }

    private void JBAceptarMouseClicked(JCTable JTACreditos){
        if(!JTDni.getText().equals("")){
            super.initComponent(
                    JTACreditos,
                    Metodos.ExistsDni(JTDni.getText(), ListaClientes)
            );
            CJPPrincipal.next(JPPrincipal);
        }
    }

    private void JTDniKeyReleased(KeyEvent evt){
        JTAClientes.filterDate(
                conn.getFilterDate(JTDni.getText(), conn.getNumDni())
        );
    }

    private JPanel JPCreditosClientes;

    private JLabel JLTitle;
    private JTextField JTDni;
    private JLButtonGestoria JBAceptar;
    private JCTable JTAClientes;
    private JScrollPane JSClientes;

}
