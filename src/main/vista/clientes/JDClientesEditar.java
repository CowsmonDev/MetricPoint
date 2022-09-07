package main.vista.clientes;

import main.statico.JCTable;
import main.statico.Metodos;
import main.creditos.vista.interfaces.Editar;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class JDClientesEditar extends JDClientes {

    public JDClientesEditar(JFrame jf, JCTable JTAClientes) {
        super(jf);
        JPFooter = main.vista.JPFooter.getInstance(new Editar() {
            @Override
            public void Guardar() {
                JBGuardarMouseClicked(JTAClientes, JTAClientes.getColumnSelectedAt(0));
            }

            @Override
            public void Cancelar() {
                JLCruzMouseClicked();
            }

            @Override
            public void VolverEditar() {
                JPFooter.next();
                Enabled(true);
            }

            @Override
            public void Salir() { JLCruzMouseClicked(); }
        });
        super.initComponent();
        llenarText(JTAClientes.getSelectedValueRow());
    }

    protected void llenarText(String[] valores) {
        JTNum_dni.setText(valores[0]);

        final String[] cuit = valores[1].split("-");
        if (cuit.length == 3) {
            JTNum_cuit_izq.setText(cuit[0]);
            JTNum_cuit.setText(cuit[1]);
            JTNum_cuit_der.setText(cuit[2]);
        } else
            JTNum_cuit.setText(cuit[0]);


        JTNombre.setText(valores[2]);
        JTApellido.setText(valores[3]);

        //fecha De nacimiento
        Metodos.setDatoFecha(JRSFecha_nacimiento, valores[4]);
        JTEstado_civil.setText(valores[5]);
        JTNacionalidad.setText(valores[6]);
        JTLocalidad.setText(valores[7]);
        JTCalle.setText(valores[8]);
        JTNumero_calle.setText(valores[9]);
        JTTel_fijo.setText(valores[10]);
        JTTel_movil.setText(valores[11]);
    }

    private Map<String, String[]> getMap(String[] valores, String Dni){
        Map<String, String[]> Cadena = new HashMap<>();

        String[] dni = new String[]{JTNum_dni.getText(), Dni};

        Cadena.put(conn.getUpdate(), valores);
        Cadena.put("UPDATE `bancos` SET " + conn.getNumDni() + " = ? " + " WHERE " + conn.getNumDni() + " = ?", dni);
        Cadena.put("UPDATE `referencias` SET " + conn.getNumDni() + " = ? " + " WHERE " + conn.getNumDni() + " = ?", dni);
        Cadena.put("UPDATE `creditos` SET " + conn.getNumDni() + " = ? " + " WHERE " + conn.getNumDni() + " = ?", dni);

        return Cadena;
    }

    protected void JBGuardarMouseClicked(JCTable JTAClientes, String Dni) {
        String[] valores = new String[]{
                JTNum_dni.getText(),
                (JTNum_cuit_izq.getText().equals("") || JTNum_cuit_der.getText().equals("")) ? JTNum_cuit.getText() : JTNum_cuit_izq.getText() + "-" + JTNum_cuit.getText() + "-" + JTNum_cuit_der.getText(),
                JTNombre.getText(),
                JTApellido.getText(),
                Metodos.getDate(JRSFecha_nacimiento),
                JTEstado_civil.getText(),
                JTNacionalidad.getText(),
                JTLocalidad.getText(),
                JTCalle.getText(),
                JTNumero_calle.getText(),
                JTTel_fijo.getText(),
                JTTel_movil.getText(),
                Dni
        };

        if(JTNum_dni.getText().equals(Dni) || conn.Comprobar(conn.getNumDni(), JTNum_dni.getText())){

            if(JTNum_dni.getText().equals(Dni)) conn.updateDate(valores);
            else conn.MultiQuery(getMap(valores, Dni));

            JTAClientes.setSelectedValueRow(new String[]{
                    JTNum_dni.getText(),
                    (JTNum_cuit_izq.getText().equals("") || JTNum_cuit_der.getText().equals("")) ? JTNum_cuit.getText() : JTNum_cuit_izq.getText() + "-" + JTNum_cuit.getText() + "-" + JTNum_cuit_der.getText(),
                    JTNombre.getText(),
                    JTApellido.getText(),
                    Metodos.getDate(JRSFecha_nacimiento),
                    JTEstado_civil.getText(),
                    JTNacionalidad.getText(),
                    JTLocalidad.getText(),
                    JTCalle.getText(),
                    JTNumero_calle.getText(),
                    JTTel_fijo.getText(),
                    JTTel_movil.getText(),
            });

            JOptionPane.showMessageDialog(null, "Datos Modificados Exitosamente");
            Enabled(false);
            JPFooter.next();

        }else JOptionPane.showMessageDialog(null, "Ese numero de dni ya se encuetra en la base de datos");
    }

}
