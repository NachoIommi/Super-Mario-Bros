package Fabricas;

import Enemigos.EstadoDeKoopa;
import Enemigos.KoopaRetraido;
import Enemigos.KoopaTroopa;
import Enemigos.PiranhaExtendida;
import Logica.Hitbox;

public class KoopaTroopaNormal extends EstadoDeKoopa{

	protected KoopaTroopa kt;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	protected Sprite s;
	
	public KoopaTroopaNormal(KoopaTroopa kt) {
		super(kt);
		this.x = x;
		this.y = y;
		this.kt	= kt;
		this.s = s;
	}

	public void cambiarEstado() {
		this.actualizarSprite();
        kt.cambiarEstado(new KoopaRetraido(s,this.x,this.y,kt));  // Cambiar al estado extendido	
	}

	
	
	
	
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


}
