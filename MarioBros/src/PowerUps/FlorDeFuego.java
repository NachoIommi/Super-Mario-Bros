package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class FlorDeFuego extends PowerUp{
	
	protected int posX;
	protected int posY;
	protected Sprite sprite;
	protected Hitbox hitbox;
	
	public FlorDeFuego(Sprite s, int x, int y) {
		super();
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x ,y,30 ,30);
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarFlorDeFuego(this);
	}
	
	public void cargarSprite(Sprite s) {
		if (mostrable) {
			sprite = s;
	    }
	}

	public void afectarPersonaje(Personaje p) {
		if (mostrable) {
	        p.getEstado().setPuntuacionFlorDeFuego();
	        mostrable = false;  
	    }
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

	public void setPosX(int x) {
		
	}


	public void setPosY(int x) {
		
	}

	public boolean necesitaActualizarSprite() {
		return false;
	}


	public void setSpriteActualizado(boolean actualizada) {
		
	}
}