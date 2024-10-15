package Personaje;

import Logica.Entidad; 
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
	
    public Personaje(Sprite sprite, int x, int y) {
        vidas = 3;        
        monedas = 0;      
        puntuacion = 0;   
        estado = new EstadoNormal(this); 
        direccionDelPersonaje = 0; // direccion 0 -> Quieto
        posX = x;
        posY = y;
        this.sprite = sprite;
    }

    public void correr() {
        estado.correr();
    }

    public void saltar() {
        this.estado.saltar();
    }

    public void morir() {
        this.estado.morir();
        this.vidas -= 1;
        if (this.vidas == 0) {
        	System.out.println("Game Over");
        }
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

   public void moverPersonaje(){
	   if (direccionDelPersonaje != 0) {
		   switch(direccionDelPersonaje){
		   	case(1):
		   		if(posX < 285) { //El personaje solo llega a la mitad de la pantalla
		   			posX = posX + 10;
		   		}				
				break;
				
			case(3):
				if(posX > 10) { //El personaje solo llega al inicio de la pantalla
					posX = posX -10;
				}
				break;
			default: // Si la dirección es 0, no se mueve
	            break;
		   }
	   }
	   
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
}
