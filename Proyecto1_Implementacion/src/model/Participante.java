package model;

import java.util.ArrayList;
import java.util.HashMap;

import consola.Aplicacion;

import java.io.InputStreamReader;

public class Participante
{
	private String nombre;
	private String correo;
	private boolean isDuenio;
	private ArrayList<Actividad> actividadesRealizadas;
	
	public Participante(String nombre, String correo, boolean isDuenio) 
	{
		this.nombre = nombre;
		this.correo = correo;
		this.isDuenio = isDuenio;
		this.actividadesRealizadas = new ArrayList<Actividad>();
	}

	public String getNombre()
		{
			return this.nombre;
		}

	public ArrayList<Actividad> getActividades()
		{
			return this.actividadesRealizadas;
		}
	
	public long tiempoTotalActividades() {
		long total = 0;
		for(int i=0; i<actividadesRealizadas.size(); i++) {
			Actividad actual = actividadesRealizadas.get(i);
			total+=actual.getTiempoRelizacion();
		}
		return total;
		}
	
	public HashMap<String,Long> tiempoPromedioPorActividad() {
		HashMap<String,Long[]> timeMap = new HashMap<String,Long[]>();
		for(int i=0; i<actividadesRealizadas.size(); i++) {
			Actividad actual = actividadesRealizadas.get(i);
			if(timeMap.containsKey(actual.getTipo())){
				Long[] val = timeMap.get(actual.getTipo());
				val[0]++;
				val[1]+=actual.getTiempoRelizacion();
				timeMap.put(actual.getTipo(),val);
			}
			else {
				Long[] val = {(long) 1,actual.getTiempoRelizacion()};
				timeMap.put(actual.getTipo(), val);
			}	
		}
		HashMap<String,Long> mapDef = new HashMap<String,Long>();
		for(String llave : timeMap.keySet()) {
			Long[] val = timeMap.get(llave);
			mapDef.put(llave,(val[1]/val[0]));
		}
		return mapDef;
	}

	public static void nuevaActividad()
		{
			boolean isTiempoReal = Boolean.parseBoolean(Aplicacion.input("Inserte true si el tiempo de la se v a tomar en tiempo real o false si es una actividad ya realizada"));

			String atr = Aplicacion.input("Inserte el nombre del autor de la actividad");
			Participante autor = new Participante("a", "a", false);
	
			for(Participante participante : Proyecto.getParticipantes())
				{
					if (participante.getNombre().equals(atr))
						{
							autor = participante;
						}
					else
						{
							System.out.println("El autor no se encuentra como participante del proyecto");
						}
				}

			String titulo = Aplicacion.input("Inserte un titulo para la actividad");
			String descripcion = Aplicacion.input("Inserte una descripcion para la actividad");
			String fecha = Aplicacion.input("Inserte la fecha en la que incia la actividad en formato DD/MM/YYYY");
			String horaInicial = Aplicacion.input("Inserte la hora en la que incia la actividad en formato HH/MM");
			String tipo = Aplicacion.input("Inserte el tipo de esta actividad");

			String horaFinal = "00/00";
			long tiempoRealizacion = 0;
				
			if(isTiempoReal == true)
				{



				}
			else
				{

					horaFinal = Aplicacion.input("Inserte la hora en la que finalizo la actividad en formato HH/MM");
					tiempoRealizacion = Actividad.calcularTiempo(horaInicial, horaFinal);

				}

			Actividad actividad = new Actividad(titulo, descripcion, tipo, fecha, horaInicial, horaFinal, tiempoRealizacion, isTiempoReal, autor, "0");
			
		}


		
}
