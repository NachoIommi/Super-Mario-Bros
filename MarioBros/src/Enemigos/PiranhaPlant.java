package Enemigos;

import javax.swing.Timer;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class PiranhaPlant extends Enemigo{
	
	private EstadosDePiranhaPlant estado;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int posX;
	protected int posY;
	protected boolean mostrable;
	protected boolean murio;
	
	public PiranhaPlant(Sprite s, int x, int y) {
		estado = new EstadoPiranhaExtendida(this ,s, x ,y); 
		posX = x;
		posY = y;
		hitb = new Hitbox(x+15, y, 10, 30);
		mostrable = true; 	
		setSpriteActualizado(false);
		murio = false;		
	}
	public void moverse() {
		estado.moverse();
	}
	
	public void cambiarEstado() {
        estado.cambiarEstado();
    }
	
	public void setEstadoActual(EstadosDePiranhaPlant e) {
		this.estado=e;
	}
	
	public EstadosDePiranhaPlant getEstadoActual() {
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
		estado.setPosX(x);
	}

	public void setPosY(int y) {  
		estado.setPosY(y);	
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarPiranhaPlant(this);
	}
	
	public void cargarSprite(Sprite s) {
		estado.cargarSprite(s);
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
	
	
	public Hitbox getHitbox() {
		return estado.getHitbox();
	}


	public void setTocandoBloqueDerecha(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void setTocandoBloqueIzquierda(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public void setTocandoBloqueArriba(boolean b) {
		
	}

	public void setTocandoBloqueAbajo(boolean b) {
		
	}

	
	public int getToleranciaAltura() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean mostrable() {
		return estado.mostrable();
	}

	public void setMostrable(boolean b) {
		estado.setMostrable(b);
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
	}
	public boolean murio() {
		return murio;
	}
	public void actualizarSprite() {
		estado.actualizarSprite();
	}
	
}
