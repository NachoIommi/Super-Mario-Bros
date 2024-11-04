package Logica;

import java.util.ArrayList;
import java.util.List;

import Enemigos.Enemigo;
import Personaje.Personaje;
import Plataformas.*;
import PowerUps.PowerUp;

public class HiloRestoMundo extends Thread {
    protected Juego juego; 
    List<Plataforma> plataforma;
    List<Enemigo> enemigo;
    List<PowerUp> powerUp;
    List<BolaDeFuego> bolas;
    protected VisitorEnemigo visitorEnemigo;
    protected VisitorEnemigoAfectado visitorEnemigoAfectado;
    protected VisitorBolaDeFuego visitorBolaDeFuego;
    protected VisitorEntidad visitorEntidad;
    private volatile boolean enEjecucion;
    Personaje personaje;
    public HiloRestoMundo(Juego juego) {
        this.juego = juego;   
        plataforma = juego.getPlataformas();
        enemigo = juego.getEnemigos();
        powerUp = juego.getPowerUps();
        personaje = juego.getPersonaje();
        bolas = juego.getBolas();
        visitorEnemigo = new VisitorEnemigo(personaje);
        visitorEnemigoAfectado = new VisitorEnemigoAfectado(personaje);
        visitorEntidad = new VisitorEntidad(personaje);
        visitorBolaDeFuego = new VisitorBolaDeFuego(personaje);
    }
    public void detener() {
    	enEjecucion = false;
    }
    public void run() {
    	enEjecucion = true;
        while (enEjecucion) {
            try {
            	List<PowerUp> copiaPowerUp = new ArrayList<PowerUp>(powerUp);
            	List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigo);
            	List<Plataforma> copiaPlataforma = new ArrayList<Plataforma>(plataforma);
            	List<BolaDeFuego> copiaBolas = new ArrayList<BolaDeFuego>(bolas);
            	
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
            	
            	for(PowerUp power : copiaPowerUp) {
            		if (power.mostrable()) {
	            		double toleranciaAltura = 10;
	            		for(Plataforma p : copiaPlataforma) {
	                    if (power.getHitbox().getX() + power.getHitbox().getWidth() > p.getHitbox().getX() &&
	                                power.getHitbox().getX() < p.getHitbox().getX() &&
	                                Math.abs(power.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
	                            {
	                                power.setTocandoBloqueDerecha(true);
	                                power.setTocandoBloqueIzquierda(false);
	               //                System.out.println("power Colisión Der");
	                            }  
	
	                            else if (power.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&
	                                     power.getHitbox().getX() > p.getHitbox().getX() &&
	                                     Math.abs(power.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
	                            {
	                                power.setTocandoBloqueIzquierda(true);
	                                power.setTocandoBloqueDerecha(false);
	                                
	             //                   System.out.println("power Colisión Izq");
	                            }
	
	                    if (power.getHitbox().getY() + power.getHitbox().getHeight() >= p.getHitbox().getY() &&
	                    	    power.getHitbox().getY() + power.getHitbox().getHeight() <= p.getHitbox().getY() + 3 && // Rango de 2 unidades
	                    	    power.getHitbox().getX() + power.getHitbox().getWidth() > p.getHitbox().getX() &&
	                    	    power.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth()) 
	                    	{
	                    	    power.setTocandoBloqueAbajo(true);
	              //      	    System.out.println("power Colisión piso");
	                    	}
	
	                            
	                            else if (power.getHitbox().getY() < p.getHitbox().getY() + p.getHitbox().getHeight() &&
	                                     power.getHitbox().getY() + power.getHitbox().getHeight() > p.getHitbox().getY()) 
	                            {
	             //                   power.setTocandoBloqueArriba(true);	                                
	                            }
	                            
	            		}
	            		power.moverse();
	            		power.setTocandoBloqueDerecha(false);
	                    power.setTocandoBloqueIzquierda(false);
	                    power.setTocandoBloqueAbajo(false);
	    			}
            	}
            	
            	for(BolaDeFuego bola : copiaBolas) {
            		int toleranciaAltura=5;
            		for(Plataforma p : copiaPlataforma) {
	                    if (bola.getHitbox().getX() + bola.getHitbox().getWidth() > p.getHitbox().getX() &&
	                                bola.getHitbox().getX() < p.getHitbox().getX() &&
	                                Math.abs(bola.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
	                            {
	                                bola.setTocandoBloqueDerecha(true);
	                              
	               //                System.out.println("power Colisión Der");
	                            }  
	
	                            else if (bola.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&
	                                     bola.getHitbox().getX() > p.getHitbox().getX() &&
	                                     Math.abs(bola.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
	                            {
	                                bola.setTocandoBloqueIzquierda(true);
	                               
	                                
	             //                   System.out.println("power Colisión Izq");
	                            }
	
	                    if (bola.getHitbox().getY() + bola.getHitbox().getHeight() >= p.getHitbox().getY() &&
	                    	   bola.getHitbox().getY() + bola.getHitbox().getHeight() <= p.getHitbox().getY() + 3 && // Rango de 2 unidades
	                    	    bola.getHitbox().getX() + bola.getHitbox().getWidth() > p.getHitbox().getX() &&
	                    	    bola.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth()) 
	                    	{
	                    	    bola.setTocandoBloqueAbajo(true);
	              //      	    System.out.println("power Colisión piso");
	                    	}
	
	                            
	                            else if (bola.getHitbox().getY() < p.getHitbox().getY() + p.getHitbox().getHeight() &&
	                                     bola.getHitbox().getY() + bola.getHitbox().getHeight() > p.getHitbox().getY()) 
	                            {
	             //                   power.setTocandoBloqueArriba(true);	                                
	                            }
	                            
	            		}
            		 for(Enemigo e : copiaEnemigos) {
                     	if(bola.getHitbox().intersects(e.getHitbox())) {
                             if (bola.getHitbox().getX() + bola.getHitbox().getWidth() > e.getHitbox().getX() &&
                                 bola.getHitbox().getX() < e.getHitbox().getX() && Math.abs(bola.getHitbox().getY() - e.getHitbox().getY()) < toleranciaAltura) {
                            	 	bola.setTocandoEnemigo(true);
                             		e.aceptarVisita(visitorBolaDeFuego);
                             }
 
                             else if (bola.getHitbox().getX() < e.getHitbox().getX() + e.getHitbox().getWidth() &&
                                      bola.getHitbox().getX() > e.getHitbox().getX()&& Math.abs(bola.getHitbox().getY() - e.getHitbox().getY()) < toleranciaAltura)
                             {
                            	 bola.setTocandoEnemigo(true);
                                 e.aceptarVisita(visitorBolaDeFuego);                                             
                             }
   
                             if (bola.getHitbox().getY() + bola.getHitbox().getHeight() > e.getHitbox().getY() &&
                                     bola.getHitbox().getY() < e.getHitbox().getY() ) 
                                 {                                	                                 		
                                 		e.aceptarVisita(visitorBolaDeFuego);
                                 		bola.setTocandoEnemigo(true);                                	                             		
                                 }                                                                              
                     	}
                     }         		
            		bola.moverse();
            	}
            
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

