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
	    			List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigos);
	                for(Enemigo enemigo : copiaEnemigos) {
	                	if(enemigo.murio()) {
	                		int posY = enemigo.getPosY();
	                 
	                        for (int i = 0; i < 30; i++) {
	                        	enemigo.setPosY(posY - (i * 2));
	                            try {
	                                Thread.sleep(14);
	                            } catch (InterruptedException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                     
	                        while (enemigo.getPosY() < ConstantesVistas.VENTANA_ALTO) {
	                        	enemigo.setPosY(enemigo.getPosY() + 5);
	                            try {
	                                Thread.sleep(14);
	                            } catch (InterruptedException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                	}
	                }
	                Thread.sleep(16);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	    	}
	    }
}
