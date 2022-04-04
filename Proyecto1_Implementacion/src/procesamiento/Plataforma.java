package procesamiento;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import model.Participante;
import model.Proyecto;

public class Plataforma
{
	String rutaArchivos = "./././data/";
	
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
	
	//Funcion para cargar los proyectos
	public int cargarProyectos()
	{
		String rutaProyectos = "\\data\\proyectos.csv";
		String tempLinea = null;
		int tempID = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(rutaProyectos));
			tempLinea = br.readLine();
			while (tempLinea != null)
			{
				String[] tempDatos = tempLinea.split(";");
				tempID = Integer.parseInt(tempDatos[4]);
				Proyecto tempProyecto = new Proyecto(tempDatos[0], tempDatos[1], tempDatos[2], tempDatos[3], tempID);
				listaProyectos.add(tempProyecto);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempID;
	}
	
	/*
	 * Funcion para cargar un proyecto
	 */
	public static void seleccionarProyecto(String nombre)
	{
		String rutaProyectos = System.getProperty("user.dir") + "\\data\\proyectos.csv" + nombre;
		
	}
	
	/*
	 * Funcion para añadir un participante
	 */
	public static void crearParticipante(String nombre, String correo, boolean isDuenio)
	{
		Participante nuevoParticipante = new Participante(nombre, correo, isDuenio);
		listaParticipantes.add(nuevoParticipante);
	}
	
	//Funcion para cargar el contador de IDs
	
	public static int cargarID()
	{
		int contador = 0;
		String rutaID = "data\\proyectos.csv";
		BufferedReader br = null;
		String tempLinea = null;
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(rutaID));
			tempLinea = br1.readLine();
			while (tempLinea != null)
			{
				String[] tempDatos = tempLinea.split(";");
				contador = Integer.parseInt(tempDatos[4]);
			}
			br1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contador;
	}
}
