package Logica;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable{
	
	private String nombre;
	private Integer puntaje;
	
	public Jugador(String nombre, Integer puntos) {
		this.nombre = nombre;
		this.puntaje = puntos;
	}

	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getPuntaje() {
		return this.puntaje;
	}
	
	public int compareTo(Jugador arg0) {
		return this.puntaje.compareTo(arg0.getPuntaje());
	}
	
}
