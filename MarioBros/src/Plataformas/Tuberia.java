package Plataformas;
import Logica.*;
import Enemigos.*;
import Fabricas.Sprite;

public class Tuberia extends Plataforma{
	
	protected Sprite sprite;
	protected PiranhaPlant contenido;
	protected int x;
	protected int y;
	
	public Tuberia(int x,int y,PiranhaPlant piranha) {
		contenido = piranha;
		this.x = x;
		this.y = y;
	}
	public Tuberia(Sprite sprite, int x,int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}

	
	
	public void mostrarPiranha() {
		
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
