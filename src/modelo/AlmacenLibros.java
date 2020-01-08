package modelo;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.CachedRowSet;

import modelo.enums.Libro;
import modelo.enums.Procedures;

public class AlmacenLibros {

    public ArrayList<HashMap<Libro, String>> obtenerListaLibros() {
        ArrayList<HashMap<Libro, String>> libros = new ArrayList<HashMap<Libro, String>>();
        CachedRowSet resul = Conexion.instance().executeQuery("SELECT * FROM LIBRO");
        try {
            while (resul.next()) {
                HashMap<Libro, String> auxHashMap = new HashMap<Libro, String>();
                CachedRowSet resulTema = Conexion.instance()
                        .executeQuery("SELECT * FROM TEMA WHERE idTema = " + resul.getString("idTema"));
                CachedRowSet resulEditorial = Conexion.instance()
                        .executeQuery("SELECT * FROM EDITORIAL WHERE idEditorial = " + resul.getString("idEditorial"));
                resulTema.next();
                resulEditorial.next();
                auxHashMap.put(Libro.TEMATICA, resulTema.getString("nombre"));
                auxHashMap.put(Libro.EDITORIAL, resulEditorial.getString("nombre"));
                auxHashMap.put(Libro.TITULO, resul.getString("titulo"));
                auxHashMap.put(Libro.AUTOR, resul.getString("autor"));
                auxHashMap.put(Libro.ISBN, resul.getString("isbn"));
                auxHashMap.put(Libro.PAGINAS, resul.getString("paginas"));
                auxHashMap.put(Libro.PRECIO, resul.getString("precio"));
                auxHashMap.put(Libro.FORMATO, resul.getString("formato"));
                auxHashMap.put(Libro.ESTADO, resul.getString("estado"));
                auxHashMap.put(Libro.CANTIDAD, resul.getString("cantidad"));
                libros.add(auxHashMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public ArrayList<String> obtenerListaISBN() {
        ArrayList<String> isbn = new ArrayList<String>();
        CachedRowSet resul = Conexion.instance().executeQuery("SELECT * FROM LIBRO");
        try {
            while (resul.next())
                isbn.add(resul.getString("isbn"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isbn;
    }

    public HashMap<Libro, String> obtenerLibro(String ISBN) {
        HashMap<Libro, String> libro = new HashMap<Libro, String>();
        CachedRowSet resul = Conexion.instance().executeQuery("SELECT * FROM LIBRO WHERE ISBN = " + ISBN);
        try {
            if (resul.next()) {
                String tema = Conexion.instance()
                        .obtenerCampo("SELECT * FROM TEMA WHERE idTema = " + resul.getString("idTema"), "nombre");
                String editorial = Conexion.instance().obtenerCampo(
                        "SELECT * FROM EDITORIAL WHERE idEditorial = " + resul.getString("idEditorial"), "nombre");
                libro.put(Libro.TITULO, resul.getString("titulo"));
                libro.put(Libro.AUTOR, resul.getString("autor"));
                libro.put(Libro.ISBN, resul.getString("isbn"));
                libro.put(Libro.PAGINAS, resul.getString("paginas"));
                libro.put(Libro.TEMATICA, tema);
                libro.put(Libro.EDITORIAL, editorial);
                libro.put(Libro.PRECIO, resul.getString("precio"));
                libro.put(Libro.FORMATO, resul.getString("formato"));
                libro.put(Libro.ESTADO, resul.getString("estado"));
                libro.put(Libro.CANTIDAD, resul.getString("cantidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }

    public boolean insertarLibro(HashMap<Libro, String> map) {
        Conexion.instance().executeProcedure(Procedures.INSERTAR_LIBRO, map.get(Libro.ISBN), map.get(Libro.TITULO),
                map.get(Libro.AUTOR), map.get(Libro.PAGINAS), map.get(Libro.TEMATICA), map.get(Libro.EDITORIAL),
                map.get(Libro.PRECIO), map.get(Libro.FORMATO), map.get(Libro.ESTADO), map.get(Libro.CANTIDAD));
        return true;
    }

    public void eliminartema(String tema) {
        Conexion.instance().executeProcedure(Procedures.ELIMINAR_TEMA, tema);
    }

    public void eliminarEditorial(String editorial) {
        Conexion.instance().executeProcedure(Procedures.ELIMINAR_EDITORIAL, editorial);
    }

    public void insertarTema(String tema) {
        Conexion.instance().executeProcedure(Procedures.INSERTAR_TEMA, tema);
    }

    public void insertarEditorial(String editorial) {
        Conexion.instance().executeProcedure(Procedures.INSERTAR_EDITORIAL, editorial);
    }

    public void borrarLibro(String ISBN) {
        Conexion.instance().executeProcedure(Procedures.ELIMINAR_LIBRO, ISBN);
    }

    public void modificarCantidad(String isbn, String cantidad) {
        Conexion.instance().executeProcedure(Procedures.MODIFICAR_CANTIDAD, isbn, cantidad);
    }

    public void modificarPrecio(String isbn, String precio) {
        Conexion.instance().executeProcedure(Procedures.MODIFICAR_PRECIO, isbn, precio);
    }

}
