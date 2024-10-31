package Enemigos;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite ;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;
import java.util.Timer;
import java.util.TimerTask;

public class Lakitu extends Enemigo{
	
	protected Sprite sprite;
	protected Hitbox hitbox;
	protected int posX;
	protected int posY;
	protected Personaje personaje;
	protected int maxX;
	private Timer spawnTimer;
	
	protected boolean tocandoBloqueDerecha=false;
	protected boolean tocandoBloqueIzquierda=false;
	protected boolean tocandoBloqueAbajo=false;
	protected boolean tocandoBloqueArriba=false;
	protected boolean mostrable=true;
	protected boolean murio;
	protected boolean direccionDerecha;
	
	public Lakitu(Sprite s, int x, int y, Personaje p) {
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		mostrable = true;
		setSpriteActualizado(false);
		personaje = p;
		murio = false;
	}
	
	public Lakitu(Sprite s, int x, int y) {
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x, y, 30, 30);
		mostrable = true;
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
	}
	
	public void setPosX(int x) {
		 posX = x;
	}
	
	public void setPosY(int y) {
		 posY = y;
	}
	
	public void setMostrable(boolean b) {
		mostrable=b;
	}
	
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
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
        sprite = fabrica.getLakituPorDisparar();
        cargarSprite(sprite);
        setSpriteActualizado(true);
        
        int posY = getPosY();

        for (int i = 0; i < 30; i++) {
            setPosY(posY - (i * 2));
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        while (getPosY() < ConstantesVistas.VENTANA_ALTO) {
            setPosY(getPosY() + 5);
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	public void setSpriteActualizado(boolean actualizada) {
		spriteActualizado = actualizada;
	}
	
	public void actualizarPosicionConScroll() {
	    int marioX = personaje.getPosX();
	    int offsetX = 150;        // Distancia entre mario y laki

	    if (marioX > maxX) {
	        maxX = marioX;   // Que solo avance si avanza mario
	    }

	    //posX = maxX + offsetX;
	    moverseLateralmente();
	    hitbox.actualizar(posX, posY);
	}
	
	public void moverseLateralmente() {
	    int limiteIzquierdo = maxX;
	    int limiteDerecho = maxX + 200;

	    if (posX >= limiteDerecho) {
	        direccionDerecha = false;
	    } else if (posX <= limiteIzquierdo) {
	        direccionDerecha  = true;
	    }

	    if (posX < maxX) {
	        posX = maxX;
	    } else {
	        posX += direccionDerecha ? 2 : -2; // Si direccionDerecha = true, posX += 2, else -= 2
	    }
	    
	    hitbox.actualizar(posX, posY);
	}
	
	private void iniciarSpawnTimer() {
        spawnTimer = new Timer();
        // Ejecutar el método spawnSpiny cada 2000 ms (2 segundos)
       // spawnTimer.schedule(new TimerTask() {
            @Override
           // public void run() {
               // spawnSpiny();
           // }
       // }, 0, 2000); // 0 ms de espera antes de iniciar, cada 2000 ms*/
    }
	
	/*private void spawnSpiny() { 
        // Crear una nueva instancia de Spiny en la posición de Lakitu
        Spiny spiny = new Spiny(parámetros necesarios, como posición inicial );
        // Aquí puedes establecer la posición inicial en la ubicación actual de Lakitu
        spiny.setPosX(getPosX());
        spiny.setPosY(getPosY());

        // Lógica para hacer que el Spiny caiga
        new Thread(() -> {
            while (spiny.getPosY() < altura objetivo) {
                spiny.setPosY(spiny.getPosY() +  velocidad de caída );
                try {
                    Thread.sleep(50); // Controlar la velocidad de caída
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Una vez que cae, activa el movimiento del Spiny
            spiny.comenzarAMoverse(); // Implementa este método en la clase Spiny
        
        
    }*/
	
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
	
	public boolean mostrable() {
		return mostrable;
	}
	
	public int getToleranciaAltura() {
		return 0;
	}

	public boolean murio() {
		return murio;
	}
	
	public boolean necesitaActualizarSprite() {
		return spriteActualizado;
	}

}