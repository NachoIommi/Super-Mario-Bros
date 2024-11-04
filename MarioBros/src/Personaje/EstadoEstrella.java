package Personaje;
import Fabricas.*;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Musica;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;
import Enemigos.*;

public class EstadoEstrella extends EstadoDePersonaje {
	
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

	public EstadoEstrella(Personaje personaje,Sprite s,int x,int y) {
		super(personaje);
		hitbox = new Hitbox(x ,y-23,30 ,60);
		setPosX(x);
		setPosY(y-23);
		sprite = s;
	    alto = 60;
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
        
    	sprite = fabricaSprite.getMarioEstrellaMuerto();
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
	        velY = -4;  
	        Musica.getMusica().reproducirSonido("Sonido/Sonidos/saltarRestoDeMarios.wav");
	    }
    }
    
	public void recibirDano() {
    	
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
		personaje.setPuntuacion(35);
	}

	public void setPuntuacionFlorDeFuego() {
		personaje.setPuntuacion(50); 
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
	    	nuevoSprite = fabrica.getMarioEstrellaCorriendoDerecha();
	    	
	    } else if (left && velX > 0) {	
	    	nuevoSprite = fabrica.getMarioEstrellaDerrapandoIzquierda();
	    	 	        
	    } else if (left && velX < 0) {
	    	nuevoSprite = fabrica.getMarioEstrellaCorriendoIzquierda();
	        
	    } else if (right && velX < 0) {
	    	nuevoSprite = fabrica.getMarioEstrellaDerrapandoDerecha();
     
	    } else if (!left && !right) {
	    	nuevoSprite = fabrica.getMarioEstrellaQuietoDerecha();
	        
	    }else if(velX==0) {
	    	nuevoSprite = fabrica.getMarioEstrellaQuietoIzquierda();		    
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
			posY=posY-5;
			saltando=true;
		}
	}

	public void colisionSuperChampi() {
		setPuntuacionSuperChampi();
    }
    
    public void colisionFlorDeFuego() {
    	setPuntuacionFlorDeFuego();
    }
    
    public void colisionEstrella() {
    	setPuntuacionEstrella();
    }
    
	public void colisionChampiVerde() {
		personaje.sumarVida();
		setPuntuacionChampiVerde();
	}

	public void colisionMoneda() {
		setPuntuacionMoneda();
	}
	
	public void colisionLateralGoomba(Goomba goomba) {
		personaje.setPuntuacion(60);
		goomba.morir();
    }

	public void colisionLateralKoopa(KoopaTroopa koopaTroopa) {
		personaje.setPuntuacion(90);
		koopaTroopa.morir();
	}
	public void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy) {
		personaje.setPuntuacion(30);
		buzzy.morir();
	}
	public void colisionLateralLakitu(Lakitu lakitu) {
		personaje.setPuntuacion(60);
		lakitu.morir();
	}
	public void colisionLateralSpiny(Spiny spiny) {
		personaje.setPuntuacion(60);
		spiny.morir();
	}
	public void colisionLateralPiranha(PiranhaPlant piranha) {
		personaje.setPuntuacion(30);
		piranha.morir();
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
			if (posX > personaje.getMin() && !tocandoBloqueIzquierda) {
		        if (velX > -5)
		            velX -= 0.1f; 
		    } 
			else 
		        velX = 0;       	    
			if(tocandoBloqueDerecha) 
				setPosX(getPosX()-3);
			}
	}
	
	public void moverDerecha() {
		if (right) {
			if (posX < 3300 && !tocandoBloqueDerecha && posX > personaje.getMin() ) {
		        if (velX < 5)
		            velX += 0.1f;
		    } 			
			else 
				velX = 0;				
			if(tocandoBloqueIzquierda) 
				setPosX(getPosX()+3);
		}		
	}	
	
	public void corregirPosEnColision() {
		if(tocandoBloqueIzquierda)  
	    	setPosX(getPosX()+1);	    		
	    if(tocandoBloqueDerecha) 
	    	setPosX(getPosX()-1);
	    if(tocandoBloqueIzquierda &&tocandoBloqueArriba) 
	    	setPosX(getPosX()+1);    	    
	    if(tocandoBloqueDerecha &&tocandoBloqueArriba) 
	    	setPosX(getPosX()-1);	     
	    if(tocandoBloqueIzquierda &&!tocandoBloqueAbajo) {
	    	setPosX(getPosX()+1);
	    	velY += 0.3;
	    }
	    if(tocandoBloqueDerecha && !tocandoBloqueAbajo) {
	    	setPosX(getPosX()-1);
	    	velY += 0.3;
	    }
	    while(jump && tocandoBloqueIzquierda && !tocandoBloqueArriba) {
	    	setPosX(getPosX()+1);
	    	saltando = true;
	        tocandoBloqueAbajo = false;
	        tocandoBloqueIzquierda=false;
	        velY = -4; 
	    }
	    while(jump && tocandoBloqueDerecha && !tocandoBloqueArriba) {
	    	setPosX(getPosX()-1);
	    	saltando = true;
	        tocandoBloqueAbajo = false;
	        tocandoBloqueDerecha=false;
	        velY = -4;
	    }
	    if(posX <= personaje.getMin()) {
            setPosX(getPosX()+1);
            velX = 0;
        }
	}
	
	public void gravedad() {
		if (!tocandoBloqueAbajo) {
	        velY += 0.3;
	        if (tocandoBloqueIzquierda || tocandoBloqueDerecha) 
	            velY += 0.6;       
	    } 
	    else {
	        velY = 0;  
	        saltando = false;}
	}
	
	public void gravedadSaltando() {
		if (saltando) {
	        if (jump && velY > -5.5 && !tocandoBloqueArriba) {
	            velY -= 0.4f;  // ALTURA DEL SALTO
	            if(tocandoBloqueArriba || tocandoBloqueDerecha || tocandoBloqueIzquierda)
	            	velY=0;	            
	        } 
	        else {
	            saltando = false;  
	        }
	    }
	}
	
	public void detenerSalto() {
		if (tocandoBloqueArriba && !tocandoBloqueAbajo) {
	        velY = 0; 
	        saltando = false; 
	        setPosY(getPosY()+1);
	    }
	}

	public void detenerFriccion() {
		if (velX > 0 && !right) 
	        velX -= 0.1f;  
	    						
	    if (velX < 0 && !left) 
	        velX += 0.1f;  
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
		return velY;
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

	@Override
	public void setPuedeDisparar(boolean b) {		
	}
}