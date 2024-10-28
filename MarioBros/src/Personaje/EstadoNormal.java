package Personaje;

import Enemigos.*;
import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import GUI.ConstantesVistas;
import Logica.Hitbox;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoNormal extends EstadoDePersonaje {

	public double toleranciaAltura=30;
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
    protected boolean saltandoSobreEnemigo;
	
	protected float velX;
	protected float velY;
	protected int alto;
	
	
	public EstadoNormal(Personaje personaje,Sprite s,int x,int y) {
		super(personaje);
		hitb = new Hitbox(x ,y,30 ,40);
		setPosX(x);
		setPosY(y);
		sprite =s;
	    tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    saltandoSobreEnemigo=false;
	    saltando=false;  
	    alto=30;
	    jump=false;
	    right=false;
	    left=false;
	}
	
	public void moverPersonaje() {	
		actualizarSprite();
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
	    hitb.actualizar((int) posX, (int) posY);
	    actualizarSprite();
	}

	public void saltarSobreEnemigo() {
		if (saltandoSobreEnemigo ) {
			velY = -3;
			posY=posY-5;
			saltando=true;
		}
	}
	
	public void saltar() {
    	if (jump && tocandoBloqueAbajo && !saltando ) {
	        saltando = true;
	        tocandoBloqueAbajo = false;
	        velY = -4;  // IMPULSO INICIAL
	    }
    }
	
	public void setSaltandoSobreEnemigo(boolean b) {
		saltandoSobreEnemigo=b;
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
	        setPosY(getPosY()+1); // Corrijo sacandolo si quedo dentro del bloque
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
	
	public void setRight(boolean b){
		right=b;
	}
	
	public void setLeft(boolean b){
		left=b;
	}
	
	public void setJump(boolean b){
		jump=b;
	}
	
	public double getToleranciaAltura() {
		return toleranciaAltura;
	}
	
	public void actualizarSprite() {
	    GenerarSprite fabrica = new GenerarSpriteOriginal();

	    if (right && velX > 0) {
	        sprite = fabrica.getPersonajeNormalCorriendoDerecha();
	    } else if (left && velX > 0) {
	        sprite = fabrica.getPersonajeNormalDerrapandoIzquierda();
	    } else if (left && velX < 0) {
	        sprite = fabrica.getPersonajeNormalCorriendoIzquierda();
	    } else if (right && velX < 0) {
	        sprite = fabrica.getPersonajeNormalDerrapandoDerecha();
	    } else if (!left && !right) {
	        sprite = fabrica.getPersonajeNormalQuietoDerecha();
	    }else if(velX==0)
	    		sprite = fabrica.getPersonajeNormalQuietoDerecha();

	    personaje.cargarSprite(sprite);
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
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoDeFuego e = new EstadoDeFuego(personaje,fabrica.getMarioFlorDeFuegoQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision con flor de fuego hecha");
    }
    
    public void colisionEstrella() {
    	personaje.setPuntuacion(personaje.getPuntuacion()+20);
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoEstrella e = new EstadoEstrella(personaje,fabrica.getMarioEstrellaQuietoDerecha(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision con estrella hecha");
    }
    
	public void colisionChampiVerde() {
		personaje.setVidas(personaje.getVidas()+1);
	}

	public void colisionMoneda() {
		personaje.setPuntuacion(personaje.getPuntuacion()+5);
	}
    
	public void recibirDano() {
		if (!personaje.esInvulnerable()) {
            personaje.morir();
            personaje.activarInvulnerabilidad(); // Activa la invulnerabilidad
		}
    }
    
    public void morir() {
    	personaje.setVidas(personaje.getVidas()-1);
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	sprite = fabrica.getPersonajeNormalMuerto();
    	personaje.cargarSprite(sprite);
    	
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
   		System.out.println("se ejecuto reiniciarNivel :: personajeNormal");

    }
    
    public boolean getSaltando() {
		return saltando;
	}
    
	public void setSaltando(boolean b){
		saltando=b;
	}
	
	public float getVelX() {
		return velX;
	}
	
	public void setTocandoBloqueDerecha(boolean b) {
		tocandoBloqueDerecha=b;
	}
	
	public void setTocandoBloqueIzquierda(boolean b) {
		tocandoBloqueIzquierda=b;
	}
	
	public void setTocandoBloqueAbajo(boolean b) {
		tocandoBloqueAbajo=b;
	}
	
	public void setTocandoBloqueArriba(boolean b) {
		tocandoBloqueArriba=b;
	}
	
	public Hitbox getHitbox() {
    	return hitb;
    }

    public void sumarPuntos(int puntos) {
        this.puntuacion += puntos;
    }
    
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getPosX() {
		return Math.round(posX);
	}
	
	public int getPosY() {
		return Math.round(posY);
		
	}

	public void setPosX(int x) {
	    this.posX = x;
	    hitb.actualizar(Math.round(posX), Math.round(posY));  // Actualizar la hitbox después de ajustar la posición
	}

	public void setPosY(int y) {
	    this.posY = y;
	    hitb.actualizar(Math.round(posX), Math.round(posY));  // Actualizar la hitbox después de ajustar la posición
	}
	
	public void actualizarMin() {
		personaje.actualizarMin();
	}
	
	public float getMin() {
		return personaje.getMin();
	}
	
	public void sumarVida() {
		
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

	public void romperLadrilloSolido(LadrilloSolido l) {
		
	}

	public void moverBloqueGolpeable(BloqueGolpeable b) {
		
	}

	public int getAlto() {
		return alto;
	}

	public void colisionLateralGoomba(Goomba goomba) {
		morir();	
		personaje.setPuntuacion(-30);
		System.out.println("MORIR PERSONAJE");
	}
	public void colisionLateralKoopa(KoopaTroopa koopaTroopa) {
		morir();
		personaje.setPuntuacion(-45);
		System.out.println("MORIR PERSONAJE POR KOOPA TROOPA");
	}
	public void colisionLateralBuzzyBeetle(BuzzyBeetle buzzy) {
		morir();
		personaje.setPuntuacion(-15);
		System.out.println("MORIR PERSONAJE POR BUZZY BEETLE");
	}
	public void colisionLateralLakitu(Lakitu lakitu) {
		morir();
		System.out.println("MORIR PERSONAJE POR LAKITU");
	}
	public void colisionLateralSpiny(Spiny spiny) {
		morir();
		personaje.setPuntuacion(-30);
		System.out.println("MORIR PERSONAJE POR SPINY");
	}
	public void colisionLateralPiranha(PiranhaPlant piranha) {
		morir();
		personaje.setPuntuacion(-30);
		System.out.println("MORIR PERSONAJE POR Piranha");
	}
	public void colisionVacio() {
		morir();
		System.out.println("MORIR X VACIO");
	}

	public float getVelY() {
		return velY;
	}



	

}
