package Logica;

import java.util.List;

import Enemigos.Enemigo;
import Personaje.Personaje;
import Plataformas.*;
import PowerUps.PowerUps;

public class HiloPersonaje extends Thread {

    protected Juego juego; 
    Personaje personaje;
    List<Plataforma> plataforma;
    List<Enemigo> enemigo;
    List<PowerUps> powerUp;
    protected VisitorEnemigo visitorEnemigo;
    protected VisitorEnemigoAfectado visitorEnemigoAfectado;
    protected VisitorEntidad visitorEntidad;

    public HiloPersonaje(Juego juego) {
        this.juego = juego;
        personaje = juego.getPersonaje();
        plataforma = juego.getPlataforma();
        enemigo = juego.getEnemigo();
        powerUp = juego.getPowerUp();    
        visitorEnemigo = new VisitorEnemigo(personaje);
        visitorEnemigoAfectado = new VisitorEnemigoAfectado(personaje);
        visitorEntidad = new VisitorEntidad(personaje);
    }
  
    public void run() {
        while (true) {
            try {
                for(Plataforma p : plataforma) {
                    if (personaje.getHitbox().intersects(p.getHitbox())) {
                        personaje.setTocandoBloque(true);

                        double toleranciaAltura = personaje.getToleranciaAltura(); 

                        if (personaje.getHitbox().getX() + personaje.getHitbox().getWidth() > p.getHitbox().getX() &&
                            personaje.getHitbox().getX() < p.getHitbox().getX() &&
                            Math.abs(personaje.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
                        {
                            personaje.setTocandoBloqueDerecha(true);
                            personaje.setTocandoBloqueIzquierda(false);
                            System.out.println("Colisión Der");
                        }  

                        else if (personaje.getHitbox().getX() < p.getHitbox().getX() + p.getHitbox().getWidth() &&
                                 personaje.getHitbox().getX() > p.getHitbox().getX() &&
                                 Math.abs(personaje.getHitbox().getY() - p.getHitbox().getY()) < toleranciaAltura) // Solo si están a la misma altura
                        {
                            personaje.setTocandoBloqueIzquierda(true);
                            personaje.setTocandoBloqueDerecha(false);
                            System.out.println("Colisión Izq");
                        }

                        if (personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > p.getHitbox().getY() &&
                            personaje.getHitbox().getY() < p.getHitbox().getY()) 
                        {
                            personaje.setTocandoBloqueAbajo(true);
                        }
                        
                        else if (personaje.getHitbox().getY() < p.getHitbox().getY() + p.getHitbox().getHeight() &&
                                 personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > p.getHitbox().getY()) 
                        {
                            personaje.setTocandoBloqueArriba(true);
                            System.out.println("Colisión tocando techo");
                        }
                    }
                }
                for(Enemigo e : enemigo) {
                	if(personaje.getHitbox().intersects(e.getHitbox())) {
                		System.out.println("Colisión");
                		 // Colisión desde la derecha (jugador a la izquierda del enemigo)
                        if (personaje.getHitbox().getX() + personaje.getHitbox().getWidth() > e.getHitbox().getX() &&
                            personaje.getHitbox().getX() < e.getHitbox().getX()) {
                        		e.aceptarVisita(visitorEnemigo);
                        }
                        // Colisión desde la izquierda (jugador a la derecha del enemigo)
                        else if (personaje.getHitbox().getX() < e.getHitbox().getX() + e.getHitbox().getWidth() &&
                                 personaje.getHitbox().getX() > e.getHitbox().getX())
                        {
                            e.aceptarVisita(visitorEnemigo);
                        }
                        // (personaje arriba del enemigo)
                        if (personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > e.getHitbox().getY() &&
                            personaje.getHitbox().getY() < e.getHitbox().getY()) 
                        {
                           e.aceptarVisita(visitorEnemigoAfectado);
                        }
                        // Colisión desde arriba (tocando el techo)
                        else if (personaje.getHitbox().getY() < e.getHitbox().getY() + e.getHitbox().getHeight() &&
                                 personaje.getHitbox().getY() + personaje.getHitbox().getHeight() > e.getHitbox().getY()) 
                        {
                            e.aceptarVisita(visitorEnemigoAfectado);
                        }
                        	
                	}
                }
                
                for(PowerUps p : powerUp) {
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
                
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
