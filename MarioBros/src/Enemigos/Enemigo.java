package Enemigos;
import Fabricas.Sprite;
import Logica.Entidad;
public abstract class Enemigo extends Entidad{
	public abstract void moverse();
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Sprite getSprite();
}
