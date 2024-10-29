package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class SuperChampi extends PowerUps{
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected boolean mostrable;
	
	public SuperChampi(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(0 , 0, 30, 30);
		mostrable=false;
	}
	
	public void moverse() {		
	}

	public boolean mostrable() {
		return mostrable;
	}
	
	public void setMostrable(boolean b) {
		mostrable=b;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarSuperChampi(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionSuperChampi();	
		setMostrable(false);
		hitb.actualizar(0, 0);
		//p.setEstado(null);
		//p.getEstado().setPuntuacionSuperChampi();
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

	public void setPosX(int x) {
		this.x=x;
	}
	
	public void setPosY(int y) {
		this.y=y;
	}
	
	public Hitbox getHitbox() {
		return hitb;
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
