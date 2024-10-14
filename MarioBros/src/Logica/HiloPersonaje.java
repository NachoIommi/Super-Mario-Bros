package Logica;

import GUI.ControladorVistas;
import Personaje.Personaje;

public class HiloPersonaje extends Thread {
	
	Juego juego;
	
	public HiloPersonaje(Juego j) {
		juego = j;
	}
	
	public void run() {
		while(true) {
			try {
				juego.getPersonaje().moverPersonaje();
				Thread.sleep(200);
				System.out.println(juego.getPersonaje().getPosX());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}
	}
	
	
	

}
