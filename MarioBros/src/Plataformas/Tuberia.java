package Plataformas;
import Logica.*;
import Personaje.Personaje;
import Enemigos.*;
import Fabricas.Sprite;

public class Tuberia extends Plataforma{
	
	protected Sprite sprite;
	protected PiranhaPlant contenido;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	protected int reloj;
	
	public Tuberia(Sprite s, int x, int y, PiranhaPlant piranha) {
		contenido = piranha;
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 32,30);
	}
	
	public Tuberia(Sprite s, int x,int y) {
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x , y, 30,30);
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

	
	public PiranhaPlant getContenido() {
		return contenido;
	}
	
	public void setContenido(PiranhaPlant p) {
		contenido = p;
	}
	
    public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public boolean cambioEstado() {
		return false;
	}

	
	public boolean necesitaActualizarSprite() {
		return false;
	}

	
	public void setSpriteActualizado(boolean actualizada) {
		
	}

}
