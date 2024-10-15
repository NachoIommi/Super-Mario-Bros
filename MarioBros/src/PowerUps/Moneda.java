package PowerUps;
import Logica.*;
import Personaje.Personaje;
import Fabricas.Sprite;


public class Moneda extends PowerUps{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	
	public Moneda(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) { 
		
	}

	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public int getPosX() {
		return x;
	}

	@Override
	public int getPosY() {
		return y;
	}
}
