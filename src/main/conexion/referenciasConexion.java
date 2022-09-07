package main.conexion;

public class referenciasConexion extends ConexionSinDni {

    private static referenciasConexion Instance;

    private final String Nombre = "nombre";
    private final String TelMovil = "tel_movil";
    private final String TelFijo = "tel_fijo";
    private final String[] TitulosReferencias = {
            "Nombre",
            "Telefono Movil",
            "Telefono Fijo"
    };


    public static referenciasConexion getInstance() {
        return (Instance == null)? Instance = new referenciasConexion() : Instance;
    }

    private referenciasConexion() {
        super();
        Table = "referencias";
        CamposSinDni = Nombre + ", " + TelMovil + ", " + TelFijo;
        Campos = NumDni + ", " + CamposSinDni;
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?,?,?)";
        Update = "UPDATE " + Table + " SET " + Nombre + " = ?, " + TelMovil + " = ?, " + TelFijo + " = ? WHERE " + NumDni + " = ? AND " + Nombre + " = ?";
        Delete = "DELETE FROM " + Table + " WHERE " + NumDni + " = ? AND " + Nombre + " = ?";
    }

    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(Nombre),
                rs.getString(TelMovil),
                rs.getString(TelFijo)
        };
    }

    public void deleteDate(String NumDni, String Nombre) {
        super.deleteDate(new String[]{
                NumDni,
                Nombre
        });
    }

    public String getNombre() { return Nombre; }
    public String getTelMovil() { return TelMovil; }
    public String getTelFijo() { return TelFijo; }
    public String[] getTitulosReferencias() { return TitulosReferencias; }

}
