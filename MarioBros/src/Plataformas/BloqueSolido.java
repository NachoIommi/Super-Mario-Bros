package Plataformas;

import Fabricas.Sprite;
import Logica.Visitor;

public class BloqueSolido extends Plataforma{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	
	public BloqueSolido(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void recibirGolpe() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		
	}

	public void cargarSprite(Sprite s) {
		
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
