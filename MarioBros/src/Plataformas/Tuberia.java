package Plataformas;
import Logica.*;
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
	}
	public Tuberia(Sprite sprite, int x,int y) {
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
	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

}
