package Personaje;

import Fabricas.Sprite;
import Logica.Entidad;
import Logica.Visitor;

public class BolaDeFuego extends Entidad{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	
	public BolaDeFuego(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarBolaDeFuego(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
