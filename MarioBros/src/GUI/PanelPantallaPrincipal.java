package GUI;

import java.awt.Image;

import javax.swing.*;

public class PanelPantallaPrincipal extends JPanel{

	private static final long serialVersionUID = 1L;

	protected JLabel imagenFondo;
	protected JButton ingresarNombre, seleccionarModoDeJuego;
	

	public PanelPantallaPrincipal() {
		setSize(600, 800);
		setLayout(null);
	}
	
	public void agregarImagenFondo() {
		imagenFondo = new JLabel();
		ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/imagenes/PantallaInicial.jpg"));
		Image imagenEscalada = iconoImagen.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenFondo.setIcon(iconoImagenEscalado);
		imagenFondo.setBounds(0,0, 800, 600);
		add(imagenFondo);
		
		
		
	}
	
}
