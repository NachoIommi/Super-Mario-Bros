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
	protected Sprite s;
	protected Hitbox hitb;
	
	public EstadoKoopaRetraido(KoopaTroopa kt, Sprite s,int x,int y) {
		super(kt);
		posX = x;
		posY = y;
		this.kt	= kt;
		this.s = s;
	}
	public void cambiarEstado() {
		this.actualizarSprite();
        kt.setEstadoActual(new EstadoKoopaNormal(kt,s,posX,posY));  // Cambiar al estado extendido
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
		this.s = fabrica.getKoopaTroopaRetraido();		
	}
	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setMostrable(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setTocandoBloqueAbajo(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTocandoBloqueArriba(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTocandoBloqueIzquierda(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setTocandoBloqueDerecha(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean mostrable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void cargarSprite(Sprite s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void serAfectadoPorPersonaje(Personaje p) {
		// TODO Auto-generated method stub
		
	}
	
}
