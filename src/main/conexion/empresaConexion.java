package main.conexion;

public class empresaConexion extends Conexion {

    private static empresaConexion Instance;

    private final String NombreEmpresa = "nombre_empresa";
    private final String Mayorista = "mayorista";
    private final String DomicilioMayorista = "domicilio_mayorista";
    private final String TelefonoMayorista = "telefono_mayorista";
    private final String ComisionLocal = "comision_local";
    private final String ComisionVendedores = "comision_vendedor";

    private final String[] TitulosEmpresas = new String[]{
            "Nombre De Empresa",
            "Mayorista",
            "Domicilio Del Mayorista",
            "Telefono Del Mayorista",
            "Comision Del Local",
            "Comision De Los Vendedores",
    };

    public static empresaConexion getInstance() {
        return (Instance == null)? Instance = new empresaConexion() : Instance;
    }

    protected empresaConexion() {
        super();
        Campos = NombreEmpresa + ", " + Mayorista + ", " + DomicilioMayorista + ", " + TelefonoMayorista + ", " + ComisionLocal + ", " + ComisionVendedores;
        Table = "empresas";
        Insert = "INSERT INTO " + Table + "( " + Campos + " )" + " VALUES(?,?,?,?,?,?)";
        Delete = "DELETE FROM " + Table + " WHERE " + NombreEmpresa + " = ? AND " + Mayorista + " = ?";
        Update = "UPDATE " + Table + " SET " + NombreEmpresa + " = ?, " + Mayorista + " = ?, " + DomicilioMayorista + " = ?, " + TelefonoMayorista + " = ?, " + ComisionLocal + " = ?, " + ComisionVendedores + " = ? WHERE " + NombreEmpresa + " = ? AND " + Mayorista + " = ?";
    }

    @Override
    protected String[] getNewNode(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new String[]{
                rs.getString(NombreEmpresa),
                rs.getString(Mayorista),
                rs.getString(DomicilioMayorista),
                rs.getString(TelefonoMayorista),
                rs.getString(ComisionLocal),
                rs.getString(ComisionVendedores)
        };
    }

    public void deleteDate(String NombreEmpresa, String Mayorista) {
        super.deleteDate(new String[]{
                NombreEmpresa,
                Mayorista
        });
    }

    public String getNombreEmpresa() { return NombreEmpresa; }
    public String getMayorista() { return Mayorista; }
    public String getDomicilioMayorista() { return DomicilioMayorista; }
    public String getTelefonoMayorista() { return TelefonoMayorista; }
    public String getComisionLocal() { return ComisionLocal; }
    public String getComisionVendedores() { return ComisionVendedores; }
    public String[] getTitulosEmpresas(){ return TitulosEmpresas; }
    public String getTituloEmpresa(Integer i){ return TitulosEmpresas[i]; }

}
