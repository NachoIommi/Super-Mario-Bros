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
