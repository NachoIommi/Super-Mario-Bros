package Plataformas;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Logica.VisitorEntidad;
import Personaje.Personaje;

public class Vacio extends Plataforma {
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	protected Hitbox hitbox;
	
	public Vacio(Sprite sprite, int x,int y, Nivel nivelActual) {
		super(nivelActual);
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitbox = new Hitbox(x, y, 30, 30);
	}

	public void aceptarVisita(Visitor v) {
		v.visitarVacio(this);
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionVacio();
		
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	public boolean cambioEstado() {
		return false;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	
	public void verificarCambioEstado() {
		// TODO Auto-generated method stub
		
	}


	public boolean necesitaActualizarSprite() {
		// TODO Auto-generated method stub
		return false;
	}


	public void setSpriteActualizado(boolean actualizada) {
		// TODO Auto-generated method stub
		
	}

}
