package almacen;

import java.io.File;
import java.util.ArrayList;

public class AlmacenIndividual<T> {

	private final String DIRECTORIO;
	private final String EXTENSION;
	private DAO<T> dao;

	public AlmacenIndividual(String directorio, String extension) {
		super();
		this.dao = new DAO<T>();
		File fileDirectorioFile = new File(directorio);
		if (!fileDirectorioFile.exists()) {
			fileDirectorioFile.mkdir();
		}

		this.DIRECTORIO = directorio + "/";
		this.EXTENSION = "." + extension;
	}

	public T getObject(String nombreFichero) {
		return this.dao.leer(this.obtenerRuta(nombreFichero));
	}

	public void eliminarFichero(String nombreFichero) {
		if (new File(this.obtenerRuta(nombreFichero)).exists())
			new File(this.obtenerRuta(nombreFichero)).delete();
	}

	public boolean grabarObject(String nombreFichero, T object) {
		return this.dao.grabar(this.obtenerRuta(nombreFichero), object);
	}

	public ArrayList<T> getListObject() {
		ArrayList<T> list = new ArrayList<T>();
		String[] nombreArchivo = new File(this.DIRECTORIO).list();
		for (int i = 0; i < nombreArchivo.length; i++)
			list.add(this.dao.leer(this.DIRECTORIO + nombreArchivo[i]));
		return list;
	}

	private String obtenerRuta(String nombreFichero) {
		return this.DIRECTORIO + nombreFichero + this.EXTENSION;
	}

}
