package Logica;

import java.util.ArrayList;
import java.util.List;

import Enemigos.Enemigo;
import Personaje.Personaje;
import Plataformas.*;
import PowerUps.PowerUps;

public class HiloRestoMundo extends Thread {

    protected Juego juego; 
    List<Plataforma> plataforma;
    List<Enemigo> enemigo;
    List<PowerUps> powerUp;
    protected VisitorEnemigo visitorEnemigo;
    protected VisitorEnemigoAfectado visitorEnemigoAfectado;
    protected VisitorEntidad visitorEntidad;
    private volatile boolean enEjecucion;
    Personaje personaje;

    public HiloRestoMundo(Juego juego) {
        this.juego = juego;   
        plataforma = juego.getPlataformas();
        enemigo = juego.getEnemigos();
        powerUp = juego.getPowerUps();
        personaje = juego.getPersonaje();

    }
    public void detener() {
    	enEjecucion = false;
    }
    public void run() {
    	enEjecucion = true;
        while (enEjecucion) {
            try {
            	List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigo);
            	List<Plataforma> copiaPlataforma = new ArrayList<Plataforma>(plataforma);
            	for(Enemigo e : copiaEnemigos) {
            		for(Plataforma p : copiaPlataforma) {
            			if (e.getHitbox().intersects(p.getHitbox())) {
            				double toleranciaAltura = e.getToleranciaAltura();
            				
		            			if (e.getHitbox().getX() + e.getHitbox().getWidth() > p.getHitbox().getX() &&
		                                e.getHitbox().getX() < p.getHitbox().getX() &&
		                                Math.abs(e.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
		                            {
		                                e.setTocandoBloqueDerecha(true);
		                                e.setTocandoBloqueIzquierda(false);
		                                //System.out.println("Colisión Der");
		                            } 
		            			else if (e.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&
		                                 e.getHitbox().getX() > p.getHitbox().getX() &&
		                                 Math.abs(e.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
		                        {
		                            e.setTocandoBloqueIzquierda(true);
		                            e.setTocandoBloqueDerecha(false);
		                            //System.out.println("Colisión Izq");
		                        }
		            			if (e.getHitbox().getY() + e.getHitbox().getHeight() > p.getHitbox().getY() &&
		                                e.getHitbox().getY() < p.getHitbox().getY()) 
		                            {
		                                e.setTocandoBloqueAbajo(true);
		                            }
		                            
		                            
		                }
        				double toleranciaAltura = e.getToleranciaAltura();
            			for(Enemigo otroE : copiaEnemigos) {
            				if (e.getHitbox().getX() + e.getHitbox().getWidth() > otroE.getHitbox().getX() &&
	                                e.getHitbox().getX() < otroE.getHitbox().getX() &&
	                                Math.abs(e.getHitbox().getY() - otroE.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
	                            {
	                                e.setTocandoBloqueDerecha(true);
	                                e.setTocandoBloqueIzquierda(false);
	                                
	                                otroE.setTocandoBloqueDerecha(false);
	                                otroE.setTocandoBloqueIzquierda(true);
	                                //System.out.println("Colisión Der");
	                            } 
            				
	            			else if (e.getHitbox().getX() < otroE.getHitbox().getX() + otroE.getHitbox().getWidth() &&
	                                 e.getHitbox().getX() > otroE.getHitbox().getX() &&
	                                 Math.abs(e.getHitbox().getY() - otroE.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
	                        {
	                            e.setTocandoBloqueIzquierda(true);
	                            e.setTocandoBloqueDerecha(false);
	                            otroE.setTocandoBloqueDerecha(true);
                                otroE.setTocandoBloqueIzquierda(false);
	                            //System.out.println("Colisión Izq");
	                        }
	            			
            				
            				
            			}
            			
            		}
            		if(Math.abs(personaje.getPosX()-e.getPosX() )<600)
            			e.moverse();
            		
            		e.setTocandoBloqueDerecha(false);
                    e.setTocandoBloqueIzquierda(false);
                    e.setTocandoBloqueAbajo(false);
		            			
            		}
            		
            	
            	
               
                
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

