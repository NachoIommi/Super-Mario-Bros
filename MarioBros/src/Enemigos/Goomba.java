package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Goomba extends Enemigo{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitb;

	public Goomba(Sprite sprite,int x,int y) {
		posX = x;
        posY = y;
        this.sprite = sprite;
        hitb = new Hitbox(x ,y,30 ,30);
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
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
		p.setPuntuacion(-30);
		p.morir();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(60);
		morir();
	}
	public void morir() {
		
	}

	public Hitbox getHitbox() {
    	return hitb;
    }
	
}

