package Enemigos;

import javax.swing.Timer;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class PiranhaPlant extends Enemigo{
	
	private EstadosDePiranhaPlant estado;
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	protected boolean mostrable;
	protected boolean murio;
	
	public PiranhaPlant(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		estado = new EstadoPiranhaExtendida(this ,s, x ,y); 
		posX = x;
		posY = y;
		hitbox = new Hitbox(x+15, y, 10, 30);
		mostrable = true; 	
		setSpriteActualizado(false);
		murio = false;		
	}
	// Setters
	public void cambiarEstado() {
        estado.cambiarEstado();
    }
	
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralPiranha(this);
	}

	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(30);
		estado.serAfectadoPorPersonaje(p);
	}
	
	public void morir() {
		murio = true;
		estado.morir();
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarPiranhaPlant(this);
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
		
	}


	public void setTocandoBloqueIzquierda(boolean b) {
		
	}

	public void setTocandoBloqueArriba(boolean b) {
		
	}

	public void setTocandoBloqueAbajo(boolean b) {
		
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
	
	public void setEstadoActual(EstadosDePiranhaPlant e) {
		this.estado=e;
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
		return 0;
	}
	
	public boolean murio() {
		return murio;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
	
	public EstadosDePiranhaPlant getEstadoActual() {
		return estado;
	}
		
}
