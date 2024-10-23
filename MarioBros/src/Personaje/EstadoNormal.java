package Personaje;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
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
	protected int direccionDelPersonaje;
	
	protected boolean tocandoBloque;
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    protected boolean saltando;
	
	protected float velX;
	protected float velY;
	protected int velSalto = -100;
	protected int alto;

	
	public EstadoNormal(Personaje personaje,Sprite s,int x,int y) {
		super(personaje);
		hitb = new Hitbox(x ,y,30 ,40);
		setPosX(x);
		setPosY(y);
		sprite =s;
		tocandoBloque=false;
	    tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    saltando=false;  
	    alto=30;
	    jump=false;
	    right=false;
	    left=false;
	}
	
	public void moverPersonaje() {
	    
	    if (right) {
	        ocultarRight();
	    }
	    
	    if (left) {
	        ocultarLeft();
	    }

	    
	    if (!right && !left && velX != 0) {
	        if (tocandoBloqueDerecha || tocandoBloqueIzquierda) {	//COLISION DESLIZANDO
	            velX = 0;
	            
	        }
	    }
	    if (velX > 0 && !right) 
	        velX -= 0.1f;  
	    						//FRENA A MARIO FRICCIONADO
	    if (velX < 0 && !left) 
	        velX += 0.1f;  
	    	    
	    posX += velX;
	    
	    //JUMP//
	    if (jump && tocandoBloqueAbajo && !saltando && !tocandoBloqueArriba) {
	        saltando = true;
	        tocandoBloqueAbajo = false;
	        velY = -4;  // IMPULSO INICIAL
	    }

	    // MIENTRAS W ESTA APRETADO
	    if (saltando) {
	        if (jump && velY > -5 && !tocandoBloqueArriba) {
	            velY -= 0.4f;  // ALTURA DEL SALTO
	            if(tocandoBloqueArriba || tocandoBloqueDerecha || tocandoBloqueIzquierda)
	            	velY=0;
	            
	        } 
	        else {
	            saltando = false;  // NO ALTURA MAXIMA O NO JUMP PRESIONADO
	        }
	    }

	    

	    // Detener el salto si colisiona con un bloque por encima
	    if (tocandoBloqueArriba) {
	        velY = 0;  // Detiene el movimiento hacia arriba
	        saltando = false;  // Evita que siga intentando saltar
	        setPosY(getPosY()+1);
	    }
	    
	    if(tocandoBloqueIzquierda) {
	    	setPosX(getPosX()+1);
	    	velY += 0.3;
	    }
	    if(tocandoBloqueDerecha) {
	    	setPosX(getPosX()-1);
	    	velY += 0.3;
	    }
	    
	    if (!tocandoBloqueAbajo) {
	        velY += 0.3;  // Gravedad
	        if (tocandoBloqueIzquierda || tocandoBloqueDerecha) {
	            velY += 0.6;  // Aplicar un poco más de gravedad si está colisionando lateralmente en el aire
	        }
	    } else {
	        velY = 0;  
	        saltando = false; 
	    }
	    
	    posY += velY;

	    hitb.actualizar((int) posX, (int) posY);
	    actualizarSprite();
	}

	
	public void ocultarLeft() {
		if (posX > personaje.getMin() && !tocandoBloqueIzquierda) {
	        if (velX > -5)
	            velX -= 0.1f;  // Decremento pequeño
	    } else {
	        velX = 0;
	        
	    }
	}
	
	public void ocultarRight() {
		if (posX < 3300 && !tocandoBloqueDerecha) {
	        if (velX < 5)
	            velX += 0.1f;  // Incremento pequeño
	    } 
			else {
				velX = 0;
				
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
	public void actualizarSprite(){
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	if(right) {
    		sprite = fabrica.getSuperMarioCorriendoDerecha();
    		personaje.cargarSprite(sprite);}
	    if(left) {
	    	sprite = fabrica.getPersonajeNormalCorriendoIzquierda();
	    	personaje.cargarSprite(sprite);}
	    if(!left&& !right) {
	    	sprite = fabrica.getPersonajeNormalQuietoDerecha();
	    	personaje.cargarSprite(sprite);}
    }

    public void colisionSuperChampi() {
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoSuperMario e = new EstadoSuperMario(personaje,fabrica.getSuperMario(),(int)posX,(int)posY);
    	personaje.cambiarEstado(e);
    	System.out.println("Colision hecha");
    }
    
    public void saltar() {
    }

    public void morir() {
    	personaje.setVidas(personaje.getVidas()-1);
    	personaje.actualizarSprite();
    }
    
    public boolean getSaltando() {
		return saltando;
	}
    
	public void setSaltando(boolean b){
		saltando=b;
	}
	
	public int getVelX() {
		return (int)velX;
	}
	
	public void setTocandoBloque(boolean b) {
		tocandoBloque=b;
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

    public void recibirDano() {
    	
    }

    public void sumarPuntos(int puntos) {
        this.puntuacion += puntos;
    }
    
    public void establecerDireccion(int d) {
	    direccionDelPersonaje = d;
    }
    
    public int getDireccion() {
    	return direccionDelPersonaje;
    }
    
	public void cargarSprite(Sprite s) {
		sprite = s;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getPosX() {
		return (int)posX;
	}
	
	public int getPosY() {
		return (int)posY;
	}

	public void setPosX(int x) {
	    this.posX = x;
	    hitb.actualizar((int) posX, (int) posY);  // Actualizar la hitbox después de ajustar la posición
	}

	public void setPosY(int y) {
	    this.posY = y;
	    hitb.actualizar((int) posX, (int) posY);  // Actualizar la hitbox después de ajustar la posición
	}
	
	public void actualizarMin() {
		personaje.actualizarMin();
	}
	
	public int getMin() {
		return personaje.getMin();
	}
	
	public void sumarVida() {
		
	}

	public void setPuntuacion(int n) {
		
	}

	public void setPuntuacionChampiVerde() {
		
	}

	public void setPuntuacionEstrella() {
		
	}

	public void setPuntuacionFlorDeFuego() {
		
	}

	public void setPuntuacionSuperChampi() {
		
	}

	public void romperLadrilloSolido(LadrilloSolido l) {
		
	}

	public void moverBloqueGolpeable(BloqueGolpeable b) {
		
	}

	public int getAlto() {
		return alto;
	}

	public void colisionLateralGoomba() {
		System.out.println("MORIR");
	}

	

}
