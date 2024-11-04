package Plataformas;

import Fabricas.Sprite; 
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class BloqueSolido extends Plataforma{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	
	public BloqueSolido(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
	}
	
	public void recibirGolpe() {
		
	}
	public boolean cambioEstado() {
		return false;
	}
	
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
	
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void verificarCambioEstado() {
	
	}

	public boolean necesitaActualizarSprite() {
		return false;
	}

	public void setSpriteActualizado(boolean actualizada) {
		
	}
}
