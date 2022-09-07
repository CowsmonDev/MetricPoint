package main.conexion;

public class vendedorConexion extends Conexion {

    private static vendedorConexion Instance;

    private final String DniVendedor = "dni_vendedor";
    private final String NombreApellido = "vendedor";
    private final String Domicilio = "domicilio";
    private final String TelFijo = "tel_fijo";
    private final String TelMovil = "tel_movil";
    private final String ZonaTrabajo = "zona_trabajo";
    private final String[] TitulosVendedores = new String[]{
            "DNI Del Vendedor",
            "Nombre Y Apellido Del Vendedor",
            "Domiciolio Del Vendedor",
            "Telefono Fijo",
            "Telefono Movil",
            "Zona De Trabajo",
    };

    public static vendedorConexion getInstance() { return (Instance == null)? Instance = new vendedorConexion() : Instance; }

    private vendedorConexion() {
        super();
        Table = "vendedores";
        Campos = DniVendedor + ", " + NombreApellido + ", " + Domicilio + ", " + TelFijo + ", " + TelMovil + ", " + ZonaTrabajo;
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?,?,?,?,?)";
        Update = "UPDATE " + Table + " SET " + DniVendedor + " = ?, " + NombreApellido + " = ?, " + Domicilio + " = ?, " + TelFijo + " = ?, " + TelMovil + " = ?, " + ZonaTrabajo + " = ? WHERE " + DniVendedor + " = ?";
        Delete = "DELETE FROM " + Table + " WHERE " + DniVendedor + " = ?";
    }

    public void deleteDate(String Dni) {
        super.deleteDate(new String[]{
                Dni
        });
    }

    public String getDniVendedor() { return DniVendedor; }
    public String getNombreApellido() { return NombreApellido; }
    public String getDomicilio() { return Domicilio; }
    public String getTelFijo() { return TelFijo; }
    public String getTelMovil() { return TelMovil; }
    public String getZonaTrabajo() { return ZonaTrabajo; }
    public String[] getTitulosVendedores() { return TitulosVendedores; }
    public String getTituloVendedor(Integer i) { return TitulosVendedores[i]; }

    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(DniVendedor),
                rs.getString(NombreApellido),
                rs.getString(Domicilio),
                rs.getString(TelFijo),
                rs.getString(TelMovil),
                rs.getString(ZonaTrabajo)
        };
    }
}
