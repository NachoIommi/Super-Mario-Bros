package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite ;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;

public class Lakitu extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitb;
	protected int posX;
	protected int posY;
	protected Personaje personaje;
	protected int maxX;
	
	protected boolean tocandoBloqueDerecha=false;
	protected boolean tocandoBloqueIzquierda=false;
	protected boolean tocandoBloqueAbajo=false;
	protected boolean tocandoBloqueArriba=false;
	protected boolean mostrable=true;
	protected boolean murio;
	
	public Lakitu(Sprite sprite, int x, int y, Personaje p) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
		mostrable = true;
		setSpriteActualizado(false);
		personaje = p;
		murio = false;
	}
	
	public Lakitu(Sprite sprite, int x, int y) {
		posX = x;
		posY = y;
		this.sprite = sprite;
		hitb = new Hitbox(x, y, 30, 30);
		mostrable = true;
		setSpriteActualizado(false);
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
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
	}
	public void moverse() {
		actualizarPosicionConScroll();
	}
	
	public void actualizarPosicionConScroll() {
	    int marioX = personaje.getPosX();  // Obtén la posición X actual de Mario

	    if (marioX > maxX) {
	        maxX = marioX;
	        posX = marioX + 150;
	    } else {
	        posX = maxX;
	    }

	    hitb.actualizar(posX, posY);
	}

	
	public void aceptarVisita(Visitor v) {
		v.visitarLakitu(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralLakitu(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		morir();
		p.setPuntuacion(60);
		murio = true;
	}
	
	public void morir() {
		hitb = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
        sprite = fabrica.getLakituPorDisparar();
        cargarSprite(sprite);
        setSpriteActualizado(true);
        
        int posY = getPosY();
        // Animación de desplazamiento hacia arriba
        for (int i = 0; i < 30; i++) {
            setPosY(posY - (i * 2));
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Caída hacia la parte inferior de la ventana
        while (getPosY() < ConstantesVistas.VENTANA_ALTO) {
            setPosY(getPosY() + 5);
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	public Hitbox getHitbox() {
		return hitb;
	}

	@Override
	public void setTocandoBloqueDerecha(boolean b) {
		tocandoBloqueDerecha = b;
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda = b;
	}

	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba = b;
	}
	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo = b;
	}
	public int getToleranciaAltura() {
		return 0;
	}

	public boolean mostrable() {
		return mostrable;
	}

	public void setMostrable(boolean b) {
		mostrable=b;
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
	}
	public boolean murio() {
		return murio;
	}

}
