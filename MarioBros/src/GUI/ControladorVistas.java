package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import PowerUps.PowerUps;

public class ControladorVistas {

	public JFrame ventana;
	protected PantallaPrincipal pantallaPrincipal;
	protected PantallaJuego pantallaJuego;
	protected PantallaPerder pantallaPerder;
	protected Juego juego;
	protected Ranking ranking;
	
	public ControladorVistas(Juego juego, Ranking ranking) {
		this.juego = juego;
		this.ranking = ranking;
		iniciar();
		pantallaPrincipal = new PantallaPrincipal(this,ranking);
		pantallaJuego = new PantallaJuego(this);
		pantallaPerder = new PantallaPerder(this);
	}
	
	public void iniciar() {
		ventana = new JFrame();
		ventana.setTitle("Super Mario Bros");
		ventana.setSize(ConstantesVistas.VENTANA_ANCHO,ConstantesVistas.VENTANA_ALTO);
		ventana.setLayout(null);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		
		// Agregar un listener para manejar el cierre de la ventana
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cierreDeJuego(); // Llamar al método para guardar el ranking
            }
        });
	}
	
	public void mostrarPantallaPrincipal() {
		ventana.setContentPane(pantallaPrincipal);
		
		
	}
	
	public void mostrarPantallaJuego() {
		
		juego.iniciarJuego();
		ventana.setContentPane(pantallaJuego);
	    ventana.revalidate();
	    pantallaJuego.requestFocus();
	}
	
	public void reiniciarNivel() {
        if(pantallaJuego!=null) {
        	pantallaJuego = null;
        	pantallaJuego = new PantallaJuego(this);
        	ventana.setContentPane(pantallaJuego);
    	    ventana.revalidate();
    	    pantallaJuego.requestFocus();
        }
        
        System.out.println("se ejecuto reiniciarNivel :: controladorVistas");
	}
	
	
	
	public void iniciarSiguienteNivel() {
		
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
		
        if(pantallaJuego!=null) {
        	pantallaJuego = null;
        	pantallaJuego = new PantallaJuego(this);
        	mostrarPantallaJuego();
        }
	
        
		
	}
	
	public Personaje obtenerPersonaje() {
		return juego.getPersonaje();
	}
	
	public List<Enemigo> obtenerEnemigo() {
		return juego.getEnemigo();
	}
	
	public List<Plataforma> obtenerPlataforma() {
		return juego.getPlataforma();
	}
	
	public List<PowerUps> obtenerPowerUp() {
		return juego.getPowerUp();
	}
	
	public void guardarJugadorEnRanking(Jugador j) {
	    ranking.addJugador(j);
	    cierreDeJuego(); 
	    System.out.println("Ranking actualizado:");
	    for (Jugador jugador : ranking.getJugadores()) { 
	        System.out.println("Nombre: " + jugador.getNombre() + ", Puntaje: " + jugador.getPuntaje());
	    }
	}
	
	public void cierreDeJuego() {
	    try {
	        // Obtener la ruta relativa del archivo dentro del paquete
	        String relativePath = "score.tdp";
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(getClass().getClassLoader().getResource(relativePath).toURI()));
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeObject(this.ranking);
	        objectOutputStream.flush();
	        objectOutputStream.close();
	        System.out.println("Ranking guardado correctamente.");
	    } catch (IOException | URISyntaxException e) {
	        e.printStackTrace();
	    }
	}

}