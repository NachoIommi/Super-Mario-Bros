package Plataformas;

import Fabricas.Sprite;
import Logica.*;

public abstract class Plataforma extends Entidad{
	
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Sprite getSprite();
	public abstract void aceptarVisita(Visitor v);

}
