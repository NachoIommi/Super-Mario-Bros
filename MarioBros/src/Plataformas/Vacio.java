package Plataformas;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Logica.VisitorEntidad;
import Personaje.Personaje;

public class Vacio extends Plataforma {
	
	protected Sprite sprite;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	
	public Vacio(Sprite sprite, int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x ,y,30 ,30);
	}

	public void aceptarVisita(Visitor v) {
		v.visitarVacio(this);
	}
	public void afectarPersonaje(Personaje p) {
		p.morir();
		p.setPuntuacion(-15);
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

	@Override
	public Hitbox getHitbox() {
		return hitb;
	}

}
