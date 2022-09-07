package main.conexion;

public class conexionClientesCreditos extends Conexion{

    private static conexionClientesCreditos instance;

    public static conexionClientesCreditos getInstance(){
        return (instance == null)? instance = new conexionClientesCreditos() : instance;
    }

    private conexionClientesCreditos(){
        super();
        Table = "clientes";
        Campos = NumDni + ", " + Nombre + ", " + Apellido + ", " + FechaNacimiento;
    }

    private final String NumDni = "num_dni";
    private final String Nombre = "nombre";
    private final String Apellido = "apellido";
    private final String FechaNacimiento = "fecha_nacimiento";

    private final String[] TitulosClientes = new String[]{
            "Numero De DNI",
            "Nombre Y Apellido",
            "Fecha De Nacimiento",
    };

    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(NumDni),
                rs.getString(Nombre),
                rs.getString(Apellido),
                rs.getString(FechaNacimiento)
        };
    }

    public String[] getTitulosClientes(){ return TitulosClientes; }
    public String getNumDni() { return NumDni; }
    public String getNombre() { return Nombre; }
    public String getApellido() { return Apellido; }
    public String getFechaNacimiento() { return FechaNacimiento; }
}
