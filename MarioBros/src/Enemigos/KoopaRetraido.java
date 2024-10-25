package Enemigos;

import Fabricas.Sprite;
import Logica.Hitbox;

public class KoopaRetraido extends EstadoDeKoopa{
	
	private KoopaTroopa kt;
	protected int x;
	protected int y;
	protected Sprite s;
	protected Hitbox hitb;
	
	public KoopaRetraido(Sprite s,int x,int y,KoopaTroopa kt) {
		super(kt);
		this.x = x;
		this.y = y;
		this.kt	= kt;
		this.s = s;
	}
	
	public void moverse() {
		
	}

	@Override
	public KoopaTroopa getKoopaTroopa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKoopaTroopa(KoopaTroopa kt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarSprite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarEstado() {
		// TODO Auto-generated method stub
		
	}
	
}
