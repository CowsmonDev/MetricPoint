package main.conexion;

public class bancoConexion extends ConexionSinDni {
    private static bancoConexion Instance;

    private final String Cbu = "cbu";
    private final String Banco = "banco";
    private final String FechaCobro = "fecha_cobro";
    private final String Dependencia = "dependencia";
    private final String Actividad = "actividad";
    private final String Beneficios = "beneficios";

    private final String[] TitulosBancos = new String[]{
            "Cbu",
            "Banco",
            "Fecha De Cobro",
            "Dependencia",
            "Actividad",
            "Beneficio"
    };

    public static bancoConexion getInstance() {
        return (Instance == null)? Instance = new bancoConexion() : Instance;
    }

    private bancoConexion(){
        super();
        CamposSinDni = Cbu + ", " + Banco + ", " + FechaCobro + ", " + Dependencia + ", " + Actividad + ", " + Beneficios;
        Campos = NumDni + ", " + CamposSinDni;
        Table = "bancos";
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?,?,?,?,?,?)";
        Update = "UPDATE " + Table + " SET " + Cbu + " = ?, " + Banco + " = ?, " + FechaCobro + " = ?, " + Dependencia + " = ?, " + Actividad + " = ?, " + Beneficios + " = ? WHERE " + NumDni + " = ? AND " + Banco + " = ? AND " + Beneficios + " = ? AND " + Actividad + " = ?";
        Delete = "DELETE FROM " + Table + " WHERE " + NumDni + " = ? AND " + Banco + " = ? AND " + Actividad + " = ? AND " + Beneficios + " = ?";
    }

    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(Cbu),
                rs.getString(Banco),
                rs.getString(FechaCobro),
                rs.getString(Dependencia),
                rs.getString(Actividad),
                rs.getString(Beneficios)
        };
    }

    public void deleteDate(String NumDni, String Banco, String Actividad, String Beneficio) {
        super.deleteDate(new String[]{
                NumDni,
                Banco,
                Actividad,
                Beneficio
        });
    }

    public String getCbu() { return Cbu; }
    public String getBanco() { return Banco; }
    public String getFechaCobro() { return FechaCobro; }
    public String getDependencia(){ return Dependencia; }
    public String getActividad(){ return  Actividad; }
    public String getBeneficios() { return Beneficios; }
    public String[] getTitulosBancos() { return TitulosBancos; }


}
