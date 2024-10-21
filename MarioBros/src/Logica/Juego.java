package Logica;
import java.util.ArrayList;
import java.util.List;

import Enemigos.Enemigo;
import GUI.ControladorVistas;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class Juego {
	
	//protected Ranking ranking;
	protected Mundo mundos;
	protected Nivel nivel;
	protected int modoDeJuego;
	protected Personaje personaje;
	protected List<Enemigo> enemigos;
	protected List<Plataforma> plataformas;
	protected List<PowerUps> powerUps;
	protected HiloPersonaje hilo;
	protected ControladorVistas controladorVistas;
	
	public Juego() {
		nivel = new Nivel(300,this);
		personaje = null;
		enemigos = new ArrayList<Enemigo>();
		plataformas = new ArrayList<Plataforma>();
		powerUps = new ArrayList<PowerUps>();
		nivel.cargarNivel(1);
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
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public int getModoDeJuego() {
		return 2; 
	}//Retonarmos un '2' a modo de convension ya que no hicimos el metodo de seleccion del modoDeJuego
	
	public void setModoDeJuego(int n) {
		
	}
	
	public void agregarPersonaje(Personaje p) {
		personaje = p;
	}
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void agregarEnemigo(Enemigo e) {
		enemigos.addLast(e);
	}
	public List<Enemigo> getEnemigo() {
		return enemigos;
	}
	
	public void agregarPlataforma(Plataforma e) {
		plataformas.addLast(e);
	}
	public List<Plataforma> getPlataforma() {
		return plataformas;
	}
	
	public void agregarPowerUp(PowerUps p) {
		powerUps.addLast(p);
	}
	
	public List<PowerUps> getPowerUp() {
		return powerUps;
	}
	public void setHiloPersonaje(HiloPersonaje hiloPersonaje) {
		hilo = hiloPersonaje;
	}
	public HiloPersonaje getHiloPersonaje() {
		return hilo;
	}
	
}
