package Plataformas;



import java.util.Timer;
import java.util.TimerTask;

import Fabricas.GenerarSprite;
import Fabricas.GenerarSpriteOriginal;
import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;
import PowerUps.PowerUps;

public class BloqueGolpeable extends EstadoDeBloque{
	
	//protected BloqueDePregunta bloque;
	protected Sprite sprite;
	protected int posX;
	protected int posY;
	protected Hitbox hitbox;
	protected PowerUps contenido;
	protected boolean mostrable;
	protected int golpesRestantes;
	protected boolean bloqueMonedas = false;
	
	
	public BloqueGolpeable(BloqueDePregunta b, Sprite s, int x, int y, PowerUps p, int golpes) {
		super(b);
		sprite = s;
		posX = x;
		posY = y;
		hitbox = new Hitbox(x ,y,30 ,30);
		contenido=p;
		golpesRestantes=golpes;	
		if (golpes>1)
			bloqueMonedas=true;
		
	}
	
	public void soltarContenido() {
		contenido.setPosX(posX);
		contenido.setPosY(posY-30);	
		System.out.println("visitado soltar contenido");
		contenido.setMostrable(true);
		
	}

	public void recibirGolpe(Personaje p) {
		if(!bloqueMonedas) {
			if(golpesRestantes!=1 ) {
				golpesRestantes--;
				
			}
			else {			
				GenerarSprite fabrica = new GenerarSpriteOriginal();
				EstadoDeBloque e = new BloqueGolpeado(bloque,fabrica.getBloqueDePreguntaRoto(),posX,posY,0);
				bloque.cambiarEstado(e);
				bloque.setSprite(fabrica.getBloqueDePreguntaRoto());}
		}
		else {
			if (golpesRestantes != 1) {
	            soltarContenido();
	            // Animación de movimiento ascendente
	            Timer timer = new Timer();
	            TimerTask animacionSubida = new TimerTask() {
	                int tiempo = 0;
	                int alturaInicial = contenido.getPosY();
	                
	                public void run() {
	                    tiempo += 50;  // intervalo en milisegundos
	                    // La moneda sube 2 píxeles cada 50 ms
	                    contenido.setPosY(alturaInicial - (tiempo / 50) * 2);	                    	                
	                    if (tiempo >= 500) {
	                        contenido.setMostrable(false);
	                        contenido.setPosY(alturaInicial); 
	                        this.cancel();
	                    }
	                }
	            };
	            timer.scheduleAtFixedRate(animacionSubida, 0, 50); // Ejecuta cada 50 ms
	            p.setMonedas(1);
	            p.setPuntuacion(5);
	            golpesRestantes--;}
			
			else {	     
				soltarContenido();
	            Timer timer = new Timer();
	            TimerTask animacionSubidaFinal = new TimerTask() {
	                int tiempo = 0;
	                int alturaInicial = contenido.getPosY();
	                
	                public void run() {
	                    tiempo += 50;
	                    contenido.setPosY(alturaInicial - (tiempo / 50) * 2);	                    
	                    if (tiempo >= 500) {
	                        contenido.setMostrable(false);
	                        contenido.setPosY(alturaInicial);
	                        this.cancel();
	                    }
	                }
	            };
	            timer.scheduleAtFixedRate(animacionSubidaFinal, 0, 50);
	            p.setMonedas(1);
	            p.setPuntuacion(5);
	            GenerarSprite fabrica = new GenerarSpriteOriginal();
	            EstadoDeBloque e = new BloqueGolpeado(bloque, fabrica.getBloqueDePreguntaRoto(), posX, posY, 0);
	            bloque.cambiarEstado(e);
	            bloque.setSprite(fabrica.getBloqueDePreguntaRoto());
	        }
		}
	}

	public BloqueDePregunta getBloque() {
		return bloque;
	}
	
	public int getGolpesRestantes() {
		return golpesRestantes;
	}

	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mostrable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EstadoDeBloque getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PowerUps getContenido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContenido(PowerUps p) {
		// TODO Auto-generated method stub
		
	}

	
}