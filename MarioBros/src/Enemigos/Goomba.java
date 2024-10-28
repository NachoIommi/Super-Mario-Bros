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
	protected Hitbox hitb;

	protected int posX;
	protected int posY;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;

	public Goomba(Sprite sprite,int x,int y) {
		posX = x;
        posY = y;
        this.sprite = sprite;
        hitb = new Hitbox(x ,y,30 ,30);
        tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    mostrable=true;
	    setSpriteActualizado(false);
	}
	
	public void moverse() {
		if(tocandoBloqueIzquierda) 
			tocoParedIzquierda=true;
		
		if(!tocoParedIzquierda) {
			moverIzq();			
			hitb.actualizar (posX, posY);
			
		} else {
			tocoParedIzquierda=true;
			moverDer();
			hitb.actualizar (posX, posY);
		}
						
		if (tocandoBloqueDerecha) {
			tocoParedDerecha=true;
			tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
		}

		hitb.actualizar (posX, posY);		
	

		if (!tocandoBloqueAbajo) 
	        posY=posY+1;
		
		hitb.actualizar (posX, posY);		
}

	
	public void moverIzq() {
		posX=posX-1;
	}
	public void moverDer() {
		posX=posX+1;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
	}
	public void aceptarVisita(Visitor v) {
		v.visitarGoomba(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void afectarPersonaje(Personaje p) {	
		p.colisionLateralGoomba(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		p.setPuntuacion(60);
		morir();
	}
	
	public void morir() {
		 hitb = new Hitbox(0 ,0,0 ,0);
		 new Thread(() -> {
		        GenerarSprite fabrica = new GenerarSpriteOriginal();
		        sprite = fabrica.getGoombaMuerto();
		        cargarSprite(sprite);
		        actualizarSprite();
		        
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
		    }).start();
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getGoombaMuerto();
    	cargarSprite(sprite);
    	setSpriteActualizado(true);
	}
	
	public Hitbox getHitbox() {
    	return hitb;
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

	public int getToleranciaAltura() {
		return (int)toleranciaAltura;
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

