package Logica;

import java.util.List;

import Personaje.Personaje;
import Plataformas.*;

public class HiloPersonaje extends Thread { 
	protected Juego juego; 
	Personaje personaje;// = juego.getPersonaje();
	List<Plataforma> plataforma;// = juego.getPlataforma().getFirst();
	boolean b;
	public HiloPersonaje(Juego juego) {
		this.juego = juego;
		personaje = juego.getPersonaje();
		plataforma = juego.getPlataforma();
		b=true;		
	}
	
	public void run() {
	    while (true) {
	        try {
	            for(Plataforma p: plataforma) {
	            	if (personaje.getHitbox().intersects(p.getHitbox())) { 	//COLISION JUGADOR BLOQUE
		                personaje.setTocandoBloque(true);		              		                
		                if (personaje.getHitbox().getX() + personaje.getHitbox().getWidth() > p.getHitbox().getX() &&	//COLISION LADO DERECHO JUGADOR IZQ BLOQUE
		                    personaje.getHitbox().getX() < p.getHitbox().getX()) 
		                {
		                	personaje.setTocandoBloqueDerecha(true);
			                personaje.setTocandoBloqueIzquierda(false);
			                System.out.println("Colision Der");
		                }                
		              else 
		            	  if (personaje.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&	//COLISION LADO IZQ JUGADOR DERECHO BLOQUE
		                         personaje.getHitbox().getX() > p.getHitbox().getX()) 
		            	  {
		               		personaje.setTocandoBloqueIzquierda(true);
		                    personaje.setTocandoBloqueDerecha(false);
		                    System.out.println("Colision Izq");
		                  }
		            }
		            		          
	            }	          
	            //System.out.println(" personaje: "+personaje.getX());	           
	            personaje.moverPersonaje();
	            personaje.setTocandoBloque(false);
                personaje.setTocandoBloqueDerecha(false);
                personaje.setTocandoBloqueIzquierda(false);
	            Thread.sleep(65); 
	        } 
	        catch (InterruptedException e) {
	            e.printStackTrace();}
	    }
	    
	    
	}
	


}
