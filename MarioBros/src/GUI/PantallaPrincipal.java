package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import Logica.Juego;
import Logica.Jugador;
import Logica.Musica;
import Logica.Ranking;

public class PantallaPrincipal extends JPanel{
	
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	protected JTextField ingresarNombre;
	protected JButton botonIngresarNombre;
	protected JButton botonVerRanking;
	protected String nombreJugador;
	
	public PantallaPrincipal(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		agregarNombre();
		agregarBotonIngresarNombre();
		agregarBotonVerRanking();
		agregarImagen();
		nombreJugador = " ";
	}
	
	public void agregarImagen() {
		String ruta = "imagenesOriginales/img/pantallaPrincipal.png";
		imagenInicio = new JLabel();
		imagenInicio.setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		ImageIcon icono = new ImageIcon(ruta);
		Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoEscalado);
		this.add(imagenInicio);
	}
	
	public void agregarBotonIngresarNombre() {
		botonIngresarNombre = new JButton();
		botonIngresarNombre.setText("Ingresar Nombre");
		botonIngresarNombre.setBounds(150, 315, 300, 20);
		
		try {
            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(13f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(marioFuente);
            botonIngresarNombre.setFont(marioFuente);
            botonIngresarNombre.setForeground(Color.WHITE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
		
		botonIngresarNombre.setOpaque(false);
		botonIngresarNombre.setContentAreaFilled(false);
		botonIngresarNombre.setBorderPainted(false);
		registrarOyenteBotonNombre();
		this.add(botonIngresarNombre);
	}
	public void agregarBotonVerRanking() {
        botonVerRanking = new JButton("Ver Ranking");
        botonVerRanking.setBounds(150, 355, 300, 20);  
        botonVerRanking.setVisible(true);
        
        botonVerRanking.setFont(new Font("Arial", Font.BOLD, 16));  
        botonVerRanking.setForeground(Color.BLACK);  
        try {
            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(13f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(marioFuente);
            botonVerRanking.setFont(marioFuente);
            botonVerRanking.setForeground(Color.WHITE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        botonVerRanking.setOpaque(false);  
        botonVerRanking.setContentAreaFilled(false);  
        botonVerRanking.setBorderPainted(false);
        botonVerRanking.setFocusPainted(false);  

        registrarOyenteBotonVerRanking();
        this.add(botonVerRanking);
    }
	
	public void agregarNombre() {
	    ingresarNombre = new JTextField();
	    ingresarNombre.setBounds(150, 280, 300, 20);
	    ingresarNombre.setBorder(null);
	    ingresarNombre.setBackground(Color.WHITE);

	    ingresarNombre.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (!ingresarNombre.getText().trim().isEmpty()) {
	                controladorVistas.guardarJugadorEnRanking(new Jugador(ingresarNombre.getText(), 0)); 
	                controladorVistas.mostrarPantallaJuego();
	            }
	        }
	    });
	    this.add(ingresarNombre);
	}
	
	public void registrarOyenteBotonNombre() {
	    botonIngresarNombre.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            nombreJugador = ingresarNombre.getText();
	            controladorVistas.mostrarPantallaJuego(); // Cambiar a la pantalla de juego
	        }
	    });   
	}
	
	public void registrarOyenteBotonVerRanking() {
	    botonVerRanking.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            controladorVistas.mostrarPantallaRanking(); 
	        }
	    });   
	}
	
	public String obtenerNombreDeJugador() {
		return ingresarNombre.getText();
	}
	
}