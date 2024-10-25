package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.KoopaNormal;
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
	public void cambiarEstado() {
		this.actualizarSprite();
        kt.setEstadoActual(new KoopaNormal(s,this.x,this.y,kt));  // Cambiar al estado extendido
    }
	
	public void moverse() {
		
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
		this.x = x;
	}

	public void setPosY(int y) {
		this.y = y;
	}

	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.s = fabrica.getKoopaTroopa();		
	}
	
}
