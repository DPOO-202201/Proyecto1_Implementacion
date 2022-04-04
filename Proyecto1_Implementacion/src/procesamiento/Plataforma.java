package procesamiento;

import java.util.ArrayList;
import java.io.File;
import model.Participante;
import model.Proyecto;

public class Plataforma
{
	String rutaArchivos = System.getProperty("user.dir") + "\\data";
	
	/*
	 * Definiendo las listas donde se van a guardar los datos
	 */
	private static ArrayList<Proyecto> listaProyectos;
	private static ArrayList<Participante> listaParticipantes;
	
	/*
	 * Funcion para crear un proyecto
	 */
	public static void crearProyecto(String nombre, String descripcion, String fechaInicial, String fechaFinal, int id)
	{
		Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, fechaInicial, fechaFinal, id);
		nuevoProyecto.crearArchivoProyecto();
	}
	
	/*
	 * Funcion para cargar un proyecto
	 */
	public static void cargarProyecto(String nombre)
	{
		String rutaProyectos = System.getProperty("user.dir") + "\\data\\proyectos\\" + nombre;
	}
	
	/*
	 * Funcion para añadir un participante
	 */
	public static void crearParticipante(String nombre, String correo, boolean isDuenio)
	{
		Participante nuevoParticipante = new Participante(nombre, correo, isDuenio);
		listaParticipantes.add(nuevoParticipante);
	}
}