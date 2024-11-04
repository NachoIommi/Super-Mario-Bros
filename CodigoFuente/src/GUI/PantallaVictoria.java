package GUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaVictoria extends JPanel{
	
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	
	 public PantallaVictoria(ControladorVistas controladorVistas) {
	    	this.controladorVistas = controladorVistas;
	    	this.setSize(600,500);
			this.setLayout(null);
			this.setVisible(true);
			this.setBackground(Color.BLACK);
			agregarImagen();
	    }
	 
	 public void agregarImagen() {
			String ruta = "imagenesOriginales/img/clap.gif";
			imagenInicio = new JLabel();
			imagenInicio.setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
			ImageIcon iconoEscalado;
			ImageIcon icono = new ImageIcon(ruta);
			Image gifImage = icono.getImage();
            Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(gifAgrandado);
			imagenInicio.setIcon(iconoEscalado);		
			this.add(imagenInicio);
		}
	 
}
