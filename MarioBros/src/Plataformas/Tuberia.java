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
	protected int reloj;
	
	public Tuberia(Sprite sprite, int x, int y, PiranhaPlant piranha,int reloj) {
		contenido = piranha;
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30,30);
		this.reloj = reloj;
	}
	
	public Tuberia(Sprite sprite, int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x , y, 30,30);
	}

	public void verificarCambioEstado() {
        if (reloj % 5 == 0) {
            contenido.cambiarEstado();  // Llamar al método para cambiar de estado
        }
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

	public boolean cambioEstado() {
		return false;
	}
	
}
