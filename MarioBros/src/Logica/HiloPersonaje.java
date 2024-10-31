package Logica;

import java.util.ArrayList; 
import java.util.List;

import Enemigos.Enemigo;
import Personaje.Personaje;
import Plataformas.*;
import PowerUps.PowerUps;

public class HiloPersonaje extends Thread {

    protected Juego juego; 
    Personaje personaje;
    List<Plataforma> plataformas;
    List<Enemigo> enemigos;
    List<PowerUps> powerUps;
    protected VisitorEnemigo visitorEnemigo;
    protected VisitorEnemigoAfectado visitorEnemigoAfectado;
    protected VisitorEntidad visitorEntidad;
    private volatile boolean enEjecucion;
    
    
    //probando Juanse
    protected boolean tocoGoombaDerecha;
    protected boolean tocoGoombaIzquierda;
    double toleranciaAltura;
    protected boolean tocoEnemigoAbajo;
    
    public HiloPersonaje(Juego juego) {
        this.juego = juego;
        personaje = juego.getPersonaje();
        plataformas = juego.getPlataformas();
        enemigos = juego.getEnemigos();
        powerUps = juego.getPowerUps();    
        visitorEnemigo = new VisitorEnemigo(personaje);
        visitorEnemigoAfectado = new VisitorEnemigoAfectado(personaje);
        visitorEntidad = new VisitorEntidad(personaje);
        toleranciaAltura = personaje.getToleranciaAltura();
    }
  
    public void detener() {
    	enEjecucion = false;
    }
    public void run() {
    	enEjecucion = true;
        while (enEjecucion) {
            try {
            	List<Plataforma> copiaPlataformas = new ArrayList<Plataforma>(plataformas);
                for(Plataforma p : copiaPlataformas) {
                    if (personaje.getHitbox().intersects(p.getHitbox())) {
                        personaje.setTocandoBloque(true);

                        if (personaje.getHitbox().getX() + personaje.getHitbox().getWidth() > p.getHitbox().getX() &&
                            personaje.getHitbox().getX() < p.getHitbox().getX() &&
                            Math.abs(personaje.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
                        {
                            personaje.setTocandoBloqueDerecha(true);
                            personaje.setTocandoBloqueIzquierda(false);
               //             System.out.println("Colisión Der");
                        }  

                        else if (personaje.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&
                                 personaje.getHitbox().getX() > p.getHitbox().getX() &&
                                 Math.abs(personaje.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
                        {
                            personaje.setTocandoBloqueIzquierda(true);
                            personaje.setTocandoBloqueDerecha(false);
                            
               //             System.out.println("Colisión Izq");
                        }

                        if (personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > p.getHitbox().getY() &&
                            personaje.getHitbox().getY() < p.getHitbox().getY()) 
                        {
                            personaje.setTocandoBloqueAbajo(true);
                            p.aceptarVisita(visitorEnemigoAfectado); //CASO VACIO
                            
                        }
                        
                        else if (personaje.getHitbox().getY() < p.getHitbox().getY() + p.getHitbox().getHeight() &&
                                 personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > p.getHitbox().getY()) 
                        {
                            personaje.setTocandoBloqueArriba(true);
                            p.aceptarVisita(visitorEntidad);
              //              System.out.println("Colisión tocando techo");
                        }
                    }
                }
                List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigos);
                for(Enemigo e : copiaEnemigos) {
                	if(!personaje.esInvulnerable() && personaje.getHitbox().intersects(e.getHitbox())) {
                           
                		 // Colisión desde la derecha (jugador a la izquierda del enemigo)
                        if (personaje.getHitbox().getX() + personaje.getHitbox().getWidth() > e.getHitbox().getX() &&
                            personaje.getHitbox().getX() < e.getHitbox().getX() && Math.abs(personaje.getHitbox().getY() - e.getHitbox().getY()) < toleranciaAltura) {
                        		tocoGoombaDerecha=true;
                        		e.aceptarVisita(visitorEnemigo);
            //            		System.out.println("enemigo lo tocan desde izquierda");
                        }
                        // Colisión desde la izquierda (jugador a la derecha del enemigo)
                        else if (personaje.getHitbox().getX() < e.getHitbox().getX() + e.getHitbox().getWidth() &&
                                 personaje.getHitbox().getX() > e.getHitbox().getX()&& Math.abs(personaje.getHitbox().getY() - e.getHitbox().getY()) < toleranciaAltura)
                        {
                        	tocoGoombaIzquierda=true;
                            e.aceptarVisita(visitorEnemigo);
           //                 System.out.println("enemigo lo tocan desde derecha");
                        }
                        // (personaje arriba del enemigo)
                        if (personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > e.getHitbox().getY() &&
                                personaje.getHitbox().getY() < e.getHitbox().getY() ) 
                            {
                            	if(!tocoGoombaDerecha && !tocoGoombaIzquierda  ) {
                            		
                            		e.aceptarVisita(visitorEnemigoAfectado);
            //                		System.out.println("Saltan sobre enemigo");
                            		personaje.setTocandoBloqueAbajo(true);
                            		personaje.setSaltandoSobreEnemigo(true);
                            		
                            		}
                            }                       
                        tocoGoombaDerecha=false;
                        tocoGoombaIzquierda=false;
                        tocoEnemigoAbajo=false;
                        
                	}
                }
                List<PowerUps> copiaPowerUps = new ArrayList<PowerUps>(powerUps);
                for(PowerUps p : copiaPowerUps) {
                	if(personaje.getHitbox().intersects(p.getHitbox())) {
                		p.aceptarVisita(visitorEntidad);}
                	
                }

                personaje.moverPersonaje();
                
                
               // System.out.println("posY " +personaje.getHitbox().getY());
                //System.out.println("Hitbox posY " +personaje.getHitbox().getHeight());
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
    
}
