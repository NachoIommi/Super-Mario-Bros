package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
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
	
	public EstadoKoopaRetraido(KoopaTroopa kt, Sprite s,int x,int y) {
		super(kt);
		posX = x;
		posY = y;
		this.kt	= kt;
		this.sprite = s;
	}
	public void cambiarEstado() {
		this.actualizarSprite();
        kt.setEstadoActual(new EstadoKoopaNormal(kt,sprite,posX,posY));  // Cambiar al estado extendido
    }
	
	public void moverse() {
		posX=posX;
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

	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.sprite = fabrica.getKoopaTroopaRetraido();		
	}
	
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		// TODO Auto-generated method stub
		
	}
	
}
