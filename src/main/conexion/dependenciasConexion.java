package main.conexion;



public class dependenciasConexion extends Conexion {
    private static dependenciasConexion Instance;

    private final String Dependencia = "dependencia";
    private final String Actividad = "actividad";
    private final String[] TitulosDependencias = new String[]{
            "Dependencias",
            "Actividad"
    };

    public static dependenciasConexion getInstance() {
        return (Instance == null)? Instance = new dependenciasConexion() : Instance;
    }

    private dependenciasConexion() {
        super();
        Table = "dependencias";
        Campos = Dependencia + ", " + Actividad;
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?)";
        Update = "UPDATE " + Table + " SET " + Dependencia + " = ?, " + Actividad + " = ? WHERE " + Dependencia + " = ? AND " + Actividad + " = ?";
        Delete = "DELETE FROM " + Table + " WHERE " + Dependencia + " = ? AND " + Actividad + " = ?";
    }

    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(Dependencia),
                rs.getString(Actividad)
        };
    }

    public void deleteDate(String Dependencia, String Actividad) {
        super.deleteDate(new String[]{
                Dependencia,
                Actividad
        });
    }

    public String getActividad(){ return Actividad; }
    public String getDependencias(){ return Dependencia; }
    public String[] getTitulosDependencias(){ return TitulosDependencias; }

}
