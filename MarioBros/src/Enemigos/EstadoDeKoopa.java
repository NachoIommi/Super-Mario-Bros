package Enemigos;

import Logica.Hitbox;

public abstract class EstadoDeKoopa {
		
	protected KoopaTroopa kt;
	
	public EstadoDeKoopa(KoopaTroopa kt) {
		this.kt = kt;
	}
	public abstract KoopaTroopa getKoopaTroopa();
	public abstract void setKoopaTroopa(KoopaTroopa kt);
	public abstract Hitbox getHitbox();
	public abstract void setPosX(int x);
	public abstract void setPosY(int y);
	public abstract void actualizarSprite();
    public abstract void cambiarEstado();
}
