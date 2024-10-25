package Logica;
import java.util.List;

import Enemigos.Enemigo.*;
import Plataformas.*;

public class HiloEnemigo extends Thread {
	protected Reloj r;
	protected List<Tuberia> lista;
	protected Juego j;
	protected Tuberia t;
	
	public HiloEnemigo(Reloj r, Juego j) {
		this.r = r;
		this.j = j;
		for(Plataforma p : j.getPlataforma()) {
			if(p.getClass().equals(t)) {
				lista.add((Tuberia) p);
			}	
		}
	}
	public void run() {
		while(r.getSegundos()>0) {
			t.verificarCambioEstado();
		}
	}
}
