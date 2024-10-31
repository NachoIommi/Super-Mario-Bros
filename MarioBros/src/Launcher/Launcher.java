package Launcher;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import GUI.*;
import Logica.*;

public class Launcher {
	public static Properties configuration;

	public static void main(String[] args) {
		loadConfiguration();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					Juego juego = new Juego();
					ControladorVistas controladorVistas = new ControladorVistas(juego);
					juego.setControladorVistas(controladorVistas);
					controladorVistas.ventana.setVisible(true);
					controladorVistas.mostrarPantallaModoDeJuego();
				

				} catch (Exception e) {
			
					e.printStackTrace();
				}
			}
		});	
	}
	
	private static void loadConfiguration() {
	    try (InputStream input = Launcher.class.getClassLoader().getResourceAsStream("configuration.properties")) {
	        if (input == null) {
	            System.out.println("Lo siento, no se encontró el archivo de configuración.");
	            return;
	        }
	        Launcher.configuration = new Properties();
	        Launcher.configuration.load(input);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

}