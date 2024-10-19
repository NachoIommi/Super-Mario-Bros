package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ranking implements Serializable{

	protected List<String> jugadores;
	protected List<String> puntajes;
	
	public Ranking() {
		jugadores = new ArrayList<String>();
		puntajes = new ArrayList<String>();
	}
	public void addPuntaje(String jugador, String puntaje) {
		jugadores.add(jugador);
		puntajes.add(puntaje);
	}
	public List<String> getJugadores(){
		return jugadores;
	}
	public List<String> getPuntajes(){
		return puntajes;
	}
		
}
