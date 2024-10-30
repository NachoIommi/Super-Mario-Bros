package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking implements Serializable{

	protected List<Jugador> jugadores;
	
	public Ranking() {
		jugadores = new ArrayList<Jugador>();
	}
	
	public void addJugador(Jugador j) {
		// Verificar si ya existe un jugador con el mismo nombre
	    for (Jugador jugador : jugadores) {
	        if (jugador != null && jugador.getNombre() != null && jugador.getNombre().equals(j.getNombre())) {
	            // Si existe, actualizamos el puntaje
	            jugador.setNuevoPuntaje(j.getPuntaje());
	            return;
	        }
	    }
	    // Si no existe, añadimos al jugador como nuevo
	    jugadores.add(j);
	}
	
	public void imprimirJugadores() {
		Collections.sort(this.jugadores, Collections.reverseOrder());
		System.out.println("\n Mejores Jugadores");
		int i = 0;
		for(Jugador j : this.jugadores) {
			System.out.println(j.getNombre() + " " + j.getPuntaje());
			if(i == 5)
				break;
			i++;
		}
	}
	
	public List<Jugador> getJugadores(){
		return jugadores;
	}
		
}
