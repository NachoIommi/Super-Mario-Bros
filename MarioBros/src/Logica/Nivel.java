package Logica;

import java.io.BufferedReader; 
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import Enemigos.Enemigo;
import Fabricas.*;
import Personaje.Personaje;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class Nivel {
	
	protected Juego juego;
	protected Sprite spriteNivel;
	protected GenerarPersonaje fabricaPersonaje;
	protected GenerarBolaDeFuego fabricaBolaDeFuego;
	protected GenerarPlataformas fabricaLadrilloSolido;
	protected GenerarPlataformas fabricaBloqueDePregunta;
	protected GenerarPlataformas fabricaBloqueSolido;
	protected GenerarPlataformas fabricaTuberia;
	protected GenerarPlataformas fabricaVacio; 
	protected GenerarEnemigos fabricaPiranhaPlant;
	protected GenerarEnemigos fabricaLakitu;
	protected GenerarEnemigos fabricaSpiny; 
	protected GenerarEnemigos fabricaBuzzyBeetle;
	protected GenerarEnemigos fabricaGoomba;
	protected GenerarEnemigos fabricaKoopaTroopa;
	protected GenerarPowerUps fabricaMoneda;
	protected GenerarPowerUps fabricaEstrella;
	protected GenerarPowerUps fabricaSuperChampi;
	protected GenerarPowerUps fabricaFlorDeFuego;
	protected GenerarPowerUps fabricaChampiVerde;
	protected GenerarSprite fabricaSprite;
	protected int reloj;
	protected int nivelActual;
	protected Personaje personaje;
	
	public Nivel(int tiempo, Juego juego) {
		
			reloj = tiempo;
			this.juego = juego;
			
			fabricaPersonaje = new GenerarPersonaje();
			fabricaBolaDeFuego = new GenerarBolaDeFuego();
			fabricaLadrilloSolido = new GenerarLadrilloSolido();
			fabricaBloqueDePregunta = new GenerarBloqueDePreguntas();
			fabricaBloqueSolido = new GenerarBloqueSolido();
			fabricaTuberia = new GenerarTuberia();
			fabricaVacio = new GenerarVacio();
			fabricaPiranhaPlant = new GenerarPiranhaPlant();
			fabricaLakitu = new GenerarLakitu();
			fabricaSpiny = new GenerarSpiny();
			fabricaBuzzyBeetle = new GenerarBuzzyBeetle();
			fabricaGoomba = new GenerarGoomba();
			fabricaKoopaTroopa = new GenerarKoopaTroopa();
			fabricaMoneda = new GenerarMoneda();
			fabricaEstrella = new GenerarEstrella();
			fabricaSuperChampi = new GenerarSuperChampi();
			fabricaFlorDeFuego = new GenerarFlorDeFuego();
			fabricaChampiVerde = new GenerarChampiVerde();		
			
			if(juego.getModoDeJuego() == 1 ) {
				fabricaSprite = new GenerarSpriteOriginal();
			} else {
				fabricaSprite = new GenerarSpriteReemplazo();
			}
			spriteNivel = null;
			
	}
	
	public Sprite getSprite() {
		return spriteNivel;
	}
	
	public void cargarSprite(Sprite sprite) {
		spriteNivel = fabricaSprite.getNivel(nivelActual);
	}

	public int getNivelActual(){
		return nivelActual;
	}

	public void setNivelActual(int i){
		nivelActual=i;
	}

	public void cargarNivel(int i) {
		try {
			int vidas = 3;
			int puntuacion = 0;
			int monedas = 0;
			if(i > 0) {
				 vidas = personaje.getVidas();
				 puntuacion = personaje.getPuntuacion();
				 monedas = personaje.getMonedas();
			 }
			 setNivelActual(i);	
			 String ruta = "Niveles" + File.separator + "nivel-"+getNivelActual()+".txt";
			 FileReader lector = new FileReader(ruta);
			 BufferedReader lectura = new BufferedReader(lector);
			 String contenido = lectura.readLine();
			 String rutaCancionNivel = "Sonido/Canciones/soundtrackNivel-"+getNivelActual()+".wav";
			 Musica.getMusica().reproducirMusica(rutaCancionNivel);
			 while(contenido != null) {
				
				String [] partes = contenido.split("\\s+");
				int tipoEntidad = Integer.parseInt(partes[0]);
				int posX = Integer.parseInt(partes[1]);
				int posY = Integer.parseInt(partes[2]);
				int tipoPUp = 0;
				if(partes.length == 4) {
					tipoPUp = Integer.parseInt(partes[3]); 
				}
				switch (tipoEntidad) {
				    case 0:
				    	personaje = fabricaPersonaje.crearPersonaje(fabricaSprite.getPersonajeNormalQuietoDerecha(),posX,posY, this);
				    	juego.agregarPersonaje(personaje); 
				    	break;
				    case 1:
				    	juego.agregarPlataforma(fabricaLadrilloSolido.crearPlataforma(fabricaSprite.getLadrilloSolido(), posX, posY, this));
				        break;
				    case 2:
				    	switch(tipoPUp)
				    	{
					    	case 31:
				    			PowerUp m = fabricaMoneda.crearPowerUp(fabricaSprite.getMonedaSaltando(), posX, posY, this);
				    			juego.agregarPlataforma(fabricaBloqueDePregunta.crearPlataforma(fabricaSprite.getBloqueDePregunta(), posX, posY, m, 5, this));
				    			juego.agregarPowerUp(m);
				    			break;
				    			
					    	case 32:
					    		PowerUp e = fabricaEstrella.crearPowerUp(fabricaSprite.getEstrella(), posX, posY, this);
					    		juego.agregarPlataforma(fabricaBloqueDePregunta.crearPlataforma(fabricaSprite.getBloqueDePregunta(), posX, posY, e, 1, this));
					    		juego.agregarPowerUp(e);
				    			break;
				    		case 33:
				    			PowerUp  s = fabricaSuperChampi.crearPowerUp(fabricaSprite.getSuperChampi(), posX, posY-30, this) ;
				    			juego.agregarPlataforma(fabricaBloqueDePregunta.crearPlataforma(fabricaSprite.getBloqueDePregunta(), posX, posY, s, 1, this));
				    			juego.agregarPowerUp(s);
				    			break;
				    			
				    		case 34:
				    			PowerUp  f = fabricaFlorDeFuego.crearPowerUp(fabricaSprite.getFlorDeFuego(), posX, posY-30, this) ;
				    			juego.agregarPlataforma(fabricaBloqueDePregunta.crearPlataforma(fabricaSprite.getBloqueDePregunta(), posX, posY, f, 1, this));
				    			juego.agregarPowerUp(f);
				    			break;
				    			
				    		 case 35:
				    			PowerUp  c = fabricaChampiVerde.crearPowerUp(fabricaSprite.getChampiVerde(), posX, posY-30, this);
					    		juego.agregarPlataforma(fabricaBloqueDePregunta.crearPlataforma(fabricaSprite.getBloqueDePregunta(), posX, posY, c, 1, this));
					    		juego.agregarPowerUp(c);
				    			break;
				    			
				    		 default:
				    			 break;
				    	}
				       
				    case 3:
				    	juego.agregarPlataforma(fabricaBloqueSolido.crearPlataforma(fabricaSprite.getBloqueSolido(), posX, posY, this));
				        break;
				    case 4:
				    	Enemigo e = fabricaPiranhaPlant.crearEnemigo(fabricaSprite.getPiranhaPlant(), posX, posY, this);
				    	Plataforma p = fabricaTuberia.crearPlataforma(fabricaSprite.getTuberia(), posX, posY, e, this);
				    	juego.agregarPlataforma(p); 
				    	juego.agregarEnemigo(e);
				        break;
				    case 5:
				    	juego.agregarPlataforma(fabricaTuberia.crearPlataforma(fabricaSprite.getTuberia(), posX, posY, this));
				        break;
				    case 6:
				    	juego.agregarPlataforma(fabricaVacio.crearPlataforma(fabricaSprite.getVacio(), posX, posY, this));
				        break;
				    case 7:
				    	juego.agregarPlataforma(fabricaBloqueSolido.crearPlataforma(fabricaSprite.getBloqueSolido2(), posX, posY, this));
				        break;
				    case 31:
				    	juego.agregarPowerUp(fabricaMoneda.crearPowerUp(fabricaSprite.getMoneda(), posX, posY, this));
				        break;
				    case 32:
				    	juego.agregarPowerUp(fabricaEstrella.crearPowerUp(fabricaSprite.getEstrella(), posX, posY, this));
				        break;
				    case 33:
				    	juego.agregarPowerUp(fabricaSuperChampi.crearPowerUp(fabricaSprite.getSuperChampi(), posX, posY, this));
				        break;
				    case 34:
				    	juego.agregarPowerUp(fabricaFlorDeFuego.crearPowerUp(fabricaSprite.getFlorDeFuego(), posX, posY, this));
				        break;
				    case 35:
				    	juego.agregarPowerUp(fabricaChampiVerde.crearPowerUp(fabricaSprite.getChampiVerde(), posX, posY, this));
				        break;
				    case 62:
				    	juego.agregarEnemigo(fabricaLakitu.crearEnemigo(fabricaSprite.getLakitu(), posX, posY, juego.getPersonaje(), this));
				        break;
				    case 63:
				    	juego.agregarEnemigo(fabricaSpiny.crearEnemigo(fabricaSprite.getSpinyCaminandoDerecha(), posX, posY, this));
				        break;
				    case 64:
				    	juego.agregarEnemigo(fabricaBuzzyBeetle.crearEnemigo(fabricaSprite.getBuzzyBeetle(), posX, posY, this));
				        break;
				    case 65:
				    	juego.agregarEnemigo(fabricaGoomba.crearEnemigo(fabricaSprite.getGoomba(),posX, posY, this));
				        break;
				    case 66:
				    	juego.agregarEnemigo(fabricaKoopaTroopa.crearEnemigo(fabricaSprite.getKoopaTroopa(), posX, posY, this));
				        break;	        
				    default:				        
				        break;
				}
				contenido = lectura.readLine();
				cargarSprite(fabricaSprite.getNivel(nivelActual));
			}
			 personaje.setVidas(vidas);
			 personaje.setPuntuacion(puntuacion);
			 personaje.setMonedas(monedas);
		} catch(IOException | NumberFormatException e) {
				System.out.println(e.getMessage());
		}
	}
	

	public void reiniciarNivel() {
		if(personaje != null) {
			int vidas = personaje.getVidas(); 
			int puntuacion = personaje.getPuntuacion();
			int monedas = personaje.getMonedas();
			juego.reseteo();
			cargarNivel(getNivelActual());
			 
			if (vidas > 0) { 
		        personaje.setVidas(vidas); 
		        personaje.setPuntuacion(puntuacion);  
		        personaje.setMonedas(monedas);
			}
			
			juego.reiniciarNivel(); 
		}
	}

	public Juego getJuego() {
		return juego;
	}
	
	public void ganarJuego(){
		cargarNivel(getNivelActual()+1);
	}

	public void perderJuego() {
		juego.perderJuego();
	}


}