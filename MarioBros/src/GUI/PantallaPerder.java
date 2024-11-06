package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaPerder extends JPanel {
	protected ControladorVistas controladorVistas;
	protected JLabel imagenPerder;
	
	public PantallaPerder(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		agregarImagen();
	}
	public void agregarImagen() {
		imagenPerder = new JLabel();
		imagenPerder.setSize(600, 500);
		ImageIcon icono = new ImageIcon(this.getClass().getResource("/img/gameOver.gif"));
		Image imagenEscalada = icono.getImage();
		Image imagenAgrandada = imagenEscalada.getScaledInstance(600, 500, Image.SCALE_DEFAULT);
		Icon iconoEscalado = new ImageIcon(imagenAgrandada);
		imagenPerder.setIcon(iconoEscalado);
		this.add(imagenPerder);
	}	
}
