package main.conexion;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class creditoConexion extends Conexion{

    private static creditoConexion Instance;

    private final String NumDni = "num_dni";
    private final String Nombre = "nombre";
    private final String Apellido = "apellido";
    private final String FechaCredito = "fecha_credito";
    private final String Mayorista = "mayorista";
    private final String Monto = "monto";
    private final String Actividad = "actividad";
    private final String CantidadCuotas = "cantidad_cuotas";
    private final String ImporteCuota = "importe_cuota";
    private final String ComisionLocal = "comision_local";
    private final String Vendedor = "vendedor";
    private final String ComisionVendedor = "comision_vendedor";
    private final String TotalLocal = "total_local";
    private final String[] TitulosCreditos = new String[]{
            "Numero De Dni",
            "Nombre",
            "Apellido",
            "Fecha Del Credito",
            "Empresa - Mayorista",
            "Monto",
            "Dependencias - Actividad",
            "Cantidad De Cuotas",
            "Importe De Cuotas",
            "Comision Local",
            "Vendedor",
            "Comision Vendedor",
            "Comision Final"
    };

    public static creditoConexion getInstance() { return (Instance == null)? Instance = new creditoConexion() : Instance; }

    private creditoConexion() {
        super();
        Table = "creditos";
        Campos = NumDni + ", " + Nombre + ", " + Apellido + ", " + FechaCredito + ", " + Mayorista + ", " + Monto + ", " + Actividad + ", " + CantidadCuotas + ", " + ImporteCuota + ", " + ComisionLocal + ", " + Vendedor + ", " + ComisionVendedor + ", " + TotalLocal;
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Update = "UPDATE " + Table + " SET " + FechaCredito + " = ?, " + Mayorista + " = ?, " + Monto + " = ?, " + Actividad + " = ?, " + CantidadCuotas + " = ?, " + ImporteCuota + " = ?, " + ComisionLocal + " = ?, " + Vendedor + " = ?, " + ComisionVendedor + " = ?, " + TotalLocal + " = ? WHERE " + NumDni + " = ? AND " + FechaCredito + " = ? AND " + Mayorista + " = ? AND " + Monto + " = ? AND " + Actividad + " = ?";
        Delete = "DELETE FROM " + Table + " WHERE " + NumDni + " = ? AND " + FechaCredito + " = ? AND " + Mayorista + " = ? AND " + Monto + " = ? AND " + Actividad + " = ?";
    }

    public Map<String, String[]> llenarArray(String consulta) {
        Map<String, String[]> map = new HashMap<>();
        try {
            st = conexionf.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                map.put(
                        rs.getString(Mayorista),
                        new String[]{
                                rs.getString(ComisionLocal),
                                rs.getString(ComisionVendedor)
                        }
                );
            }
            return map;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return map;
    }


    @Override
    protected String[] getNewNode(ResultSet rs) throws SQLException {
        return new String[]{
                rs.getString(NumDni),
                rs.getString(Nombre),
                rs.getString(Apellido),
                rs.getString(FechaCredito),
                rs.getString(Mayorista),
                rs.getString(Monto),
                rs.getString(Actividad),
                rs.getString(CantidadCuotas),
                rs.getString(ImporteCuota),
                rs.getString(ComisionLocal),
                rs.getString(Vendedor),
                rs.getString(ComisionVendedor),
                rs.getString(TotalLocal)
        };
    }

    public void deleteDate(String NumDni, String FechaCredito, String Mayorista, String Monto, String Actividad) {
        super.deleteDate(new String[]{
                NumDni,
                FechaCredito,
                Mayorista,
                Monto,
                Actividad
        });
    }

    public String getNumDni() { return NumDni; }
    public String getNombre() { return Nombre; }
    public String getApellido() { return Apellido; }
    public String getFechaCredito() { return FechaCredito; }
    public String getMayorista() { return Mayorista; }
    public String getMonto() { return Monto; }
    public String getActividad() { return Actividad; }
    public String getCantidadCuotas() { return CantidadCuotas; }
    public String getImporteCuota() { return ImporteCuota; }
    public String getComisionLocal() { return ComisionLocal; }
    public String getVendedor() { return Vendedor; }
    public String getComisionVendedor() { return ComisionVendedor; }
    public String getTotalLocal() { return TotalLocal; }
    public String[] getTitulosCreditos(){ return TitulosCreditos; }
    public String getTituloCredito(Integer i){ return TitulosCreditos[i]; }

}
