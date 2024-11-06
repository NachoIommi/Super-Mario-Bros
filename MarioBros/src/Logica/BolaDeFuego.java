package Logica;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;

public class BolaDeFuego extends Entidad{
	
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	protected int posXInicial;
	protected int direc;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    protected boolean exploto = false;
    protected boolean tocoEnemigo = false;
    protected boolean subiendo = false;
    protected int contador;
	
	public BolaDeFuego(Sprite sprite, int x, int y, Nivel nivelActual,int direccion) {
		super(nivelActual);
		posX = x;
		posY = y;
		this.sprite = sprite;
		posXInicial = x;
		hitbox = new Hitbox(x, y, 15, 15);
		tocandoBloqueDerecha = false;
		tocandoBloqueIzquierda = false;
		tocandoBloqueAbajo = false;
		tocandoBloqueArriba = false;
		direc = direccion;
	}
	
	public void moverse() {
		if(!exploto) {
			if(direc == 0) {
				if(!tocandoBloqueAbajo && !subiendo) {
					posY = posY + 3;
					posX = posX + 5;
					hitbox.actualizar (posX, posY);
				}
				
				if(tocandoBloqueAbajo && subiendo) {
					contador++;
					posY = posY - 3;
					posX = posX + 5;
					hitbox.actualizar (posX, posY);
					
					if(contador == 13) {
		                contador = 0;
		                subiendo = false; 
		                tocandoBloqueAbajo = false;
		            }
				}				
			} else {
				if(!tocandoBloqueAbajo && !subiendo) {
					posY = posY + 3;
					posX = posX - 5;
					hitbox.actualizar (posX, posY);
				}
				
				if(tocandoBloqueAbajo && subiendo) {
					contador++;
					posY = posY - 3;
					posX = posX - 5;
					hitbox.actualizar (posX, posY);
					if(contador == 13) {
		                contador = 0;
		                subiendo = false; 
		                tocandoBloqueAbajo = false;
		            }				
				}
			}
		}
	}
	
	public void explotar() {			
		exploto = true;
		hitbox = new Hitbox(0, 0, 0, 0);
	}
	public boolean exploto() {
		return exploto;
	}

	public void setTocandoEnemigo(boolean b) {
		explotar();
	}
	public void setTocandoBloqueDerecha(boolean b) {
		explotar();
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		explotar();
	}

	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba = b;
	}

	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo = b;
		subiendo = true;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarBolaDeFuego(this);
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
	
	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
	}
	
	public void actualizarSprite() {
        GenerarSprite fabricaSprite;
        if(nivelActual.getJuego().getModoDeJuego() == 1) {
            fabricaSprite = new GenerarSpriteOriginal();
        } else {
            fabricaSprite = new GenerarSpriteReemplazo();
        }
        sprite = fabricaSprite.getVacio();
        cargarSprite(sprite);
        setSpriteActualizado(true);
    }
	
	public boolean mostrable() {
		return mostrable;
	}
	public void setMostrable(boolean b) {
		mostrable = b;
	}
}
