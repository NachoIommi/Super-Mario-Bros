package Personaje;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Plataformas.BloqueGolpeable;
import Plataformas.LadrilloSolido;

public class EstadoSuperMario extends EstadoDePersonaje {
	
	//protected Personaje personaje;
	protected Sprite sprite;
	protected Hitbox hitb;
	
	
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;
	
	protected int min = 10;
	
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
	
	protected int tiempoSaltando=0;
	protected final int maxTiempoSalto=20;
	


	
	public EstadoSuperMario(Personaje personaje,Sprite s,int x,int y) {
		
		super(personaje);
		hitb = new Hitbox(x ,y,30 ,60);
		setPosX(x);
		setPosY(y);
		sprite =s;
		tocandoBloque=false;
	    tocandoBloqueDerecha=false;
	    tocandoBloqueIzquierda=false;
	    tocandoBloqueAbajo=false;
	    tocandoBloqueArriba=false;
	    saltando=false;  
		
	}
	
	public void moverPersonaje(){	
		int factorVelocidad = 1; //en estado estrella mueve mas rapido, en el resto es = 1
		
		if (direccionDelPersonaje != 0) {
			   switch(direccionDelPersonaje){
				   	case(1):
				   		if(posX < 3300 && tocandoBloqueDerecha==false) {
				   			if(velX<11)
				   				velX=(velX+1 * factorVelocidad);
				   			posX = posX+ velX;
				   			hitb.actualizar(posX, posY);
				   			actualizarSprite();
				   			
				   			}		
				   			
						break;
						
					case(3):
						if(posX > min && tocandoBloqueIzquierda==false) { //El personaje solo llega al inicio de la pantalla
							if (velX<11)
								velX=(velX+1* factorVelocidad);
							posX = posX - velX;
							hitb.actualizar(posX, posY);
							actualizarSprite();
							}
							
						break;
						
					case (2): // Saltar
		                if (tocandoBloqueAbajo && !saltando) { // Solo si está en el suelo
		                    saltando = true;
		                    velY = velSalto;  // Aplicar la velocidad de salto
		                    tiempoSaltando = 0;  // Reiniciar tiempo de salto
		                }
		                break;					
				
				default: // Si la dirección es 0, no se mueve
		            break;
			   }
			   
		   }
		   
		   else { //DIRECCION 0
			   velX=0;	//REINICIO VELOCIDAD
			   actualizarSprite();
		   }	
		   
		   if (saltando) {
			    // Aplicar la gravedad y la velocidad inicial
			   
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

    public void saltar() {
    	
    }

    public void morir() {
    	personaje.setVidas(personaje.getVidas()-1);
    	//personaje.cargarSprite("spritesOriginales\marioNormalMuerto.png"); 
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
    	;
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
		   min += velX;
	}
	
	public int getMin() {
		return min;
	}
	
	@Override
	public void sumarVida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacion(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionChampiVerde() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionEstrella() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionFlorDeFuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntuacionSuperChampi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFactorVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void romperLadrilloSolido(LadrilloSolido l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverBloqueGolpeable(BloqueGolpeable b) {
		// TODO Auto-generated method stub
		
	}

	
 
}
