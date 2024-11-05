package Enemigos;
import Fabricas.GenerarSprite; 
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.EstadoNormal;
import Personaje.Personaje;

public class KoopaTroopa extends Enemigo{
	
	private EstadoDeKoopa estado;
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	
	public KoopaTroopa(Sprite s, int x,int y, Nivel nivelActual) {
		super(nivelActual);
		estado = new EstadoKoopaNormal(this ,s, x ,y); 
		posX = x;
		posY = y;
		hitbox = new Hitbox(x, y, 30, 30);
		setSpriteActualizado(false);
	}
	
	// Setters
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralKoopa(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(90);
		estado.serAfectadoPorPersonaje(p);
	}
	
	public void morir() {
		murio = true;
		estado.morir();
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarKoopaTroopa(this);
	}
	
	public void moverse() {
		estado.moverse();
	}
	
	public void setPosX(int x) {
        estado.setPosX(x);
   }

   public void setPosY(int y) {
       estado.setPosY(y);
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
	
	public void cargarSprite(Sprite s) {
		estado.cargarSprite(s);
	}
	
	public void actualizarSprite() {
		estado.actualizarSprite();
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;	
	}
	
	public void cambiarEstado() {
        estado.cambiarEstado();  
    }
	
	// Getters
	public int getPosX() {
		return estado.getPosX();
	}

	public int getPosY() {
		return estado.getPosY();
	}
	
	public Hitbox getHitbox() {
		return estado.getHitbox();
	}
	
	public Sprite getSprite() {
		return estado.getSprite();
	}

	public boolean mostrable() {
		return estado.mostrable();
	}

	public int getToleranciaAltura() {
		return 20;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
	
	public EstadoDeKoopa getEstadoActual() {
		return estado;
	}
	
	public void setEstadoActual(EstadoDeKoopa nuevoEstado) {
		this.estado = nuevoEstado;
	}
}	
