package model;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Actividad
{
	private String titulo;
	private String descripcion;
	private String tipo;
	private String fecha;
	private static String horaInicial;
	private static String horaFinal;
	private static long tiempoRealizacion;
	private boolean isTiempoReal;
	private Participante autor;
	private String iD;
	
	public Actividad(String titulo, String descripcion, String tipo, String fecha, 
			String horaInicial, String horaFinal, long tiempoRealizacion, boolean isTiempoReal, 
			Participante autor, String iD)
	{
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fecha = fecha;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.tiempoRealizacion = tiempoRealizacion;
		this.isTiempoReal = isTiempoReal;
		this.autor = autor;
		this.iD = iD;
	}

	public Participante getAutor() {
		return this.autor;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public long getTiempoRelizacion() {
		return tiempoRealizacion;
	}

	public static long calcularTiempo(String horaInicial, String horaFinal)
		{


			String[] horaInicial1 = horaInicial.split("/");
			Calendar hora1 = Calendar.getInstance();
			hora1.set(0, 0, 0, Integer.parseInt(horaInicial1[0]), Integer.parseInt(horaInicial1[1]));

			String[] horaFinal2 = horaFinal.split("/");
			Calendar hora2 = Calendar.getInstance();
			hora2.set(0, 0, 0, Integer.parseInt(horaFinal2[0]), Integer.parseInt(horaFinal2[1]));

			long diferencia = TimeUnit.MILLISECONDS.toSeconds(hora2.getTimeInMillis() - hora1.getTimeInMillis());
			tiempoRealizacion = diferencia;

			return tiempoRealizacion;
		}

}