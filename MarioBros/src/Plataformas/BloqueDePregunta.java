package Plataformas;

import Fabricas.Sprite;
import Logica.Visitor;
import Personaje.EstadoDePersonaje;
import Personaje.Personaje;
import PowerUps.PowerUps;

public class BloqueDePregunta extends BloqueSolido {
	
	protected EstadoDeBloque estado;
	protected PowerUps contenido;
	protected boolean mostrable;
	protected int golpesRestantes;
	protected boolean cambio;
	
	public BloqueDePregunta(Sprite sprite, int x, int y, PowerUps p , int golpes) {
		super(sprite, x, y);
		contenido = p;
		golpesRestantes=golpes;
		estado= new BloqueGolpeable(this,sprite,x,y,p,golpes);
		cambio=false;
	}
	
	public void setSprite(Sprite s) {
		sprite=s;
	}
	
	public void soltarContenido() {
		estado.soltarContenido();
	}
	
	public void aceptarVisita(Visitor v){
		v.visitarBloqueDePregunta(this);
	}
	
	public boolean mostrable() {
		return mostrable;
	}
	
	public void recibirGolpe(Personaje p) {
		estado.recibirGolpe(p);
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
	public boolean cambioEstado() {
		return cambio;
	}
	
	public void cambiarEstado(EstadoDeBloque nuevoEstado) {
		this.estado = nuevoEstado;        
        cambio=true;
    }

}
