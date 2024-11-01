package Personaje;

import Enemigos.*;
import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoDeFuego extends EstadoDePersonaje {
	
	public double toleranciaAltura=50;
	protected boolean right;
	protected boolean left;
	protected boolean jump;
	protected Sprite sprite;
	protected Hitbox hitb;

	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected float posX;
	protected float posY;
	
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    protected boolean saltando;
	
	protected float velX;
	protected float velY;
	protected int alto;

	public EstadoDeFuego(Personaje p,Sprite s,int x,int y) {
		super(p);
		hitb = new Hitbox(x ,y-23,30 ,60);
		setPosX(x);
		setPosY(y-23);;
		sprite =s;
	    tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    saltando=false;  
	    jump=false;
	    right=false;
	    left=false;	
	    alto=60;
	}
	
	public void disparar() {
		//
	}
	
	// Setters
	public void morir() {
    	personaje.setVidas(personaje.getVidas()-1);
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getMarioFlorDeFuegoMuerto();
    	personaje.cargarSprite(sprite);
    	personaje.setSpriteActualizado(true);
    	
    	int posY = personaje.getPosY();

        for (int i = 0; i < 30; i++) {
            personaje.setPosY(posY - (i * 2));
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (personaje.getPosY() < ConstantesVistas.VENTANA_ALTO) {
            personaje.setPosY(personaje.getPosY() + 5);
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        personaje.nivelActual.reiniciarNivel();
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
	    posY += velY;
	    hitb.actualizar((int) posX, (int) posY);
	    actualizarSprite();
	}

	public void setPosX(int x) {
	    this.posX = x;
	    hitb.actualizar(Math.round(posX), Math.round(posY));  // Actualizar la hitbox después de ajustar la posición
	}

	public void setPosY(int y) {
	    this.posY = y;
	    hitb.actualizar(Math.round(posX), Math.round(posY));  // Actualizar la hitbox después de ajustar la posición
	}
	
	public void saltar() {
    	if (jump && tocandoBloqueAbajo && !saltando ) {
	        saltando = true;
	        tocandoBloqueAbajo = false;
	        velY = -4;  // IMPULSO INICIAL
	    }
    }
    
	public void recibirDano() {
		if (!personaje.esInvulnerable()) {
            personaje.morir();
            personaje.activarInvulnerabilidad(); // Activa la invulnerabilidad
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
		personaje.setPuntuacion(50);
	}

	public void setPuntuacionSuperChampi() {
		personaje.setPuntuacion(50);
	}
	public void setPuntuacionMoneda(){
		personaje.setPuntuacion(5);
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
	
	public void actualizarSprite() {
	    GenerarSprite fabrica = new GenerarSpriteOriginal();
	    Sprite nuevoSprite = sprite;
	    
	    if (right && velX > 0) {
	    	nuevoSprite = fabrica.getMarioFlorDeFuegoCorriendoDerecha();
	    	
	    } else if (left && velX > 0) {	
	    	nuevoSprite = fabrica.getMarioFlorDeFuegoDerrapandoIzquierda();
	    	 	        
	    } else if (left && velX < 0) {
	    	nuevoSprite = fabrica.getMarioFlorDeFuegoCorriendoIzquierda();
	        
	    } else if (right && velX < 0) {
	    	nuevoSprite = fabrica.getMarioFlorDeFuegoDerrapandoDerecha();
     
	    } else if (!left && !right) {
	    	nuevoSprite = fabrica.getMarioFlorDeFuegoQuietoDerecha();
	        
	    }else if(velX==0) {
	    	nuevoSprite = fabrica.getMarioFlorDeFuegoQuietoIzquierda();		    
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
	
	public void setSaltando(boolean b){
		saltando = b;
	}
	
	public void setSaltandoSobreEnemigo(boolean b) {
		
	}
	
	public void saltarSobreEnemigo() {
	
	}
	
	public void setRight(boolean b){
		right = b;
	}
	
	public void setLeft(boolean b){
		left = b;
	}
	
	public void setJump(boolean b){
		jump = b;
	}
	
	public void colisionSuperChampi() {
		
	}
	
	public void colisionEstrella() {
		
	}

	
	public void colisionFlorDeFuego() {
	
	}

	
	public void colisionChampiVerde() {
		
	}

	public void colisionMoneda() {

	}
	
	public void colisionLateralGoomba(Goomba goomba) {
		velX=0;
    	GenerarSprite fabrica = new GenerarSpriteOriginal();	
    	EstadoNormal e = new EstadoNormal(personaje,fabrica.getPersonajeNormalQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision Goomba");
    }
	public void colisionLateralKoopa(KoopaTroopa koopaTroopa) {
		velX=0;
    	GenerarSprite fabrica = new GenerarSpriteOriginal();	
    	EstadoNormal e = new EstadoNormal(personaje,fabrica.getPersonajeNormalQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision Koopa");
	}
	public void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy) {
		velX=0;
    	GenerarSprite fabrica = new GenerarSpriteOriginal();	
    	EstadoNormal e = new EstadoNormal(personaje,fabrica.getPersonajeNormalQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision Buzzy");
	}
	public void colisionLateralLakitu(Lakitu lakitu) {
		velX=0;
    	GenerarSprite fabrica = new GenerarSpriteOriginal();	
    	EstadoNormal e = new EstadoNormal(personaje,fabrica.getPersonajeNormalQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision lakitu");
	}
	public void colisionLateralSpiny(Spiny spiny) {
		velX=0;
    	GenerarSprite fabrica = new GenerarSpriteOriginal();	
    	EstadoNormal e = new EstadoNormal(personaje,fabrica.getPersonajeNormalQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision spiny");
	}
	public void colisionLateralPiranha(PiranhaPlant piranha) {
		velX=0;
    	GenerarSprite fabrica = new GenerarSpriteOriginal();	
    	EstadoNormal e = new EstadoNormal(personaje,fabrica.getPersonajeNormalQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision Piranha");
	}
	
	public void colisionVacio() {
		morir();
	}
	
	public void romperLadrilloSolido(LadrilloSolido l) {
		
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
			if(tocandoBloqueDerecha) //caso que este deslizando en velocidad contraria
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
			if(tocandoBloqueIzquierda) //caso que este deslizando en velocidad contraria
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
	        setPosY(getPosY()+1); // Corrijo sacandolo si quedo dentro del bloque
	    }
	}

	public void detenerFriccion() {
		if (velX > 0 && !right) 
	        velX -= 0.1f;  
	    						//FRENA A MARIO FRICCIONADO
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
    	return hitb;
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
    
    public boolean getSaltando() {
		return saltando;
	}

}