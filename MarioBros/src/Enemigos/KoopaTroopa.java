package Enemigos;
import Fabricas.Sprite;
import Logica.Visitor;

public class KoopaTroopa extends Enemigo{
	
	protected Sprite sprite;
	private EstadoDeKoopa estadoActual;
	
	protected int x;
	protected int y;
	public KoopaTroopa(int x,int y) {
		this.x = x;
		this.y = y;
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
	
	public EstadoDeKoopa getEstadoActual() {
		return estadoActual;
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
}	
