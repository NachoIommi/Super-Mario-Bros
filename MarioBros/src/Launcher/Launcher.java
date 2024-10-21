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
					Ranking ranking = cargarRanking();
					ControladorVistas controladorVistas = new ControladorVistas(juego,ranking);
					juego.setControladorVistas(controladorVistas);
					controladorVistas.ventana.setVisible(true);
					controladorVistas.mostrarPantallaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
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
	    } catch (IOException | ClassNotFoundException | URISyntaxException e) {
	        System.out.println("Error al cargar el ranking.");
	        e.printStackTrace();
	    }
	    return ranking; 
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