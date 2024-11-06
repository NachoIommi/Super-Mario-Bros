package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Jugador;

public class PantallaVictoria extends JPanel{
	
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	
	 public PantallaVictoria(ControladorVistas controladorVistas) {
	    this.controladorVistas = controladorVistas;
	    this.setSize(600,500);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		mostrarGanar();
		mostrarRanking();
		agregarImagen();
	}
	 
	 public void agregarImagen() {
		String ruta = "imagenesOriginales/img/imagenVictoria.jpg";;
		imagenInicio = new JLabel();
		imagenInicio.setSize(ConstantesVistas.PANEL_ANCHO, 465);
		ImageIcon icono = new ImageIcon(ruta);
		Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO, 465, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoEscalado);
		this.add(imagenInicio);
	 }
	 
	 public void mostrarRanking() {
	    JLabel[] labelJugadores = new JLabel[5];
	    JLabel ranking = new JLabel("RANKING");
	    ranking.setBounds(30, 250, 350, 50); 
	    ranking.setVisible(true); 
	    add(ranking);
	    for (int j = 0; j < labelJugadores.length; j++) {
	            labelJugadores[j] = new JLabel(); 
	            labelJugadores[j].setBounds(30, 280 + (j * 30), 350, 50); 
	            labelJugadores[j].setVisible(true); 
	            add(labelJugadores[j]); 
	    }
	        
	        try {
	            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(12f);
	            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            ge.registerFont(marioFuente);
	            for (JLabel label : labelJugadores) {
	                label.setFont(marioFuente);
	                label.setForeground(Color.WHITE);
	            }

	            ranking.setFont(marioFuente.deriveFont(22f));
	            ranking.setForeground(Color.WHITE);
	        } catch (FontFormatException | IOException e) {
	            e.printStackTrace();
	        }
	        List<Jugador> topCinco = controladorVistas.obtenerJuego().getRanking().mostrarTopCinco();
	        for (int i = 0; i < topCinco.size() && i < labelJugadores.length; i++) {
	            Jugador jugador = topCinco.get(i);
	            labelJugadores[i].setText(jugador.getNombre() + " " + jugador.getPuntaje());
	        }
	        refrescar();   
	    }
	 
	 public void mostrarGanar() {
		 JLabel labelGanar = new JLabel("¡GANASTE!");
	     labelGanar.setBounds(370, 100, 350, 50); 
	     labelGanar.setVisible(true);
	     add(labelGanar);
	     
	     try {
	            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(12f);
	            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            ge.registerFont(marioFuente);
	           
	            labelGanar.setFont(marioFuente.deriveFont(24f));
	            labelGanar.setForeground(Color.WHITE);
	        } catch (FontFormatException | IOException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void refrescar() {
 	   	revalidate();
        repaint();
	 }
}