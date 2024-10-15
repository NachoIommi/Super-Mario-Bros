package Plataformas;

import Fabricas.Sprite;
import Logica.Visitor;
import PowerUps.PowerUps;

public class BloqueDePregunta extends BloqueSolido {
	
	protected EstadoDeBloque estado;
	protected PowerUps contenido;
	
	public BloqueDePregunta(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	public void cambiarEstado(EstadoDeBloque e) {
		estado = e;
	}
	
	public void soltarContenido() {
		
	}
	
	public void aceptarVisita(Visitor v){
		
	}
	
	public EstadoDeBloque getEstado() {
		return estado;
	}
	
	/*
	public void setEstado(EstadoDeBloque e) {
		estado = e;
	} 
	no estaba en diagrama, lo dejo comentado por si lo usamos 
	*/
	
	public PowerUps getContenido() {
		return contenido;
	}
	
	public void setContenido(PowerUps p) {
		contenido = p;
	}

}
