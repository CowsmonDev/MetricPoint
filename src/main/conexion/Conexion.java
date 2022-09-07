package main.conexion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * <b>Clase Padre Conexion</b>
 * <p>esta clase contiene todos los datos generales sobre la conexion a la base de datos</p>
 * <p>Tambien contiene tanto la variable de tipo Conexion, el Statement, ResultSet y PreparedStatement para realizar la conexion
 * consultas y actividades similares</p>
 * <p>la clase tambien contiene el enlace contraseña y usuario a la base de datos</p>
 */
public abstract class Conexion {

    protected static Connection conexionf;
    protected static Statement st;
    protected static ResultSet rs;
    protected static PreparedStatement ps;

    private final String url = "jdbc:mysql://localhost/metricpoint?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "";

    protected String Campos = "";
    protected String Table = "";
    protected String Insert = "";
    protected String Update = "";
    protected String Delete = "";

    protected Conexion(){ }

    /**
     * {@code Procedimiento sin retorno: } abre la conexion a la base de datos
     */
    public void connopen(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexionf = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Conectar a la base de datos: " + e);
        }
    }

    /**
     * {@code Procedimiento sin retorno: } cierra la conexion a la base de datos
     */
    public void connclose(){
        try {
            conexionf.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al Cerrar la base de datos: " + e);
        }
    }

    /**{@code Procedimiento sin retorno} En procedimiento realizara multiples consultas de forma pararela a la base de datos.
     * estas se cargaran al prepareStatement para luego ser enviadas...
     *
     * @param Cadena Map<String, String[]> que contiene las consultas que seran enviadas a la base de datos, este contiene como clave
     *               la consulta y como valor un String[] que contiene los parametros necesarios para completar el prepareStatement
     *               en cada consulta individual
     */
    public void MultiQuery(Map<String, String[]> Cadena){
        try {
            conexionf.setAutoCommit(false);
            for (Map.Entry<String, String[]> cadena : Cadena.entrySet()) {
                ps = conexionf.prepareStatement(cadena.getKey());
                int indice = 1;
                for (String campo : cadena.getValue())
                    ps.setString(indice++, campo);
                ps.executeUpdate();
            }
            conexionf.commit();
            conexionf.setAutoCommit(true);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ha Habido un Error al intentar realizar una accion en la base de datos: " + e);
        }
    }

    /**
     * {@code Procedimiento sin retorno} el cual ejecutara una consulta a la base de datos
     * que cumpla con las caracteristicas de la consulta pasada por parametro
     * @param Cadena este parametro contiene la consulta que se hara a dicha base de datos, esta debera ser presentada
     *               con todas las caracteristicas estandares de SQL, en caso de haber algun error en la consulta
     *               el programa lanzara un mensaje de alerta con un SQLException
     * @param Campos String[] que contiene todos los valores que seran pasados por el prepareStatement
     *               este valor debe concordar con la cantidad de ? que hay en el String del parametro Cadena
     *               en caso de no cumplir lo ultimo dara una excepcion de tipo SQLException
     * @since 1.0
     */
    public void OnlyQuery(String Cadena, String[] Campos){
        int indice = 1;
        try {
            ps = conexionf.prepareStatement(Cadena);
            for (String dato : Campos)
                ps.setObject(indice++, dato);
            ps.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ha Habido un Error al intentar realizar la accion en la base de datos\n" + e);
        }
    }

    public boolean Comprobar(String[] campos, String[] datos){
        if ((campos.length == datos.length) && (campos.length > 0)){
            StringBuilder cadena = new StringBuilder("SELECT " + campos[0]);
            for (var i = 1; i < datos.length; i++)
                cadena.append(", ")
                        .append(campos[i]);

            cadena.append(" FROM ")
                    .append(Table)
                    .append(" WHERE ")
                    .append(campos[0])
                    .append(" = ")
                    .append("'")
                    .append(datos[0])
                    .append("'");
            for (var i = 1; i < datos.length; i++)
                cadena.append(" AND ")
                        .append(campos[i])
                        .append(" = ")
                        .append("'")
                        .append(datos[i])
                        .append("'");

            return Comprobar(String.valueOf(cadena));
        }else return false;
    }

    public boolean Comprobar(String[][] campos){
        if (campos.length > 0){
            StringBuilder cadena = new StringBuilder("SELECT " + campos[0][0]);
            for(var i = 1; i < campos.length; i++)
                cadena.append(", ")
                        .append(campos[i][0]);
            cadena.append(" FROM ")
                    .append(Table)
                    .append(" WHERE ")
                    .append(campos[0][0])
                    .append(" = ")
                    .append("'")
                    .append(campos[0][1])
                    .append("'");
            for (var i = 1; i < campos.length; i++)
                cadena.append(" AND ")
                        .append(campos[i][0])
                        .append(" = ")
                        .append("'")
                        .append(campos[i][1])
                        .append("'");
            return Comprobar(String.valueOf(cadena));
        }else return false;
    }

    /**{@code Function con retorno} El cual ejecutara una consulta a la base de datos y verificara si esta devuelve algun valor.
     *
     * @param Cadena esta es la consulta que se realizara a la base de datos.
     * @return devuelve verdadero en caso de no encontrar ningun elemento que cumpla con la consulta.
     */
    public boolean Comprobar(String Cadena){
        try {
            st = conexionf.createStatement();
            rs = st.executeQuery(Cadena);
            return !rs.next();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "se ha encontrado un error al intentar acceder a la base de datos: " + e);
        }
        return false;
    }

    /**{@code Function con retorno} El cual ejecutara una consulta a la base de datos y verificara si esta devuelve algun valor
     *
     * @param campo columna de la tabla en el cual se buscara coincidencia.
     * @param dato dato que se comparara con la columna solicitada.
     * @return devuelve verdadero en caso de no encontrar ningun elemento que cumpla con la consulta.
     */
    public boolean Comprobar(String campo, String dato){ return Comprobar("SELECT " + campo + " FROM " + Table + " WHERE " + campo + " = '" + dato + "'"); }

    /**{@code Function con retorno} el cual ejecutara una consulta a la base de datos, con los datos resultantes se llenara un ArrayList el cual contendra los valores resultantes de la consulta en el campo solicitado
     *
     * @param cadena consulta que se realizara a la base de datos
     * @param campo campo de la base de datos del cual se tomaran los valores para llenar el ArrayList\<String\>
     * @return ArrayList\<String\> el cual contendra los datos del campo solicitado
     */
    public String[] llenarArray(String cadena, String campo) {
        ArrayList<String> array = new ArrayList<>();
        try {
            st = conexionf.createStatement();
            rs = st.executeQuery(cadena);
            while(rs.next()){
                array.add(rs.getString(campo));
            }

            return array.toArray(new String[0]);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return new String[]{};
    }

    /**{@code Procedimiento sin retorno} el cual ejecutara un insert a una tabla en la base de datos
     * esta tabla se definira en las clases hijas de esta.
     * @param arrayCampos estos son los parametros que se requieren para completar el prepareStatent en la consulta
     */
    public void insertDate(String[] arrayCampos){
        OnlyQuery(
                getInsert(),
                arrayCampos
        );
    }

    /**{@code Procedimiento sin retorno} el cual ejecutara una Modificacion a una tabla en la base de datos
     * esta tabla se definira en las clases hijas de esta.
     * @param arrayCampos estos son los parametros que se requieren para completar el prepareStatent en la consulta
     */
    public void updateDate(String[] arrayCampos){
        OnlyQuery(
                getUpdate(),
                arrayCampos
        );
    }

    /**{@code Procedimiento sin retorno} el cual ejecutara un Eliminado a una tabla en la base de datos
     * esta tabla se definira en las clases hijas de esta.
     * @param arrayCampos estos son los parametros que se requieren para completar el prepareStatent en la consulta
     */
    protected void deleteDate(String[] arrayCampos){
        OnlyQuery(
                getDelete(),
                arrayCampos
        );
    }

    //modificar comentario
    /**{@code Procedimiento sin retorno} el cual llenara una lista que contendra los valores que se utilizaran para llenar las tablas
     *
     * @param consulta la consulta que se realizara a la base de datos
     */
    protected ArrayList<String[]> llenarTabla(String consulta){
        ArrayList<String[]> Lista = new ArrayList<>();
        try {
            st = conexionf.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next())
                Lista.add(getNewNode(rs));//Crea un String[] utilizando una function creada en las clases hijas.

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al llenar la tabla: " + e);
        }
        return Lista;
    }

    //modificar comentario
    /**{@code Procedimiento sin retorno} el cual llenara una lista que contendra los valores que se utilizaran para llenar las tablas
     */
    public ArrayList<String[]> llenarTabla(){
        return llenarTabla(
                "SELECT " + getCampos() + " FROM " + getTabla()
        );
    }

    public ArrayList<String[]> llenarTabla(String Campo, String Valor){
        return llenarTabla("SELECT " + getCampos() + " FROM " + getTabla() + " WHERE " + Campo + " LIKE '%" + Valor + "%'");
    }

    public ArrayList<String[]> getFilterDate(String Texto, String campo){
        return (!Texto.equals(""))? llenarTabla(campo, Texto) : llenarTabla();
    }

    /**{@code Function con retorno} realizara un get de un elemento privado
     *
     * @return Devuelve la tabla a la cual se estara conectando para la realizacion de las consultas
     */
    public String getTabla(){ return Table; }

    /**{@code Function con retorno} realizara un get de un elemento privado
     *
     * @return Devuelve la consulta la cual se utilizara al momento de insertar un nuevo registro en la base de datos
     */
    public String getInsert(){ return Insert; }

    /**{@code Function con retorno} realizara un get de un elemento privado
     *
     *
     * @return Devuelve la consulta la cual se utilizara al momento de modificar un registro en la base de datos
     */
    public String getUpdate(){ return Update; }

    /**{@code Function con retorno} realizara un get de un elemento privado
     *
     * @return Devuelve la consulta la cual se utilizara al momento de eliminar un registro en la base de datos
     */
    public String getDelete(){ return Delete; }

    /**{@code Function con retorno} realizara un get de un elemento privado
     *
     * @return Devuelve los campos a los que seran accedidos durante las conexiones a la base de datos
     */
    public String getCampos(){ return Campos; }

    /**{@code Function abstracta con retorno} que llenara un String[] dependiendo de la clase hija que lo declare, luego devolvera este String[]
     *
     * @param rs contendra el ResultSet que devolvio la base de datos despues de realizar la consulta a la misma
     * @return devuelve un String[] el cual contendra los valores que vendran del ResultSet, Estos cambiaran dependiendo la clase hija que se estara utilizando
     * @throws SQLException En caso de un error esto lanzara un SQLException
     */
    protected abstract String[] getNewNode(ResultSet rs) throws SQLException;



}

