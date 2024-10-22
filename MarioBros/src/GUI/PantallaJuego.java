package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Enemigos.Enemigo;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public class PantallaJuego extends JPanel {

    protected ControladorVistas controladorVistas;
    protected JScrollPane panelScrollNivel;
    protected JPanel panelNivel;
    protected JPanel panelEntidades;
    protected JLabel imagenFondo;
    protected JLabel reloj;
    protected JLabel puntuacion;
    protected JLabel monedas;
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
        eventosTeclado();
        setFocusable(true);
        iniciarTimerRefresco();
    }
    
    public void iniciarTimerRefresco() {
        // Iniciar un Timer que actualice la pantalla cada 50 ms
        refrescarPantalla = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	actualizarImagenPersonaje();
                actualizarPosicionPersonaje();  
                actualizarFondo(); 
                reloj.setText(""+controladorVistas.juego.getReloj().getSegundos());
                monedas.setText(""+controladorVistas.juego.getPersonaje().getMonedas());
                llegoAlFinal();
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
    	agregarReloj();
    	mostrarMonedas();
    	agregarImagenNivel();
    	
    	panelNivel.setPreferredSize(new Dimension(imagenFondo.getIcon().getIconWidth(), ConstantesVistas.PANEL_ALTO));
    	
    	panelScrollNivel = new JScrollPane(panelNivel);
    	panelScrollNivel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScrollNivel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelScrollNivel.setBounds(posicionInicialX, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		
		panelScrollNivel.setFocusable(true);
		panelScrollNivel.requestFocusInWindow();
		
		add(panelScrollNivel);
		
		System.out.println("fondo mide: "+imagenFondo.getIcon().getIconWidth());
		refrescar();
    }
    
    public void actualizarPosicionMonedas(int x) {
    	monedas.setBounds(monedas.getX()+x, 10, 90, 20);
    }
    
    public void mostrarMonedas() {
    	monedas = new JLabel();
    	
    	String ruta = "/spritesOriginales/monedaQuieta.gif";
    	monedas.setIcon(verificarExtension(ruta));
    	
    	monedas.setBounds(10, 10, 90, 20);
    	monedas.setVisible(true);
    	try {
	        Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(24f);
	        monedas.setFont(marioFuente);
	        monedas.setForeground(Color.WHITE);
	    } catch (FontFormatException | IOException e) {
	        e.printStackTrace();
	    }
    	panelNivel.add(monedas);
    	refrescar();
    	
    }
    
    public void mostrarPuntuacion() {
    	
    }
    
    public void llegoAlFinal() {
    	Personaje personaje = controladorVistas.juego.getPersonaje();
    	if(personaje.getPosX() >= imagenFondo.getIcon().getIconWidth()-320) {
    		controladorVistas.juego.getNivel().cargarNivel(controladorVistas.juego.getNivel().getNivelActual()+1);
    		System.out.print("hola");
    	}
    }
    
    public void agregarReloj() {
    	reloj = new JLabel();
    	reloj.setText("TIEMPO \n"+controladorVistas.juego.getReloj().getSegundos());
    	reloj.setBounds(500, 10, 90, 20);
		reloj.setVisible(true);
		try {
		        Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(24f);
		        reloj.setFont(marioFuente);
		        reloj.setForeground(Color.WHITE);
		    } catch (FontFormatException | IOException e) {
		        e.printStackTrace();
		    }
      panelNivel.add(reloj);
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
 
    public void actualizarImagenPersonaje() {
        Personaje personaje = controladorVistas.obtenerPersonaje();
        String ruta = personaje.getSprite().getRutaImagen();
        personaje.setIcon(verificarExtension(ruta)); 
        refrescar();
    }      
    
    public void actualizarPosicionPersonaje() {
        Personaje personaje = controladorVistas.obtenerPersonaje();
        if(personaje.getPosX() < 3700) {
        	personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, personaje.getAlto());
            refrescar();
        }
    }

    public void actualizarPosicionReloj(int x) {
    	reloj.setBounds(reloj.getX()+x, 10, 90, 20);
    }
    
    public void moverFondo(int posicionX) {
    	Personaje personaje = controladorVistas.obtenerPersonaje();
        posicionInicialX += posicionX;
        //Verificar si el fondo ha llegado a su límite izquierdo
        if (posicionInicialX < -imagenFondo.getIcon().getIconWidth()) {
        	posicionInicialX = -imagenFondo.getIcon().getIconWidth();
        }
        // Desplazar el fondo solo si no ha alcanzado el límite
        if (maximoDerecha != (imagenFondo.getIcon().getIconWidth() - 320)) {
            panelScrollNivel.getHorizontalScrollBar().setValue(panelScrollNivel.getHorizontalScrollBar().getValue()+personaje.getVelX());
            actualizarPosicionReloj(personaje.getVelX());
            actualizarPosicionMonedas(personaje.getVelX());
        }
        
        maximoDerecha += personaje.getVelX();
        
        if(controladorVistas.obtenerPersonaje().getMin() < 2780) { //Cuando el scroll esta en el final, el minimo mas alto al q llega es 2780
        	controladorVistas.obtenerPersonaje().actualizarMin();
        }
        
        
        
        repaint();
    }
   
    public void actualizarFondo() {
    	Personaje personaje = controladorVistas.obtenerPersonaje();
    	
    	if(personaje.getPosX() >= maximoDerecha ) {
    		moverFondo(-personaje.getVelX());
    	}
    }
    
    public void detenerMovimientoEtiquetas() {
    	actualizarPosicionPersonaje();
    	actualizarPosicionReloj(0);
    	actualizarPosicionMonedas(0);
    }
    
    public void eventosTeclado() {
    	addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent k) {
                int keyCode = k.getKeyCode(); 
                switch(keyCode) {
                
                	case(KeyEvent.VK_D):
                		controladorVistas.obtenerPersonaje().setRight(true);
                	actualizarImagenPersonaje();
                		break;
                	case(KeyEvent.VK_A):
                		controladorVistas.obtenerPersonaje().setLeft(true);
                	actualizarImagenPersonaje();
                		break;		
                	case(KeyEvent.VK_W):
                		controladorVistas.obtenerPersonaje().setJump(true); //o llamar a saltar
                		actualizarImagenPersonaje();
                		//controladorVistas.obtenerPersonaje().saltar();
                		break;
                }
                actualizarPosicionPersonaje();
        		actualizarFondo();	
            }
            public void keyReleased(KeyEvent k) {
            	int keyCode = k.getKeyCode(); 
                switch(keyCode) {
                
            	case(KeyEvent.VK_D):
            		controladorVistas.obtenerPersonaje().setRight(false);
            	actualizarImagenPersonaje();
            		break;
            	case(KeyEvent.VK_A):
            		controladorVistas.obtenerPersonaje().setLeft(false);
            	actualizarImagenPersonaje();
            		break;		
            	case(KeyEvent.VK_W):
            		controladorVistas.obtenerPersonaje().setJump(false); //o llamar a saltar
            		//controladorVistas.obtenerPersonaje().saltar();
            		break;
            }     	
            	actualizarImagenPersonaje();
            	refrescar();
            }
        });
    }

    public void mostrarPersonaje() {	
        Personaje personaje = controladorVistas.obtenerPersonaje();
        personaje.setVisible(true);
        String ruta = personaje.getSprite().getRutaImagen();
        personaje.setIcon(verificarExtension(ruta));
        personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
        panelNivel.add(personaje);
        refrescar();
    }
    
    public void mostrarEnemigos() {
    	List<Enemigo> listaEnemigos = controladorVistas.obtenerEnemigo();
    	for(Enemigo e : listaEnemigos) {
    		e.setVisible(true);
    		String ruta = e.getSprite().getRutaImagen();
            e.setIcon(verificarExtension(ruta));
            e.setBounds(e.getPosX(), e.getPosY(), 50, 50);
            panelNivel.add(e);
            refrescar();
    	}
    }
    
    public void mostrarPlataformas() {
    	List<Plataforma> listaPlataformas = controladorVistas.obtenerPlataforma();	
    	for (Plataforma p : listaPlataformas) {
    		p.setVisible(true);
    		String ruta = p.getSprite().getRutaImagen();
    		p.setIcon(verificarExtension(ruta));
	        p.setBounds(p.getPosX(), p.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO);
            panelNivel.add(p);
            refrescar();
    	}   	
    }  
    
  
    
    public void mostrarPowerUps() {
    	List<PowerUps> listaPowerUps = controladorVistas.obtenerPowerUp();
    	for(PowerUps p : listaPowerUps) {
    		p.setVisible(true);
    		String ruta = p.getSprite().getRutaImagen();
    		p.setIcon(verificarExtension(ruta));
    		p.setBounds(p.getPosX(), p.getPosY(), 50, 50);
    		panelNivel.add(p);
            refrescar();
    	}
    }
    
    public ImageIcon verificarExtension(String ruta) {
    	Personaje personaje = controladorVistas.obtenerPersonaje();
        ImageIcon iconoEscalado;
        
        if(ruta.toLowerCase().endsWith(".gif")) {
            ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
            Image gifImage = icono.getImage();
            Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, personaje.getAlto(), Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(gifAgrandado);
        }else{
            ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
            Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, personaje.getAlto(), Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(imagenEscalada);
        }
        
        return iconoEscalado;
    }
    
    public void refrescar() {
    	   revalidate();
           repaint();
    }
    
}

