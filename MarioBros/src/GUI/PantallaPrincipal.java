package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
		ingresarNombre.setText("Ingrese su Nombre");
		ingresarNombre.setBounds(250, 350, 300, 20);
		ingresarNombre.setBorder(null);
		ingresarNombre.setBackground(Color.black);
		this.add(ingresarNombre);
	}
	
	public void registrarOyenteBotonNombre() {
		botonIngresarNombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controladorVistas.juego.getMundo().cargarPrimerNivel();
				}
		});
	}
	
	public void agregarModosDeJuego() {
		
	}
	public void mostrarRanking() {
        // Aquí muestras el ranking. Puedes usar JLabel para mostrar el texto.
        JLabel labelRanking = new JLabel("Ranking:");
        labelRanking.setBounds(50, 50, 200, 30);  // Ajusta las coordenadas según el diseño
        add(labelRanking);
        
        // Supongamos que ranking tiene un método para obtener los puntajes como lista de cadenas
        int yOffset = 80;
        for (String puntaje : ranking.getPuntajes()) {
            JLabel labelPuntaje = new JLabel(puntaje);
            labelPuntaje.setBounds(50, yOffset, 200, 30);
            add(labelPuntaje);
            yOffset += 30;  // Desplazar hacia abajo para cada puntaje
        }
    }
}