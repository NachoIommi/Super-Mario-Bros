package Logica;
import java.util.ArrayList;
import java.util.List;

import GUI.ControladorVistas;
import Personaje.Personaje;

public class Juego {
	//protected Ranking ranking;
	protected Mundo mundos;
	protected Nivel nivel;
	protected int modoDeJuego;
	
	protected Personaje personaje;
	HiloPersonaje hilo;
	
	protected ControladorVistas controladorVistas;
	
	
	public Juego() {
		nivel = new Nivel(300,this);
		personaje = null;
		nivel.cargarNivel(0);
		hilo = new HiloPersonaje(this); //prueba
		hilo.start();
	}
	
	public void setControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	
	public ControladorVistas getControladorVistas() {
		return controladorVistas;
	}
	
	public void iniciarJuego() {
		controladorVistas.mostrarPantallaJuego();
	}
	public void perderJuego() {
		controladorVistas.mostrarPantallaPerder();
	}
	
	public void seleccionarMundo(Mundo m) {
		
	}
	
	public void agregarMundo(Mundo m) {
		
	}
	
	public void eliminarMundo(Mundo m) {
		
	}
	
	public Mundo getMundo() {
		return mundos;
	}
	
	public int getModoDeJuego() {
		return 2; //borrar
	}
	
	public void setModoDeJuego(int n) {
		
	}
	
	public void agregarPersonaje(Personaje p) {
		personaje = p;
	}
	public Personaje getPersonaje() {
		return personaje;
	}
	
}
