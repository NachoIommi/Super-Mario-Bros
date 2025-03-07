package Enemigos;

import Fabricas.GenerarEnemigos; 
import Fabricas.GenerarSpiny;
import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite ;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;
import java.util.Timer;
import java.util.TimerTask;

public class Lakitu extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected Personaje personaje;
	protected boolean direccionDerecha;
	protected boolean lanzo;
	protected int maxX;
	protected int posX;
	protected int posY;
	protected int distanciaConPersonaje = 250;	
	protected int toleranciaAltura = 0;
	
	public Lakitu(Sprite s, int x, int y, Personaje p, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		setSpriteActualizado(false);
		personaje = p;
		lanzo = false;
	}
	
	public Lakitu(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		setSpriteActualizado(false);
	}	
	
	public void aceptarVisita(Visitor v) {
		v.visitarLakitu(this);
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
        sprite = fabrica.getLakituPorDisparar();
        cargarSprite(sprite);
        setSpriteActualizado(true);   
	}
	
	public void moverse() {
		actualizarPosicionConScroll();
		moverseLateralmente();
		lanzarSpiny();	
	}
	
	public void actualizarPosicionConScroll() {
	    int marioX = personaje.getPosX();
	    if (marioX > maxX) {
	        maxX = marioX; 
	    }
	    hitbox.actualizar(posX, posY);
	}
	
	public void moverseLateralmente() {
	    int limiteIzquierdo = Math.abs(maxX - distanciaConPersonaje); 
	    int limiteDerecho = maxX + distanciaConPersonaje;
	    int velocidadLakitu;
	    
	    if(personaje.getPosX() > maxX) {
	    	velocidadLakitu = 10;
	    } else {
	    	velocidadLakitu = 4;
	    }
	    
	    if (posX >= limiteDerecho) {
	        direccionDerecha = false;
	    } else if (posX <= limiteIzquierdo) {
	        direccionDerecha = true;
	    }
	    
	    if (direccionDerecha){
	    	posX += velocidadLakitu;
	    } else {  	
	    	posX -= velocidadLakitu;
	    }
	    
	    hitbox.actualizar(posX, posY);
	}

	private void lanzarSpiny() {
        GenerarSprite fabricaSprite;
        if(personaje.getNivelActual().getJuego().getModoDeJuego() == 1) {
            fabricaSprite = new GenerarSpriteOriginal();
        } else {
            fabricaSprite = new GenerarSpriteReemplazo();
        }
        int segundosActuales = nivelActual.getJuego().getReloj().getSegundos();
        if(segundosActuales < 299 && segundosActuales % 5 == 0  && !lanzo) {
            lanzo = true;
            GenerarEnemigos fabricaSpiny = new GenerarSpiny();
            Enemigo nuevoSpiny = fabricaSpiny.crearEnemigo(fabricaSprite.getSpinySpawneando(), posX, posY, nivelActual);
            personaje.getNivelActual().getJuego().agregarEnemigoEnEjecucion(nuevoSpiny);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    lanzo = false;
                }
            }, 3000);
        }
    }
	
	// Setters
	public void afectarPersonaje(Personaje p) {
		p.colisionLateralLakitu(this);
	}
	
	public void serAfectadoPorPersonaje(Personaje p) {
		morir();
		p.setPuntuacion(60);
		murio = true;
	}
	
	public void morir() {		
		hitbox = new Hitbox(0, 0, 0, 0);
		murio = true;
	}	
	
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
	}
	
	// Getters
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getToleranciaAltura() {
		return toleranciaAltura;
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
	
}