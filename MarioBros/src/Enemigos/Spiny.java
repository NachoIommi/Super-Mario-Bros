package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Spiny extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	protected boolean mostrable;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    protected boolean murio;
	
	public Spiny(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitbox = new Hitbox(x, y, 30, 30);
		mostrable = true;
		setSpriteActualizado(false);
		murio = false;
		moverse();
	}
	
	// Setters	
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralSpiny(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		morir();
		p.setPuntuacion(60);
		murio = true;
	}
	
	public void morir() {
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarSpiny(this);
	}
	
	public void moverse() {
		if(tocandoBloqueIzquierda) 
			tocoParedIzquierda=true;
		
		if(!tocoParedIzquierda) {
			moverIzq();			
			hitbox.actualizar (posX, posY);
			
		} else {
			tocoParedIzquierda=true;
			moverDer();
			hitbox.actualizar (posX, posY);
		}
						
		if (tocandoBloqueDerecha) {
			tocoParedDerecha=true;
			tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
		}		

		if (!tocandoBloqueAbajo) { 
	        posY=posY+1;
		} else {
			actualizarSprite2();
			setSpriteActualizado(true);
		}
		
		hitbox.actualizar (posX, posY);	
	}
	
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
	}
	
	public void setMostrable(boolean b) {
		mostrable=b;
	}
	
	public void setTocandoBloqueDerecha(boolean b) {
		tocandoBloqueDerecha=b;
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda=b;
	}

	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba=b;
	}

	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo=b;
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getSpinyMuerto();
    	cargarSprite(sprite);
    	setSpriteActualizado(true);
    	
    	int posY = getPosY();
        // Animación de desplazamiento hacia arriba
        for (int i = 0; i < 30; i++) {
            setPosY(posY - (i * 2));
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Caída hacia la parte inferior de la ventana
        while (getPosY() < ConstantesVistas.VENTANA_ALTO) {
            setPosY(getPosY() + 5);
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	public void actualizarSprite2(){
		 GenerarSprite fabrica = new GenerarSpriteOriginal();
	     sprite = fabrica.getSpinyCaminandoDerecha();
	}
	
	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;	
	}
	
	public void moverIzq() {
		posX = posX-2;
	}
	public void moverDer() {
		posX = posX+2;
	}
	
	public void spawnear() {
        moverse();
    }

	// Getters
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
		
	public boolean mostrable() {
		return mostrable;
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
	
	public boolean getTocandoAbajo() {
		return tocandoBloqueAbajo;
	}
	
}
