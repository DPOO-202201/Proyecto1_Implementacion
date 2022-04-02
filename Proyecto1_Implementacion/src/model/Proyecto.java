package model;

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
	}
	
}