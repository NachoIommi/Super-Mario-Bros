package Plataformas;

import Fabricas.Sprite; 
import Logica.*;
import Personaje.Personaje;

public abstract class Plataforma extends Entidad{
	
	public Plataforma(Nivel nivelActual) {
		super(nivelActual);
	}
	
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Sprite getSprite();
	public abstract void aceptarVisita(Visitor v);
	public abstract boolean cambioEstado();
	
}
