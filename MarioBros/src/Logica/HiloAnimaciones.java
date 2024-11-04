package Logica;

import Enemigos.Enemigo;
import GUI.ConstantesVistas;
import Personaje.Personaje;
import Plataformas.Plataforma;

import java.util.ArrayList;
import java.util.List;

public class HiloAnimaciones extends Thread{
		protected Juego juego; 
		protected Personaje personaje;
		protected List<Enemigo> enemigos;
		private volatile boolean enEjecucion;
		protected boolean entro;
		
		public HiloAnimaciones(Juego juego) {
			entro = false;
		    this.juego = juego;
		    enemigos = juego.getEnemigos();
		    personaje = juego.getPersonaje();
		        
		}
		public void detener() {
	    	enEjecucion = false;
	    }
	    public void run() {
	    	enEjecucion = true;
	    	while(enEjecucion) {
	    		 
	    		try {   
	    			
	    			/*if(personaje.getMuerto()) {
	    				int posicionY = personaje.getPosY()	;
	    				for (int i = 0; i < 45; i++) {
	    		            personaje.setPosY(personaje.getPosY() - (i * 2));
	    		            
	    		            try {
	    		                Thread.sleep(16);
	    		            } catch (InterruptedException e) {
	    		                e.printStackTrace();
	    		            }
	    		        }

	    		        while (personaje.getPosY() < 500) {
	    		            personaje.setPosY(personaje.getPosY() + 4);
	    		            try {
	    		                Thread.sleep(16);
	    		            } catch (InterruptedException e) {
	    		                e.printStackTrace();
	    		            }
	    		        }
	    			}*/
	    			
	    			
	    			List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigos);
	                for(Enemigo enemigo : copiaEnemigos) {
	                	if(enemigo.murio()) {
	                		int posY = enemigo.getPosY();
	                        // Animación de desplazamiento hacia arriba
	                        for (int i = 0; i < 30; i++) {
	                        	enemigo.setPosY(posY - (i * 2));
	                            try {
	                                Thread.sleep(14);
	                            } catch (InterruptedException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                        // Caída hacia la parte inferior de la ventana
	                        while (enemigo.getPosY() < ConstantesVistas.VENTANA_ALTO) {
	                        	enemigo.setPosY(enemigo.getPosY() + 5);
	                            try {
	                                Thread.sleep(14);
	                            } catch (InterruptedException e) {
	                                e.printStackTrace();
	                            }
	                        };
	                	}
	                }
	                Thread.sleep(16);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	    	}
	    }
}
