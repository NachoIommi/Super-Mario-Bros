package GUI;

import java.awt.event.WindowEvent; 
import java.awt.event.WindowAdapter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List; 

import javax.swing.JFrame;
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
	
	/*
	 * Creo el JFrame que contendra los paneles
	 */
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
	   ventana.setContentPane(pantallaJuego);
	   ventana.revalidate();
	    pantallaJuego.requestFocus();
	    
	    // Iniciar el hilo del personaje
	    if (!juego.getHiloPersonaje().isAlive()) {
	        juego.getHiloPersonaje().start();
	    }
	}
	
	public void mostrarPantallaPerder() {
		ventana.setContentPane(pantallaPerder);
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
	    cierreDeJuego(); // Asegúrate de que el ranking se guarde en el archivo
	    System.out.println("Ranking actualizado:");
	    for (Jugador jugador : ranking.getJugadores()) { // Asegúrate de tener un método para obtener la lista de jugadores
	        System.out.println("Nombre: " + jugador.getNombre() + ", Puntaje: " + jugador.getPuntaje());
	    }
	}
	public void cierreDeJuego() {
	    try (FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/juans/git/p-comision-16/MarioBros/resources/score.tdp");
	         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
	        objectOutputStream.writeObject(this.ranking);
	        System.out.println("Ranking guardado correctamente.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
}