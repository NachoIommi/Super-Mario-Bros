package PowerUps;
import Logica.*; 
import Personaje.Personaje;
import Fabricas.Sprite;

public class Moneda extends PowerUps{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	protected boolean mostrable;
	
	public Moneda(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitbox = new Hitbox(x , y, 30, 30);
		mostrable=true;
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
		
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		
	
	}

	public void setTocandoBloqueArriba(boolean b) {
		
	}


	public void setTocandoBloqueAbajo(boolean b) {
	
	}

	@Override
	public void afectarPersonaje(Personaje p) {
		p.setPuntuacion(5);
		p.setMonedas(1);
		hitbox.actualizar(0, 0);
		setMostrable(false);
		hitbox.actualizar(0, 0);
		
	}

	@Override
	public boolean mostrable() {
								
		return mostrable;
	}
	
	@Override
	public void cargarSprite(Sprite s) {
			}
	
}
