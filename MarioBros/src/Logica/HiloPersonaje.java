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
	            if (personaje.getHitbox().intersects(plataforma.getHitbox())) {            
	                personaje.setTocandoBloque(b);
	                if(personaje.getHitbox().getX()+personaje.getHitbox().getWidth()>=plataforma.getHitbox().getX()) {
	                	System.out.println("Colision der Per Izq bloque");
	                	personaje.setTocandoBloqueDerecha(b);
	                }
	                
	                
	            }
	                //System.out.println("Hitbox Personaje"+personaje.getHitbox().getX());
	                //System.out.println("Hitbox bloque"+plataforma.getHitbox().getX());
	            
	            personaje.moverPersonaje();
	            personaje.setTocandoBloqueDerecha(false);
	            
	            Thread.sleep(65);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }   
	    }
	}
}
