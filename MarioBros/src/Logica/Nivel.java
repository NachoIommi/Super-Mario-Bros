package Logica;

import java.io.BufferedReader;
import java.io.File;

import Personaje.*;
import java.io.FileReader;
import java.io.IOException;

import Fabricas.*;
import Personaje.Personaje;

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
			
			if(juego.getModoDeJuego() == 2 ) {
				fabricaSprite = new GenerarSpriteOriginal();
			}else {
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
			 setNivelActual(i);	
			 String ruta = "Niveles" + File.separator + "nivel-"+getNivelActual()+".txt";
			 FileReader lector = new FileReader(ruta);
			 BufferedReader lectura = new BufferedReader(lector);
			 String contenido = lectura.readLine();
			 String rutaCancionNivel = "Sonido/Canciones/soundtrackNivel-"+getNivelActual()+".wav";
			 Musica.getInstancia().reproducirMusica(rutaCancionNivel);
			 while(contenido != null) {
				
				String [] partes = contenido.split("\\s+"); //Guardo en el array cada cadena separada
				int tipoEntidad = Integer.parseInt(partes[0]);
				int posX = Integer.parseInt(partes[1]);
				int posY = Integer.parseInt(partes[2]);
				int tipoPUp = 0; //considerando que ningun powerUp tiene asignado 0
				if(partes.length == 4) {//Si tiene long cuatro, la cuarta posicion es el PUp contenido
					tipoPUp = Integer.parseInt(partes[3]); 
				}
				switch (tipoEntidad) {
				    case 0:
				    	juego.agregarPersonaje(fabricaPersonaje.crearPersonaje(fabricaSprite.getPersonajeNormalQuietoDerecha(),posX,posY));
				        break;
				    case 1:
				    	juego.agregarPlataforma(fabricaLadrilloSolido.crearPlataforma(fabricaSprite.getLadrilloSolido(), posX, posY));
				        break;
				    case 2:
				    	juego.agregarPlataforma(fabricaBloqueDePregunta.crearPlataforma(fabricaSprite.getBloqueDePregunta(), posX, posY));
				        break;
				    case 3:
				    	juego.agregarPlataforma(fabricaBloqueSolido.crearPlataforma(fabricaSprite.getBloqueSolido(), posX, posY));
				        break;
				     /*   
				    case 4:
				    	fabricaTuberia.crearPlataforma(posX, posY, tipoPUp); //Tuberia con Piranha 
				        break;
				       */ 
				    case 5:
				    	juego.agregarPlataforma(fabricaTuberia.crearPlataforma(fabricaSprite.getTuberia(), posX, posY)); //Tuberia sin Piranha
				        break;
				    case 6:
				    	juego.agregarPlataforma(fabricaVacio.crearPlataforma(fabricaSprite.getVacio(), posX, posY));
				        break;

				    case 31:
				    	juego.agregarPowerUp(fabricaMoneda.crearPowerUp(fabricaSprite.getMoneda(), posX, posY));
				        break;
				    case 32:
				    	juego.agregarPowerUp(fabricaEstrella.crearPowerUp(fabricaSprite.getEstrella(), posX, posY));
				        break;
				    case 33:
				    	juego.agregarPowerUp(fabricaSuperChampi.crearPowerUp(fabricaSprite.getSuperChampi(), posX, posY));
				        break;
				    case 34:
				    	juego.agregarPowerUp(fabricaFlorDeFuego.crearPowerUp(fabricaSprite.getFlorDeFuego(), posX, posY));
				        break;
				    case 35:
				    	juego.agregarPowerUp(fabricaChampiVerde.crearPowerUp(fabricaSprite.getChampiVerde(), posX, posY));
				        break;
				    case 61:
				    	juego.agregarEnemigo(fabricaPiranhaPlant.crearEnemigo(fabricaSprite.getPiranhaPlant(), posX, posY));
				        break;
				    case 62:
				    	juego.agregarEnemigo(fabricaLakitu.crearEnemigo(fabricaSprite.getLakitu(), posX, posY));
				        break;
				   /* case 63:
				    	juego.agregarEnemigo(fabricaSpiny.crearEnemigo(fabricaSprite.getSpiny(), posX, posY));
				        break;
				    case 64:
				    	juego.agregarEnemigo(fabricaBuzzyBeetle.crearEnemigo(fabricaSprite.getBuzzyBeetle(), posX, posY));
				        break;
				        */
				    case 65:
				    	juego.agregarEnemigo(fabricaGoomba.crearEnemigo(fabricaSprite.getGoomba(),posX, posY));
				        break;
				    case 66:
				    	juego.agregarEnemigo(fabricaKoopaTroopa.crearEnemigo(fabricaSprite.getKoopaTroopa(), posX, posY));
				        break;
				        
				    /*case 100: 
				    	fabricaBolaDeFuego.crearBolaDeFuego(posX, posY);
				        break;*/ //El case 100 se debe parsear? 
				        
				    default:
				        System.out.println("Tipo no válido");
				        break;
				}
				contenido = lectura.readLine(); //Leo prox renglon del txt
				cargarSprite(fabricaSprite.getNivel(nivelActual));
				
			}
			//setReloj();
			//setNivelActual(i);			
		}catch(IOException | NumberFormatException e) {
				System.out.println(e.getMessage());}
	}
	
	public void perderVida(Personaje p){
		if(p.getVidas() != 1){
			p.setVidas(p.getVidas() - 1);
			reiniciarNivel();
		}
		else
			perderJuego();
	}

	public void reiniciarNivel(){
		cargarNivel(getNivelActual());
	}

	public void ganarJuego(){
		//hay que ver caso nivel final
		cargarNivel(getNivelActual()+1);
	}

	public void perderJuego(){
		//pantalla especial
		juego.perderJuego();
			//botones
				//reiniciar juego
				//volver a pantalla inicial
		//cargar al ranking 
	}
	//ver tema RELOJ
	
}
