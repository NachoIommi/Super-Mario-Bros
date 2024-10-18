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
	            
	            if (personaje.getHitbox().intersects(plataforma.getHitbox())) { 	//COLISION JUGADOR BLOQUE
	                personaje.setTocandoBloque(true);

	                
	                if (personaje.getHitbox().getX() + personaje.getHitbox().getWidth() > plataforma.getHitbox().getX() &&	//COLISION LADO DERECHO JUGADOR IZQ BLOQUE
	                    personaje.getHitbox().getX() < plataforma.getHitbox().getX()) {
	                    personaje.setTocandoBloqueDerecha(true);
	                    personaje.setTocandoBloqueIzquierda(false);
	                }

	                
	              else 
	            	  if (personaje.getHitbox().getX() < plataforma.getHitbox().getX() + plataforma.getHitbox().getWidth() &&	//COLISION LADO IZQ JUGADOR DERECHO BLOQUE
	                         personaje.getHitbox().getX() > plataforma.getHitbox().getX()) {
	                
	             
	                    personaje.setTocandoBloqueIzquierda(true);
	                    personaje.setTocandoBloqueDerecha(false);
	                    System.out.println("Colision");
	                }

	            } 
	            
	            else {		//NO COLISION 
	                
	                personaje.setTocandoBloque(false);
	                personaje.setTocandoBloqueDerecha(false);
	                personaje.setTocandoBloqueIzquierda(false);
	            }

	            System.out.println(" personaje: "+personaje.getX());
	            //System.out.println("Hitbox del bloque :"+ (plataforma.getHitbox().getX() + plataforma.getHitbox().getWidth()) );
	            personaje.moverPersonaje();

	            Thread.sleep(65); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	


}
