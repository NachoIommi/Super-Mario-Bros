package Plataformas;

import Fabricas.Sprite;
import Logica.Visitor;
import Personaje.EstadoNormal;
import Personaje.Personaje;
import PowerUps.PowerUps;

public class BloqueDePregunta extends BloqueSolido {
	
	protected EstadoDeBloque estado;
	protected PowerUps contenido;
	
	public BloqueDePregunta(Sprite sprite, int x, int y, PowerUps p) {
		super(sprite, x, y);
		 
		contenido=p;
		estado = new BloqueGolpeable(this ,sprite, x ,y);
	}
	
	public void cambiarEstado(EstadoDeBloque e) {
		estado = e;
	}
	
	public void soltarContenido() {
		contenido.activarPowerUp();
		System.out.println("visitado3");
		
	}
	
	public void aceptarVisita(Visitor v){
		//v.visitarBloqueDePregunta(this);
		System.out.println("visitado"); //el visitor pasa por aca

	}
	
	public void recibirGolpe(Personaje p) {
	    System.out.println("visitado - personaje golpea bloque pregunta"); // Ver si este println aparece
	    estado.recibirGolpe(p);  // Llama al método del estado actual
	    System.out.println("visitado2 - estado actual golpeado");
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
