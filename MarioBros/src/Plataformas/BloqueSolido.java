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
		System.out.println("ruta de bloquesolido: "+ sprite.getRutaImagen());
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

	@Override
	public int getPosX() {
		return x;
	}

	@Override
	public int getPosY() {
		return y;
	}
	
	

}
