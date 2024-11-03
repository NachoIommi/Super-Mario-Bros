package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Enemigos.Enemigo;
import Logica.BolaDeFuego;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class PantallaJuego extends JPanel {
	
	private ControladorVistas controladorVistas;
    private List<Enemigo> copiaEnemigos;
    //
    private List<BolaDeFuego> copiaBolas;
    //
    //List<Enemigo> copiaEnemigos = new CopyOnWriteArrayList<>();
    private List<Plataforma> copiaPlataformas;
    private List<PowerUp> copiaPowerUps;
    private JScrollPane panelScrollNivel;
    private JLayeredPane panelNivel;
    private JLabel imagenFondo;
    private JLabel reloj;
    private JLabel puntuacion;
    private JLabel vidas;
    private JLabel monedas;
    private JLabel bandera;
    private Timer timerBandera;
    private Timer refrescarPantalla;
    private Personaje personaje;
    private int posicionInicialX = 0;  
    private float maximoDerecha = 298.0f;
    private boolean banderaActualizada = false;
    private boolean nivelGanado = false;
    private boolean pantallaCorriendo = false;

    public PantallaJuego(ControladorVistas controladorVistas) {
        this.controladorVistas = controladorVistas;
        this.setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ANCHO));
        setLayout(null);
        agregarPanelNivel();  
        eventosTeclado();
        setFocusable(true);
        iniciarTimerRefresco();
        copiaBolas= new CopyOnWriteArrayList<>(controladorVistas.obtenerBolas());
        pantallaCorriendo = true;
    }
    
    public void agregarPanelNivel() {
    	panelNivel = new JLayeredPane();
    	agregarImagenNivel();
    	mostrarPersonaje();
    	mostrarPlataformas();
    	mostrarEnemigos();
    	mostrarPowerUps();
    	mostrarReloj();
    	mostrarMonedas();
    	mostrarBandera();
    	mostrarPuntuacion();
    	mostrarVidas();
    	panelNivel.setPreferredSize(new Dimension(imagenFondo.getIcon().getIconWidth(), ConstantesVistas.PANEL_ALTO));
    	
    	panelScrollNivel = new JScrollPane(panelNivel);
    	panelScrollNivel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScrollNivel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		panelScrollNivel.setBounds(posicionInicialX, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		panelScrollNivel.setFocusable(true);
		panelScrollNivel.requestFocusInWindow();
		add(panelScrollNivel, Integer.valueOf(1));
		
		refrescar();
    }
      
    public void iniciarTimerRefresco() {
        refrescarPantalla = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
            	if(pantallaCorriendo) {
	            		if(personaje.getPosX() < imagenFondo.getWidth()-320) {
	                		
	            			mostrarBolas();
	            			
	                		actualizarPosicionPersonaje();
	                		actualizarPosicionEnemigos();
	                		actualizarPosicionReloj(0);
	                		actualizarPosicionPuntuacion(0);
	                		actualizarPosicionVidas(0);
	                		actualizarPosicionMonedas(0);
	                        actualizarPosBolas();	                		
	                        actualizarFondo(); 
	                        actualizarImagenPersonaje();
	                        actualizarImagenPlataformas();
	                        actualizarImagenPowerUps();
	                        actualizarImagenEnemigos();            
	                	}
	                    llegoAlFinal();
	                }
            	}
        });
        refrescarPantalla.start();
    }
    public void setPantallaCorriendo(boolean b) {
    	pantallaCorriendo = b;
    }
    
    public void llegoAlFinal() {
        if (personaje != null && personaje.getPosX() >= imagenFondo.getIcon().getIconWidth() - 320 && !nivelGanado) {
        	nivelGanado = true;
        	if(!banderaActualizada) {
        		actualizarImagenBandera();
                banderaActualizada = true;
                personaje.tocarBandera();
        	}      	           
            if (timerBandera != null && timerBandera.isRunning()) {
                return;
            }                        
            timerBandera = new Timer(1050, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	timerBandera.stop();                     
                    controladorVistas.iniciarSiguienteNivel();                   
                }
            });
            timerBandera.setRepeats(false); 
            timerBandera.start();           
        }  
    }
   
    //MOSTRAR LABELS 
    
    public void mostrarBolas() {
    	
    	if(copiaBolas.size()!=controladorVistas.obtenerBolas().size()){
    		copiaBolas= new CopyOnWriteArrayList<>(controladorVistas.obtenerBolas());
		    if(!copiaBolas.isEmpty()){
		    	BolaDeFuego bola = copiaBolas.getLast();
			    		bola.setVisible(true);
			    		String ruta = bola.getSprite().getRutaImagen();
			    		ImageIcon iconoEscalado;
			    		ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
			            Image gifImage = icono.getImage();
			            Image gifAgrandado = gifImage.getScaledInstance(15,15, Image.SCALE_DEFAULT);
			            iconoEscalado = new ImageIcon(gifAgrandado);        
			            bola.setIcon(iconoEscalado);
			            bola.setBounds(bola.getPosX(), bola.getPosY(), 15,15);
			            panelNivel.add(bola, Integer.valueOf(1));
			    	}
    	}	
    }
    
    public void actualizarPosBolas() {
    	if(copiaBolas.size()>0) {
        	for(BolaDeFuego e : copiaBolas) {
        		e.setLocation(e.getPosX(), e.getPosY());	
        	}
    	}
    }
    
    public void actualizarImagenBolas() {
    	if(copiaBolas.size()>0) {
	    	for(BolaDeFuego enemigo : copiaBolas) {   		
		    	String ruta = enemigo.getSprite().getRutaImagen();
		    	enemigo.setIcon(verificarExtension(ruta));
		    	enemigo.setBounds(enemigo.getPosX(), enemigo.getPosY(), 15, 15);		
		    	enemigo.setSpriteActualizado(false);
	    	}
    	}
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
        panelNivel.add(imagenFondo, Integer.valueOf(0));
    }
    
    public void mostrarPersonaje() {	
    	if(personaje == null) {
    		personaje = controladorVistas.obtenerPersonaje();
            personaje.setVisible(true);
            String ruta = personaje.getSprite().getRutaImagen();
            personaje.setIcon(verificarExtension(ruta));
            personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
            panelNivel.add(personaje, Integer.valueOf(1));
    	}    
    }
    
    public void mostrarEnemigos() {
    	//copiaEnemigos = new ArrayList<Enemigo>(controladorVistas.obtenerEnemigo());
    	copiaEnemigos = new CopyOnWriteArrayList<>(controladorVistas.obtenerEnemigo());
    	if (!copiaEnemigos.isEmpty()) {
    		for(Enemigo e : copiaEnemigos) {
        		e.setVisible(true);
        		String ruta = e.getSprite().getRutaImagen();
                e.setIcon(verificarExtension(ruta));
                e.setBounds(e.getPosX(), e.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
                panelNivel.add(e, Integer.valueOf(1));
        	}
    	}
    	
    }
    
    public void mostrarPlataformas() {
    	copiaPlataformas = new ArrayList<Plataforma>(controladorVistas.juego.getPlataformas());
    	for (Plataforma p : copiaPlataformas) {
    		p.setVisible(true);
    		String ruta = p.getSprite().getRutaImagen();
    		p.setIcon(verificarExtension(ruta));
	        p.setBounds(p.getPosX(), p.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO);
            panelNivel.add(p, Integer.valueOf(1));
    	}   	
    }  
    
    public void mostrarPowerUps() {
    	copiaPowerUps = new ArrayList<PowerUp>(controladorVistas.obtenerPowerUp());
    	for(PowerUp powerUp : copiaPowerUps) {
    		powerUp.setBounds(powerUp.getPosX(), powerUp.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO);
    		panelNivel.add(powerUp, Integer.valueOf(1));
    	}
    }
    
    public void mostrarBandera() {
    	bandera = new JLabel();
    	String ruta = "/spritesOriginales/banderaBajando1.png";    	
    	ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
    	Image imagenEscalada = icono.getImage().getScaledInstance(30, 300, Image.SCALE_DEFAULT);
    	ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
    	bandera.setIcon(iconoEscalado);
    	bandera.setBounds(imagenFondo.getWidth()-320, 30, 30, 500);
    	panelNivel.add(bandera, Integer.valueOf(1));
    }
    
    public void mostrarMonedas() {
    	if(personaje != null) {
    		monedas = new JLabel();
        	monedas.setText("" + personaje.getMonedas());
        	String ruta = "/spritesOriginales/monedaQuieta.gif";
        	monedas.setIcon(verificarExtension(ruta));
        	monedas.setBounds(10, 10, 150, 50);
        	monedas.setVisible(true);
        	try {
    	        Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(20f);
    	        monedas.setFont(marioFuente);
    	        monedas.setForeground(Color.WHITE);
    	    } catch (FontFormatException | IOException e) {
    	        e.printStackTrace();
    	    }
        	panelNivel.add(monedas, Integer.valueOf(1));
    	}
    }
    
    public void mostrarReloj() {
    	if(personaje != null) {
    		reloj = new JLabel();
        	reloj.setText("<html><div style='text-align: center;'>Reloj<br>" + controladorVistas.juego.getReloj().getSegundos() + "</div></html>");
        	reloj.setBounds(500, 10, 150, 50);
    		reloj.setVisible(true);
    		try {
    		        Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(14f);
    		        reloj.setFont(marioFuente);
    		        reloj.setForeground(Color.WHITE);
    		    } catch (FontFormatException | IOException e) {
    		        e.printStackTrace();
    		    }
          panelNivel.add(reloj, Integer.valueOf(1));
    	}
    }
    
    public void mostrarVidas() {
    	if(personaje != null) {
    		vidas = new JLabel();
            vidas.setText("<html><div style='text-align: center;'>Vidas<br>" + personaje.getVidas()+ "</div></html>");
            vidas.setBounds(350, 10, 150, 50); 
            vidas.setVisible(true);       
            try {
                Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(14f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(marioFuente);
                vidas.setFont(marioFuente);
                vidas.setForeground(Color.WHITE);
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }        
            panelNivel.add(vidas, Integer.valueOf(1));
    	}
    }
    
    public void mostrarPuntuacion() {
    	if(personaje != null) {
    		puntuacion = new JLabel();
        	puntuacion.setText("<html><div style='text-align: center;'>Puntuacion<br> " + personaje.getPuntuacion() + "</div></html>");
        	puntuacion.setBounds(130, 10, 150, 50);
        	puntuacion.setVisible(true);
    		try {
    		        Font marioFuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/SuperMarioBros.2.ttf")).deriveFont(14f);
    		        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	            ge.registerFont(marioFuente);
    		        puntuacion.setFont(marioFuente);
    		        puntuacion.setForeground(Color.WHITE);
    		    } catch (FontFormatException | IOException e) {
    		        e.printStackTrace();
    		    }
          panelNivel.add(puntuacion, Integer.valueOf(1));
    	}
    }
    
   // ACTUALIZAR POSICIONES  
    public void actualizarPosicionImagenFondo(int x) {
    	imagenFondo.setLocation(imagenFondo.getX() + x, 0);   	
    }
    
    public void actualizarPosicionPersonaje() {
        if(personaje != null && personaje.getPosX() < imagenFondo.getIcon().getIconWidth()-320 && !nivelGanado) {
        	personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, personaje.getAlto());
        }
    }
    
    public void actualizarPosicionEnemigos() {
    	if(!copiaEnemigos.isEmpty()) {
    		for(Enemigo enemigo : copiaEnemigos) {
        		enemigo.setLocation(enemigo.getPosX(), enemigo.getPosY());	
        	}
    	}
    }
    
    public void actualizarPosicionMonedas(int x) {
    	if(personaje != null) {
    		monedas.setBounds(monedas.getX()+x, 10, 150, 50);
        	monedas.setText("" + personaje.getMonedas() );
    	}
    }
    
    public void actualizarPosicionVidas(int x) {
    	if(personaje != null) {
    		vidas.setText("<html><div style='text-align: center;'>Vidas<br>" + personaje.getVidas()+ "</div></html>");
        	vidas.setBounds(vidas.getX()+x, 10, 150, 50);
    	}
    	
    }
    
    public void actualizarPosicionPuntuacion(int x) {
    	if(personaje != null) {
    		puntuacion.setText("<html><div style='text-align: center;'>Puntuacion<br> " + personaje.getPuntuacion() + "</div></html>");
        	puntuacion.setBounds(puntuacion.getX()+x, 10, 150, 50);  
    	}
    }
    
    public void actualizarPosicionReloj(int x) {
    	if(personaje != null) {
    		reloj.setText("<html><div style='text-align: center;'>Reloj<br>" + controladorVistas.juego.getReloj().getSegundos() + "</div></html>");
        	reloj.setBounds(reloj.getX()+x, 10, 150, 50);
    	}	
    }
    
    // ACTUALIZAR IMAGENES
    
    public void actualizarImagenPersonaje() {
    	if(personaje != null && personaje.necesitaActualizarSprite()) {
    		String ruta = personaje.getSprite().getRutaImagen();
            personaje.setIcon(verificarExtensionPersonaje(ruta)); 
            personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ALTO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
            personaje.setSpriteActualizado(false);
    	}     
    } 
    
    public void actualizarImagenEnemigos(){
    	//copiaEnemigos = controladorVistas.obtenerEnemigo();
    	if(!copiaEnemigos.isEmpty()) {
    		for(Enemigo enemigo : copiaEnemigos) {
        		if(enemigo.mostrable() && enemigo.necesitaActualizarSprite()) {   		
    	    		String ruta = enemigo.getSprite().getRutaImagen();
    	    		enemigo.setIcon(verificarExtension(ruta));
    	    		enemigo.setBounds(enemigo.getPosX(), enemigo.getPosY(), 30, 30);		
    	    		enemigo.setSpriteActualizado(false);
        		} else if (!enemigo.mostrable()){
        			enemigo.setVisible(false);
        		}	
        	}
    	}
    }
    
    public void actualizarListaEnemigos() {
    	if(copiaEnemigos.size() != controladorVistas.obtenerEnemigo().size() && !copiaEnemigos.isEmpty()) {
			copiaEnemigos = new CopyOnWriteArrayList<>(controladorVistas.obtenerEnemigo());
        	Enemigo e1 = copiaEnemigos.getLast();
        	e1.setVisible(true);
    		String ruta = e1.getSprite().getRutaImagen();
            e1.setIcon(verificarExtension(ruta));
            e1.setBounds(e1.getPosX(), e1.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
            panelNivel.add(e1, Integer.valueOf(1));        	
        }
    }
    
    public void actualizarImagenPlataformas() {	
    	for (Plataforma plataforma : copiaPlataformas) {
    		if(plataforma.getSprite()==null) {
    			plataforma.setVisible(false);
    		}
    		if(plataforma.cambioEstado()) {
    			String ruta = plataforma.getSprite().getRutaImagen();
    			plataforma.setIcon(verificarExtension(ruta)); 
    		}  	
    	}
    }
    
    public void actualizarImagenPowerUps() {
    	for(PowerUp powerUp : copiaPowerUps) {
    		if(powerUp.mostrable()) {   			
	    		powerUp.setVisible(true);
	    		String ruta = powerUp.getSprite().getRutaImagen();
	    		powerUp.setIcon(verificarExtension(ruta));
	    		powerUp.setBounds(powerUp.getPosX(), powerUp.getPosY(), 30, 30);
    		}
    		else 
    			powerUp.setVisible(false);
    	}
    }
    
    public void actualizarImagenBandera() {
    	System.out.println("se actualizo bandera");
    	String ruta = "/spritesOriginales/banderaBajando.gif";
    	ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image gifImage = icono.getImage();
        Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, 300, Image.SCALE_DEFAULT);
        ImageIcon iconoEscalado = new ImageIcon(gifAgrandado);
        bandera.setIcon(iconoEscalado);
    }
    
    // COMANDOS UTILES
    public void moverFondo(int velocidad) {
    	int mitadAnchoVentana = panelScrollNivel.getViewport().getWidth() / 2;
    	System.out.println("mitad"+mitadAnchoVentana	);
    	System.out.println("maximo: "+maximoDerecha	);
    	System.out.println("minimo: "+personaje.getMin());
        
        if (maximoDerecha <= (imagenFondo.getIcon().getIconWidth() - 320) && personaje.getVelX()>=0) {
            panelScrollNivel.getHorizontalScrollBar().setValue(panelScrollNivel.getHorizontalScrollBar().getValue()+velocidad);
            actualizarPosicionReloj(velocidad);
            actualizarPosicionMonedas(velocidad);
            actualizarPosicionPuntuacion(velocidad);
            actualizarPosicionVidas(velocidad);         
            maximoDerecha += velocidad;
            personaje.actualizarMin();
        }      
        repaint();
    }
   
    public void actualizarFondo() {
    	if(personaje != null) {
    		int velocidad = Math.round(personaje.getVelX());
        	if(personaje.getPosX() >= maximoDerecha-10 ) {
        		moverFondo(velocidad);	
        	}
    	}    	
    }
 
    public void eventosTeclado() {
    	if(!nivelGanado && personaje != null) {
    		addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent k) {
                    int keyCode = k.getKeyCode(); 
                    switch(keyCode) {
                    	case(KeyEvent.VK_D):
                    		personaje.setRight(true);
                    		break;
                    	case(KeyEvent.VK_A):
                    		personaje.setLeft(true);
                    		break;		
                    	case(KeyEvent.VK_W):
                    		personaje.setJump(true);
                    		break;
                    	case(KeyEvent.VK_SPACE):
                    		personaje.disparar();
                    }
                }
                public void keyReleased(KeyEvent k) {
                	int keyCode = k.getKeyCode(); 
                    switch(keyCode) {
                	case(KeyEvent.VK_D):
                		personaje.setRight(false);               	
                		break;
                	case(KeyEvent.VK_A):
                		personaje.setLeft(false);               	
                		break;		
                	case(KeyEvent.VK_W):
                		personaje.setJump(false); 
                		break;
                }     	
                }
            });
    	}
    	refrescar();	
    }
 
    public ImageIcon verificarExtensionPersonaje(String ruta) {
    	 ImageIcon iconoEscalado;
    	 if(personaje.getHitbox().getHeight()>= ConstantesVistas.PERSONAJE_SUPER_TAMANO_ALTO) {
    		 if(ruta.toLowerCase().endsWith(".gif")) {
                 ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
                 Image gifImage = icono.getImage();
                 Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.PERSONAJE_SUPER_TAMANO_ALTO, Image.SCALE_DEFAULT);
                 iconoEscalado = new ImageIcon(gifAgrandado);
             }else{
                 ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
                 Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.PERSONAJE_SUPER_TAMANO_ALTO, Image.SCALE_DEFAULT);
                 iconoEscalado = new ImageIcon(imagenEscalada);
             }
    	 }else {
    		 if(ruta.toLowerCase().endsWith(".gif")) {
                 ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
                 Image gifImage = icono.getImage();
                 Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO, Image.SCALE_DEFAULT);
                 iconoEscalado = new ImageIcon(gifAgrandado);
             }else{
                 ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
                 Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO, Image.SCALE_DEFAULT);
                 iconoEscalado = new ImageIcon(imagenEscalada);
             }
    	 } 
         return iconoEscalado;
     }
    
    public ImageIcon verificarExtension(String ruta) {
        ImageIcon iconoEscalado;
        
        if(ruta.toLowerCase().endsWith(".gif")) {
            ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
            Image gifImage = icono.getImage();
            Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO, Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(gifAgrandado);
        }else{
            ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
            Image imagenEscalada = icono.getImage().getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO, Image.SCALE_DEFAULT);
            iconoEscalado = new ImageIcon(imagenEscalada);
        }
        return iconoEscalado;
    }
 
    public void refrescar() {
    	   revalidate();
           repaint();
    }
 
}
