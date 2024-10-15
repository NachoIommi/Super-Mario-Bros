package Logica;

import GUI.ControladorVistas;
import Personaje.Personaje;

public class MoverPersonaje extends Thread {
	
	protected Juego juego;

	public MoverPersonaje(Juego juego) {
		this.juego = juego;
	}
	
	public void run() {
	    while (true) {
	        try {
	            Personaje personaje = juego.getPersonaje();
	            if (personaje != null) {
	                if (personaje.getDireccion() != 0) {
	                    personaje.moverPersonaje();
	                    System.out.println("Posición X del personaje: " + personaje.getPosX());
	                }
	            }
	            Thread.sleep(200);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }   
	    }
	}
	
}
