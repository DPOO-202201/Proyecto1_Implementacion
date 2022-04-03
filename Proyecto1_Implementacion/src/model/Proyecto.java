package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Proyecto
{
	private String nombre;
	private String descripcion;
	private String fechaInicial;
	private String fechaFinal;
	private int id;
	private ArrayList<String> tiposActividades;
	private ArrayList<Participante> participantes;
	
	public Proyecto (String nombre, String descripcion, String fechaInicial, String fechaFinal, int id)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.id = id;
		tiposActividades = new ArrayList<String>();
		participantes = new ArrayList<Participante>();
	}

	public static void crearArchivoProyecto(String nombre, String descripcion, String fechaInicial, String fechaFinal, int id) 
	{
		String nombreArchivo = nombre+".csv";
		File archivo = new File(nombreArchivo);
		try
		{
		     BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		     
		     bw.write(nombre+","+descripcion+","+fechaInicial+","+fechaFinal+","+Integer.toString(id));

		     // Hay que cerrar el fichero
		     bw.close();
		  } catch (IOException ioe){
		     ioe.printStackTrace();
		  }
			
	}
	
}