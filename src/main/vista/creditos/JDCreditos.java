package main.creditos.vista.creditos;

import main.statico.Metodos;
import main.statico.Generales;
import main.vista.JDVista;
import main.vista.JPFooter;
import rojeru_san.componentes.RSDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

public class JDCreditos extends JDVista implements Generales {

    protected main.conexion.creditoConexion conn = main.conexion.creditoConexion.getInstance();
    private Map<String, String[]> ArrayMayorista;


    public JDCreditos(JFrame jf) {
        super(jf, new Dimension(900, 700), "Creditos");
        CJPPrincipal = new CardLayout();
        JPPrincipal.setLayout(CJPPrincipal);
    }

    protected void initComponent(){

        conn.connopen();

        JPCreditos = new JPanel();

        JLTitle = new JLabel("Credito");
        Metodos.setPropTitle(JLTitle);

        JLDni.setFont(JFText);
        JLDni.setBorder(BorderFactory.createMatteBorder(1,0,1,0, Green));
        JLDni.setOpaque(true);
        JLDni.setBackground(WhiteGreen);
        JLDni.setHorizontalAlignment(SwingConstants.CENTER);

        JLNombreYApellido.setFont(JFText);
        JLNombreYApellido.setBorder(BorderFactory.createMatteBorder(1,0,1,0, Green));
        JLNombreYApellido.setOpaque(true);
        JLNombreYApellido.setBackground(WhiteGreen);
        JLNombreYApellido.setHorizontalAlignment(SwingConstants.CENTER);

        JLFNacimiento.setFont(JFText);
        JLFNacimiento.setBorder(BorderFactory.createMatteBorder(1,0,1,0, Green));
        JLFNacimiento.setOpaque(true);
        JLFNacimiento.setBackground(WhiteGreen);
        JLFNacimiento.setHorizontalAlignment(SwingConstants.CENTER);

        JLFechaCredito = new JLabel("Fecha Del Credito");
        JLFechaCredito.setOpaque(false);
        JLFechaCredito.setHorizontalAlignment(SwingConstants.CENTER);
        JLFechaCredito.setFont(JFText);

        JLEmpresa = new JLabel("Nombre De Empresa");
        Metodos.setDesignTitle(JLEmpresa);

        JLMayorista = new JLabel("Nombre Del Mayorista");
        Metodos.setDesignTitle(JLMayorista);

        JLMonto = new JLabel("Monto Del Credito");
        Metodos.setDesignTitle(JLMonto);

        JLDependencias = new JLabel("Dependencias");
        Metodos.setDesignTitle(JLDependencias);

        JLActividad = new JLabel("Actividad");
        JLActividad.setOpaque(false);
        JLActividad.setHorizontalAlignment(SwingConstants.CENTER);
        JLActividad.setFont(JFText);

        JCHActividad = new JCheckBox();
        JCHActividad.setSelected(true);
        JCHActividad.addItemListener(this::JCHActividadItemStateChange);

        JLCantidadCuotas = new JLabel("Cantidad De Cuotas");
        Metodos.setDesignTitle(JLCantidadCuotas);

        JLImporteCuota = new JLabel("Importe De Cuota");
        Metodos.setDesignTitle(JLImporteCuota);

        JLComisionLocal = new JLabel("Comision Local");
        Metodos.setDesignTitle(JLComisionLocal);

        JLVendedor = new JLabel("Nombre Del Vendedor");
        JLVendedor.setOpaque(false);
        JLVendedor.setHorizontalAlignment(SwingConstants.CENTER);
        JLVendedor.setFont(JFText);

        JCHVendedor = new JCheckBox();
        JCHVendedor.setSelected(true);
        JCHVendedor.addItemListener(this::JCHVendedorItemStateChange);

        JLComisionVendedor = new JLabel("Comision Del Vendedor");
        Metodos.setDesignTitle(JLComisionVendedor);

        JLComisionTotal = new JLabel("Comision Total");
        Metodos.setDesignTitle(JLComisionTotal);

        JRSDFechaCredito = Metodos.getJRSDataChooser("Fecha Del Credito");

        JCEmpresa = new JComboBox<>(conn.llenarArray("SELECT DISTINCT nombre_empresa FROM empresas", "nombre_empresa"));
        JCEmpresa.setSelectedIndex(-1);
        JCEmpresa.addItemListener(this::JCEmpresaItemStateChanged);

        JCMayorista = new JComboBox<>();

        ArrayMayorista = conn.llenarArray("SELECT " + conn.getMayorista() + ", " + conn.getComisionLocal() + ", " + conn.getComisionVendedor() + " FROM empresas WHERE nombre_empresa = '" + Metodos.getItem(JCEmpresa) + "'");
        Metodos.setItemCombo(ArrayMayorista,JCMayorista);
        JCMayorista.setSelectedIndex(-1);
        JCMayorista.addItemListener(evt -> {
            if(JCMayorista.getItemCount() == ArrayMayorista.size()){
                JCMayoristaItemStateChanged(evt);
            }
        });

        JTMonto = Metodos.getTextGestoria("Monto Del Credito");
        JTMonto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                JTMontokeyReleased();
            }
        });

        JCDependencias = new JComboBox<>(conn.llenarArray("SELECT DISTINCT dependencia FROM bancos WHERE " + conn.getNumDni() + " = '" + JLDni.getText() + "'", "dependencia"));
        JCDependencias.setSelectedIndex(-1);
        JCDependencias.addItemListener(this::JCDependenciasItemStateChanged);

        JCActividad = new JComboBox<>(conn.llenarArray("SELECT DISTINCT " + conn.getActividad() + " FROM bancos WHERE " + conn.getNumDni() + " = '" + JLDni.getText() + "' AND dependencia = '" + Metodos.getItem(JCDependencias) + "'", conn.getActividad())
        );
        JCActividad.setSelectedIndex(-1);

        JPanel JPActividad = new JPanel();
        JPActividad.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Green));

        GroupLayout GJPActividad = new GroupLayout(JPActividad);
        JPActividad.setLayout(GJPActividad);

        GJPActividad.setHorizontalGroup(GJPActividad.createSequentialGroup()
                .addComponent(JLActividad, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                .addComponent(JCHActividad, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)

        );
        GJPActividad.setVerticalGroup(GJPActividad.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(JLActividad, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(JCHActividad, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        );

        JTCantidadCuotas = Metodos.getTextGestoria("Cantidad De Cuotas");

        JTImporteCuota = Metodos.getTextGestoria("Importe De La Cuota");

        JCVendedor = new JComboBox<>(conn.llenarArray("SELECT DISTINCT " + conn.getVendedor() + " FROM vendedores", conn.getVendedor()));
        JCVendedor.setSelectedIndex(-1);
        JCVendedor.addItemListener(this::JCVendedorItemStateChanged);

        JPanel JPVendedor = new JPanel();

        JPVendedor.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Green));

        GroupLayout GJPVendedor = new GroupLayout(JPVendedor);
        JPVendedor.setLayout(GJPVendedor);

        GJPVendedor.setHorizontalGroup(GJPVendedor.createSequentialGroup()
                .addComponent(JLVendedor, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                .addComponent(JCHVendedor, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)

        );
        GJPVendedor.setVerticalGroup(GJPVendedor.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(JLVendedor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(JCHVendedor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        );


        JTComisionLocal = Metodos.getTextGestoria("Comision Del Local");
        JTComisionLocal.setEnabled(false);

        JTComisionVendedor = Metodos.getTextGestoria("Comision Del Vendedor");
        JTComisionVendedor.setEnabled(false);

        JTComisionTotal = Metodos.getTextGestoria("Comision Final Del Local");
        JTComisionTotal.setEnabled(false);

        GroupLayout GJPCredito = new GroupLayout(JPCreditos);
        JPCreditos.setLayout(GJPCredito);

        GJPCredito.setHorizontalGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)

                .addGroup(GJPCredito.createSequentialGroup()
                        .addGap(250)
                        .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                )

                .addGroup(GJPCredito.createSequentialGroup()
                        .addComponent(JLDni, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNombreYApellido, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLFNacimiento, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(GJPCredito.createSequentialGroup()
                        .addGap(10)
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLMonto, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTMonto, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLDependencias, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCDependencias, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLEmpresa, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCEmpresa, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComisionTotal, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComisionTotal, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20)
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLCantidadCuotas, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTCantidadCuotas, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JPActividad, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCActividad, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLMayorista, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCMayorista, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComisionLocal, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComisionLocal, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20)
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLImporteCuota, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTImporteCuota, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLFechaCredito, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JRSDFechaCredito, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JPVendedor, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCVendedor, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComisionVendedor, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComisionVendedor, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)

                        )
                )
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
        );

        GJPCredito.setVerticalGroup(GJPCredito.createSequentialGroup()
                .addGap(10)
                .addComponent(JLTitle, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(JLDni, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLNombreYApellido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLFNacimiento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20)
                .addGroup(GJPCredito.createSequentialGroup()
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLMonto, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLCantidadCuotas, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLImporteCuota, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JTMonto, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTCantidadCuotas, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTImporteCuota, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20)
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLFechaCredito, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLDependencias, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JPActividad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JRSDFechaCredito, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCDependencias, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCActividad, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGap(20)
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLEmpresa, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLMayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JPVendedor, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JCEmpresa, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCMayorista, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCVendedor, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20)
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLComisionLocal, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComisionVendedor, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLComisionTotal, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(GJPCredito.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JTComisionLocal, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComisionVendedor, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTComisionTotal, GroupLayout.PREFERRED_SIZE, JButtonAlto, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addGap(20)
                .addComponent(JPFooter, GroupLayout.PREFERRED_SIZE,120, GroupLayout.PREFERRED_SIZE)
        );

        JPPrincipal.add(JPCreditos, "JPCreditos");
    }

    private void JCHVendedorItemStateChange(ItemEvent evt) {
        JCVendedor.setSelectedIndex(-1);
        JCVendedor.setEnabled(JCHVendedor.isSelected());
    }

    private void JCHActividadItemStateChange(ItemEvent evt) {
        JCActividad.setSelectedIndex(-1);
        JCActividad.setEnabled(JCHActividad.isSelected());
    }

    private void JCEmpresaItemStateChanged(ItemEvent evt) {
        ArrayMayorista = conn.llenarArray("SELECT " + conn.getMayorista() + ", " + conn.getComisionLocal() + ", " + conn.getComisionVendedor() + " FROM empresas WHERE nombre_empresa = '" + Metodos.getItem(JCEmpresa) + "'");
        Metodos.setItemCombo(ArrayMayorista,JCMayorista);
        JCMayoristaItemStateChanged(evt);
    }

    private void JCMayoristaItemStateChanged(ItemEvent evt) {
        if (JCMayorista.getItemCount() == ArrayMayorista.size()) Calcular();
    }

    private void JCVendedorItemStateChanged(ItemEvent evt) {
        Calcular();
    }

    private void JCDependenciasItemStateChanged(ItemEvent evt) {
        Metodos.setItem(
                conn.llenarArray(
                        "SELECT DISTINCT " + conn.getActividad() + " FROM bancos WHERE " + conn.getNumDni() + " = '" + JLDni.getText() + "' AND dependencia = '" + Metodos.getItem(JCDependencias) + "'"
                        , conn.getActividad()
                )
                ,JCActividad
        );
        JCActividad.setSelectedItem(-1);
    }

    private void JTMontokeyReleased() {
        Calcular();
    }

    private void Calcular(){
        //error: siempre que se cambie la empresa o el mayorista, el programa calculara 2 veces, encontrar otra forma de detectar el cambio en el JCMayorista
        if (!((JTMonto.getText().equals("")) || (JCMayorista.getSelectedIndex() == -1))) {
            String[] valor = ArrayMayorista.get(Metodos.getItem(JCMayorista));
            try{
                Double comisionTotal = (Double.parseDouble(JTMonto.getText()) * (Double.parseDouble(valor[0]))) / 100;;
                if (!JCHVendedor.isSelected() || JCVendedor.getSelectedIndex() == -1) {
                    JTComisionLocal.setText(String.valueOf(comisionTotal));
                    JTComisionVendedor.setText("0");
                    JTComisionTotal.setText(String.valueOf(comisionTotal));
                    //del credito se saca un porcentaje para el local, de ese porcentaje se saca la comision para el local, y de la comision del local se saca la comision del vendedor. despues la comision total, se saca restando la comision local y la comision Vendedor
                } else {
                    Double comisionVendedor = (comisionTotal * Double.parseDouble(valor[1])) / 100;
                    JTComisionLocal.setText(String.valueOf(comisionTotal - comisionVendedor));
                    JTComisionVendedor.setText(String.valueOf(comisionVendedor));
                    JTComisionTotal.setText(String.valueOf(comisionTotal));
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El Monto debe ser numerico");
            }

        }
    }

    protected CardLayout CJPPrincipal;

    protected JPanel JPCreditos;

    protected JLabel JLTitle;
    protected JLabel JLDni;
    protected JLabel JLNombreYApellido;
    protected JLabel JLFNacimiento;
    protected JLabel JLFechaCredito;
    protected JLabel JLEmpresa;
    protected JLabel JLMayorista;
    protected JLabel JLMonto;
    protected JLabel JLDependencias;
    protected JLabel JLActividad;

    protected JCheckBox JCHActividad;

    protected JLabel JLCantidadCuotas;
    protected JLabel JLImporteCuota;
    protected JLabel JLComisionLocal;
    protected JLabel JLVendedor;
    protected JCheckBox JCHVendedor;
    protected JLabel JLComisionVendedor;
    protected JLabel JLComisionTotal;

    protected RSDateChooser JRSDFechaCredito;

    protected JComboBox<String> JCEmpresa;
    protected JComboBox<String> JCMayorista;

    protected JTextField JTMonto;
    protected JComboBox<String> JCDependencias;
    protected JComboBox<String> JCActividad;
    protected JTextField JTCantidadCuotas;
    protected JTextField JTImporteCuota;
    protected JComboBox<String> JCVendedor;
    protected JTextField JTComisionLocal;
    protected JTextField JTComisionVendedor;
    protected JTextField JTComisionTotal;

    protected JPFooter JPFooter;


    protected void setEditable(Boolean bandera){
        JTMonto.setEditable(bandera);
        JTCantidadCuotas.setEditable(bandera);
        JTImporteCuota.setEditable(bandera);
        JCDependencias.setEnabled(bandera);
        JCActividad.setEnabled(bandera);
        JRSDFechaCredito.setEnabled(bandera);
        JRSDFechaCredito.setEnabled(bandera);
        JCEmpresa.setEnabled(bandera);
        JCMayorista.setEnabled(bandera);
        JCVendedor.setEnabled(bandera);
        JTComisionLocal.setEditable(bandera);
        JTComisionVendedor.setEditable(bandera);
        JTComisionTotal.setEditable(bandera);
    }

    @Override
    protected void JLCruzMouseClicked() {
        dispose();
    }

}

