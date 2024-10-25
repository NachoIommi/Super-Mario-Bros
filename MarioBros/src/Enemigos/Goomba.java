package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Goomba extends Enemigo{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitb;
	protected boolean mostrable;

	public Goomba(Sprite sprite,int x,int y) {
		posX = x;
        posY = y;
        this.sprite = sprite;
        hitb = new Hitbox(x ,y,30 ,30);
        mostrable=true;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void moverse() {
		
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarGoomba(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void afectarPersonaje(Personaje p) {	
		p.colisionLateralGoomba();
	}
	public void serAfectadoPorPersonaje(Personaje p) {
		//p.setPuntuacion(60);
		morir();
	}
	public void morir() {
		actualizarSprite();
		hitb.actualizar(0, 0);
		System.out.println("goomba muerto");
	}
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getGoombaMuerto();
    	cargarSprite(sprite);
	}
	public Hitbox getHitbox() {
    	return hitb;
    }

	@Override
	public boolean setTocandoBloqueDerecha(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTocandoBloqueIzquierda(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTocandoBloqueArriba(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTocandoBloqueAbajo(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getToleranciaAltura() {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}
	
}

