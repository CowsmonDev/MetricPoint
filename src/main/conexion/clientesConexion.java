package main.conexion;

public class clientesConexion extends Conexion{

    private static clientesConexion Instance;

    private final String NumDni = "num_dni";
    private final String NumCuit = "num_cuit";
    private final String Nombre = "nombre";
    private final String Apellido = "apellido";
    private final String FechaNacimiento = "fecha_nacimiento";
    private final String EstadoCivil = "estado_civil";
    private final String Nacionalidad = "nacionalidad";
    private final String Localidad = "localidad";
    private final String Calle = "calle";
    private final String NumCalle = "num_calle";
    private final String TelFijo = "tel_fijo";
    private final String TelMovil = "tel_movil";

    private final String[] TitulosClientes = new String[]{
            "Numero De DNI",
            "Numero De CUIT",
            "Nombre",
            "Apellido",
            "Fecha De Nacimiento",
            "Estado Civil",
            "Nacionalidad",
            "Localidad",
            "Calle",
            "Numero De Calle",
            "Telefono Fijo",
            "Telefono Movil"
    };

    public static clientesConexion getInstance() { return (Instance == null)? Instance = new clientesConexion() : Instance; }

    private clientesConexion() {
        super();
        Table = "clientes";
        Campos = NumDni + ", " + NumCuit + ", " + Nombre + ", " + Apellido + ", " + FechaNacimiento + ", " + EstadoCivil + ", " + Nacionalidad + ", " + Localidad + ", " + Calle + ", " + NumCalle + ", " + TelFijo + ", " + TelMovil;
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Update = "UPDATE " + Table + " SET " + NumDni + " = ?, " + NumCuit + " = ?, " + Nombre + " = ?, " + Apellido + " = ?, " + FechaNacimiento + " = ?, " + EstadoCivil + " = ?, " + Nacionalidad + " = ?, " + Localidad + " = ?, " + Calle + " = ?, " + NumCalle + " = ?, " + TelFijo + " = ?, " + TelMovil + " = ? WHERE " + NumDni + " = ?";
        Delete = "DELETE FROM " + Table + " WHERE " + NumDni + " = ?";
    }


    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(NumDni),
                rs.getString(NumCuit),
                rs.getString(Nombre),
                rs.getString(Apellido),
                rs.getString(FechaNacimiento),
                rs.getString(EstadoCivil),
                rs.getString(Nacionalidad),
                rs.getString(Localidad),
                rs.getString(Calle),
                rs.getString(NumCalle),
                rs.getString(TelFijo),
                rs.getString(TelMovil)
        };
    }

    public void deleteDate(String Dni) {
        super.deleteDate(new String[]{
                Dni
        });
    }


    public String getNumDni() { return NumDni; }
    public String getNumCuit() { return NumCuit; }
    public String getNombre() { return Nombre; }
    public String getApellido() { return Apellido; }
    public String getFechaNacimiento() { return FechaNacimiento; }
    public String getEstadoCivil() { return EstadoCivil; }
    public String getNacionalidad() { return Nacionalidad; }
    public String getLocalidad() { return Localidad; }
    public String getCalle() { return Calle; }
    public String getNumCalle() { return NumCalle; }
    public String getTelFijo() { return TelFijo; }
    public String getTelMovil() { return TelMovil; }
    public String[] getTitulosClientes(){ return TitulosClientes; }
    public String getTituloCliente(Integer i){ return TitulosClientes[i]; }


}
