package Plataformas;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class LadrilloSolido extends BloqueSolido{
	
	public LadrilloSolido(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	public void aceptarVisita(Visitor v){
		v.visitarLadrilloSolido(this);
	}
	
	public void recibirGolpe(Personaje p) {
		p.getEstado().romperLadrilloSolido(this);
	}
	public void destruir() {
		this.hitb = new Hitbox(0, 0, 0, 0);
		this.sprite=null;
	}

}
