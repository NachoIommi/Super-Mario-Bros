package Plataformas;

import Fabricas.Sprite; 
import Logica.*;
import Personaje.Personaje;

public abstract class Plataforma extends Entidad{
	
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Sprite getSprite();
	public abstract void aceptarVisita(Visitor v);
	public abstract void afectarPersonaje(Personaje p);
	
}
