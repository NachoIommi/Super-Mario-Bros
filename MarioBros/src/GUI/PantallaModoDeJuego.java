package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaModoDeJuego extends JPanel{

	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	protected JButton botonModoSonic;
	protected JButton botonModoMario;
	
	public PantallaModoDeJuego(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		agregarBotonMario();
		agregarBotonSonic();
		registrarOyenteBotonModoMario();
		registrarOyenteBotonModoSonic();
		agregarImagen();
	}
	
	
	public void agregarImagen() {
		String ruta = "imagenesOriginales/img/marioySonic.png";
		imagenInicio = new JLabel();
		imagenInicio.setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		ImageIcon icono = new ImageIcon(ruta);
		Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoEscalado);
		this.add(imagenInicio);
	}
	
	public void agregarBotonMario() {
		botonModoMario = new JButton();
		botonModoMario.setBounds(0, 0, 300, 500);
		botonModoMario.setVisible(true);
		botonModoMario.setOpaque(false);
		botonModoMario.setContentAreaFilled(false);
		botonModoMario.setBorderPainted(false);
		this.add(botonModoMario);
	}
	
	public void agregarBotonSonic() {
		botonModoSonic = new JButton();
		botonModoSonic.setBounds(300, 0, 300, 500);
		botonModoSonic.setVisible(true);
		botonModoSonic.setOpaque(false);
		botonModoSonic.setContentAreaFilled(false);
		botonModoSonic.setBorderPainted(false);
		add(botonModoSonic);
	}
	
	public void registrarOyenteBotonModoMario() {
		botonModoMario.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	controladorVistas.juego.setModoDeJuego(1);
	            controladorVistas.mostrarPantallaPrincipal();
	        }
	    });   
	}
	
	public void registrarOyenteBotonModoSonic() {
		botonModoSonic.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	controladorVistas.juego.setModoDeJuego(2);
	            controladorVistas.mostrarPantallaPrincipal(); 
	        }
	    });   
	}
	
}
