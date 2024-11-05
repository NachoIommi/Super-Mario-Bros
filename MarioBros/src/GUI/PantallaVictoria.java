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

public class PantallaVictoria extends JPanel{
	
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	protected JButton botonVerRanking;
	protected JButton botonVolver;
	
	 public PantallaVictoria(ControladorVistas controladorVistas) {
	    	this.controladorVistas = controladorVistas;
	    	this.setSize(600,500);
			this.setLayout(null);
			this.setVisible(true);
			this.setBackground(Color.BLACK);
			agregarBotonVolver();
			agregarBotonVerRanking();
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
	 
	 public void agregarBotonVerRanking() {
	        botonVerRanking = new JButton("Ver Ranking");
	        botonVerRanking.setBounds(330, 50, 300, 20);  
	        botonVerRanking.setVisible(true);
	        
	        try {
	            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(13f);
	            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            ge.registerFont(marioFuente);
	            botonVerRanking.setFont(marioFuente);
	            botonVerRanking.setForeground(Color.WHITE);
	        } catch (FontFormatException | IOException e) {
	            e.printStackTrace();
	        }
	        
	        botonVerRanking.setOpaque(false);  
	        botonVerRanking.setContentAreaFilled(false);  
	        botonVerRanking.setBorderPainted(false);
	        botonVerRanking.setFocusPainted(false);  

	        registrarOyenteBotonVerRanking();
	        this.add(botonVerRanking);
	    }
	 public void agregarBotonVolver() {
	        botonVolver = new JButton("Volver");
	        botonVolver.setBounds(440, 8, 140, 50);  
	        botonVolver.setVisible(true);
	   
	        botonVolver.setFont(new Font("Arial", Font.BOLD, 16));  
	        botonVolver.setForeground(Color.BLACK);  
	        try {
	            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(13f);
	            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	            ge.registerFont(marioFuente);
	            botonVolver.setFont(marioFuente);
	            botonVolver.setForeground(Color.WHITE);
	        } catch (FontFormatException | IOException e) {
	            e.printStackTrace();
	        }
	        
	        botonVolver.setOpaque(false); 
	        botonVolver.setContentAreaFilled(false);
	        botonVolver.setBorderPainted(false); 
	        botonVolver.setFocusPainted(false); 
	        
	        registrarOyenteBotonVolver();
	        add(botonVolver);
	    }
	    
	 public void registrarOyenteBotonVerRanking() {
	    botonVerRanking.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            controladorVistas.mostrarPantallaRanking(); 
	        }
	    });   
	}
    public void registrarOyenteBotonVolver() {
		botonVolver.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            controladorVistas.mostrarPantallaPrincipal(); 
	        }
	    });   
	}
}