package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Goomba extends Enemigo{
	
	public double toleranciaAltura=20;
	protected Sprite sprite;
	protected Hitbox hitbox;

	protected int posX;
	protected int posY;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    protected boolean murio;

	public Goomba(Sprite s,int x,int y) {
		posX = x;
        posY = y;
        sprite = s;
        hitbox = new Hitbox(x ,y,30 ,30);
        tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    mostrable=true;
	    setSpriteActualizado(false);
	    murio = false;
	}
	// Setters
	public void afectarPersonaje(Personaje p) {	
		p.colisionLateralGoomba(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		murio = true;
		morir();
		p.setPuntuacion(60);
	}
	
	public void morir() {
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarGoomba(this);
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

		hitbox.actualizar (posX, posY);		
	

		if (!tocandoBloqueAbajo) 
	        posY=posY+1;
		
		hitbox.actualizar (posX, posY);		
	}

	
	public void moverIzq() {
		posX=posX-1;
	}
	
	public void moverDer() {
		posX=posX+1;
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
    	sprite = fabrica.getGoombaMuerto();
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
	
	public void setSpriteActualizado(boolean actualizado) {
		spriteActualizado = actualizado;
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
		return (int)toleranciaAltura;
	}
	
	public boolean murio() {
		return murio;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
	
}