package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Logica.Jugador;
import Logica.Ranking;

public class PantallaPrincipal extends JPanel{
	
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	protected JTextField ingresarNombre;
	protected JButton botonIngresarNombre;
	protected Ranking ranking;
	/*
	 * Creo el panel
	 */
	public PantallaPrincipal(ControladorVistas controladorVistas, Ranking ranking) {
		this.controladorVistas = controladorVistas;
		this.ranking = ranking;
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		//agregarPanelBotones();
		//agregarBotonComenzar();
		agregarNombre();
		agregarBotonIngresarNombre();
		agregarModosDeJuego();
		agregarImagen();
		
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
		botonIngresarNombre.setBounds(250, 370, 300, 20);
		botonIngresarNombre.setOpaque(false);
		botonIngresarNombre.setContentAreaFilled(false);
		botonIngresarNombre.setBorderPainted(false);
		registrarOyenteBotonNombre();
		this.add(botonIngresarNombre);
	}
	public void agregarNombre() {
	    ingresarNombre = new JTextField();
	    ingresarNombre.setBounds(250, 350, 300, 20);
	    ingresarNombre.setBorder(null);
	    ingresarNombre.setBackground(Color.white);

	    // Agregar ActionListener para detectar cuando se presiona "Enter"
	    ingresarNombre.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Verificar que el nombre no esté vacío antes de cambiar de pantalla
	            if (!ingresarNombre.getText().trim().isEmpty()) {
	                controladorVistas.guardarJugadorEnRanking(new Jugador(ingresarNombre.getText(), 0));  // Guardar el nombre
	                controladorVistas.mostrarPantallaJuego();  // Cambiar a la pantalla de juego
	            }
	        }
	    });

	    this.add(ingresarNombre);
	}
	public void guardarJugadorEnRanking(Jugador j) {
	    ranking.addJugador(j);
	    controladorVistas.cierreDeJuego(); // Asegúrate de que el ranking se guarde en el archivo
	}
	
	public void registrarOyenteBotonNombre() {
	    botonIngresarNombre.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            String nombreJugador = ingresarNombre.getText();
	            Jugador j = new Jugador(nombreJugador,0);
	            controladorVistas.guardarJugadorEnRanking(j); // Puntaje inicial 0
	            controladorVistas.mostrarPantallaJuego(); // Cambiar a la pantalla de juego
	        }
	    });   
	}
	
	public void agregarModosDeJuego() {
		
	}
}