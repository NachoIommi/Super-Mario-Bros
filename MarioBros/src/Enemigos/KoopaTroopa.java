package Enemigos;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class KoopaTroopa extends Enemigo{
	
	private EstadoDeKoopa estadoActual;
	protected Sprite sprite;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	
	public KoopaTroopa(Sprite sprite, int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		hitb = new Hitbox(x ,y,30 ,30);
		
	}
	
	public EstadoDeKoopa getEstadoActual() {
		return estadoActual;
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
	
	public void cambiarEstado(EstadoDeKoopa e) {
		estadoActual = e;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarKoopaTroopa(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(-45);
		p.morir();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(90);
		morir();
	}
	public void morir() {
		
	}

	@Override
	public Hitbox getHitbox() {
		return hitb;
	}

}	
