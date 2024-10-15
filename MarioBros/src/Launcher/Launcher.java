package Launcher;

import java.awt.EventQueue; 

import GUI.ControladorVistas;
import Logica.Juego;
import Logica.Nivel;

public class Launcher {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego juego = new Juego();
					ControladorVistas controladorVistas = new ControladorVistas(juego);
					juego.setControladorVistas(controladorVistas);
					controladorVistas.ventana.setVisible(true);
					controladorVistas.mostrarPantallaJuego();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
