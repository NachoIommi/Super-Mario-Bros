package Enemigos;

import java.util.Timer; 
import java.util.TimerTask;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Personaje.EstadoSuperMario;
import Personaje.Personaje;

public class EstadoKoopaNormal extends EstadoDeKoopa {
	
	public double toleranciaAltura=20;
	
	//private KoopaTroopa koopa;
	
	protected int posX;
	protected int posY;	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
	protected boolean mostrable;
	protected boolean tocoParedIzquierda;
    protected boolean tocoParedDerecha;
    
    protected Sprite sprite;
    protected Hitbox hitbox;
    protected boolean recibirDano;
    protected boolean murio;
	
	public EstadoKoopaNormal(KoopaTroopa kt,Sprite s,int x,int y) {
		super(kt);
		//koopa = kt;
		posX = x;
		posY = y;
		sprite = s;
		hitbox = new Hitbox(x ,y,30 ,30);
        tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    mostrable=true;	
	    recibirDano=false;
	    murio = false;
	}
	
	// Setters
	public void cambiarEstado() {
		this.actualizarSpriteKoopaRetraido();
        koopa.setEstadoActual(new EstadoKoopaRetraido(koopa,sprite,posX,posY));  // Cambiar al estado extendido
    }
	
	public void serAfectadoPorPersonaje(Personaje p) {
	    recibirDano = true;
	    cambiarEstado();
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        public void run() {	
	        	
		        koopa.setEstadoActual(new EstadoKoopaNormal(koopa, actualizarSpriteNormal(), koopa.getX(), koopa.getY()));
		        koopa.setSpriteActualizado(true);	            
	        }
	    }, 10000); // 10 segundos en milisegundos
	    
	}
	public void morir() {
		hitbox = new Hitbox(0 ,0,0 ,0);
		murio = true;
	}
	
	public void moverse() {
		if(!recibirDano) {
		
		if(tocandoBloqueIzquierda) 
			tocoParedIzquierda=true;
			
		if(!tocoParedIzquierda) {
			moverIzq();			
			hitbox.actualizar (posX, posY);
		}
		else
			 {
			tocoParedIzquierda=true;
			moverDer();
			hitbox.actualizar (posX, posY);}				
				
		if (tocandoBloqueDerecha) {
			tocoParedDerecha=true;
			tocoParedIzquierda=false; // lo hago caminar a la izquierda de vuelta
				}

		if (!tocandoBloqueAbajo) 
	        posY=posY+1;
		
			hitbox.actualizar (posX, posY);	}			
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
		tocandoBloqueDerecha=b;
	}

	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda=b;
	}

	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba=b;
	}


	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo=b;
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void actualizarSprite() {
		GenerarSprite fabricaSprite;
		
        if(koopa.getNivelActual().getJuego().getModoDeJuego() == 1) {
            fabricaSprite = new GenerarSpriteOriginal();
        } else {
            fabricaSprite = new GenerarSpriteReemplazo();
        }
		
		sprite = fabricaSprite.getKoopaTroopaMuerto();
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
		
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
	
	private Sprite actualizarSpriteNormal() {
	    GenerarSprite fabrica = new GenerarSpriteOriginal();
	    return fabrica.getKoopaTroopa(); // Asegúrate de tener un método que retorne la sprite de Koopa normal
	}
	
	public void actualizarSpriteKoopaRetraido() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		sprite = fabrica.getKoopaTroopaRetraido();
		cargarSprite(sprite);
		koopa.setSpriteActualizado(true);
	}
	
	public void moverIzq() {
		posX=posX-1;
	}
	public void moverDer() {
		posX=posX+1;
	}
	public void setKoopaTroopa(KoopaTroopa kt) {
		koopa=kt;		
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
	
	public boolean mostrable() {
		return mostrable;
	}
	
	public boolean murio() {
		return murio;
	}
	
	public KoopaTroopa getKoopaTroopa() {
		return koopa;
	}

}
