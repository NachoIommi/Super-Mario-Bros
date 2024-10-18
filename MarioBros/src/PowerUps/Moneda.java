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
		v.visitarMoneda(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) { 
		p.setPuntuacion(5);
    	p.setMonedas(1);
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
	
}
