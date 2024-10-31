package Logica;

import Enemigos.Enemigo;
import Plataformas.Plataforma;

import java.util.ArrayList;
import java.util.List;

public class HiloAnimaciones extends Thread{
		protected Juego juego; 
		protected List<Enemigo> enemigos;
		private volatile boolean enEjecucion;
		
		public HiloAnimaciones(Juego juego) {
		     this.juego = juego;
		     enemigos = juego.getEnemigos();
		        
		}
		public void detener() {
	    	enEjecucion = false;
	    }
	    public void run() {
	    	enEjecucion = true;
	    	while(enEjecucion) {
	    		try {
	    			List<Enemigo> copiaEnemigos = new ArrayList<Enemigo>(enemigos);
	                for(Enemigo e : copiaEnemigos) {
	                	if(e.murio()) {
	                		e.actualizarSprite();
	                	}
	                }
	                Thread.sleep(16);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	    	}
	    }
}
