package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class ChampiVerde extends PowerUps{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected boolean mostrable;
	
	public ChampiVerde(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x ,y,30 ,30);
		mostrable=false;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarChampiVerde(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) {
		p.getEstado().setPuntuacionChampiVerde();
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

	public Hitbox getHitbox() {
		return hitb;
	}

	@Override
	public void setPosX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosY(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mostrable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}
	
}
