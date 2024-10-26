package Logica;

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

    public HiloRestoMundo(Juego juego) {
        this.juego = juego;   
        plataforma = juego.getPlataforma();
        enemigo = juego.getEnemigo();
        powerUp = juego.getPowerUp();    

    }
    public void detener() {
    	enEjecucion = false;
    }
    public void run() {
    	enEjecucion = true;
        while (true) {
            try {
            	for(Enemigo e : enemigo) {
            		for(Plataforma p : plataforma) {
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
		                        }
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

