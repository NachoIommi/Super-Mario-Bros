package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class SuperChampi extends PowerUps{
	
	protected int posX;
	protected int posY;
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    protected boolean cayendo;
	protected Sprite sprite;
	protected Hitbox hitbox;
	
	public SuperChampi(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitbox = new Hitbox(0 ,0,25 ,25);
		mostrable=false;
		tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	}
	
	public void moverse() {
		
		if(mostrable){			
			if(tocandoBloqueIzquierda) {
				tocoParedIzquierda=true;
				tocoParedDerecha=false;}
			
			if(tocandoBloqueDerecha)
				tocoParedDerecha=true;
			
			if(!tocoParedDerecha) {
				moverDer();
				hitbox.actualizar (posX, posY);
			}
			else {
				tocoParedDerecha=true;
				moverIzq();
				hitbox.actualizar (posX, posY);
			}	
			
			if (!tocandoBloqueAbajo) {
		        posY=posY+3;}
			
			hitbox.actualizar (posX, posY);		
			corregirPosEnColision();
		}
		
	}
	public void moverIzq() {
		posX = posX-2;
	}
	public void moverDer() {
		posX = posX+2;
	}
	public void corregirPosEnColision() {
		if(tocandoBloqueIzquierda)  
	    	posX=posX+1;	    		
	    if(tocandoBloqueDerecha) 
	    	posX=posX-1;	    
	}
	
	
	public boolean mostrable() {
		return mostrable;
	}

	public void aceptarVisita(Visitor v) {
		v.visitarSuperChampi(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}
	
	public void afectarPersonaje(Personaje p) {
		
		p.colisionSuperChampi();
		hitbox.actualizar(0, 0);
		setMostrable(false);
		hitbox.actualizar(0, 0);
		//p.setEstado(null);
		//p.getEstado().setPuntuacionSuperChampi();
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
		this.posX=x;
	}
	
	public void setPosY(int y) {
		this.posY=y;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	@Override
	public boolean necesitaActualizarSprite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSpriteActualizado(boolean actualizada) {
		// TODO Auto-generated method stub
		
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
	
}
