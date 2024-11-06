package Logica;

import java.util.ArrayList; 
import java.util.List;

import Enemigos.Enemigo;
import Personaje.Personaje;
import Plataformas.*;
import PowerUps.PowerUp;

public class HiloPersonaje extends Thread {

    protected Juego juego; 
    Personaje personaje;
    List<Plataforma> plataformas;
    List<Enemigo> enemigos;
    List<Enemigo> enemigosEnEjecucion;
    List<PowerUp> powerUps;
    protected VisitorEnemigo visitorEnemigo;
    protected VisitorEnemigoAfectado visitorEnemigoAfectado;
    protected VisitorEntidad visitorEntidad;
    private volatile boolean enEjecucion;
    
    protected boolean tocoEnemigoDerecha;
    protected boolean tocoEnemigoIzquierda;
    double toleranciaAltura;
    protected boolean tocoEnemigoAbajo;
    
    public HiloPersonaje(Juego juego) {
        this.juego = juego;
        personaje = juego.getPersonaje();
        plataformas = juego.getPlataformas();
        enemigos = juego.getEnemigos();
        enemigosEnEjecucion = juego.getEnemigosEnEjecucion();
        powerUps = juego.getPowerUps();    
        visitorEnemigo = new VisitorEnemigo(personaje);
        visitorEnemigoAfectado = new VisitorEnemigoAfectado(personaje);
        visitorEntidad = new VisitorEntidad(personaje);
    }
  
    public void detener() {
    	enEjecucion = false;
    }
    public void run() {
    	enEjecucion = true;
        while (enEjecucion) {
            try {
                toleranciaAltura = personaje.getToleranciaAltura();
            	List<Plataforma> copiaPlataformas = new ArrayList<Plataforma>(plataformas);
            	
                for(Plataforma p : copiaPlataformas) {
                    if (personaje.getHitbox().intersects(p.getHitbox())) {
                        personaje.setTocandoBloque(true);
                        
                        if (colisionLadoDerecho(personaje,p)) {
                            personaje.setTocandoBloqueDerecha(true);
                            personaje.setTocandoBloqueIzquierda(false);
                        }  
                        else if (colisionLadoIzquierdo(personaje,p)) {
                            personaje.setTocandoBloqueIzquierda(true);
                            personaje.setTocandoBloqueDerecha(false);
                        }
                        if (colisionPiso(personaje,p)) {
                            personaje.setTocandoBloqueAbajo(true);
                            p.aceptarVisita(visitorEnemigo); 
                        }
                        else if (colisionTecho(personaje,p)) {
                            personaje.setTocandoBloqueArriba(true);
                            p.aceptarVisita(visitorEntidad);
                        }
                    }
                }
                List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigos);
                
                for(Enemigo e : copiaEnemigos) {
                	if(!personaje.esInvulnerable() && personaje.getHitbox().intersects(e.getHitbox())) {
                        if (colisionDerechaEnemigo(personaje,e)) {
                        		tocoEnemigoDerecha=true;
                        		e.aceptarVisita(visitorEnemigo);
                        }
                        else if (colisionIzquierdaEnemigo(personaje,e)) {
                        	tocoEnemigoIzquierda=true;
                            e.aceptarVisita(visitorEnemigo);
                        }
                        if (colisionArribaDeEnemigo(personaje,e)) 
                            {
                            	if(!tocoEnemigoDerecha && !tocoEnemigoIzquierda  ) {
                            		e.aceptarVisita(visitorEnemigoAfectado);
                            		personaje.setTocandoBloqueAbajo(true);
                            		personaje.setSaltandoSobreEnemigo(true);	
                            	}
                            }                       
                        tocoEnemigoDerecha=false;
                        tocoEnemigoIzquierda=false;
                        tocoEnemigoAbajo=false;
                	}
                }
                
                List<Enemigo> copiaEnemigosEnEjecucion = new ArrayList<Enemigo>(enemigosEnEjecucion);
                
                for(Enemigo e : copiaEnemigosEnEjecucion) {
                	if(!personaje.esInvulnerable() && personaje.getHitbox().intersects(e.getHitbox())) {
                        if (colisionDerechaEnemigo(personaje,e)) {
                        		tocoEnemigoDerecha=true;
                        		e.aceptarVisita(visitorEnemigo);
                        }
                        else if (colisionIzquierdaEnemigo(personaje,e)){
                        	tocoEnemigoIzquierda=true;
                            e.aceptarVisita(visitorEnemigo);
                        }
                        if (colisionArribaDeEnemigo(personaje,e)){
                            	if(!tocoEnemigoDerecha && !tocoEnemigoIzquierda  ) {                            		
                            		e.aceptarVisita(visitorEnemigoAfectado);
                            		personaje.setTocandoBloqueAbajo(true);
                            		personaje.setSaltandoSobreEnemigo(true);
                            	}
                            }                       
                        tocoEnemigoDerecha=false;
                        tocoEnemigoIzquierda=false;
                        tocoEnemigoAbajo=false;                        
                	}
                }
                List<PowerUp> copiaPowerUps = new ArrayList<PowerUp>(powerUps);
                for(PowerUp p : copiaPowerUps) {
                	if(personaje.getHitbox().intersects(p.getHitbox())) {
                		p.aceptarVisita(visitorEntidad);}               	
                }

                personaje.moverPersonaje();
                // Reiniciar estado de colisiones
                personaje.setTocandoBloque(false);
                personaje.setTocandoBloqueDerecha(false);
                personaje.setTocandoBloqueIzquierda(false);
                personaje.setTocandoBloqueAbajo(false);
                personaje.setTocandoBloqueArriba(false);
                personaje.setSaltandoSobreEnemigo(false);
                
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean colisionLadoDerecho(Personaje pj , Plataforma plat) {
    	return (pj.getHitbox().getX() + pj.getHitbox().getWidth() > plat.getHitbox().getX() &&
    			pj.getHitbox().getX() < plat.getHitbox().getX() &&
                Math.abs(pj.getHitbox().getY() - plat.getHitbox().getY()) < toleranciaAltura);    			
    }
    private boolean colisionLadoIzquierdo(Personaje pj , Plataforma plat) {
    	return (pj.getHitbox().getX() < plat.getHitbox().getX() + plat.getHitbox().getWidth() &&
                pj.getHitbox().getX() > plat.getHitbox().getX() &&
                Math.abs(pj.getHitbox().getY() - plat.getHitbox().getY()) < toleranciaAltura);
    }
    private boolean colisionPiso(Personaje pj , Plataforma plat) {
    	return (pj.getHitbox().getY() + pj.getHitbox().getHeight() > plat.getHitbox().getY() &&
                pj.getHitbox().getY() < plat.getHitbox().getY());
    }
    private boolean colisionTecho(Personaje pj , Plataforma plat) {
    	return (pj.getHitbox().getY() < plat.getHitbox().getY() + plat.getHitbox().getHeight() &&
                pj.getHitbox().getY() + pj.getHitbox().getHeight() > plat.getHitbox().getY()) ;
    }
    private boolean colisionDerechaEnemigo(Personaje pj , Enemigo enem) {
    	return (pj.getHitbox().getX() + pj.getHitbox().getWidth() > enem.getHitbox().getX() &&
                pj.getHitbox().getX() < enem.getHitbox().getX() && Math.abs(pj.getHitbox().getY() - enem.getHitbox().getY()) < toleranciaAltura);
    }
    private boolean colisionIzquierdaEnemigo(Personaje pj , Enemigo enem) {
    	return (pj.getHitbox().getX() < enem.getHitbox().getX() + enem.getHitbox().getWidth() &&
                pj.getHitbox().getX() > enem.getHitbox().getX()&& Math.abs(pj.getHitbox().getY() - enem.getHitbox().getY()) < toleranciaAltura); 
    }
    private boolean colisionArribaDeEnemigo(Personaje pj , Enemigo enem) {
    	return (pj.getHitbox().getY() + pj.getHitbox().getHeight() > enem.getHitbox().getY() &&
                pj.getHitbox().getY() < enem.getHitbox().getY() );
    }
}
