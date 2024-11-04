package Plataformas;

import Fabricas.Sprite;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

public class LadrilloSolido extends BloqueSolido{
	
	public LadrilloSolido(Sprite sprite, int x, int y, Nivel nivelActual) {
		super(sprite, x, y, nivelActual);
	}
	
	public void aceptarVisita(Visitor v){
		v.visitarLadrilloSolido(this);
	}
	
	public void recibirGolpe(Personaje p) {
		p.getEstado().romperLadrilloSolido(this);
	}
	public boolean cambioEstado() {
		return false;
	}
}
