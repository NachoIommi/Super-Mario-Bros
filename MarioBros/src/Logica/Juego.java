package Logica;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import Enemigos.Enemigo;
import GUI.ControladorVistas;
import Launcher.Launcher;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class Juego {
	
	protected Reloj reloj;
	protected Mundo mundos;
	protected Nivel nivel;
	protected int modoDeJuego;
	protected Personaje personaje;
	protected Ranking ranking;
	protected int puntuacion;
	protected int monedas;
	
	protected List<Enemigo> enemigos;
	protected List<Enemigo> enemigosEnEjecucion;
	protected List<Plataforma> plataformas;
	protected List<PowerUp> powerUps;
	protected List<BolaDeFuego> bolas;
	
	protected HiloPersonaje hilo;
	protected HiloAnimaciones hiloAnimaciones;
	protected HiloRestoMundo hiloRM;
	protected ControladorVistas controladorVistas;
	
	public Juego() {
		
		reloj = new Reloj();		
		
		personaje = null;
		enemigos = new ArrayList<Enemigo>();
		enemigosEnEjecucion = new ArrayList<Enemigo>();
		plataformas = new ArrayList<Plataforma>();
		powerUps = new ArrayList<PowerUp>();
		bolas = new ArrayList<BolaDeFuego>();
		ranking = cargarRanking();
		
	
		hilo = new HiloPersonaje(this);
		hiloAnimaciones = new HiloAnimaciones(this);
		hiloRM = new HiloRestoMundo(this);
	}
	
	public void setControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	
	public void cargarPrimerNivel() {
		if(nivel == null) {
			nivel = new Nivel(300,this);
		}
		nivel.cargarNivel(0);
	}
	
	public void reseteo() {
				if(hilo.isAlive()) {
					hilo.detener();
				}
				
				if(hiloRM.isAlive()) {
					hiloRM.detener();
				}
				
				if(reloj.isAlive()) {
					reloj.detener();
				}
				
				personaje = null;
				
				powerUps.clear();
				enemigos.clear();
				plataformas.clear();
				enemigosEnEjecucion.clear();
				bolas.clear();
	}
	
	public synchronized void iniciarSiguienteNivel() {
		reseteo();
		nivel.ganarJuego();		
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
	        hilo.detener();
	    }
	    
	    hilo = new HiloPersonaje(this);
	    hilo.start();
	    
	    if (hiloRM != null && hiloRM.isAlive()) {
	        hiloRM.detener();
	    }
	    
	    hiloRM = new HiloRestoMundo(this);
	    hiloRM.start();
	    
	    if (hiloAnimaciones != null && hiloAnimaciones.isAlive()) {
	        hiloAnimaciones.detener();
	    }
	    
	    hiloAnimaciones = new HiloAnimaciones(this);
	    hiloAnimaciones.start();

	    if (reloj != null && reloj.isAlive()) {
	        reloj.detener();
	    }
	    
	    reloj = new Reloj();
	    reloj.start();
	    
	}
	
	public void reiniciarNivel() {
		iniciarJuego();
		controladorVistas.reiniciarNivel();
	}
	
	public void perderJuego() {
		guardarPuntuacion();
		reseteo();
		nivel = null;
		controladorVistas.perderJuego();
	}
	
	public void guardarPuntuacion() {
		if(personaje!=null)
			puntuacion = personaje.getPuntuacion();
	}
	
	public int getPuntuacion() {
		return puntuacion;
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
		return modoDeJuego; 
	}
	
	public void setModoDeJuego(int n) {
		modoDeJuego = n;
	}
	
	public void agregarPersonaje(Personaje p) {
		personaje = p;
	}
	
	public Personaje getPersonaje() {
		if(personaje == null) {
			return null;
		} else {
			return personaje;
		}
		
	}
	
	public void agregarEnemigo(Enemigo e) {
		enemigos.addLast(e);
	}
	
	public void agregarEnemigoEnEjecucion(Enemigo e) {
		enemigosEnEjecucion.addLast(e);
	}
	
	public void agregarBola(BolaDeFuego b) {
		bolas.addLast(b);
	}
	public List<BolaDeFuego> getBolas(){
		return bolas;
	}
	
	public List<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public List<Enemigo> getEnemigosEnEjecucion(){
		return enemigosEnEjecucion;
	}
	
	public void agregarPlataforma(Plataforma e) {
		plataformas.addLast(e);
	}
	
	public List<Plataforma> getPlataformas() {
		return plataformas;
	}
	
	public void agregarPowerUp(PowerUp p) {
		powerUps.addLast(p);
	}
	
	public List<PowerUp> getPowerUps() {
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
	
	public static Ranking cargarRanking() {
	    Ranking ranking = new Ranking(); 
	    try {
	        String relativePath = Launcher.configuration.getProperty("file");
	        if (relativePath == null || relativePath.isEmpty()) {
	            System.out.println("La ruta del archivo de ranking no está configurada.");
	            return ranking;
	        }
	        URL resource = Launcher.class.getClassLoader().getResource(relativePath);
	        if (resource == null) {
	            System.out.println("No se encontró el archivo de ranking en la ruta: " + relativePath);
	            return ranking;
	        }

	        File file = new File(resource.toURI()); 

	        try (FileInputStream fileInputStream = new FileInputStream(file);
	             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
	             
	            ranking = (Ranking) objectInputStream.readObject();
	            System.out.println("Ranking cargado correctamente: ");
	        }
	        catch (EOFException |InvalidClassException e) {
                System.out.println("Error: versión incompatible del archivo de ranking. Intenta borrar el archivo para solucionar el problema.");
            }
	    } catch (IOException | ClassNotFoundException | URISyntaxException e) {
	        System.out.println("Error al cargar el ranking.");
	        e.printStackTrace();
	    }
	    return ranking; 
	}
	
	public void cierreDeJuego() {
	    try {
	        String relativePath = "score.tdp";
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(getClass().getClassLoader().getResource(relativePath).toURI()));
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeObject(ranking);
	        objectOutputStream.flush();
	        objectOutputStream.close();
	        System.out.println("Ranking guardado correctamente.");
	    } catch (IOException | URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public Ranking getRanking() {
		return ranking;
	}
}
