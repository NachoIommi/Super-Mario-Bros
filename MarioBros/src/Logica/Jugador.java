package Logica;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable{
	private String jugador;
	private Integer puntaje;
	public Jugador(String nombre, Integer puntos) {
		this.jugador = nombre;
		this.puntaje = puntos;
	}
	public String getJugador() {
		return this.jugador;
	}
	public Integer getPuntaje() {
		return this.puntaje;
	}
	public int compareTo(Jugador arg0) {
		return this.puntaje.compareTo(arg0.getPuntaje());
	}
}
