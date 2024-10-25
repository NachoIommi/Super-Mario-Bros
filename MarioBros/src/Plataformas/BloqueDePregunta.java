package Plataformas;

import Fabricas.Sprite;
import Logica.Visitor;
import Personaje.Personaje;
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
		v.visitarBloqueDePregunta(this);
	}
	
	public void recibirGolpe(Personaje p) {
		// sin importar el estado va a activar un gif por medio segundo y darle un power up o moneda a mario
	}
	
	public EstadoDeBloque getEstado() {
		return estado;
	}
	
	public PowerUps getContenido() {
		return contenido;
	}
	
	public void setContenido(PowerUps p) {
		contenido = p;
	}

}
