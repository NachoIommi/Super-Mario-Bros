package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Personaje.EstadoSuperMario;
import Personaje.Personaje;

public class EstadoKoopaNormal extends EstadoDeKoopa {
	
	protected Sprite sprite;
	protected Hitbox hitb;
	public double toleranciaAltura=20;
	
	protected int posX;
	protected int posY;	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    
    protected boolean mori;
	
	public EstadoKoopaNormal(KoopaTroopa kt,Sprite s,int x,int y) {
		super(kt);
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
		posX=posX-2;
	}
	public void moverDer() {
		posX=posX+2;
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		mori=true;
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getKoopaTroopaRetraido();
		EstadoKoopaRetraido e = new EstadoKoopaRetraido(koopa,sprite,posX,posY);
		
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	@Override
	public KoopaTroopa getKoopaTroopa() {
		return koopa;
	}

	@Override
	public void setKoopaTroopa(KoopaTroopa kt) {
		koopa=kt;		
	}

	@Override
	public Hitbox getHitbox() {
		return hitb;
	}

	@Override
	public void setPosX(int x) {
		posX=x;		
	}

	@Override
	public void setPosY(int y) {
		posY=y;		
	}

	@Override
	public void actualizarSprite() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void cambiarEstado() {		
		
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
