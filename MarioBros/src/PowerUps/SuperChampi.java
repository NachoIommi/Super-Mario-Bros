package PowerUps;

import Fabricas.Sprite;
import Logica.Visitor;
import Personaje.Personaje;

public class SuperChampi extends PowerUps{
	
	protected Sprite sprite;
	
	public SuperChampi(Sprite sprite, int x, int y) {
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
		return null;
	}
	
}
