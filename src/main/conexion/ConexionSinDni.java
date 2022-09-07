package main.conexion;

import java.util.ArrayList;

public abstract class ConexionSinDni extends Conexion{
    protected String CamposSinDni = "";

    protected final String NumDni = "num_dni";

    protected ConexionSinDni(){
        super();
    }

    @Override
    public ArrayList<String[]> llenarTabla(String Dni){
        return super.llenarTabla("SELECT " + CamposSinDni + " FROM " + Table + " WHERE " + NumDni + " = " + Dni);
    }

    public ArrayList<String[]> llenarTabla(String Campo, String Valor, String Dni) {
        return super.llenarTabla("SELECT " + CamposSinDni + " FROM " + getTabla() + " WHERE " + Campo + " LIKE '%" + Valor + "%' AND " + NumDni + " = " + Dni);
    }

    public ArrayList<String[]> getFilterDate(String Texto, String campo, String Dni){
        return (!Texto.equals(""))? llenarTabla(campo, Texto, Dni) : llenarTabla(Dni);
    }

    public String getNumDni() { return NumDni; }

}
