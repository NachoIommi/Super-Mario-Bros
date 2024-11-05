
package GUI;
import java.awt.Color;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import java.io.IOException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Jugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaRanking extends JPanel{
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	protected JButton botonVolver;
	protected JTextField ranking;
	

    public PantallaRanking(ControladorVistas controladorVistas) {
    	this.controladorVistas = controladorVistas;
    	this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		mostrarRanking();
		agregarBotonVolver();
        agregarImagen();  
        
    }
    
    public void agregarImagen() {
		String ruta = "imagenesOriginales/img/RANKING.jpg";
		imagenInicio = new JLabel();
		imagenInicio.setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		ImageIcon icono = new ImageIcon(ruta);
		Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoEscalado);
		this.add(imagenInicio);
	}
    
    public void agregarBotonVolver() {
        botonVolver = new JButton("Volver");
        botonVolver.setBounds(440, 8, 140, 50);  // Ajusta el tamaño según la fuente que uses
        botonVolver.setVisible(true);
        // Configura una fuente personalizada
        botonVolver.setFont(new Font("Arial", Font.BOLD, 16));  // Cambia "Arial" y el tamaño a tu gusto
        botonVolver.setForeground(Color.BLACK);  // Color de texto en negro
        try {
            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(13f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(marioFuente);
            botonVolver.setFont(marioFuente);
            botonVolver.setForeground(Color.WHITE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        botonVolver.setOpaque(false);  // Fondo transparente
        botonVolver.setContentAreaFilled(false);  // Sin relleno
        botonVolver.setBorderPainted(false);  // Sin borde
        botonVolver.setFocusPainted(false);  // Sin borde de enfoque
        
        registrarOyenteBotonVolver();
        add(botonVolver);
    }
    
    public void registrarOyenteBotonVolver() {
		botonVolver.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            controladorVistas.mostrarPantallaPrincipal(); 
	        }
	    });   
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
    
    public void refrescar() {
 	   	revalidate();
        repaint();
    }

}