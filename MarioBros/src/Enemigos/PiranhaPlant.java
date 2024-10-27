package Enemigos;

import javax.swing.Timer;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class PiranhaPlant extends Enemigo{
	
	private EstadosDePiranhaPlant estadoActual;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int x;
	protected int y;
	protected boolean mostrable;
	
	private boolean subiendo;
	private Timer timer;
	private int pixelesMovidos = 0;
	
	public PiranhaPlant(Sprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		estadoActual = new PiranhaInvulnerable(sprite, x, y, this);
		hitb = new Hitbox(x+5, y, 20, 30);
		mostrable = true;
		setSpriteActualizado(false);
		subiendo = true;
		iniciarMovimiento();
		
	}
	
	public EstadosDePiranhaPlant getEstadoActual() {
		return estadoActual;
	}
	public void cambiarEstado(EstadosDePiranhaPlant nuevoEstado) {
        estadoActual = nuevoEstado;
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
	
	public void moverse() {
		
		if(subiendo && pixelesMovidos < 30) {
			setPosY(getPosY()-1);
			hitb.actualizar(x+5, y);
			estadoActual.cambiarEstado();
			pixelesMovidos++;
		}else if(!subiendo && pixelesMovidos > 0){
				setPosY(getPosY()+1);
				hitb.actualizar(x+5, y);
				estadoActual.cambiarEstado();
				pixelesMovidos--;
		}
		
		if(pixelesMovidos == 30 || pixelesMovidos == 0) {
			estadoActual.cambiarEstado();
		}
		
		System.out.println("posY piranha: "+getPosY());
	}
	
	public void iniciarMovimiento() {
		
		timer = new Timer(5000, e -> {
			subiendo = !subiendo;
		});
		timer.start();
		
	
	}
	public void setPosX(int x) {
		this.x = x;
	}

	public void setPosY(int y) {  
		this.y = y;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarPiranhaPlant(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionPiranhaPlant();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(30);
		morir();
	}
	
	public void morir() {
		
	}
	
	public void setEstadoActual(EstadosDePiranhaPlant e) {
		
	}

	public Hitbox getHitbox() {
		return hitb;
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
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
		
	}
	
}
