package Plataformas;

import Logica.Visitor;
import Personaje.Personaje;
import PowerUps.PowerUps;

public abstract class EstadoDeBloque  {
	
	protected BloqueDePregunta bloque;
	
	public EstadoDeBloque(BloqueDePregunta b) {
		this.bloque =b;		
	}
	
	public abstract void soltarContenido();
	public abstract void setContenido(PowerUps p);
	public abstract void cambiarEstado(EstadoDeBloque e);
	public abstract void aceptarVisita(Visitor v);
	public abstract void recibirGolpe(Personaje p);
	public abstract EstadoDeBloque getEstado();
	public abstract PowerUps getContenido();
	
}
