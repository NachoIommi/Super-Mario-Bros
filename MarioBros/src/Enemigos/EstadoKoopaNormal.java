package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.EstadoSuperMario;
import Personaje.Personaje;

public class EstadoKoopaNormal extends EstadoDeKoopa {
	
	public double toleranciaAltura=20;
	
	//private KoopaTroopa koopa;
	
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
    protected boolean mori;
	
	public EstadoKoopaNormal(KoopaTroopa kt,Sprite s,int x,int y) {
		super(kt);
		//koopa = kt;
		posX = x;
		posY = y;
		sprite = s;
		hitb = new Hitbox(x ,y,30 ,30);
        tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    mostrable=true;	
	    mori=false;
	}
	
	public void moverse() {
		if(!mori) {
		
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
		
			hitb.actualizar (posX, posY);	}			
	}
	
	public void moverIzq() {
		posX=posX-1;
	}
	public void moverDer() {
		posX=posX+1;
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralKoopa(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		mori=true;
		cambiarEstado();
	}
	public void morir() {
		//actualizarSprite();
		hitb.actualizar(0, 0);
		posX=0;
		posY=-300;
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getKoopaTroopaRetraido();
		koopa.setSpriteActualizado(true);
	}
	public void cambiarEstado() {
		this.actualizarSprite();
        koopa.setEstadoActual(new EstadoKoopaRetraido(koopa,sprite,posX,posY));  // Cambiar al estado extendido
    }
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	
	public KoopaTroopa getKoopaTroopa() {
		return koopa;
	}

	
	public void setKoopaTroopa(KoopaTroopa kt) {
		koopa=kt;		
	}

	
	public Hitbox getHitbox() {
		return hitb;
	}

	
	public void setPosX(int x) {
		posX=x;		
	}

	
	public void setPosY(int y) {
		posY=y;		
	}
	
	

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
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
	
}
