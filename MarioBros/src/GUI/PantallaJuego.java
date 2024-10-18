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
import javax.swing.JScrollPane;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Enemigos.Enemigo;
import Logica.Entidad;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class PantallaJuego extends JPanel {

    protected ControladorVistas controladorVistas;
    protected JScrollPane panelScrollNivel;
    protected JPanel panelNivel;
    protected JPanel panelEntidades;
    protected JLabel imagenFondo;
    protected int posicionInicialX = 0;  
    protected int velocidadDesplazamiento = 10; 
    protected Timer refrescarPantalla;
    protected int maximoDerecha = 280;//ES PERFECTO
    protected int maximoIzquierda = 10;
    

    public PantallaJuego(ControladorVistas controladorVistas) {
        this.controladorVistas = controladorVistas;
        this.setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ANCHO));
        setLayout(null);
        
        agregarPanelNivel();
        agregarImagenNivel();
        mostrarPowerUps();
        mostrarEnemigos();
       
        eventosTeclado();
        setFocusable(true);
        
        iniciarTimerRefresco();
    }
    
    public void iniciarTimerRefresco() {
        // Iniciar un Timer que actualice la pantalla cada 50 ms
        refrescarPantalla = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarPosicionPersonaje();  // Refrescar posición de Mario
                actualizarFondo();  // Actualizar la posición del fondo
            }
        });
        refrescarPantalla.start();
    }

 
    
    public void agregarPanelNivel() {
    	panelNivel = new JPanel(null);
    	mostrarPersonaje();
    	mostrarPlataformas();
    	mostrarEnemigos();
    	mostrarPowerUps();
    	agregarImagenNivel();
    	panelNivel.setPreferredSize(new Dimension(imagenFondo.getIcon().getIconWidth(), ConstantesVistas.PANEL_ALTO));
    	
    	panelScrollNivel = new JScrollPane(panelNivel);
    	panelScrollNivel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScrollNivel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelScrollNivel.setBounds(posicionInicialX, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		
		panelScrollNivel.setFocusable(true);
		panelScrollNivel.requestFocusInWindow();
		
		add(panelScrollNivel);
		refrescar();
    }
    
    public void agregarImagenNivel() {
    	String ruta = controladorVistas.juego.getNivel().getSprite().getRutaImagen();
    	imagenFondo = new JLabel();
    	imagenFondo.setLayout(null);
    	ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
    	Image imagenEscalada = icono.getImage().getScaledInstance(icono.getIconWidth(), ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        imagenFondo.setIcon(iconoEscalado);
        imagenFondo.setBounds(posicionInicialX, 0, imagenFondo.getIcon().getIconWidth(), imagenFondo.getIcon().getIconHeight());
        panelNivel.add(imagenFondo);
    }
 
  
    
    public void actualizarPosicionPersonaje() {
        Personaje personaje = controladorVistas.obtenerPersonaje();
        if(personaje.getPosX() < 3350) {
        	personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO);
            //System.out.println("la pos dell pj es:"+personaje.getPosX()+" y "+personaje.getPosY());
            refrescar();
        }

    }

    // Método para mover la imagen de fondo solo en X (hacia la derecha)
    public void moverFondo(int posicionX) {
    	Personaje personaje = controladorVistas.obtenerPersonaje();
        posicionInicialX += posicionX;
        if (posicionInicialX < -imagenFondo.getIcon().getIconWidth()) {
        	posicionInicialX = -imagenFondo.getIcon().getIconWidth();
        }
        panelScrollNivel.getHorizontalScrollBar().setValue(panelScrollNivel.getHorizontalScrollBar().getValue()+personaje.getVelX());
        maximoDerecha += personaje.getVelX();
        if(controladorVistas.obtenerPersonaje().getMin() < 2780) { //Cuando el scroll esta en el final, el minimo mas alto al q llega es 2780
        	controladorVistas.obtenerPersonaje().actualizarMin();
        }
        repaint();
    }
   
    public void actualizarFondo() {
    	Personaje personaje = controladorVistas.obtenerPersonaje();
    	if(personaje.getPosX() >= maximoDerecha) {
    		moverFondo(-personaje.getVelX());
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
                actualizarPosicionPersonaje();
        		actualizarFondo();
                
            }
            public void keyReleased(KeyEvent k) {
            	controladorVistas.obtenerPersonaje().establecerDireccion(0);
            }
        });
    }
    
    public void mostrarPersonaje() {	
        Personaje personaje = controladorVistas.obtenerPersonaje();
        personaje.setVisible(true);
        //Cargar la imagen desde los SPRITES
        String ruta = personaje.getSprite().getRutaImagen();
        personaje.setIcon(verificarExtension(ruta));
        personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
        
        panelNivel.add(personaje);
        refrescar();
    }
    
    
    public void mostrarEnemigos() {
    	Enemigo enemigo;
    	while(!controladorVistas.obtenerEnemigo().isEmpty()) {
    		enemigo = controladorVistas.obtenerEnemigo().removeFirst();
    		enemigo.setVisible(true);
    		String ruta = enemigo.getSprite().getRutaImagen();
            enemigo.setIcon(verificarExtension(ruta));
            enemigo.setBounds(enemigo.getPosX(), enemigo.getPosY(), 50, 50);
            panelNivel.add(enemigo);
            refrescar();
    	}
    }
    
    public void mostrarPlataformas() {
    	Plataforma plataforma;
    	//while(!controladorVistas.obtenerPlataforma().isEmpty()) {
    		plataforma = controladorVistas.obtenerPlataforma().getFirst();
    		plataforma.setVisible(true);
    		String ruta = plataforma.getSprite().getRutaImagen();
    		plataforma.setIcon(verificarExtension(ruta));
	        plataforma.setBounds(plataforma.getPosX(), plataforma.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO);
            panelNivel.add(plataforma);
            refrescar();
    	//}
    }  
    
    public void mostrarPowerUps() {
    	PowerUps powerUp;
    	while(!controladorVistas.obtenerPowerUp().isEmpty()) {
    		powerUp = controladorVistas.obtenerPowerUp().removeFirst();
    		powerUp.setVisible(true);	
    		String ruta = powerUp.getSprite().getRutaImagen();
    		powerUp.setIcon(verificarExtension(ruta));
    		powerUp.setBounds(powerUp.getPosX(), powerUp.getPosY(), 50, 50);
    		panelNivel.add(powerUp);
            refrescar();
    	}
    }
    
    public ImageIcon verificarExtension(String ruta) {
        ImageIcon iconoEscalado;
        if(ruta.toLowerCase().endsWith(".gif")) {
            ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
            Image gifImage = icono.getImage();
            Image gifAgrandado = gifImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(gifAgrandado);
        }else{
            ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
            Image imagenEscalada = icono.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(imagenEscalada);
        }
        return iconoEscalado;
    }
    
    public void refrescar() {
    	   revalidate();
           repaint();
    }
}

