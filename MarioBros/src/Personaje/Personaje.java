package Personaje;

import Logica.Entidad;
import Logica.Hitbox;
import Logica.Visitor;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Fabricas.*;

public class Personaje extends Entidad{
	
	private EstadoDePersonaje estado;
	
	protected Sprite sprite;
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;
	protected Hitbox hitb;
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
	
	
	
	
	public Personaje(Sprite sprite, int x, int y) {
        vidas = 3;        
        monedas = 0;      
        puntuacion = 0;   
        estado = new EstadoNormal(this); 
        direccionDelPersonaje = 0; // direccion 0 -> Quieto
        posX = x;
        posY = y;
        this.sprite = sprite;       
        hitb = new Hitbox(x ,y,30 ,40);
        tocandoBloque=false;
        tocandoBloqueDerecha=false;
        tocandoBloqueIzquierda=false;
        tocandoBloqueAbajo=false;
        tocandoBloqueArriba=false;
        saltando=false;  
        
    }
	
	//D 4
	

	public void moverPersonaje(){
		
		int factorVelocidad = estado.getFactorVelocidad(); //en estado estrella mueve mas rapido, en el resto es = 1
		
		if (direccionDelPersonaje != 0) {
			   switch(direccionDelPersonaje){
				   	case(1):
				   		if(posX < 3300 && tocandoBloqueDerecha==false) {
				   			if(velX<11)
				   				velX=(velX+1 * factorVelocidad);
				   			posX = posX+ velX;
				   			hitb.actualizar(posX, posY);}		
						break;
						
					case(3):
						if(posX > min && tocandoBloqueIzquierda==false) { //El personaje solo llega al inicio de la pantalla
							if (velX<11)
								velX=(velX+1* factorVelocidad);
							posX = posX - velX;
							hitb.actualizar(posX, posY);}
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
		   
		   else //DIRECCION 0
			   velX=0;	//REINICIO VELOCIDAD
		   
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
	
	public void saltar() {
        if (tocandoBloqueAbajo && !saltando) { // Solo saltar si está tocando el suelo
        	saltando=true;
        	velY = velSalto;
        	tiempoSaltando=0;
        	System.out.println("Saltando");
        }
    }


	public boolean isJumping() {
		return saltando;
	}
	public void setJumping(boolean b){
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

    public void correr() {
        estado.correr();
    }

    
    public void morir() {
        this.estado.morir();
        this.vidas -= 1;
        if (this.vidas == 0) {
        	System.out.println("Game Over");
        }
    }
    
    public void recibirDano() {
    	estado.recibirDano();
    }

    public void sumarVida() {
        this.vidas += 1;
    }

    public void sumarPuntos(int puntos) {
        this.puntuacion += puntos;
    }

    public void cambiarEstado(EstadoDePersonaje nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void aceptarVisita(Visitor v) {
        //v.visitarPersonaje(this);
    }

    public int getVidas(){
        return this.vidas;
    }
    
    public void setVidas(int n){
        this.vidas = n;
    }
    
    public int getMonedas(){
        return this.monedas;
    }
    
    public void setMonedas(int n){
        this.monedas = n;
    }

    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public void setPuntuacion(int n){
        this.puntuacion = n;
    }
    
    public EstadoDePersonaje getEstado(){
        return this.estado;
    }
    
    public void setEstado(EstadoDePersonaje nuevoEstado){
        this.estado = nuevoEstado;
    }

   
   
   public void actualizarMin() {
	   min += velX;
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
	
	public int getMin() {
		return min;
	}

	public void setPosX(int x) {
	    this.posX = x;
	    hitb.actualizar(posX, posY);  // Actualizar la hitbox después de ajustar la posición
	}
}
