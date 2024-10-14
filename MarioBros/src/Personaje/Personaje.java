package Personaje;

import Logica.Entidad; 
import Logica.Visitor;

import Fabricas.*;

public class Personaje extends Entidad{
	
	//atributos
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	private EstadoDePersonaje estado;
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected int direccionDelPersonaje;

	
    public Personaje(Sprite s, int x, int y) {
        vidas = 3;        // Inicialmente 3 vidas
        monedas = 0;      // Monedas iniciales
        puntuacion = 0;   // Puntos iniciales
        estado = new EstadoNormal(this);  // Comienza en estado normal
	direccionDelPersonaje = 0; //inicialmente en 0 , sino arranca moviendose
        posX = x;
        posY = y;
        sprite = s;
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
	   switch(direccionDelPersonaje){
	   	case(1):
			posX = posX + 5;
			break;
			   
		case(3):
			posX = posX -5;
			break;
	   }
   }
    
    public void establecerDireccion(int d) {
	    direccionDelPersonaje = d;
    }
    
	@Override
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
