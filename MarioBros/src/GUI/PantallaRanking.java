package GUI;
import java.awt.Color;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import java.io.IOException;



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
	protected JButton botonModoMario;
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
		String ruta = "imagenesOriginales/img/ranking.jpg";
		imagenInicio = new JLabel();
		imagenInicio.setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		ImageIcon icono = new ImageIcon(ruta);
		Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_DEFAULT);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoEscalado);
		this.add(imagenInicio);
	}
    
    public void agregarBotonVolver() {
        botonVolver = new JButton("Volver");
        botonVolver.setBounds(-15, 20, 140, 50);  // Ajusta el tamaño según la fuente que uses
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
	        	System.out.println("volvi");
	            controladorVistas.mostrarPantallaPrincipal(); 
	        }
	    });   
	}
    
    public void refrescar() {
 	   revalidate();
        repaint();
    }
    
    public void mostrarRanking() {
        ranking = new JTextField();
        ranking.setEditable(false);
        ranking.setBounds(150, 280, 300, 300);
        ranking.setBorder(null);
        ranking.setBackground(Color.WHITE);
        ranking.setFont(new Font("Arial", Font.PLAIN, 14)); // Ajusta la fuente según sea necesario
        
        controladorVistas.obtenerJuego().getRanking().ordenarTopCinco();
       // System.out.println(controladorVistas.obtenerJuego().getRanking().mostrarTopCinco().toString());

        String top = ""; // Usar StringBuilder para mejorar el rendimiento
        for (Jugador j : controladorVistas.obtenerJuego().getRanking().mostrarTopCinco()) {
            //top.append(j.toString()).append("\n"); // Usar StringBuilder para construir la cadena
        	top += j.toString()+"\n";
        }

        ranking.setText(top.toString()); // Establecer el texto del JTextField al contenido del ranking
        this.add(ranking);
    }
    
    
    
}
