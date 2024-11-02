package Logica;

import Fabricas.Sprite;

public class BolaDeFuego extends Entidad{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitb;
	protected int posXInicial;
	
	public BolaDeFuego(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		posXInicial=x;
	}
	
	public void moverse() {
		posX=posX+1;
		System.out.println("PosX BOla "+posX);
	}
	
	public void moverse2() {
		
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

	public Hitbox getHitbox() {
		return hitb;
	}

	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	
	@Override
	public boolean necesitaActualizarSprite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSpriteActualizado(boolean actualizada) {
		// TODO Auto-generated method stub
		
	}
}
