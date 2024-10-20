package GUI;

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
	}
	
	public void mostrarPantallaPrincipal() {
		ventana.setContentPane(pantallaPrincipal);
	}
	
	public void mostrarPantallaJuego() {
		ventana.setContentPane(pantallaJuego);
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
}