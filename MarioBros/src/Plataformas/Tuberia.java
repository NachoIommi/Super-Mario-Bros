package Plataformas;
import Logica.*;
import Enemigos.*;

public class Tuberia extends Plataforma{
	
	protected PiranhaPlant contenido;
	
	public Tuberia(PiranhaPlant piranha) {
		contenido = piranha;
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

}
