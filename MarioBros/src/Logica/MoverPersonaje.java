package Logica;

import GUI.ControladorVistas;
import Personaje.Personaje;

public class MoverPersonaje extends Thread {
	
	Juego juego;

	
	public MoverPersonaje(Juego j) {
		juego = j;
		
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
	        	
	        	
	            Thread.sleep(200);  // Pausar el hilo
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	           
	    }
	}


	
	

}
