package consola;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Proyecto;
import procesamiento.Plataforma;

public class Aplicacion
{

	public int iDProyecto = 0;
	private ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();

	public void cargarProyectos(String rutaArchivo)
		{
			BufferedReader lector;
			String linea;
			String partes[];
	
			try
				{
					lector = new BufferedReader(new FileReader(rutaArchivo));
					
					lector.readLine();
	
					while ((linea = lector.readLine()) != (null))
						{
							partes = linea.split(";");

							Proyecto proyecto = new Proyecto(partes[0], partes[1], partes[2], partes[3], Integer.parseInt(partes[4]));
							proyectos.add(proyecto);
						}
						
						lector.close();
						linea = null;
						partes = null;
	
				} catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
		}

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

		boolean continuar = true;
		boolean seleccion = false;
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
						ejecutarCrearProyecto();
					else if (opcion_seleccionada == 2)
						ejecutarCargarProyecto();
					else if (opcion_seleccionada == 3)
						{
							ejecutarCargarParticipantes(iDProyecto);
							ejecutarCargarActividades(iDProyecto);
							System.out.println(Proyecto.getParticipantes().get(0).getActividades().get(0).getAutor().getNombre());

							seleccion = true;
						}
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
					}
					else if (opcion_seleccionada == 2)
					{
						ejecutarCargarProyecto();
						seleccion = true;
					}
					else if (opcion_seleccionada == 3)
					{
						ejecutarInciarActividad();
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
		System.out.println("3. Iniciar una nueva actividad");
		System.out.println("0. Guardar y salir del proyecto");
	}
	
	public void mostrarMenuApp() 
	{
		System.out.println("\n"+" --- Seleccion de proyecto --- "+"\n");
		System.out.println("1. Crear un nuevo proyecto");
		System.out.println("2. Cargar un proyecto");

		System.out.println("0. Salir");
	}

	private void ejecutarInciarActividad()
		{
			Proyecto.iniciarActividad();
		}

	private void ejecutarCargarProyectos()
		{
			String ruta = "./././data/proyectos.csv";
			cargarProyectos(ruta);
		}

	private void ejecutarCargarActividades(int iDProyecto){

		String rutaArchivo = "./././data/proyecto "+iDProyecto+"/actividades.csv";

		Proyecto.cargarActividades(rutaArchivo);

	}

	private void ejecutarCargarParticipantes(int iDProyecto)
		{
			String rutaArchivo = "./././data/proyecto "+iDProyecto+"/participantes.csv";
	
			Proyecto.cargarParticipantes(rutaArchivo);
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
		Plataforma.crearParticipante(tempNombre,tempCorreo,isDuenio);
	}
	
	
	/**
	 * Crea un nuevo proyecto
	 */
	private String ejecutarCrearProyecto()
	{
		System.out.println("\n"+"--- Crear Proyecto ---"+"\n");
		System.out.println("\n"+"Debe digitar el nombre, la descripcion y la fecha inicial y el creador del proyecto."+"\n");
		String tempNombreProyecto = input("\n"+"Nombre del proyecto");
		String tempDescripcion= input("\n"+"Descripcion");
		String tempFechaInicial = input("\n"+"Fecha inicial en formato DD-MM-AAAA");
		String tempFechaFinal = input("\n"+"Fecha final en formato DD-MM-AAAA (Si se desconoce, dejar en blanco)");
		int tempID = 1 + Plataforma.cargarID();
		System.out.println(tempID);
		Plataforma.crearProyecto(tempNombreProyecto, tempDescripcion, tempFechaInicial, tempFechaFinal, tempID);
		System.out.println("\n"+"A continuacion debe digitar los datos del creador del proyecto");
		ejecutarCrearParticipante(true);
		return tempNombreProyecto;
	}
	
	/*
	 * Carga un proyecto a partir del nombre del proyecto
	 * Por ahora se indica el nombre y se dirige a la carpeta para cargar los .csv del proyecto, de los participantes y de las actividades.
	 */
	private void ejecutarCargarProyecto()
		{

			System.out.println("\n"+"--- Cargar Proyecto ---"+"\n");
			String nombreProyecto = input("\n"+"Inserte el nombre del proyecto");

			for(Proyecto proyecto : proyectos)
				{
					System.out.println("-----------");

					if (proyecto.getNombre().equals(nombreProyecto))
						{
							
							iDProyecto = proyecto.getId();

						}

				}
			
			if (iDProyecto != 0)
				{
					ejecutarCargarParticipantes(iDProyecto);
					ejecutarCargarActividades(iDProyecto);

				}
			else
				{
					System.out.println("\nEl proyecto no se ha encontrado.");
				}

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
	public static String input(String mensaje)
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
		consola.ejecutarCargarProyectos();
		consola.ejecutarAplicacion();
	}

}