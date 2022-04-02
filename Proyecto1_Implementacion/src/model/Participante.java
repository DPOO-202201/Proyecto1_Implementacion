package model;

import java.util.ArrayList;

public class Participante
{
	private String nombre;
	private String correo;
	private boolean isDuenio;
	private ArrayList<Actividad> actividadesRealizadas;
	
	public Participante(String nombre, String correo) 
	{
		this.nombre = nombre;
		this.correo = correo;
		this.isDuenio = isDuenio;
	}
}