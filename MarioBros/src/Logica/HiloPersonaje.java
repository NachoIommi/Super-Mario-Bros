package Logica;

import Personaje.Personaje;

public class HiloPersonaje extends Thread {
	
	protected Juego juego; 

	public HiloPersonaje(Juego juego) {
		this.juego = juego;
	}
	
	public void run() {
	    while (true) {
	        try {            	
	        	Personaje personaje = juego.getPersonaje();
	            personaje.moverPersonaje();
	            System.out.println("Posición X del personaje: " + personaje.getPosX());            
	            Thread.sleep(65);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }   
	    }
	}
	
}
