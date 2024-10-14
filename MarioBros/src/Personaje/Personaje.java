package Personaje;

import Logica.Entidad;
import Logica.Sprite;

import java.awt.image.BufferedImage;

import Fabricas.*;

public class Personaje extends Entidad{
	
	//atributos
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	private EstadoDePersonaje estado;
	protected Sprite sprite;

	
    public Personaje() {
        vidas = 3;        // Inicialmente 3 vidas
        monedas = 0;      // Monedas iniciales
        puntuacion = 0;   // Puntos iniciales
        estado = new EstadoNormal(this);  // Comienza en estado normal
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
        v.visitarPersonaje(this);
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
    
    public void cambiarDireccion(int d) {
    	
    }
    
    String rutaQuieto = "/MarioBros/src/imagenes/spritesMario/estadoNormal/quieto/0.png";

	public void cargarSprite(Sprite s) {
		sprite = s;
		sprite.setRutaImagen(rutaQuieto);
		sprite.cargarImagen(); //Esto puede ir en el constructor, o en el generarPersonaje 
	}
	
	public void mostrarSprite() {
		BufferedImage imagen = sprite.getImagen();
	}
}
