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
	protected JButton botonReiniciar;
	
	public PantallaPerder(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		agregarBotonReiniciar();
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
	
	public void agregarBotonReiniciar() {
        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setBounds(-15, 20, 240, 50);  // Ajusta el tamaño según la fuente que uses
        botonReiniciar.setVisible(true);
        // Configura una fuente personalizada
        botonReiniciar.setFont(new Font("Arial", Font.BOLD, 16));  // Cambia "Arial" y el tamaño a tu gusto
        botonReiniciar.setForeground(Color.BLACK);  // Color de texto en negro
        try {
            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(13f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(marioFuente);
            botonReiniciar.setFont(marioFuente);
            botonReiniciar.setForeground(Color.WHITE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        botonReiniciar.setOpaque(false);  // Fondo transparente
        botonReiniciar.setContentAreaFilled(false);  // Sin relleno
        botonReiniciar.setBorderPainted(false);  // Sin borde
        botonReiniciar.setFocusPainted(false);  // Sin borde de enfoque
        
        registrarOyenteBotonReiniciar();
        add(botonReiniciar);
    }
    
    public void registrarOyenteBotonReiniciar() {
		botonReiniciar.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("volvi");
	            controladorVistas.mostrarPantallaModoDeJuego(); 
	        }
	    });   
	}
	
}
