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
	}
	public void cambiarEstado() {
		this.actualizarSprite();
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
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getKoopaTroopaMuerto();
    	cargarSprite(sprite);
    	actualizarSpriteKoopaMuerto();
    	
    	int posY = getPosY();

        for (int i = 0; i < 30; i++) {
            setPosY(posY - (i * 2));
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (getPosY() < ConstantesVistas.VENTANA_ALTO) {
            setPosY(getPosY() + 5);
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.sprite = fabrica.getKoopaTroopaRetraido();		
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
	}
	public void actualizarSpriteKoopaMuerto() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getKoopaTroopaMuerto();
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
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
	
<<<<<<< HEAD
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralKoopa(this);

	}
	
=======
>>>>>>> 3dd64ead7c71e206339b743ed3bf52d4d2b65e3e
	public void serAfectadoPorPersonaje(Personaje p) {
		saltoArriba=true;
	}
	
}
