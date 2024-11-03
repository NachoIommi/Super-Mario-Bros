package PowerUps;
import Logica.*; 
import Personaje.Personaje;
import Fabricas.Sprite;

public class Moneda extends PowerUp{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	
	public Moneda(Sprite s, int x, int y) {
		super();
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x , y, 30, 30);
		mostrable = true;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarMoneda(this);
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

	public void setPosX(int x) {
		posX = x;
	}
	
	public void setPosY(int y) {
		posY = y;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public boolean necesitaActualizarSprite() {
		return false;
	}

	public void setSpriteActualizado(boolean actualizada) {
		
	}

	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(5);
		p.setMonedas(1);
		hitbox.actualizar(0, 0);
		setMostrable(false);
		hitbox.actualizar(0, 0);
		
	}
	
	public void cargarSprite(Sprite s) {
		
	}
}
