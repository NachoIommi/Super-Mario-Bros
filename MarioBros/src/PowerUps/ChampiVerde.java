package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class ChampiVerde extends PowerUps{
	
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
	protected Hitbox hitbox;
	
	public ChampiVerde(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitbox = new Hitbox(x ,y,30 ,30);
		mostrable=false;
	}
	
	public void moverse() {
		if(tocandoBloqueIzquierda) 
			tocoParedIzquierda=true;
			
		if(!tocoParedIzquierda) {
			moverIzq();			
			hitbox.actualizar (posX, posY);
		}
		else
			 {
			tocoParedIzquierda=true;
			moverDer();
			hitbox.actualizar (posX, posY);}				
				
		if (tocandoBloqueDerecha) {
			tocoParedDerecha=true;
			tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
				}

		if (!tocandoBloqueAbajo) 
	        posY=posY+1;
	
	}
	public void moverIzq() {
		posX = posX-3;
	}
	public void moverDer() {
		posX = posX+3;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarChampiVerde(this);
	}
	
	public void cargarSprite(Sprite s) {
		
	}

	public void afectarPersonaje(Personaje p) {
		p.getEstado().setPuntuacionChampiVerde();
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

	public Hitbox getHitbox() {
		return hitbox;
	}

	@Override
	public void setPosX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosY(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mostrable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
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

	@Override
	public void setTocandoBloqueDerecha(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTocandoBloqueIzquierda(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTocandoBloqueArriba(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTocandoBloqueAbajo(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
