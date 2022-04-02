package procesamiento;

import java.util.ArrayList;
import model.Proyecto;

public class Plataforma
{
	private ArrayList<Proyecto> proyectos;
	
	public void registrarParticipante(String nombre, String correo)
	{
		
	}
	public void crearProyecto(String nombre, String descripcion, String fechaInicial, String fechaFinal, int id)
	{
		Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, fechaInicial, fechaFinal, id);
		proyectos.add(nuevoProyecto);
	}
	
}