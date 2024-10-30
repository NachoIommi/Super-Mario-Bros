package Enemigos;
import Fabricas.Sprite; 
import Logica.Entidad;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;
public abstract class Enemigo extends Entidad{
	
	// Setters
	public abstract void afectarPersonaje(Personaje p);
	public abstract void serAfectadoPorPersonaje(Personaje p);
	public abstract void morir();
	public abstract void aceptarVisita(Visitor r);
	public abstract void moverse();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void setMostrable(boolean b);
	public abstract void setTocandoBloqueDerecha(boolean b);
	public abstract void setTocandoBloqueIzquierda(boolean b);
	public abstract void setTocandoBloqueArriba(boolean b);
	public abstract void setTocandoBloqueAbajo(boolean b);
	public abstract void cargarSprite(Sprite s);
	public abstract void actualizarSprite();
	public abstract void setSpriteActualizado(boolean actualizado);
	// Getters
	public abstract int getPosX();
	public abstract int getPosY();
	public abstract Hitbox getHitbox();
	public abstract Sprite getSprite();
	public abstract boolean mostrable();
	public abstract int getToleranciaAltura();
	public abstract boolean murio();
	public abstract boolean necesitaActualizarSprite();
	
	
	
}
