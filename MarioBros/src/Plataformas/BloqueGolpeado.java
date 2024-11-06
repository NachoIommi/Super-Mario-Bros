package Plataformas;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.EstadoSuperMario;
import Personaje.Personaje;
import PowerUps.PowerUp;

public class BloqueGolpeado extends EstadoDeBloque{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	protected PowerUp contenido;
	protected boolean mostrable;
	protected int golpesRestantes;
	
	public BloqueGolpeado(BloqueDePregunta b, Sprite s, int x, int y,int g) {
		super(b);
		sprite = s;
		posX = x;
		posY = y;
		hitbox = new Hitbox(x ,y,30 ,40);
		golpesRestantes = g;	
	}
	
	public void recibirGolpe() {
		
	}
	
	public BloqueDePregunta getBloque() {
		return bloque;
	}
	
	public int getGolpesRestantes() {
		return golpesRestantes;
	}

	public boolean cambioEstado() {
		return false;
	}

	public void soltarContenido() {
		
	}

	public void aceptarVisita(Visitor v) {
		
	}

	public boolean mostrable() {
		return false;
	}

	public void recibirGolpe(Personaje p) {
				
	}

	public EstadoDeBloque getEstado() {
		return null;
	}

	public PowerUp getContenido() {
		return null;
	}

	public void setContenido(PowerUp p) {
		
	}
	
}
