package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Proyecto
{
	private String nombre;
	private String descripcion;
	private String fechaInicial;
	private String fechaFinal;
	private int id;
	private ArrayList<String> tiposActividades;
	private static ArrayList<Participante> participantes = new ArrayList<Participante>();
	
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

	public static ArrayList<Participante> getParticipantes(){
		return participantes;
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

	public static void cargarParticipantes(String rutaArchivo)
	{
		BufferedReader lector;
		String linea;
		String partes[];

		try
			{
				lector = new BufferedReader(new FileReader(rutaArchivo));
				
				lector.readLine();

				while ((linea = lector.readLine()) != null)
					{
						partes = linea.split(";");

						boolean isDuenio;

						if(partes[2] == "True")
							{
								isDuenio = true;
							}
						else
							{
								isDuenio = false;
							}
						
						
						ArrayList<Participante> participantes = Proyecto.getParticipantes();
						Participante participante = new Participante(partes[0], partes[1], isDuenio);
						participantes.add(participante);

					}
					
					lector.close();
					linea = null;
					partes = null;

			} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}

	}

	public static void cargarActividades(String rutaArchivo)
	{
		BufferedReader lector;
		String linea;
		String partes[];

		try
			{
				lector = new BufferedReader(new FileReader(rutaArchivo));
				
				lector.readLine();

				while ((linea = lector.readLine()) != null)
					{
						partes = linea.split(";");
					
						String autor = partes[8];
						
						ArrayList<Participante> participantes = Proyecto.getParticipantes();

						for (Participante participante : participantes) 
							{ 
								if (participante.getNombre().equals(autor))
									{
										Actividad actividad = new Actividad(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], Integer.parseInt(partes[6]), Boolean.parseBoolean(partes[7]), participante, partes[9]);
										
										ArrayList<Actividad> actividades = participante.getActividades();
										actividades.add(actividad);
									}
							}
					}

					// ArrayList<Participante> participantes = Proyecto.getParticipantes();
					// System.out.println(participantes.get(0).getActividades().get(0).getAutor());
					
					lector.close();
					linea = null;
					partes = null;
			} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}

	}

    public static void crearArchivoProyecto(Proyecto nuevoProyecto, String rutaArchivos) {
    }

}