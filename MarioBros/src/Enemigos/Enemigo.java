package Enemigos;
import Fabricas.Sprite;
import Logica.Entidad;
import Logica.Visitor;
import Personaje.Personaje;
public abstract class Enemigo extends Entidad{
	
	public abstract void afectarPersonaje(Personaje p);
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void aceptarVisita(Visitor r);
	public abstract void moverse();
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Sprite getSprite();
	public abstract double getToleranciaAltura();
	public abstract void setTocandoBloqueAbajo(boolean b);
	public abstract void setTocandoBloqueDerecha(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
}
