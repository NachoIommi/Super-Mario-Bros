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
	
	protected BloqueDePregunta bloque;
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
		golpesRestantes=g;	
		
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

	@Override
	public void soltarContenido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mostrable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recibirGolpe(Personaje p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstadoDeBloque getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PowerUp getContenido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContenido(PowerUp p) {
		// TODO Auto-generated method stub
		
	}

	
}
