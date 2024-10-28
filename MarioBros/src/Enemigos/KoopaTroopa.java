package Enemigos;
import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
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
		setSpriteActualizado(false);
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
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
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
		p.colisionLateralKoopa(this);
	}
	public void morir() {
		estado.morir();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(90);
		estado.serAfectadoPorPersonaje(p);
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getKoopaTroopaMuerto();
    	cargarSprite(sprite);
    	setSpriteActualizado(true);	
	}

	public Hitbox getHitbox() {
		return estado.getHitbox();
	}
	
	public boolean mostrable() {
		return estado.mostrable();
	}

	
	public void setMostrable(boolean b) {
		estado.setMostrable(b);
	}

	
	public void setTocandoBloqueDerecha(boolean b) {
		estado.setTocandoBloqueDerecha(b);
	}

	
	public void setTocandoBloqueIzquierda(boolean b) {
		estado.setTocandoBloqueIzquierda(b);	
	}

	
	public void setTocandoBloqueArriba(boolean b) {
		estado.setTocandoBloqueArriba(b);
	}

	public void setTocandoBloqueAbajo(boolean b) {
		estado.setTocandoBloqueAbajo(b);
		
	}

	public int getToleranciaAltura() {
		return 20;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
		
	}

}	
