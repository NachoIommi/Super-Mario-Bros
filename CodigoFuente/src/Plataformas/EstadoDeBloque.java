package Plataformas;

import Logica.Visitor;
import Personaje.Personaje;
import PowerUps.PowerUp;

public abstract class EstadoDeBloque{
	
	protected BloqueDePregunta bloque;
	
	public EstadoDeBloque(BloqueDePregunta b) {
		bloque = b;
	}
	
	public abstract void soltarContenido() ;
	
	public abstract void aceptarVisita(Visitor v);
	
	public abstract boolean mostrable() ;	
	
	public abstract void recibirGolpe(Personaje p) ;
	
	public abstract EstadoDeBloque getEstado() ;
	
	public abstract PowerUp getContenido() ;
	
	public abstract void setContenido(PowerUp p);
}