package Personaje;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoNormal extends EstadoDePersonaje {
	
	protected Sprite sprite;
	protected Hitbox hitb;

	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;
	
	protected boolean tocandoBloque;
	protected boolean tocandoBloqueDerecha;
	protected boolean tocandoBloqueIzquierda;
	protected boolean tocandoBloqueAbajo;
    protected boolean tocandoBloqueArriba;
    protected boolean saltando;
	
	protected int velX;
	protected int gravedad=1;
	protected int velY;
	protected int velSalto = -50;
	protected int alto;
	protected int tiempoSaltando=0;
	protected final int maxTiempoSalto=20;
	
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
	}
	
	public void moverPersonaje(){	
		int factorVelocidad = 1; 
		
		if (direccionDelPersonaje != 0) {
			if(direccionDelPersonaje==1)
			   {
				   	if(posX < 3300 && tocandoBloqueDerecha==false) {
				   			if(velX<11)
				   				velX=(velX+1 * factorVelocidad);
				   			posX = posX+ velX;
				   			hitb.actualizar(posX, posY);
				   			actualizarSprite();}
			   }		
				   	
			if(direccionDelPersonaje==3){
						if(posX > personaje.getMin() && tocandoBloqueIzquierda==false) { //El personaje solo llega al inicio de la pantalla
							if (velX>-11)
								velX=(velX-1* factorVelocidad);
							posX = posX + velX;
							hitb.actualizar(posX, posY);
							actualizarSprite();}
					}
			
			if(direccionDelPersonaje==2)
		                if (tocandoBloqueAbajo && !saltando) { // Solo si está en el suelo
		                    saltando = true;
		                    velY = velSalto;  // Aplicar la velocidad de salto
		                    tiempoSaltando = 0;  // Reiniciar tiempo de salto
		                }
		                				}
		   
		   else { 
			   velX=0;
			   actualizarSprite();
		   }	
		   
		   if (saltando) {
			    velY = velY + gravedad;
			    if(!tocandoBloqueArriba)
			    	posY = posY + velY;
			    
			    if (tocandoBloqueAbajo==true) { // Verificar si el personaje ha tocado el suelo
			        saltando = false;
			        velY = 0;
			    }
			}
		   else 
			   if (!tocandoBloqueAbajo) { //NO HAY BLOQUE ABAJO -> CAIDA LIBRE
				   velY=velY+gravedad;					   
				   posY = posY+ velY; // Actualizar la posición Y del personaje con la velocidad de caída
		        	} 
			   else 
				   velY = 0; // Si toca un bloque debajo, detener la caída
		    
		    // Actualizar la hitbox del personaje
		    hitb.actualizar(posX, posY);
		   
	   }
	
    public void actualizarSprite(){
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	switch(direccionDelPersonaje){
    		case(1):
	    		sprite = fabrica.getPersonajeNormalCorriendo();
	    		break;
    		case(3):
	    		sprite = fabrica.getPersonajeNormalCorriendo();
	    		break;
    		case(0):
	    		sprite = fabrica.getPersonaje();
	    		break;
    		
    		default:
    			break;
    	}

        personaje.cargarSprite(sprite);
    }

    public void colisionSuperChampi() {
    	GenerarSprite fabrica = new GenerarSpriteOriginal();
    	EstadoSuperMario e = new EstadoSuperMario(personaje,fabrica.getSuperMario(),posX,posY);
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
		return velX;
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
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public void setPosX(int x) {
	    this.posX = x;
	    hitb.actualizar(posX, posY);  // Actualizar la hitbox después de ajustar la posición
	}

	public void setPosY(int y) {
	    this.posY = y;
	    hitb.actualizar(posX, posY);  // Actualizar la hitbox después de ajustar la posición
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
