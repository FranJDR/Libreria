package modelo;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import modelo.enums.Procedures;

public class Conexion {

    private final String user;
    private final String password;
    private final String nombreBBDD;

    private final String url = "jdbc:mysql://localhost/bbdd";

    private Connection connection;
    private Statement miStatement;

    private static Conexion conexion;

    public Conexion() {
        super();
        this.user = "root";
        this.password = "";
        this.nombreBBDD = "libreriafjdr";
    }

    public static Conexion instance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    private void abrirConexion() {
        try {
            this.connection = DriverManager.getConnection(this.url.replace("bbdd", this.nombreBBDD), this.user,
                    this.password);
            this.miStatement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeProcedure(Procedures procedure, String... parametros) {
        assert procedure.getNumParametros() != parametros.length;
        this.abrirConexion();
        try {
            CallableStatement callableStatement = this.connection.prepareCall("CALL " + procedure.getNombre());
            for (int i = 0; i < procedure.getNumParametros(); i++) {
                callableStatement.setString(i + 1, parametros[i]);
            }
            callableStatement.execute();
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[][] obtenerTablaHistorico() {
        this.abrirConexion();
//		try {
//			CallableStatement callableStatement = this.connection.prepareCall("obtenerTablaHistorico()");
//			callableStatement.registerOutParameter(1, Types.VARCHAR);
//			callableStatement.executeUpdate();
//			String consulta = callableStatement.getString(1);
//			System.out.println(consulta);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

        CachedRowSet resul = this.executeQuery("SELECT * FROM historico");
        String[][] datos = null;
        int indice = 0;
        try {
            datos = new String[resul.size()][3];
            while (resul.next()) {
                datos[indice][0] = resul.getString("isbn");
                datos[indice][1] = resul.getString("operacion");
                datos[indice][2] = resul.getString("fecha");
                indice++;
            }
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    private ResultSet executeSelect(String consulta) {
        try {
            return this.miStatement.executeQuery(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CachedRowSet executeQuery(String consulta) {
        this.abrirConexion();
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(this.executeSelect(consulta));
            this.connection.close();
            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> obtenerListCampo(String consulta, String campo) {
        CachedRowSet cachedRowSet = this.executeQuery(consulta);
        ArrayList<String> list = new ArrayList<String>();
        try {
            while (cachedRowSet.next()) {
                list.add(cachedRowSet.getString(campo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String obtenerCampo(String consulta, String campo) {
        CachedRowSet cachedRowSet = this.executeQuery(consulta);
        String retorno = null;
        try {
            cachedRowSet.next();
            return retorno = cachedRowSet.getString(campo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }

}
