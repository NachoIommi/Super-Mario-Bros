package PowerUps;
import Logica.*; 
import Personaje.Personaje;
import Fabricas.Sprite;

public class Moneda extends PowerUps{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitb;
	protected boolean mostrable;
	
	public Moneda(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitb = new Hitbox(x , y, 30, 30);
		mostrable=false;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarMoneda(this);
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
		return hitb;
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
		
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		
	
	}

	public void setTocandoBloqueArriba(boolean b) {
		
	}


	public void setTocandoBloqueAbajo(boolean b) {
	
	}

	@Override
	public void afectarPersonaje(Personaje p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mostrable() {
								
		return mostrable;
	}
	
	@Override
	public void cargarSprite(Sprite s) {
			}
	
}
