package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.List; 
import java.io.File;


import javax.swing.JFrame;
import javax.swing.Timer;

import Enemigos.Enemigo;
import Logica.*;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class ControladorVistas {

	public JFrame ventana;
	protected PantallaPrincipal pantallaPrincipal;
	protected PantallaRanking pantallaRanking;
	protected PantallaJuego pantallaJuego;
	protected PantallaVictoria pantallaVictoria;
	protected PantallaModoDeJuego pantallaModoDeJuego;
	protected PantallaPerder pantallaPerder;
	protected Juego juego;
	
	public ControladorVistas(Juego juego) {
		this.juego = juego;
		iniciar();
		pantallaPrincipal = new PantallaPrincipal(this);
	}
	
	public void iniciar() {
		ventana = new JFrame();
		ventana.setTitle("Super Mario Bros");
		ventana.setSize(ConstantesVistas.VENTANA_ANCHO,ConstantesVistas.VENTANA_ALTO);
		ventana.setLayout(null);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
        ventana.addWindowListener(new WindowAdapter() {
        	 public void windowClosing(WindowEvent e) {
             	obtenerJuego().guardarPuntuacion();
             	int puntuacionGuardada = obtenerJuego().getPuntuacion();
         		Jugador jugador = new Jugador(pantallaPrincipal.obtenerNombreDeJugador(),puntuacionGuardada);
         		
         		if(pantallaPrincipal.obtenerNombreDeJugador().isEmpty()) {
         			jugador.setNombre("Jugador ");
         		}
         		
             	guardarJugadorEnRanking(jugador); 
                 juego.cierreDeJuego(); 
             }
        });
	}
	
	public void mostrarPantallaModoDeJuego(){
		Musica.getMusica().reproducirMusica("Sonido/Canciones/seleccionPersonaje.wav");
		if(pantallaModoDeJuego == null) {
			pantallaModoDeJuego = new PantallaModoDeJuego(this);
		}
		
		ventana.setContentPane(pantallaModoDeJuego);
	}
	public void mostrarPantallaPerder() {
		Musica.getMusica().reproducirMusicaSinLoop("Sonido/Canciones/gameOver.wav");
		if(pantallaPerder == null) {
			pantallaPerder = new PantallaPerder(this);
		}
		ventana.setContentPane(pantallaPerder);
	}
	
	
	public void mostrarPantallaPrincipal() {
		Musica.getMusica().reproducirMusica("Sonido/Canciones/menuPrincipal.wav");
		if(pantallaPrincipal == null) {
			pantallaPrincipal = new PantallaPrincipal(this);
		}
		ventana.setContentPane(pantallaPrincipal);
	}
	
	public void mostrarPantallaVictoria() {
		juego.guardarPuntuacion();
		if (juego.getHiloPersonaje().isAlive()) {
            juego.getHiloPersonaje().detener();
        }
        if (juego.getReloj().isAlive()) {
            juego.getReloj().detener();
        }
        if(juego.getHiloRM().isAlive()) {
        	juego.getHiloRM().detener();
        }
        
        juego.reseteo();
		
        if(pantallaJuego!=null) {
        	pantallaJuego = null;
        	pantallaVictoria = new PantallaVictoria(this);
        }
        
		ventana.setContentPane(pantallaVictoria);
	}
	
	public void mostrarPantallaJuego() {
		
		if(pantallaJuego == null) {
			juego.cargarPrimerNivel();
			juego.iniciarJuego();
			pantallaJuego = new PantallaJuego(this);
		}
		
		configurarEventosTeclado();
		
		ventana.setContentPane(pantallaJuego);
	    ventana.revalidate();
	    pantallaJuego.requestFocus();
	}
	
	public void mostrarPantallaRanking() {
		if(pantallaRanking == null) {
			pantallaRanking = new PantallaRanking(this);
		}
		ventana.setContentPane(pantallaRanking);
	}
	
	public void reiniciarNivel() {
        if(pantallaJuego!=null) {
        	pantallaJuego.setPantallaCorriendo(false);
        	pantallaJuego = null;
        	pantallaJuego = new PantallaJuego(this);
        	
        	configurarEventosTeclado();
        	
        	ventana.setContentPane(pantallaJuego);
    	    ventana.revalidate();
    	    pantallaJuego.requestFocus();
        }
       
	}
	
	public void perderJuego() {
		mostrarPantallaPerder();
		if(pantallaJuego != null) {
			pantallaJuego.setPantallaCorriendo(false);
			pantallaJuego = null;
		}
	}
	
	public synchronized void iniciarSiguienteNivel() {		
		if (juego.getHiloPersonaje().isAlive()) {
            juego.getHiloPersonaje().detener();
        }
        if (juego.getReloj().isAlive()) {
            juego.getReloj().detener();
        }
        if(juego.getHiloRM().isAlive()) {
        	juego.getHiloRM().detener();
        }
        
        juego.iniciarSiguienteNivel();
        
        if (pantallaJuego != null) {
            pantallaJuego = null;
            pantallaJuego = new PantallaJuego(this);
            mostrarPantallaJuego();
        }
	}
	
	public Juego obtenerJuego() {
		return juego;
	}
	public Personaje obtenerPersonaje() {
		if(juego.getPersonaje() == null) {
			return null;
		}else {
			return juego.getPersonaje();
		}
		
	}
	
	public List<Enemigo> obtenerEnemigo() {
		return juego.getEnemigos();
	}
	
	public List<Enemigo> obtenerEnemigosEnEjecucion() {
		return juego.getEnemigosEnEjecucion();
	}
	
	public List<Plataforma> obtenerPlataforma() {
		return juego.getPlataformas();
	}
	
	public List<PowerUp> obtenerPowerUp() {
		return juego.getPowerUps();
	}
	public List<BolaDeFuego> obtenerBolas(){
		return juego.getBolas();
	}
	
	public void guardarJugadorEnRanking(Jugador jugador) {
	    if(jugador != null) {
	    	juego.getRanking().addJugador(jugador);
	    	
	    } 
	}
	
	public void configurarEventosTeclado() {
	    if ( obtenerPersonaje() != null ) {
	    	Personaje personaje=obtenerPersonaje();	    	
	        pantallaJuego.addKeyListener(new KeyAdapter() {
	        	public void keyPressed(KeyEvent k) {
                    int keyCode = k.getKeyCode(); 
                    switch(keyCode) {
                    	case(KeyEvent.VK_D):
                    		personaje.setRight(true);
                    		break;
                    	case(KeyEvent.VK_A):
                    		personaje.setLeft(true);
                    		break;		
                    	case(KeyEvent.VK_W):
                    		personaje.setJump(true);
                    		break;
                    	case(KeyEvent.VK_SPACE):
                    		personaje.disparar();
                    		personaje.setPuedeDisparar(false);
                    		break;
                    }
	            }
	            public void keyReleased(KeyEvent k) {
                	int keyCode = k.getKeyCode(); 
                    switch(keyCode) {
                	case(KeyEvent.VK_D):
                		personaje.setRight(false);               	
                		break;
                	case(KeyEvent.VK_A):
                		personaje.setLeft(false);               	
                		break;		
                	case(KeyEvent.VK_W):
                		personaje.setJump(false); 
                		break;
                	case(KeyEvent.VK_SPACE):
                		personaje.setPuedeDisparar(true);
                		break;
	                }
	            }
	        });
	    }
	}
}
