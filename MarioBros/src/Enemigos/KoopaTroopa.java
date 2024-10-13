package Enemigos;

public class KoopaTroopa extends Enemigo{
	protected Sprite sprite;
	private EstadoDeKoopa estadoActual;
	
	public KoopaTroopa() {
		
	}
	
	public void cambiarEstado(EstadoDelKoopa e) {
		estadoActual = e;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public EstadosDeKoopa getEstadoActual() {
		return estadoActual;
	}
}	
