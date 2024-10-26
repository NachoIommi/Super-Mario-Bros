package Enemigos;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.EstadoNormal;
import Personaje.Personaje;

public class KoopaTroopa extends Enemigo{
	
	private EstadoDeKoopa estado;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int posX;
	protected int posY;
	protected boolean mostrable;
	
	public KoopaTroopa(Sprite s, int x,int y) {
		estado = new EstadoKoopaNormal(this ,s, x ,y); 
		posX = x;
		posY = y;
		hitb = new Hitbox(x, y, 30, 30);
		mostrable = true; //?	
	}
	
	public void cambiarEstado() {
        estado.cambiarEstado();  
    }
	
	public EstadoDeKoopa getEstadoActual() {
		return estado;
	}
	
	public Sprite getSprite() {
		return estado.getSprite();
	}

	public int getPosX() {
		return estado.getPosX();
	}

	public int getPosY() {
		return estado.getPosY();
	}
	
	public void setEstadoActual(EstadoDeKoopa nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public void moverse() {
		estado.moverse();
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarKoopaTroopa(this);
	}
	
	public void cargarSprite(Sprite s) {
		estado.cargarSprite(s);
	}
	
	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(-45);
		p.morir();
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(90);
		estado.serAfectadoPorPersonaje(p);
	}
	
	public void morir() {
		
	}

	public Hitbox getHitbox() {
		return estado.getHitbox();
	}
	@Override
	public boolean mostrable() {
		return estado.mostrable();
	}

	@Override
	public void setMostrable(boolean b) {
		estado.setMostrable(b);
		
	}

	@Override
	public void setTocandoBloqueDerecha(boolean b) {
		estado.setTocandoBloqueDerecha(b);
		
	}

	@Override
	public void setTocandoBloqueIzquierda(boolean b) {
		estado.setTocandoBloqueIzquierda(b);
		
	}

	@Override
	public void setTocandoBloqueArriba(boolean b) {
		// TODO Auto-generated method stub
		estado.setTocandoBloqueArriba(b);
	}

	@Override
	public void setTocandoBloqueAbajo(boolean b) {
		estado.setTocandoBloqueAbajo(b);
		
	}

	@Override
	public int getToleranciaAltura() {
		return 20;
	}

}	
