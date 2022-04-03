package model;

public class Actividad
{
	private String titulo;
	private String descripcion;
	private String tipo;
	private String fecha;
	private String horaInicial;
	private String horaFinal;
	private int tiempoRealizacion;
	private boolean isTiempoReal;
	private Participante autor;
	private String iD;
	
	public Actividad(String titulo, String descripcion, String tipo, String fecha, 
			String horaInicial, String horaFinal, int tiempoRealizacion, boolean isTiempoReal, 
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

}