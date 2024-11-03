package Personaje;

import Enemigos.*;
import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.GenerarSpriteReemplazo;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Musica;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoNormal extends EstadoDePersonaje {

	public double toleranciaAltura = 30;
	
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
	
	
	public EstadoNormal(Personaje personaje,Sprite s,int x,int y) {
		super(personaje);
		hitbox = new Hitbox(x ,y,30 ,40);
		setPosX(x);
		setPosY(y);
		sprite = s;  
	    alto = 30;
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
        
    	sprite = fabricaSprite.getPersonajeNormalMuerto();
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
        //Musica.getMusica().reproducirMusica("Sonido/Canciones/muerte.wav");
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
	    hitbox.actualizar(Math.round(posX), Math.round(posY));  // Actualizar la hitbox después de ajustar la posición
	}

	public void setPosY(int y) {
	    this.posY = y;
	    hitbox.actualizar(Math.round(posX), Math.round(posY));  // Actualizar la hitbox después de ajustar la posición
	}
	
	public void saltar() {
    	if (jump && tocandoBloqueAbajo && !saltando ) {
	        saltando = true;
	        tocandoBloqueAbajo = false;
	        velY = -4;  // IMPULSO INICIAL
	        Musica.getMusica().reproducirSonido("Sonido/Sonidos/saltarMarioNormal.wav");
	    }
    }
	
	public void recibirDano() {
		if (!personaje.esInvulnerable()) {
            personaje.morir();
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
		personaje.setPuntuacion(20);
	}

	public void setPuntuacionFlorDeFuego() {
		personaje.setPuntuacion(5);
	}

	public void setPuntuacionSuperChampi() {
		personaje.setPuntuacion(10);
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
	    	nuevoSprite = fabrica.getPersonajeNormalCorriendoDerecha();
	    	
	    } else if (left && velX > 0) {	
	    	nuevoSprite = fabrica.getPersonajeNormalDerrapandoIzquierda();
	    	 	        
	    } else if (left && velX < 0) {
	    	nuevoSprite = fabrica.getPersonajeNormalCorriendoIzquierda();
	        
	    } else if (right && velX < 0) {
	    	nuevoSprite = fabrica.getPersonajeNormalDerrapandoDerecha();
     
	    } else if (!left && !right) {
	    	nuevoSprite = fabrica.getPersonajeNormalQuietoDerecha();
	        
	    }else if(velX==0) {
	    	nuevoSprite = fabrica.getPersonajeNormalQuietoDerecha();		    
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
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoSuperMario e = new EstadoSuperMario(personaje,fabrica.getSuperMario(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	personaje.setPuntuacion(20);
    	System.out.println("Colision con superchampi hecha");
    }
    
    public void colisionFlorDeFuego() {
    	setPuntuacionFlorDeFuego();
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoDeFuego e = new EstadoDeFuego(personaje,fabrica.getMarioFlorDeFuegoQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision con flor de fuego hecha");
    }
    
    public void colisionEstrella() {
    	Musica.getMusica().reproducirMusica("Sonido/Canciones/marioEstrellaCancion.wav");
    	setPuntuacionEstrella();
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoEstrella e = new EstadoEstrella(personaje,fabrica.getMarioEstrellaQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision con estrella hecha");
    }
    
	public void colisionChampiVerde() {
		personaje.setVidas(personaje.getVidas()+1);
		setPuntuacionChampiVerde();
	}

	public void colisionMoneda() {
		setPuntuacionMoneda();
	}
	
	public void colisionLateralGoomba(Goomba goomba) {
		morir();	
		personaje.setPuntuacion(-30);
	}
	public void colisionLateralKoopa(KoopaTroopa koopaTroopa) {
		morir();
		personaje.setPuntuacion(-45);
	}
	public void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy) {
		morir();
		personaje.setPuntuacion(-15);
	}
	public void colisionLateralLakitu(Lakitu lakitu) {
		morir();
	}
	public void colisionLateralSpiny(Spiny spiny) {
		morir();
		personaje.setPuntuacion(-30);
	}
	public void colisionLateralPiranha(PiranhaPlant piranha) {
		morir();
		personaje.setPuntuacion(-30);
	}
	
	public void colisionVacio() {
		morir();
		personaje.setPuntuacion(-15);
	}
	
	public void romperLadrilloSolido(LadrilloSolido l) {
		
	}

	public void moverBloqueGolpeable(BloqueGolpeable b) {
		
	}
	
	public void moverDerecha() {
		if (right) {
			actualizarSprite();
			if (posX < 3300 && !tocandoBloqueDerecha && posX > personaje.getMin() ) {
		        if (velX < 5)
		            velX += 0.1f;
		    } 			
			else 
				velX = 0;				
			if(tocandoBloqueIzquierda) //caso que este deslizando en velocidad contraria
				setPosX(getPosX()+3);
		}		
		 
	}
	
	public void moverIzquierda() {
		if (left) {
			actualizarSprite();
			if (posX > personaje.getMin() && !tocandoBloqueIzquierda) {
		        if (velX > -5)
		            velX -= 0.1f; 
		    } 
			else 
		        velX = 0;       	    
			if(tocandoBloqueDerecha) //caso que este deslizando en velocidad contraria
				setPosX(getPosX()-3);
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
	        velY += 0.3;  // Gravedad
	        if (tocandoBloqueIzquierda || tocandoBloqueDerecha) 
	            velY += 0.6;  // Aplicar un poco más de gravedad si está colisionando lateralmente en el aire        
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
	            saltando = false;  // NO ALTURA MAXIMA O NO JUMP PRESIONADO
	        }
	    }
	}
	
	public void detenerSalto() {
		if (tocandoBloqueArriba && !tocandoBloqueAbajo) {
	        velY = 0;  // Detiene el movimiento hacia arriba
	        saltando = false;  // Evita que siga intentando saltar
	        setPosY(getPosY()+3); // Corrijo sacandolo si quedo dentro del bloque
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
}
