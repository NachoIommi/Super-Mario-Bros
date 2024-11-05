package Enemigos;

import Fabricas.GenerarEnemigos; 
import Fabricas.GenerarSpiny;
import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite ;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Nivel;
import Logica.Visitor;
import Personaje.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Lakitu extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	protected Personaje personaje;
	protected int maxX;
	private Timer spinyTimer;
	private int distanciaConPersonaje = 250;
	public boolean lanzo;
	
	protected boolean direccionDerecha;
	//List<Enemigo> enemigosParaAgregar;
	
	public Lakitu(Sprite s, int x, int y, Personaje p, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		setSpriteActualizado(false);
		personaje = p;
		lanzo = false;
		//iniciarSpawningSpiny();
		//enemigosParaAgregar = new ArrayList<>();
	}
	
	public Lakitu(Sprite s, int x, int y, Nivel nivelActual) {
		super(nivelActual);
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		setSpriteActualizado(false);
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
		
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	
	public void aceptarVisita(Visitor v) {
		v.visitarLakitu(this);
	}
	
	public void moverse() {
		actualizarPosicionConScroll();
		moverseLateralmente();
		lanzarSpiny();
	
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
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
        sprite = fabrica.getLakituPorDisparar();
        cargarSprite(sprite);
        setSpriteActualizado(true);
       
     
	}
	
	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
	}
	
	public void actualizarPosicionConScroll() {
	    int marioX = personaje.getPosX();

	    if (marioX > maxX) {
	        maxX = marioX;   // Que solo avance si avanza mario
	    }
	    hitbox.actualizar(posX, posY);
	}
	
	public void moverseLateralmente() {
	    int limiteIzquierdo = Math.abs(maxX - distanciaConPersonaje); //Para caso lakitu al principio del nivel
	    int limiteDerecho = maxX + distanciaConPersonaje;
	    int velocidadLakitu = (personaje.getPosX() > maxX) ? 10 : 4; //mas rapido si mario avanzo

	    if (posX >= limiteDerecho) {
	        direccionDerecha = false;
	    } else if (posX <= limiteIzquierdo) {
	        direccionDerecha = true;
	    }

	    posX += direccionDerecha ? velocidadLakitu : -velocidadLakitu;
	    hitbox.actualizar(posX, posY);
	}
	

	private void lanzarSpiny() {
        GenerarSprite fabricaSprite;
        if(personaje.getNivelActual().getJuego().getModoDeJuego() == 1) {
            fabricaSprite = new GenerarSpriteOriginal();
        } else {
            fabricaSprite = new GenerarSpriteReemplazo();
        }
        if(nivelActual.getJuego().getReloj().getSegundos() % 5 == 0  && !lanzo) {
            lanzo=true;
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
		return 0;
	}

	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}
}