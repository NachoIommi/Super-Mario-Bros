package Plataformas;
import Logica.*;
import Personaje.Personaje;
import Enemigos.*;
import Fabricas.Sprite;

public class Tuberia extends Plataforma{
	
	protected Sprite sprite;
	protected PiranhaPlant contenido;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	
	public Tuberia(Sprite sprite, int x, int y, PiranhaPlant piranha) {
		contenido = piranha;
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30,30);
	}
	
	public Tuberia(Sprite sprite, int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x , y, 30,30);
	}

	public boolean cambioEstado() {
		return false;
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
	

	public void mostrarPiranha() {
		
	}
	
	public Hitbox getHitbox() {
		return hitb;
	}
	
	public void afectarPersonaje(Personaje p) {
		
	}
	
}
