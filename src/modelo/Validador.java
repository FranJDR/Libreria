package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import modelo.enums.Error;
import modelo.enums.Libro;
import utiles.Utiles;

public class Validador {

    private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

    public boolean validarLibro(HashMap<Libro, String> map) {
        this.respuestas.clear();
        for (String campo : map.values())
            this.respuestas.add(new Respuesta(Error.CAMPO_VACIO.getMensaje(), !campo.isEmpty()));
        this.respuestas.add(new Respuesta(Error.DIGIT_ISBN.getMensaje(), this.isDigit(map.get(Libro.ISBN))));
        this.respuestas.add(new Respuesta(Error.DIGIT_PAGINAS.getMensaje(), this.isDigit(map.get(Libro.PAGINAS))));
        this.respuestas.add(new Respuesta(Error.DIGIT_PRECIO.getMensaje(), this.isDigit(map.get(Libro.PRECIO))));
        this.respuestas.add(new Respuesta(Error.LENGTH_ISBN.getMensaje(), map.get(Libro.ISBN).length() == 13));
        this.respuestas.add(new Respuesta(Error.DIGIT_AUTOR.getMensaje(), validarAutor(map.get(Libro.AUTOR))));
        this.respuestas.add(new Respuesta(Error.PRECIO_CERO.getMensaje(), validarSinCeros(map.get(Libro.PRECIO))));
        this.respuestas.add(new Respuesta(Error.PAGINAS_CERO.getMensaje(), validarSinCeros(map.get(Libro.PAGINAS))));

        for (Respuesta respuesta : respuestas) {
            if (!respuesta.isValido()) {
                Utiles.mensajeError(respuesta.getMensage());
                return false;
            }
        }
        return true;
    }

    private boolean validarAutor(String nombre) {
        return Pattern.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$*", nombre);
    }

    public boolean isLetter(String cadena) {
        if (Pattern.matches("[a-zA-Z]{1,200}", cadena))
            return true;
        Utiles.mensajeError("No se permiten numeros");
        return false;
    }

    public boolean isDigit(String cadena) {
        if (Pattern.matches("[0-9]{1,200}", cadena))
            return true;
        return false;
    }

    public boolean isNumber(String cadena) {
        if (Pattern.matches("[0-9]{1,200}", cadena))
            return true;
        Utiles.mensajeError("Tiene que ser un digito.");
        return false;
    }

    private boolean validarSinCeros(String cadena) {
        return Pattern.matches("[1-9]{1}[0-9]{0,200}", cadena);
    }

}
