package Enemigos;
import Fabricas.Sprite;
import Logica.Visitor;

public class KoopaTroopa extends Enemigo{
	
	private EstadoDeKoopa estadoActual;
	protected Sprite sprite;
	protected int x;
	protected int y;
	
	public KoopaTroopa(Sprite sprite, int x,int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
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
		
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}

}	
