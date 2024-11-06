package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class FlorDeFuego extends PowerUp{
	
	protected int posX;
	protected int posY;
	protected Sprite sprite;
	protected Hitbox hitbox;
	
	public FlorDeFuego(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(0 ,0,30 ,30);
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarFlorDeFuego(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) {
		p.colisionFlorDeFuego();
		hitbox.actualizar(0, 0);
		setMostrable(false);
		
		setSpriteActualizado(false);
		
		hitbox.actualizar(0, 0);
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
		posX=x;
	}

	public void setPosY(int y) {
		posY=y;
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado=actualizada;
	}
}