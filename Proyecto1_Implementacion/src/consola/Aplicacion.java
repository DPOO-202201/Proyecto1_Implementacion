package consola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion"));
				if (opcion_seleccionada == 1)
					ejecutarRegistrarParticipante();
				else if (opcion_seleccionada == 2)
					ejecutarCrearProyecto();
				else if (opcion_seleccionada == 0)
				{
					System.out.println("\nSaliendo de la aplicación...\n");
					continuar = false;
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
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicacion:\n");
		System.out.println("1. Registrar nuevo participante");
		System.out.println("2. Crear un nuevo proyecto");
		System.out.println("0. Salir");
	}
	

	/**
	 * Crea un nuevo usuario
	 */
	private void ejecutarRegistrarParticipante()
	{
		System.out.println("\n");
		//Plataforma.registrarParticipante();
	}
	
	
	/**
	 * Crea un nuevo proyecto
	 */
	private void ejecutarCrearProyecto()
	{
		System.out.println("\n" + "Crear nuevo proyecto" + "\n");
		//Plataforma.crearProyecto();
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