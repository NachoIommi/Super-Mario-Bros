package Plataformas;

import Fabricas.Sprite;
import Logica.Visitor;
import Personaje.Personaje;
import PowerUps.PowerUps;

public class BloqueDePregunta extends BloqueSolido {
	
	protected EstadoDeBloque estado;
	protected PowerUps contenido;
	protected boolean mostrable;
	
	public BloqueDePregunta(Sprite sprite, int x, int y, PowerUps p) {
		super(sprite, x, y);
		contenido = p;
	}
	
	public void cambiarEstado(EstadoDeBloque e) {
		estado = e;
	}
	
	
	
	public void soltarContenido() {
		contenido.setPosX(x);
		contenido.setPosY(y-30);	
		contenido.getHitbox().actualizar(x, y-30);
		System.out.println("visitado soltar contenido");
		contenido.setMostrable(true);
	}
	
	public void aceptarVisita(Visitor v){
		v.visitarBloqueDePregunta(this);
	}
	
	public boolean mostrable() {
		return mostrable;
	}
	
	public void recibirGolpe(Personaje p) {
		soltarContenido();
		System.out.println("visitado");
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
