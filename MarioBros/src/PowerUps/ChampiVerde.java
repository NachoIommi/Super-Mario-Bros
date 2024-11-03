package PowerUps;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class ChampiVerde extends PowerUp{
	
	protected int posX;
	protected int posY;
	
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
	protected Sprite sprite;
	protected Hitbox hitbox;
	
	public ChampiVerde(Sprite s, int x, int y) {
		super();
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x ,y,30 ,30);
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


	public void setPosX(int x) {
		
	}


	public void setPosY(int x) {
		
	}

	public boolean necesitaActualizarSprite() {
		return false;
	}


	public void setSpriteActualizado(boolean actualizada) {
		
	}
}
