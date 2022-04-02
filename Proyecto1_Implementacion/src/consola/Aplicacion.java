package consola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Participante;
import procesamiento.Plataforma;

public class Aplicacion
{
	/**
	 * Ejecuta la aplicación: le muestra el menú al usuario y la pide que ingrese
	 * una opción, y ejecuta la opción seleccionada por el usuario. Este proceso se
	 * repite hasta que el usuario seleccione la opción de abandonar la aplicación.
	 * @return 
	 */
	public void ejecutarAplicacion()
	{
		/**
		 * Define las rutas donde estan almacenados los documentos.
		 */
		String rutaProyectos = System.getProperty("user.dir") + "\\data\\proyectos";
		String rutaUsuarios = System.getProperty("user.dir") + "\\data\\usuarios";

		boolean continuar = true;
		boolean seleccion = false;
		String nombreProyecto = "";
		/*
		 * Mientras que el usuario no haya salido de la aplicacion
		 */
		while (continuar)
		{
			try
			{
				/*
				 * Si el usuario ya selecciono un proyecto, le ofrecera opciones para trabajar con este
				 * 
				 * El usuario puede volver al menu de seleccion de proyectos
				 */
				if (seleccion)
				{
					mostrarMenuProyecto();
					int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion"));
					if (opcion_seleccionada == 1)
						nombreProyecto = ejecutarCrearProyecto();
					else if (opcion_seleccionada == 2)
						ejecutarCargarProyecto();
					else if (opcion_seleccionada == 0)
					{
						System.out.println("\n"+"Saliendo del proyecto..."+"\n");
						seleccion = false;	
					}
					
				}
				/*
				 * Si no ha seleccionado un proyecto, le pedira que cargue uno o que cree uno
				 * 
				 * El usuario puede salir de la aplicacion desde aca
				 */
				else
				{
					mostrarMenuApp();
					int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion"));
					if (opcion_seleccionada == 1) 
					{
						ejecutarCrearProyecto();
						seleccion = true;
					}
					else if (opcion_seleccionada == 2)
					{
						ejecutarCargarProyecto();
						seleccion = true;
					}
					else if (opcion_seleccionada == 0)
					{
						System.out.println("\n"+"Saliendo de la aplicacion..."+"\n");
						continuar = false;
					}
				}
				
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	/**
	 * Muestra al usuario el menú con las opciones para que escoja la siguiente
	 * acción que quiere ejecutar.
	 */
	public void mostrarMenuProyecto()
	{
		System.out.println("\nOpciones de la aplicacion:\n");
		System.out.println("1. Registrar nuevo participante");
		System.out.println("2. Crear un nuevo proyecto");
		System.out.println("0. Guardar y salir del proyecto");
	}
	
	public void mostrarMenuApp() 
	{
		System.out.println("\n"+" --- Seleccion de proyecto --- "+"\n");
		System.out.println("1. Crear un nuevo proyecto");
		System.out.println("2. Cargar un proyecto");
		System.out.println("0. Salir");
	}
	

	/**
	 * Crea un nuevo usuario
	 */
	private void ejecutarCrearParticipante(boolean isDuenio)
	{
		System.out.println("\n"+"--- Registrar Participante ---"+"\n");
		System.out.println("\n"+"Debe digitar el nombre y el correo del participante que quiere agregar."+"\n");
		String tempNombre = input("\nNombre del participante");
		String tempCorreo = input("\nCorreo del participante");
		//Plataforma.crearParticipante(tempNombre,tempCorreo,isDuenio);
	}
	
	
	/**
	 * Crea un nuevo proyecto
	 */
	private String ejecutarCrearProyecto()
	{
		System.out.println("\n"+"--- Crear Proyecto ---"+"\n");
		System.out.println("\n"+"Debe digitar el nombrem la descripcion y la fecha inicial y el creador del proyecto."+"\n");
		String tempNombreProyecto = input("\n"+"Nombre del proyecto");
		String tempDescripcion= input("\n"+"Descripcion");
		String tempFechaInicial = input("\n"+"Fecha inicial en formato DD-MM-AAAA");
		String tempFechaFinal = input("\n"+"Fecha final en formato DD-MM-AAAA (Si se desconoce, dejar en blanco)");
		int tempID = 0;
		//Plataforma.crearProyecto(tempNombreProyecto, tempDescripcion, tempFechaInicial, tempFechaFinal, tempID);
		System.out.println("\n"+"A continuacion debe digitar los datos del creador del proyecto");
		ejecutarCrearParticipante(true);
		return tempNombreProyecto;
	}
	
	/*
	 * Carga un proyecto a partir de un archivo .csv
	 */
	private void ejecutarCargarProyecto()
	{
		System.out.println("\n"+"--- Cargar Proyecto ---"+"\n");
		System.out.println("\n"+"Debe digitar el nombre del proyecto (NO incluya .csv al final)."+"\n");
		String tempNombre = input("\n"+"Nombre del proyecto: ");
		Plataforma.cargarProyecto(tempNombre);
	}

	/**
	 * Agrega un elemento a un pedido
	 */
		
	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Este es el método principal de la aplicación, con el que inicia la ejecución
	 * de la aplicación
	 * 
	 * @param args Parámetros introducidos en la línea de comandos al invocar la
	 *             aplicación
	 */
	public static void main(String[] args)
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}

}