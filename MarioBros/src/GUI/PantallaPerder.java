package GUI;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
		imagenPerder.setSize(800, 600);
		ImageIcon icono = new ImageIcon(this.getClass().getResource("/img/pantallaPerder.jpg"));
		Image imagenEscalada = icono.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenPerder.setIcon(iconoEscalado);
		this.add(imagenPerder);
	}
	
}
