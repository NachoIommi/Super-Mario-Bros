package Launcher;

import java.awt.EventQueue; 

import GUI.ControladorVistas;
import Logica.Juego;
import Logica.Nivel;

public class Launcher {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego juego = new Juego();
					ControladorVistas controladorVistas = new ControladorVistas(juego);
					
					controladorVistas.ventana.setVisible(true);
					juego.setControladorVistas(controladorVistas);
					controladorVistas.mostrarPantallaJuego();

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
