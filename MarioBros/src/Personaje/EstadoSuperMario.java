package Personaje;

import java.util.Timer;
import java.util.TimerTask;

import Enemigos.*;
import Fabricas.GenerarSprite; 
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Musica;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;


public class EstadoSuperMario extends EstadoDePersonaje {
	
	public double toleranciaAltura=50;
	protected Sprite sprite;
	protected Hitbox hitbox;

	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected float posX;
	protected float posY;
	
	protected float velX;
	protected float velY;
	protected int alto;
	protected boolean aterrice;

	public EstadoSuperMario(Personaje p, Sprite s, int x, int y) {
		super(p);
		hitbox = new Hitbox(x, y-23, 30, 60);
		setPosX(x);
		setPosY(y-23);
		sprite = s;
	    alto = 60;
	}
	
	public EstadoSuperMario(Personaje p) {
		super(p);
	}
	
	// Setters
	  public void morir() {
		  Musica.getMusica().reproducirMusicaSinLoop("Sonido/Canciones/muerte.wav");
		  GenerarSprite fabricaSprite;
			
	       if(personaje.getNivelActual().getJuego().getModoDeJuego() == 1) {
	           fabricaSprite = new GenerarSpriteOriginal();
	       } else {
	           fabricaSprite = new GenerarSpriteReemplazo();
	       }
	    
	       sprite = fabricaSprite.getSuperMarioMuerto();
	       personaje.cargarSprite(sprite);
	       personaje.setSpriteActualizado(true);
	    	
	       int posY = personaje.getPosY();

	       for (int i = 0; i < 60; i++) {   	   
	    	   personaje.setPosY(posY - (i * 2));
	           try {
	               Thread.sleep(16);
	           } catch (InterruptedException e) {
	               e.printStackTrace();
	           }
	       }

	       while (personaje.getPosY() < 500) {
	           personaje.setPosY(personaje.getPosY() + 4);
	           try {
	               Thread.sleep(16);
	           } catch (InterruptedException e) {
	               e.printStackTrace();
	           }
	       }
	        personaje.morir();
	    }
	  
	public void moverPersonaje() {	
		moverDerecha();	    
	    moverIzquierda(); 	    	    	
	    colisionDesliz(); 
	    detenerFriccion();    
	    posX += velX;
	    saltar();	    
	    gravedadSaltando();
	    corregirPosEnColision();
	    gravedad();
	    detenerSalto();
	    saltarSobreEnemigo();
	    posY += velY;
	    hitbox.actualizar((int) posX, (int) posY);
	    actualizarSprite();
	}
	
	public void setPosX(int x) {
	    this.posX = x;
	    hitbox.actualizar(Math.round(posX), Math.round(posY));
	}

	public void setPosY(int y) {
	    this.posY = y;
	    hitbox.actualizar(Math.round(posX), Math.round(posY));
	}
	

	public void saltar() {
    	if (jump && tocandoBloqueAbajo && !saltando ) {
	        saltando = true;
	        tocandoBloqueAbajo = false;
	        velY = -4;  // IMPULSO INICIAL
	        Musica.getMusica().reproducirSonido("Sonido/Sonidos/saltarRestoDeMarios.wav");
	    }
    }
	
	public void recibirDano() {
		if (!personaje.esInvulnerable()) {
			personaje.cambiarEstado(new EstadoNormal(personaje, sprite, personaje.getPosX(), personaje.getPosY()));
            personaje.activarInvulnerabilidad();
        }
    }
	
	public void sumarVida() {
		
	}
	
	public void sumarPuntos(int puntos) {
		this.puntuacion += puntos;
	}
	 
 	public void setPuntuacion(int n) {
		
	}

	public void setPuntuacionChampiVerde() {
		personaje.setPuntuacion(100);
	}

	public void setPuntuacionEstrella() {
		personaje.setPuntuacion(30);
	}

	public void setPuntuacionFlorDeFuego() {
		personaje.setPuntuacion(30);
	}

	public void setPuntuacionSuperChampi() {
		personaje.setPuntuacion(50);
	}
	public void setPuntuacionMoneda(){
		personaje.setPuntuacion(5);
	}
	
	public void actualizarSprite() {
		GenerarSprite fabrica;
		if(personaje.getNivelActual().getJuego().getModoDeJuego() == 1) {
			 fabrica = new GenerarSpriteOriginal();
		} else {
			 fabrica = new GenerarSpriteReemplazo();
		}
	   
	    Sprite nuevoSprite = sprite;
	    
	    if (right && velX > 0) {
	    	nuevoSprite = fabrica.getSuperMarioCorriendoDerecha();
	    	
	    } else if (left && velX > 0) {	
	    	nuevoSprite = fabrica.getSuperMarioDerrapandoIzquierda();
	    	 	        
	    } else if (left && velX < 0) {
	    	nuevoSprite = fabrica.getSuperMarioCorriendoIzquierda();
	        
	    } else if (right && velX < 0) {
	    	nuevoSprite = fabrica.getSuperMarioDerrapandoDerecha();
     
	    } else if (!left && !right) {
	    	nuevoSprite = fabrica.getSuperMario();
	        
	    } else if(velX==0) {
	    	nuevoSprite = fabrica.getSuperMarioQuietoIzquierda();		    
	    }	    
	   
	    if(!personaje.getSprite().getRutaImagen().equals(nuevoSprite.getRutaImagen())) {
	    	personaje.cargarSprite(nuevoSprite);
	    	personaje.setSpriteActualizado(true);
	    }
	}
	
	public void actualizarMin() {
		personaje.actualizarMin();
	}
	
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public void saltarSobreEnemigo() {
		if (saltandoSobreEnemigo ) {
			velY = -3;
			posY = posY - 5;
			saltando = true;
		}
	}
	
	public void colisionSuperChampi() {
		setPuntuacionSuperChampi();
    }
    
    public void colisionFlorDeFuego() {
    	setPuntuacionFlorDeFuego();
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoDeFuego e = new EstadoDeFuego(personaje,fabrica.getMarioFlorDeFuegoQuietoDerecha(), (int)posX, (int)posY);
    	personaje.cambiarEstado(e);
    }
    
    public void colisionEstrella() {
    	Musica.getMusica().reproducirMusica("Sonido/Canciones/marioEstrellaCancion.wav");
    	setPuntuacionEstrella();
    	
    	GenerarSprite fabrica;
		if(personaje.getNivelActual().getJuego().getModoDeJuego() == 1) {
			 fabrica = new GenerarSpriteOriginal();
		} else {
			 fabrica = new GenerarSpriteReemplazo();
		}
		
		EstadoEstrella e = new EstadoEstrella(personaje,fabrica.getMarioEstrellaQuietoDerecha(), (int)posX, (int)posY);
    	personaje.cambiarEstado(e);
    	
    	Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        public void run() {	
	        	Musica.getMusica().reproducirMusica("Sonido/Canciones/soundtrackNivel-"+personaje.getNivelActual().getNivelActual()+".wav");
	        	personaje.cambiarEstado(new EstadoSuperMario(personaje, fabrica.getPersonajeNormalQuietoDerecha(), personaje.getPosX(), personaje.getPosY()));     
	        }
	    }, 10000);

    }
    
	public void colisionChampiVerde() {
		personaje.sumarVida();
		setPuntuacionChampiVerde();
	}

	public void colisionMoneda() {
		setPuntuacionMoneda();
	}

	public void colisionLateralGoomba(Goomba goomba) {
		velX = 0;
		recibirDano();
    }
	
	public void colisionLateralKoopa(KoopaTroopa koopaTroopa) {
		velX = 0;
		recibirDano();
	}
	public void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy) {
		velX = 0;
		recibirDano();
	}
	public void colisionLateralLakitu(Lakitu lakitu) {
		velX = 0;
		recibirDano();
	}
	public void colisionLateralSpiny(Spiny spiny) {
		velX = 0;
		recibirDano();
	}
	public void colisionLateralPiranha(PiranhaPlant piranha) {
		velX = 0;
		recibirDano();
	}
	public void colisionVacio() {
		morir();
		
	}

	public void romperLadrilloSolido(LadrilloSolido l) {
		l.getHitbox().actualizar(0, 0);
		l.cargarSprite(null);
	}

	public void moverBloqueGolpeable(BloqueGolpeable b) {
		
	}
	
	public void moverIzquierda() {
		if (left) {
			actualizarSprite();
			if (posX > personaje.getMin() && !tocandoBloqueIzquierda) {
		        if (velX > -5) {
		            velX -= 0.1f; 
		        }
		        
		    } else {
		        velX = 0; 
			}
			
			if(tocandoBloqueDerecha) //caso que este deslizando en velocidad contraria
				setPosX(getPosX() - 3);
			}
		
	}
	
	public void moverDerecha() {
		if (right) {
			actualizarSprite();
			if (posX < 3300 && !tocandoBloqueDerecha && posX > personaje.getMin() ) {
		        if (velX < 5) {
		            velX += 0.1f;
		        }
		    } else {
				velX = 0;	
			}
			
			if(tocandoBloqueIzquierda) //caso que este deslizando en velocidad contraria
				setPosX(getPosX() + 3);
		}		
		 
	}
	
	public void corregirPosEnColision() {
		if(tocandoBloqueIzquierda)  
	    	setPosX(getPosX() + 1);	    		
	    if(tocandoBloqueDerecha) 
	    	setPosX(getPosX() - 1);
	    if(tocandoBloqueIzquierda &&tocandoBloqueArriba) 
	    	setPosX(getPosX() + 1);    	    
	    if(tocandoBloqueDerecha &&tocandoBloqueArriba) 
	    	setPosX(getPosX() - 1);	     
	    if(tocandoBloqueIzquierda &&!tocandoBloqueAbajo) {
	    	setPosX(getPosX() + 1);
	    	velY += 0.3;
	    }
	    
	    if(tocandoBloqueDerecha && !tocandoBloqueAbajo) {
	    	setPosX(getPosX() - 1);
	    	velY += 0.3;
	    }
	    
	    while(jump && tocandoBloqueIzquierda && !tocandoBloqueArriba) {
	    	setPosX(getPosX() + 1);
	    	saltando = true;
	        tocandoBloqueAbajo = false;
	        tocandoBloqueIzquierda = false;
	        velY = -4; 
	    }
	    
	    while(jump && tocandoBloqueDerecha && !tocandoBloqueArriba) {
	    	setPosX(getPosX() - 1);
	    	saltando = true;
	        tocandoBloqueAbajo = false;
	        tocandoBloqueDerecha = false;
	        velY = -4;
	    }
	    
	    if(posX <= personaje.getMin()) {
            setPosX(getPosX() + 1);
            velX = 0;
        }
	    
	    if(saltando && tocandoBloqueAbajo) {
	    	setPosY(getPosY() - 3);
	    	saltando = false;
		}
	}
	
	public void gravedad() {
		if (!tocandoBloqueAbajo) {
	        velY += 0.3;  // Gravedad
	        aterrice = false;
	        if (tocandoBloqueIzquierda || tocandoBloqueDerecha) {
	            velY += 0.6;      
	        }
	    } else {
	        velY = 0;
	        saltando = false;
	        if(!aterrice) {
	        	setPosY(getPosY()-1);
	             hitbox.actualizar((int) posX, (int) posY);
	             aterrice = true;
	        }
	    }
	}
	
	public void gravedadSaltando() {
		if (saltando) {
	        if (jump && velY > -5.5 && !tocandoBloqueArriba) {
	            velY -= 0.4f;  // ALTURA DEL SALTO
	            if(tocandoBloqueArriba || tocandoBloqueDerecha || tocandoBloqueIzquierda) {
	            	velY = 0;	  
	            }
	        } else {
	            saltando = false;  // NO ALTURA MAXIMA O NO JUMP PRESIONADO
	        }
	    }
	}
	
	public void detenerSalto() {
		if (tocandoBloqueArriba && !tocandoBloqueAbajo) {
	        velY = 0;  // Detiene el movimiento hacia arriba
	        saltando = false;  // Evita que siga intentando saltar
	        setPosY(getPosY() + 3); // Corrijo sacandolo si quedo dentro del bloque
	    }
	}
	
	public void detenerFriccion() {
		if (velX > 0 && !right) 
	        velX -= 0.1f;  
	    						//FRENA A MARIO FRICCIONADO
	    if (velX < 0 && !left) 
	        velX += 0.1f; 
	    
	    if (Math.abs(velX) < 0.1f) {
	        velX = 0;
	    }
	}
	
	public void colisionDesliz() {
		if (!right && !left && velX != 0) { 
	        if (tocandoBloqueDerecha || tocandoBloqueIzquierda) {
	            velX = 0;	            
	        }
	    }
	}
	

	// Getters
	public int getPosX() {
		return Math.round(posX);
	}
	
	public int getPosY() {
		return Math.round(posY);
	}
	
	public Hitbox getHitbox() {
    	return hitbox;
    }

	public Sprite getSprite() {
		return sprite;
	}
	
	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return 0;
	}
	public double getToleranciaAltura() {
		return toleranciaAltura;
	}

	public int getAlto() {
		return alto;
	}
	
	public float getMin() {
		return personaje.getMin();
	}
	
	public void disparar() {		
	}
	
	public boolean puedeDisparar() {
		return false;
	}
	
	public void setPuedeDisparar(boolean b) {		
	}
}
