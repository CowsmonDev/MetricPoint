package main.vista.referencias;

import main.statico.JCTable;
import main.creditos.vista.interfaces.Change;
import main.creditos.vista.interfaces.Editar;

import javax.swing.*;

public class JDReferenciasEditar extends JPReferencias {

    public JDReferenciasEditar(String[] Valores, JCTable JTAReferencia, Change change) {
        super();
        initComponent(Valores, JTAReferencia, change);
    }

    private void initComponent(String[] Valores, JCTable JTAReferencia, Change change){
        JPFooter = main.vista.JPFooter.getInstance(new Editar() {

            @Override
            public void Guardar() { JBGuardarMouseClicked(Valores[0], JTAReferencia); }

            @Override
            public void Cancelar() { change.change(); }

            @Override
            public void VolverEditar() {
                Enabled(true);
                JPFooter.next();
            }

            @Override
            public void Salir() { change.change(); }
        });
        super.initComponent(Valores);

        JTNombre_ref.setText(JTAReferencia.getColumnSelectedAt(0));
        JTTel_movil.setText(JTAReferencia.getColumnSelectedAt(1));
        JTTel_fijo.setText(JTAReferencia.getColumnSelectedAt(2));

    }

    private void JBGuardarMouseClicked(String Dni, JCTable JTAReferencia) {
        if (
                (JTNombre_ref.getText().equals(JTAReferencia.getColumnSelectedAt(0)))
                        ||
                        (conn.Comprobar(new String[][]{
                                {conn.getNumDni(), Dni},
                                {conn.getNombre(), JTNombre_ref.getText()}
                        }))
        ) {
            conn.updateDate(new String[]{
                    JTNombre_ref.getText(),
                    JTTel_movil.getText(),
                    JTTel_fijo.getText(),
                    Dni,
                    JTAReferencia.getColumnSelectedAt(0)
            });

            JTAReferencia.setSelectedValueRow(new String[]{
                    JTNombre_ref.getText(),
                    JTTel_movil.getText(),
                    JTTel_fijo.getText()
            });

            JOptionPane.showMessageDialog(null, "Datos Modificados Exitosamente");
            Enabled(false);
            JPFooter.next();

        } else JOptionPane.showMessageDialog(null, "Ese Registro ya se encuentra en la Base De Datos");

    }

}
