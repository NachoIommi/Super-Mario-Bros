package Logica;

import Personaje.Personaje;
import Plataformas.*;

public class HiloPersonaje extends Thread {
	
	protected Juego juego; 
	Personaje personaje;// = juego.getPersonaje();
	BloqueSolido plataforma;// = juego.getPlataforma().getFirst();
	boolean b;
	public HiloPersonaje(Juego juego) {
		this.juego = juego;
		personaje = juego.getPersonaje();
		plataforma = (BloqueSolido) juego.getPlataforma().getFirst();
		b=true;
		
	}
	
	public void run() {
	    while (true) {
	        try {             
	            // Imprime la posición del personaje y la hitbox para depurar
	            //System.out.println("Posición del personaje: " + personaje.getPosX() + ", " + personaje.getPosY());
	            //System.out.println("Hitbox del personaje: " + personaje.getHitbox());
	            //System.out.println("Hitbox de la plataforma: " + plataforma.getHitbox());

	            if (personaje.getHitbox().intersects(plataforma.getHitbox())) {            
	                personaje.setTocandoBloque(b);
	                System.out.println("INTERSECCION");
	            }
	            personaje.moverPersonaje();
	            Thread.sleep(65);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }   
	    }
	}
}
