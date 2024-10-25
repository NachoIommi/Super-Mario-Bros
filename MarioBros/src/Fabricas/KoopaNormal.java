package Fabricas;

import Enemigos.EstadoDeKoopa;
import Enemigos.KoopaRetraido;
import Enemigos.KoopaTroopa;
import Enemigos.PiranhaExtendida;
import Logica.Hitbox;

public class KoopaNormal extends EstadoDeKoopa{

	protected KoopaTroopa kt;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	protected Sprite s;
	
	public KoopaNormal(Sprite s,int x,int y,KoopaTroopa kt) {
		super(kt);
		this.x = x;
		this.y = y;
		this.kt	= kt;
		this.s = s;
	}

	public void cambiarEstado() {
		this.actualizarSprite();
        kt.setEstadoActual(new KoopaRetraido(s,this.x,this.y,kt));  // Cambiar al estado extendido	
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
		this.s = fabrica.getKoopaTroopaRetraido();			
	}


}
