package Enemigos;

import java.util.Timer;
import java.util.TimerTask;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Personaje.Personaje;

public class EstadoKoopaRetraido extends EstadoDeKoopa{
	
	private KoopaTroopa kt;
	protected int posX;
	protected int posY;
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
	protected Sprite sprite;
	protected Hitbox hitb;
	protected boolean saltoArriba;
	protected boolean murio;
	
	public EstadoKoopaRetraido(KoopaTroopa kt, Sprite s,int x,int y) {
		super(kt);
		posX = x;
		posY = y;
		this.kt	= kt;
		sprite = s;
		hitb = new Hitbox(x, y, 30, 30);
		tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    mostrable=true;	
	    saltoArriba=false;
	    murio = false;
	}
	public void cambiarEstado() {
		this.actualizarSpriteKoopaRetraido();
        kt.setEstadoActual(new EstadoKoopaNormal(kt,sprite,posX,posY));  // Cambiar al estado extendido
    }
	
	public void moverse() {
		if(saltoArriba) {
			
			if(tocandoBloqueIzquierda) 
				tocoParedIzquierda=true;
				
			if(!tocoParedIzquierda) {
				moverIzq();			
				hitb.actualizar (posX, posY);
			}
			else
				 {
				tocoParedIzquierda=true;
				moverDer();
				hitb.actualizar (posX, posY);}				
					
			if (tocandoBloqueDerecha) {
				tocoParedDerecha=true;
				tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
					}
	
			if (!tocandoBloqueAbajo) 
		        posY=posY+1;
		}
		
	}
	
	public void moverIzq() {
		posX=posX-4;
	}
	public void moverDer() {
		posX=posX+4;
	}
	
	
	public KoopaTroopa getKoopaTroopa() {
		return kt;
	}

	public void setKoopaTroopa(KoopaTroopa kt) {
		this.kt = kt;
	}

	public Hitbox getHitbox() {
		return hitb;
	}

	public void setPosX(int x) {
		posX = x;
	}

	public void setPosY(int y) {
		posY = y;
	}
	public void morir() {
		hitb = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	public void actualizarSpriteKoopaRetraido() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.sprite = fabrica.getKoopaTroopaRetraido();		
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
	}
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getKoopaTroopaMuerto();
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
		
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
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public Sprite getSprite() {
		return sprite;
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
	
	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
		
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		saltoArriba=true;
	}
	public boolean murio() {
		return murio;
	}
}
