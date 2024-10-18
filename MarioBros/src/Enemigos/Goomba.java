package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Goomba extends Enemigo{
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	protected Hitbox hitb;

	public Goomba(Sprite sprite,int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
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
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarGoomba(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void afectarPersonaje(Personaje p) {
		// si te choca mario de costado ejecutas p.morir()
		// podría ir un boolean de si chocoDeCostado
		p.morir();
		// else
			morir();
			p.setPuntuacion(5);
		// si te choca ejecutas morir de goomba y sumas puntos
	}
	public void morir() {
		
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

