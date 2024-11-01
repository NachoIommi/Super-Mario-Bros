package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking implements Serializable{

	protected List<Jugador> jugadores;
	protected List<Jugador> topCinco;
	
	public Ranking() {
		jugadores = new ArrayList<Jugador>();
		topCinco = new ArrayList<Jugador>();
	}
	
	public void addJugador(Jugador j) {
	    for (Jugador jugador : jugadores) {
	        if (jugador != null && jugador.getNombre() != null && jugador.getNombre().equals(j.getNombre())) {
	            jugador.setNuevoPuntaje(j.getPuntaje());
	            ordenarTopCinco();
	            return;
	        }
	    }
	    jugadores.add(j);
	    ordenarTopCinco();
	}
	
	public void imprimirJugadores() {
	    System.out.println("\nMejores Jugadores");
	    for (Jugador j : mostrarTopCinco()) {
	        System.out.println(j.getNombre() + " " + j.getPuntaje());
	    }
	}
	
	public void ordenarTopCinco(){
		topCinco.clear();
		Collections.sort(jugadores, Collections.reverseOrder());
		for (int i = 0; i < Math.min(5, jugadores.size()); i++) {
	        topCinco.add(jugadores.get(i));
	    }
	}
	public List<Jugador> mostrarTopCinco(){
		return topCinco;
	}
	
	public List<Jugador> getJugadores(){
		return jugadores;
	}
		
}
