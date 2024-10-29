package Logica;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Enemigos.Enemigo;
import GUI.ControladorVistas;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class Juego {
	
	//protected Ranking ranking;
	protected Reloj reloj;
	protected Mundo mundos;
	protected Nivel nivel;
	protected int modoDeJuego;
	protected Personaje personaje;
	protected List<Enemigo> enemigos;
	protected List<Plataforma> plataformas;
	protected List<PowerUps> powerUps;
	protected HiloPersonaje hilo;
	protected HiloAnimaciones hiloAnimaciones;
	protected HiloRestoMundo hiloRM;
	protected ControladorVistas controladorVistas;
	//protected Musica musica; ver si va aca, no toy seguro
	
	public Juego() {
		reloj = new Reloj();
		nivel = new Nivel(300,this);
		personaje = null;
		enemigos = new ArrayList<Enemigo>();
		plataformas = new ArrayList<Plataforma>();
		powerUps = new ArrayList<PowerUps>();
		cargarPrimerNivel();
		
	
		hilo = new HiloPersonaje(this);
		hiloAnimaciones = new HiloAnimaciones(this);
		hiloRM = new HiloRestoMundo(this);
		//Musica.getInstancia().reproducirMusica("Sonido/Canciones/menuPrincipal.wav");
	}
	
	public void setControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	public void cargarPrimerNivel() {
		nivel.cargarNivel(0);
		System.out.println(enemigos.toString());
	}
	
	public void reseteo() {
		//reinicio todo, entidades e hilos
				if(hilo.isAlive()) {
					hilo.detener();
					
				}
				if(hiloRM.isAlive()) {
					hiloRM.detener();
				}
				
				if(reloj.isAlive()) {
					reloj.detener();
				}
				
				
				powerUps.clear();
				enemigos.clear();
				plataformas.clear();
	}
	
	public void iniciarSiguienteNivel() {
		
		reseteo();
		
		System.out.println(enemigos.toString());
		
		nivel.ganarJuego();
		System.out.println("cargando nivel: " + getNivel().getNivelActual());
		System.out.println();
		
		iniciarJuego();
	}
	public ControladorVistas getControladorVistas() {
		return controladorVistas;
		
	}
	
	public Reloj getReloj() {
		return reloj;
	}
	
	public void iniciarJuego() {
	    if (hilo != null && hilo.isAlive()) {
	        hilo.detener(); // Debes asegurarte de que el hilo tenga un método para detenerse adecuadamente.
	    }
	    hilo = new HiloPersonaje(this); // Crear un nuevo hilo
	    hilo.start();
	    
	    if (hiloRM != null && hiloRM.isAlive()) {
	        hiloRM.detener(); // Debes asegurarte de que el hilo tenga un método para detenerse adecuadamente.
	    }
	    
	    hiloRM = new HiloRestoMundo(this);
	    hiloRM.start();
	    
	    if (hiloAnimaciones != null && hiloAnimaciones.isAlive()) {
	        hiloAnimaciones.detener(); // Debes asegurarte de que el hilo tenga un método para detenerse adecuadamente.
	    }
	    
	    hiloAnimaciones = new HiloAnimaciones(this);
	    hiloAnimaciones.start();

	    if (reloj != null && reloj.isAlive()) {
	        reloj.detener();
	    }
	    reloj = new Reloj(); // Crear un nuevo reloj
	    reloj.start();
	}
	
	public void reiniciarNivel() {
		iniciarJuego();
		controladorVistas.reiniciarNivel();
		
		System.out.println("se ejecuto reiniciarNivel :: juego");
		
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
	
	public List<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public void agregarPlataforma(Plataforma e) {
		plataformas.addLast(e);
	}
	
	public List<Plataforma> getPlataformas() {
		return plataformas;
	}
	
	public void agregarPowerUp(PowerUps p) {
		powerUps.addLast(p);
	}
	
	public List<PowerUps> getPowerUps() {
		return powerUps;
	}
	
	public void setHiloPersonaje(HiloPersonaje hiloPersonaje) {
		hilo = hiloPersonaje;
	}
	
	public HiloPersonaje getHiloPersonaje() {
		return hilo;
	}
	
	public HiloRestoMundo getHiloRM() {
		return hiloRM;
	}
	public HiloAnimaciones getHiloAnimaciones() {
		return hiloAnimaciones;
	}
	
}
