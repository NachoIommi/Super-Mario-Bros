package Launcher;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
		    if (Launcher.configuration != null) {
		        try {
		            FileInputStream fileInputStream = new FileInputStream(Launcher.configuration.getProperty("file"));
		            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		            ranking = (Ranking) objectInputStream.readObject();
		            objectInputStream.close();
		        } catch (FileNotFoundException e) {
		        	System.out.println("No se encontró el archivo de ranking: " + e.getMessage());
		        } catch (IOException e) {
		        	System.out.println("Error de I/O: " + e.getMessage());
		        } catch (ClassNotFoundException e) {
		        	System.out.println("Error al cargar la clase: " + e.getMessage());
		        }
		    } else {
		        System.out.println("Configuration es nulo.");
		    }
		    return ranking;
	}
	private static void loadConfiguration() {
		try (
			InputStream input = new FileInputStream("C:/Users/juans/git/p-comision-16/MarioBros/resources/configuration.properties")) {
            Launcher.configuration = new Properties();
            Launcher.configuration.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}