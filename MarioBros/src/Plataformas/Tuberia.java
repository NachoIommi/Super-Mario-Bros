package Plataformas;
import Logica.*;
import Enemigos.*;
import Fabricas.Sprite;

public class Tuberia extends Plataforma{
	
	protected PiranhaPlant contenido;
	
	public Tuberia(int x,int y,PiranhaPlant piranha) {
		contenido = piranha;
	}
	public Tuberia(int x,int y) {
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
