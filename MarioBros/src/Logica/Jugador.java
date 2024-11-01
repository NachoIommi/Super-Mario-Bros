package Logica;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable{
	
	private static final long serialVersionUID = 9092039043357571029L;
	
	private String nombre;
	private Integer puntaje;
	
	public Jugador(String n, Integer puntos) {
		nombre = n;
		puntaje = puntos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getPuntaje() {
		return puntaje;
	}
	
	public void setNuevoPuntaje(int p) {
		puntaje = p;
	}
	
	public int compareTo(Jugador arg0) {
		return this.puntaje.compareTo(arg0.getPuntaje());
	}
	
}
