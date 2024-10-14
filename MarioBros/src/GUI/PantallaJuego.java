package GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Entidad;
// numero 3376
// numero 240
import Personaje.Personaje;

public class PantallaJuego extends JPanel {

    protected ControladorVistas controladorVistas;
    protected JLabel imagenFondo;
    protected int posicionInicialX = 0;  
    protected int velocidadDesplazamiento = 10; 

    public PantallaJuego(ControladorVistas controladorVistas) {
        this.controladorVistas = controladorVistas;
        this.setPreferredSize(new Dimension(1600, 600));
        
        setLayout(null);  // Usar layout nulo para posicionamiento manual
          
        mostrarPersonaje(); // el orden importa, si primero va el personaje se superpone al fondo
        agregarImagen();   // Agregar la imagen de fondo
        eventosTeclado();
       
        setFocusable(true);  // Permite que el panel capture los eventos del teclado
    }

    public void agregarImagen() {
        // Crear el JLabel para la imagen de fondo
        imagenFondo = new JLabel();
        imagenFondo.setLayout(null);  // Sin layout para posicionar manualmente
        imagenFondo.setBounds(posicionInicialX, 0, 1600, 930);  // Posicionar la imagen en el panels

        // Cargar la imagen desde los recursos
        ImageIcon icono = new ImageIcon(this.getClass().getResource("/img/nivel1.png"));
        Image imagenEscalada = icono.getImage().getScaledInstance(5000, 960, Image.SCALE_SMOOTH);  // Escalar imagen al tamaño adecuado
        Icon iconoEscalado = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoEscalado);  // Establecer la imagen escalada en el JLabel
       
        // Agregar la imagen al panel
        add(imagenFondo);
    }

    // Método para mover la imagen de fondo solo en X (hacia la derecha)
    public void moverFondo(int posicionX) {
        posicionInicialX += posicionX;  // Actualiza la posición en X

        // Limitar el movimiento para que no salga del área visible
        if (posicionInicialX < -4340) posicionInicialX = -4340;  // Limitar movimiento hacia la derecha

        // Actualizar la posición de la imagen de fondo
        imagenFondo.setBounds(posicionInicialX, 0, 5000, 930);
        repaint();  // Redibuja el panel para reflejar el cambio
    }
    public void mostrarPersonaje() {
    	
        Personaje personaje = controladorVistas.obtenerPersonaje();
        personaje.setVisible(true);
        
        // Cargar la imagen desde los recursos
        ImageIcon icono = new ImageIcon(this.getClass().getResource("/spritesMario/quietoNormal.png"));
        Image imagenEscalada = icono.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imagenEscalada);
      
        personaje.setIcon(iconoEscalado);
        personaje.setBounds(personaje.getPosX(),personaje.getPosY(),50,50);
        add(personaje);
        revalidate();
        repaint();
    }
    public void actualizarPosicionPersonaje() {
        Personaje personaje = controladorVistas.obtenerPersonaje();
        personaje.setBounds(personaje.getPosX(), personaje.getPosY(), 50, 50); // Actualiza la posición
        revalidate(); // Para recalcular el layout
        repaint();    // Redibuja el panel
    }
    public void actualizarFondo() {
    	// if pos de pj es mayor a 300 moverFondo
    	Personaje personaje = controladorVistas.obtenerPersonaje();
    	if(personaje.getPosX() == 285) {
    		moverFondo(-velocidadDesplazamiento);
    	}
    }
    public void eventosTeclado() {
    
    	addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent k) {
                int keyCode = k.getKeyCode();
                
                switch(keyCode) {
                
                	case(KeyEvent.VK_D):
                		controladorVistas.obtenerPersonaje().establecerDireccion(1);
                		break;
                			
                	case(KeyEvent.VK_A):
                		controladorVistas.obtenerPersonaje().establecerDireccion(3);
                		break;		
                }
                actualizarPosicionPersonaje();  // Actualiza la posición del personaje
                actualizarFondo();
            }
            
            public void keyReleased(KeyEvent k) {
            	controladorVistas.obtenerPersonaje().establecerDireccion(0);
            }
        });
    	
    }
    
    	
  
    
      
}

