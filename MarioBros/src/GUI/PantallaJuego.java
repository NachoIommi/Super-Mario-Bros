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
    protected JLabel vidas;
    protected JLabel monedas;
    protected Personaje personaje;
    protected int posicionInicialX = 0;  
    protected int velocidadDesplazamiento = 10; 
    protected Timer refrescarPantalla;
    protected float maximoDerecha = 280.0f;//ES PERFECTO
    protected int maximoIzquierda = 10;
    protected JLabel bandera;
    protected Timer timer;
    protected List<Enemigo> copiaEnemigos;
    protected List<Plataforma> copiaPlataformas;
    protected List<PowerUps> copiaPowerUps;
    private boolean banderaActualizada = false;
    private boolean nivelGanado = false;
    

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
        refrescarPantalla = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {          	
                actualizarPosicionPersonaje();
                actualizarFondo(); 
                actualizarImagenPersonaje();
                actualizarImagenPlataformas();
                actualizarImagenPowerUps();
                actualizarImagenEnemigos();
               // actualizarImagenPersonaje();
                actualizarPosicionEnemigos();
                reloj.setText("<html><div style='text-align: center;'>Reloj<br>" + controladorVistas.juego.getReloj().getSegundos() + "</div></html>");
                monedas.setText("" + controladorVistas.juego.getPersonaje().getMonedas() );    
                puntuacion.setText("<html><div style='text-align: center;'>Puntuación<br> " + controladorVistas.juego.getPersonaje().getPuntuacion() + "</div></html>");
                vidas.setText("<html><div style='text-align: center;'>Vidas<br>" + controladorVistas.juego.getPersonaje().getVidas()+ "</div></html>");
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
    	agregarBandera();
    	mostrarPuntuacion();
    	mostrarVidas();
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
    	monedas.setBounds(monedas.getX()+x, 10, 150, 50);
    }
    
    public void mostrarMonedas() {
    	monedas = new JLabel();
    	
    	String ruta = "/spritesOriginales/monedaQuieta.gif";
    	monedas.setIcon(verificarExtension(ruta));
    	
    	monedas.setBounds(10, 10, 150, 50);
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
    
    public void actualizarPosicionVidas(int x) {
    	vidas.setBounds(vidas.getX()+x, 10, 150, 50);
    }
    
    public void mostrarVidas() {
        vidas = new JLabel("Vidas: " + controladorVistas.juego.getPersonaje().getVidas());
        vidas.setBounds(350, 10, 150, 50); // Asegúrate de que estas dimensiones sean adecuadas
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
        
        panelNivel.add(vidas);
        panelNivel.revalidate();
        panelNivel.repaint(); 
    }
    
    
    
    public void actualizarPosicionPuntuacion(int x) {
    	puntuacion.setBounds(puntuacion.getX()+x, 10, 150, 50);
    	
    }
    
    public void mostrarPuntuacion() {
    	puntuacion = new JLabel();
    	puntuacion.setText("PUNTUACION \n"+controladorVistas.juego.getPersonaje().getPuntuacion());
    	puntuacion.setBounds(150, 10, 150, 50);
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
      panelNivel.add(puntuacion);
      puntuacion.revalidate(); // Forzar la validación del componente
      puntuacion.repaint(); // Forzar el repintado del componente
      refrescar();
    }
    
   
    
    
    public void actualizarBandera() {
    	System.out.println("se actualizo bandera");
    	String ruta = "/spritesOriginales/banderaBajando.gif";
    	ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image gifImage = icono.getImage();
        Image gifAgrandado = gifImage.getScaledInstance(ConstantesVistas.ENTIDAD_TAMANO_ANCHO, 300, Image.SCALE_DEFAULT);
        ImageIcon iconoEscalado = new ImageIcon(gifAgrandado);
        bandera.setIcon(iconoEscalado);
  
    }
    
    public void llegoAlFinal() {
        if (personaje.getPosX() >= imagenFondo.getIcon().getIconWidth() - 320 && !nivelGanado) {
            
        	nivelGanado = true;
        	
        	
            // Cambiar la imagen de la bandera
        	if(!banderaActualizada) {
        		actualizarBandera();
                banderaActualizada = true;
        	}
        	
        	
            

            // Verifica si el timer ya está creado y corriendo
            if (timer != null && timer.isRunning()) {
                return; // Si ya está corriendo, no hacemos nada
            }
            
            // Iniciar un Timer para esperar 3 segundos y luego ejecutar el siguiente nivel
            timer = new Timer(1050, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop(); // Detener el Timer
                    controladorVistas.iniciarSiguienteNivel(); // Iniciar el siguiente nivel
                }
            });
            timer.setRepeats(false); // Asegúrate de que el Timer no repita
            timer.start(); // Iniciar el Timer
        }
    }

   
    public void agregarReloj() {
    	reloj = new JLabel();
    	reloj.setText("TIEMPO \n"+controladorVistas.juego.getReloj().getSegundos());
    	reloj.setBounds(500, 10, 150, 50);
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
    public void actualizarImagenPlataformas() {
    	List<Plataforma> listaPlataformas = controladorVistas.obtenerPlataforma();	
    	for (Plataforma p : copiaPlataformas) {
    		if(p.getSprite()==null) {
    			p.setVisible(false);
    		}
    		if(p.cambioEstado()) {
    			String ruta = p.getSprite().getRutaImagen();
    			p.setIcon(verificarExtension(ruta)); 
    	        refrescar();
    		}
    	
    	}
    }
    
    
    
    public void actualizarPosicionReloj(int x) {
    	reloj.setBounds(reloj.getX()+x, 10, 150, 50);
    }
 
    
    public void actualizarPosicionEnemigos() {
    	List<Enemigo> listaEnemigos = controladorVistas.obtenerEnemigo();
    	for(Enemigo e : listaEnemigos) {
    		e.setBounds(e.getPosX(), e.getPosY(), 30, 30);
    	}
    }
    
    public void actualizarPosicionPersonaje() {
       // personaje = controladorVistas.obtenerPersonaje();
        if(personaje.getPosX() < imagenFondo.getIcon().getIconWidth()-320) {
        	personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, personaje.getAlto());
            refrescar();
        }
    }

    
    
    public void moverFondo(int posicionX) {
    	//personaje = controladorVistas.obtenerPersonaje();
        posicionInicialX += posicionX;
        //Verificar si el fondo ha llegado a su límite izquierdo
        if (posicionInicialX < -imagenFondo.getIcon().getIconWidth()) {
        	posicionInicialX = -imagenFondo.getIcon().getIconWidth();
        }
        // Desplazar el fondo solo si no ha alcanzado el límite
        int velocidad = Math.round(personaje.getVelX());
        if (maximoDerecha <= (imagenFondo.getIcon().getIconWidth() - 320) && personaje.getVelX()>=0) {
            panelScrollNivel.getHorizontalScrollBar().setValue(panelScrollNivel.getHorizontalScrollBar().getValue()+velocidad);
            actualizarPosicionReloj(velocidad);
            actualizarPosicionMonedas(velocidad);
            actualizarPosicionPuntuacion(velocidad);
            actualizarPosicionVidas(velocidad);
            maximoDerecha += personaje.getVelX();
            controladorVistas.obtenerPersonaje().actualizarMin();
        }      
        repaint();
    }
   
    public void actualizarFondo() {
    	//personaje = controladorVistas.obtenerPersonaje();
    	int velocidad = Math.round(personaje.getVelX());
    	if(personaje.getPosX() > maximoDerecha ) {
    		moverFondo(-velocidad);
    	}
    }
    
    public void eventosTeclado() {
    	addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent k) {
                int keyCode = k.getKeyCode(); 
                switch(keyCode) {
                
                	case(KeyEvent.VK_D):
                		controladorVistas.obtenerPersonaje().setRight(true);
                		//actualizarImagenPersonaje();
                		break;
                	case(KeyEvent.VK_A):
                		controladorVistas.obtenerPersonaje().setLeft(true);
                	//	actualizarImagenPersonaje();
                		break;		
                	case(KeyEvent.VK_W):
                		controladorVistas.obtenerPersonaje().setJump(true);
                	//	actualizarImagenPersonaje();
         
                		break;
                }
          	
            }
            public void keyReleased(KeyEvent k) {
            	int keyCode = k.getKeyCode(); 
                switch(keyCode) {
                
            	case(KeyEvent.VK_D):
            		controladorVistas.obtenerPersonaje().setRight(false);
            	//actualizarImagenPersonaje();
            		break;
            	case(KeyEvent.VK_A):
            		controladorVistas.obtenerPersonaje().setLeft(false);
            	//actualizarImagenPersonaje();
            		break;		
            	case(KeyEvent.VK_W):
            		controladorVistas.obtenerPersonaje().setJump(false); //o llamar a saltar
            		controladorVistas.obtenerPersonaje().saltar();
            		break;
            }     	
            	//actualizarImagenPersonaje();
            	refrescar();
            }
        });
    }

    public void mostrarPersonaje() {	
        personaje = controladorVistas.obtenerPersonaje();
        personaje.setVisible(true);
        String ruta = personaje.getSprite().getRutaImagen();
        personaje.setIcon(verificarExtension(ruta));
        personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
        panelNivel.add(personaje);
        refrescar();
    }
    
    public void mostrarEnemigos() {
    	copiaEnemigos = new ArrayList<Enemigo>(controladorVistas.obtenerEnemigo());
    	for(Enemigo e : copiaEnemigos) {
    		e.setVisible(true);
    		String ruta = e.getSprite().getRutaImagen();
            e.setIcon(verificarExtension(ruta));
            e.setBounds(e.getPosX(), e.getPosY(), 50, 50);
            panelNivel.add(e);
            refrescar();
    	}
    }
    

    
    public void mostrarPlataformas() {
    	copiaPlataformas = new ArrayList<Plataforma>(controladorVistas.juego.getPlataforma());
    	for (Plataforma p : copiaPlataformas) {
    		p.setVisible(true);
    		String ruta = p.getSprite().getRutaImagen();
    		p.setIcon(verificarExtension(ruta));
	        p.setBounds(p.getPosX(), p.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ANCHO, ConstantesVistas.ENTIDAD_TAMANO_ALTO);
            panelNivel.add(p);
            refrescar();
    	}   	
    }  
    
    public void mostrarPowerUps() {
    	copiaPowerUps = new ArrayList<PowerUps>(controladorVistas.obtenerPowerUp());
    	for(PowerUps p : copiaPowerUps) {
    		p.setBounds(p.getPosX(), p.getPosY(), 30, 30);
    		panelNivel.add(p);
            refrescar();
    	}
    }
    
    public void actualizarImagenPersonaje() {
    	if(personaje.necesitaActualizarSprite()) {
    		String ruta = personaje.getSprite().getRutaImagen();
            personaje.setIcon(verificarExtensionPersonaje(ruta)); 
            personaje.setBounds(personaje.getPosX(), personaje.getPosY(), ConstantesVistas.ENTIDAD_TAMANO_ALTO, ConstantesVistas.ENTIDAD_TAMANO_ANCHO);
            refrescar();
            personaje.setSpriteActualizado(false);
    	}
        
    }      
    
    public void actualizarImagenEnemigos(){
    	List<Enemigo> listaEnemigos = controladorVistas.obtenerEnemigo();
    	for(Enemigo e : copiaEnemigos) {
    		if(e.mostrable() && e.necesitaActualizarSprite()) {   			
	    		//e.setVisible(true);
	    		String ruta = e.getSprite().getRutaImagen();
	    		e.setIcon(verificarExtension(ruta));
	    		e.setBounds(e.getPosX(), e.getPosY(), 30, 30);
	    		
	    		e.setSpriteActualizado(false);
	            refrescar();
    		} else if (!e.mostrable()){
    			e.setVisible(false);
    		}	
    	}
    }
    
    public void actualizarImagenPowerUps() {
    	List<PowerUps> listaPowerUps = controladorVistas.obtenerPowerUp();
    	for(PowerUps p : copiaPowerUps) {
    		if(p.mostrable()) {   			
	    		p.setVisible(true);
	    		String ruta = p.getSprite().getRutaImagen();
	    		p.setIcon(verificarExtension(ruta));
	    		p.setBounds(p.getPosX(), p.getPosY(), 30, 30);
	            refrescar();
    		}
    		else 
    			p.setVisible(false);
    	}
    }
    
    public void agregarBandera() {
    	bandera = new JLabel();
    	String ruta = "/spritesOriginales/banderaBajando1.png";
    	
    	ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
    	Image imagenEscalada = icono.getImage().getScaledInstance(30, 300, Image.SCALE_DEFAULT);
    	ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
    	bandera.setIcon(iconoEscalado);
    	bandera.setBounds(3376-320, 30, 30, 500);
    	panelNivel.add(bandera);
    	refrescar();
    }
    
    public ImageIcon verificarExtensionPersonaje(String ruta) {
    	 ImageIcon iconoEscalado;
         
    	 if(personaje.getHitbox().getHeight()>50) {
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
