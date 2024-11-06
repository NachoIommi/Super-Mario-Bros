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
    List<Enemigo> enemigosEnEjecucion;
    List<PowerUp> powerUp;
    List<BolaDeFuego> bolas;
    protected VisitorEnemigo visitorEnemigo;
    protected VisitorEnemigoAfectado visitorEnemigoAfectado;
    protected VisitorBolaDeFuego visitorBolaDeFuego;
    protected VisitorEntidad visitorEntidad;
    private volatile boolean enEjecucion;
    protected double toleranciaAltura;
    Personaje personaje;
    public HiloRestoMundo(Juego juego) {
        this.juego = juego;   
        plataforma = juego.getPlataformas();
        enemigo = juego.getEnemigos();
        enemigosEnEjecucion = juego.getEnemigosEnEjecucion();
        powerUp = juego.getPowerUps();
        personaje = juego.getPersonaje();
        bolas = juego.getBolas();
        visitorEnemigo = new VisitorEnemigo(personaje);
        visitorEnemigoAfectado = new VisitorEnemigoAfectado(personaje);
        visitorEntidad = new VisitorEntidad(personaje);
        visitorBolaDeFuego = new VisitorBolaDeFuego(personaje,null);
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
            	List<Enemigo> copiaEnemigosEnEjecucion = new ArrayList<Enemigo>(enemigosEnEjecucion);
            	
            	for(Enemigo e : copiaEnemigos) {
            		for(Plataforma p : copiaPlataforma) {
            			if (e.getHitbox().intersects(p.getHitbox())) {
            				 toleranciaAltura = e.getToleranciaAltura();           				
		            			if (colisionEnemigoBloqueDerecha(e,p)) {
		                                e.setTocandoBloqueDerecha(true);
		                                e.setTocandoBloqueIzquierda(false);   
		                            } 
		            			else if (colisionEnemigoBloqueIzquierda(e,p)) {
		                            e.setTocandoBloqueIzquierda(true);
		                            e.setTocandoBloqueDerecha(false);
		                            }
		            			if (colisionEnemigoBloqueAbajo(e,p)) {
		                                e.setTocandoBloqueAbajo(true);
		                        }		                         		                            
		                }
            		}
            			
        			 toleranciaAltura = e.getToleranciaAltura();
            		for(Enemigo otroE : copiaEnemigos) {
            				if (enemigoConEnemigoDerecha(e,otroE)) {
	                                e.setTocandoBloqueDerecha(true);
	                                e.setTocandoBloqueIzquierda(false);                                
	                                otroE.setTocandoBloqueDerecha(false);
	                                otroE.setTocandoBloqueIzquierda(true);
	                            } 
            				
	            			else if (enemigoConEnemigoIzquierda(e,otroE)) {
	                            e.setTocandoBloqueIzquierda(true);
	                            e.setTocandoBloqueDerecha(false);
	                            otroE.setTocandoBloqueDerecha(true);
                                otroE.setTocandoBloqueIzquierda(false);
	                        }
            			}
            			
            			for(Enemigo otroEj : copiaEnemigosEnEjecucion) {
            				if (enemigoConEnemigoDerecha(e,otroEj))
	                            {
	                                e.setTocandoBloqueDerecha(true);
	                                e.setTocandoBloqueIzquierda(false);                                
	                                otroEj.setTocandoBloqueDerecha(false);
	                                otroEj.setTocandoBloqueIzquierda(true);
	                            } 
            				
	            			else if (enemigoConEnemigoIzquierda(e,otroEj)) {
	                            e.setTocandoBloqueIzquierda(true);
	                            e.setTocandoBloqueDerecha(false);
	                            otroEj.setTocandoBloqueDerecha(true);
                                otroEj.setTocandoBloqueIzquierda(false);
	                        }
            			}
        
            		if(Math.abs(personaje.getPosX()-e.getPosX() )<600) {
            			e.moverse();
            		}            			           		
	            		e.setTocandoBloqueDerecha(false);
	                    e.setTocandoBloqueIzquierda(false);
	                    e.setTocandoBloqueAbajo(false);		            			
            	}
            	
            	for(Enemigo e : copiaEnemigosEnEjecucion) {
            		for(Plataforma p : copiaPlataforma) {
            			if (e.getHitbox().intersects(p.getHitbox())) {
            				toleranciaAltura = e.getToleranciaAltura();           				
		            			if (colisionEnemigoBloqueDerecha(e,p))
		                            {
		                                e.setTocandoBloqueDerecha(true);
		                                e.setTocandoBloqueIzquierda(false);
		                            } 
		            			else if (colisionEnemigoBloqueIzquierda(e,p))
		                        {
		                            e.setTocandoBloqueIzquierda(true);
		                            e.setTocandoBloqueDerecha(false);
		                        }
		            			if (colisionEnemigoBloqueAbajo(e,p))
		                            {
		                                e.setTocandoBloqueAbajo(true);
		                            }		                         		                            
		                }
            		}
        			 toleranciaAltura = e.getToleranciaAltura();
            		for(Enemigo otroEj : copiaEnemigosEnEjecucion) {
            				if (enemigoConEnemigoDerecha(e,otroEj))
	                            {
	                                e.setTocandoBloqueDerecha(true);
	                                e.setTocandoBloqueIzquierda(false);                                
	                                otroEj.setTocandoBloqueDerecha(false);
	                                otroEj.setTocandoBloqueIzquierda(true);
	                            } 
            				
	            			else if (enemigoConEnemigoIzquierda(e,otroEj))
	                        {
	                            e.setTocandoBloqueIzquierda(true);
	                            e.setTocandoBloqueDerecha(false);
	                            otroEj.setTocandoBloqueDerecha(true);
                                otroEj.setTocandoBloqueIzquierda(false);
	                        }
         			}
            		
            		for(Enemigo otroE : copiaEnemigos) {
        				if (enemigoConEnemigoDerecha(e,otroE)) 
                            {
                                e.setTocandoBloqueDerecha(true);
                                e.setTocandoBloqueIzquierda(false);                                
                                otroE.setTocandoBloqueDerecha(false);
                                otroE.setTocandoBloqueIzquierda(true);
                            } 
        				
            			else if (enemigoConEnemigoIzquierda(e,otroE)) 
                        {
                            e.setTocandoBloqueIzquierda(true);
                            e.setTocandoBloqueDerecha(false);
                            otroE.setTocandoBloqueDerecha(true);
                            otroE.setTocandoBloqueIzquierda(false);
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
	            		toleranciaAltura = 10;
	            		for(Plataforma p : copiaPlataforma) {
		                    if (colisionPowerUpDerecha(power,p)) {
		                                power.setTocandoBloqueDerecha(true);
		                                power.setTocandoBloqueIzquierda(false);
		                            }  
		
		                            else if (colisionPowerUpIzquierda(power,p)) {
		                                power.setTocandoBloqueIzquierda(true);
		                                power.setTocandoBloqueDerecha(false);	                            
		                            }
		
		                    if (colisionPowerUpAbajo(power,p)) {
		                    	    power.setTocandoBloqueAbajo(true);	             
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
	                                Math.abs(bola.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) {
	                                bola.setTocandoBloqueDerecha(true);                    
	                            }  
	
	                            else if (bola.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&
	                                     bola.getHitbox().getX() > p.getHitbox().getX() &&
	                                     Math.abs(bola.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) {
	                                bola.setTocandoBloqueIzquierda(true);
	                            }
	
	                    if (bola.getHitbox().getY() + bola.getHitbox().getHeight() >= p.getHitbox().getY() &&
	                    	   bola.getHitbox().getY() + bola.getHitbox().getHeight() <= p.getHitbox().getY() + 3 && 
	                    	    bola.getHitbox().getX() + bola.getHitbox().getWidth() > p.getHitbox().getX() &&
	                    	    bola.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth()) {
	                    	
	                    	    bola.setTocandoBloqueAbajo(true);
	                    	    visitorBolaDeFuego.setBolaDeFuego(bola);
	                    	    p.aceptarVisita(visitorBolaDeFuego);
	                    	}
	     
	                            else if (bola.getHitbox().getY() < p.getHitbox().getY() + p.getHitbox().getHeight() &&
	                                     bola.getHitbox().getY() + bola.getHitbox().getHeight() > p.getHitbox().getY()) {
	                            }          
	            	 }
            		 for(Enemigo e : copiaEnemigos) {
                     	if(bola.getHitbox().intersects(e.getHitbox())) {
                             if (colisionBolaConEnemigoDerecha(bola,e)) {
                            	 	bola.setTocandoEnemigo(true);
                             		e.aceptarVisita(visitorBolaDeFuego);
                             }
 
                             else if (colisionBolaConEnemigoIzquierda(bola,e)) {
                            	 bola.setTocandoEnemigo(true);
                                 e.aceptarVisita(visitorBolaDeFuego);                                             
                             }
   
                             if (colisionBolaConEnemigoArriba(bola,e) ) {                                	                                 		
                                 	e.aceptarVisita(visitorBolaDeFuego);
                                 	bola.setTocandoEnemigo(true);                                	                             		
                             }                                                                              
                     	}
                     }
            		 for(Enemigo e : copiaEnemigosEnEjecucion) {
                      	if(bola.getHitbox().intersects(e.getHitbox())) {
                              if (colisionBolaConEnemigoDerecha(bola,e)) {
                             	 	bola.setTocandoEnemigo(true);
                              		e.aceptarVisita(visitorBolaDeFuego);
                              }
  
                              else if (colisionBolaConEnemigoIzquierda(bola,e)) {
                             	 bola.setTocandoEnemigo(true);
                                  e.aceptarVisita(visitorBolaDeFuego);                                             
                              }
    
                              if (colisionBolaConEnemigoArriba(bola,e) ) {                                	                                 		
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
    private boolean colisionEnemigoBloqueDerecha(Enemigo enem , Plataforma plat) {
    	return (enem.getHitbox().getX() + enem.getHitbox().getWidth() > plat.getHitbox().getX() &&
                enem.getHitbox().getX() < plat.getHitbox().getX() &&
                Math.abs(enem.getHitbox().getY() - plat.getHitbox().getY()) < toleranciaAltura);
    }
    private boolean colisionEnemigoBloqueIzquierda(Enemigo enem , Plataforma plat) {
    	return (enem.getHitbox().getX() < plat.getHitbox().getX() + plat.getHitbox().getWidth() &&
                enem.getHitbox().getX() > plat.getHitbox().getX() &&
                Math.abs(enem.getHitbox().getY() - plat.getHitbox().getY()) < toleranciaAltura);
    }
    private boolean colisionEnemigoBloqueAbajo(Enemigo enem , Plataforma plat) {
    	return (enem.getHitbox().getY() + enem.getHitbox().getHeight() > plat.getHitbox().getY() &&
                enem.getHitbox().getY() < plat.getHitbox().getY());
    }
    private boolean enemigoConEnemigoDerecha(Enemigo enem , Enemigo otroEnem) {
    	return (enem.getHitbox().getX() + enem.getHitbox().getWidth() > otroEnem.getHitbox().getX() &&
        enem.getHitbox().getX() < otroEnem.getHitbox().getX() &&
        Math.abs(enem.getHitbox().getY() - otroEnem.getHitbox().getY()) < toleranciaAltura);
    }
    private boolean enemigoConEnemigoIzquierda(Enemigo enem , Enemigo otroEnem) {
    	return(enem.getHitbox().getX() < otroEnem.getHitbox().getX() + otroEnem.getHitbox().getWidth() &&
                enem.getHitbox().getX() > otroEnem.getHitbox().getX() &&
                Math.abs(enem.getHitbox().getY() - otroEnem.getHitbox().getY()) < toleranciaAltura) ;                     
    }
    private boolean colisionPowerUpAbajo(PowerUp p , Plataforma plat) {
    	return((p.getHitbox().getY() + p.getHitbox().getHeight() >= plat.getHitbox().getY() &&
        	    p.getHitbox().getY() + p.getHitbox().getHeight() <= plat.getHitbox().getY() + 3 && 
        	    p.getHitbox().getX() + p.getHitbox().getWidth() > plat.getHitbox().getX() &&
        	    p.getHitbox().getX() < plat.getHitbox().getX() + plat.getHitbox().getWidth()));
    }
    private boolean colisionPowerUpDerecha(PowerUp p , Plataforma plat) {
    	return (p.getHitbox().getX() + p.getHitbox().getWidth() > plat.getHitbox().getX() &&
                p.getHitbox().getX() < plat.getHitbox().getX() &&
                Math.abs(p.getHitbox().getY() - plat.getHitbox().getY()) < toleranciaAltura);
    }
    private boolean colisionPowerUpIzquierda(PowerUp p,Plataforma plat) {
    	return((p.getHitbox().getX() < plat.getHitbox().getX() + plat.getHitbox().getWidth() &&
    			p.getHitbox().getX() > plat.getHitbox().getX() &&
		        Math.abs(p.getHitbox().getY() - plat.getHitbox().getY()) < toleranciaAltura));
    }
    private boolean colisionBolaConEnemigoDerecha(BolaDeFuego b,Enemigo enem) {
    	return(b.getHitbox().getX() + b.getHitbox().getWidth() > enem.getHitbox().getX() &&
                b.getHitbox().getX() < enem.getHitbox().getX());
    }
    private boolean colisionBolaConEnemigoIzquierda(BolaDeFuego b,Enemigo enem) {
    	return (b.getHitbox().getX() < enem.getHitbox().getX() + enem.getHitbox().getWidth() &&
                b.getHitbox().getX() > enem.getHitbox().getX());
    }
    private boolean colisionBolaConEnemigoArriba(BolaDeFuego b,Enemigo enem) {
    	return(b.getHitbox().getY() + b.getHitbox().getHeight() > enem.getHitbox().getY() &&
                b.getHitbox().getY() < enem.getHitbox().getY() );
    }      
}

