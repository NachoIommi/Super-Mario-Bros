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
		Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
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
    	//JLabel j1 = new JLabel("Jugador j1 ");
    	//JLabel j2 = new JLabel("Jugador j2 ");
    	JLabel[] labelJugadores = new JLabel[5];
        for (int j = 0; j < labelJugadores.length; j++) {
            labelJugadores[j] = new JLabel(); // Crear un nuevo JLabel
            labelJugadores[j].setBounds(30, 280 + (j * 30), 150, 50); // Ajustar la posición vertical
            labelJugadores[j].setVisible(true); // Hacer visible el JLabel
            add(labelJugadores[j]); // Añadir el JLabel al contenedor
        }
       // j1.setBounds(30, 280, 150, 50); // Asegúrate de que estas dimensiones sean adecuadas
        //j1.setVisible(true);
        
        controladorVistas.obtenerJuego().getRanking().ordenarTopCinco();
        try {
            Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(marioFuente);
            for (JLabel label : labelJugadores) {
                label.setFont(marioFuente);
                label.setForeground(Color.WHITE);
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        // Actualizar los JLabels con los datos de los jugadores en orden inverso
        List<Jugador> topCinco = controladorVistas.obtenerJuego().getRanking().mostrarTopCinco();
        int j = topCinco.size(); // Obtener el tamaño de la lista de jugadores
        for (int i = 0; i < labelJugadores.length; i++) {
            if (i < j) { // Asegurarse de no acceder fuera de los límites
                Jugador jugador = topCinco.get(j - 1 - i); // Acceder en orden inverso
                labelJugadores[i].setText(jugador.getNombre() + " " + jugador.getPuntaje());
            } else {
                labelJugadores[i].setText(""); // Limpiar el JLabel si no hay suficientes jugadores
            }
        }

        revalidate(); // Revalidar el contenedor
        repaint();    // Redibujar el contenedor
      
        
        /* ranking = new JTextField();
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
        */
    }
    
    
    
}
