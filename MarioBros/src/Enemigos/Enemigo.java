package Enemigos;
import Fabricas.Sprite;
import Logica.Entidad;
import Logica.Visitor;
import Personaje.Personaje;
public abstract class Enemigo extends Entidad{
	
	public abstract void afectarPersonaje(Personaje p);
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void morir();
	public abstract void aceptarVisita(Visitor r);
	public abstract void moverse();
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract Sprite getSprite();
	public abstract boolean mostrable();
	public abstract void setMostrable(boolean b);
	public abstract void setTocandoBloqueDerecha(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
	public abstract void setTocandoBloqueArriba(boolean b);
	public abstract void setTocandoBloqueAbajo(boolean b);
	public abstract int getToleranciaAltura();
	public abstract boolean murio();
	public abstract void actualizarSprite();
	
}
