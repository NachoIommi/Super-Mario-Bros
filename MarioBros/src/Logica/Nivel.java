package Logica;

import java.io.BufferedReader;
import java.io.File;

import Personaje.*;
import java.io.FileReader;
import java.io.IOException;

import Fabricas.*;
import Personaje.Personaje;

public class Nivel {
	
	protected int reloj;
	protected int nivel_actual;
	protected Juego juego;
	
	GenerarPersonaje fabricaPersonaje;
	
	GenerarBolaDeFuego fabricaBolaDeFuego;
	
	GenerarPlataformas fabricaLadrilloSolido;
	GenerarPlataformas fabricaBloqueDePregunta;
	GenerarPlataformas fabricaBloqueSolido;
	GenerarPlataformas fabricaTuberia;
	GenerarPlataformas fabricaVacio; 
	
	GenerarEnemigos fabricaPiranhaPlant;
	GenerarEnemigos fabricaLakitu;
	GenerarEnemigos fabricaSpiny; 
	GenerarEnemigos fabricaBuzzyBeetle;
	GenerarEnemigos fabricaGoomba;
	GenerarEnemigos fabricaKoopaTroopa;
	

	GenerarPowerUps fabricaMoneda;
	GenerarPowerUps fabricaEstrella;
	GenerarPowerUps fabricaSuperChampi;
	GenerarPowerUps fabricaFlorDeFuego;
	GenerarPowerUps fabricaChampiVerde;
	
	GenerarSprite fabricaSprite;
	
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
			
	}

	public int getNivelActual(){
		return nivel_actual;
	}

	public void setNivelActual(int i){
		nivel_actual=i;
	}
		
	public void cargarNivel(int i) {
		try {
			 String ruta = "Niveles" + File.separator + "nivel-1.txt";
			    FileReader lector = new FileReader(ruta);
			    BufferedReader lectura = new BufferedReader(lector);
			    
			    String contenido = lectura.readLine();
			
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
				//0 personaje
				//1 a 30 bloques
				//31 a 60 power ups
				//61 a 99 enemigos
				//100 -> otros
				    case 0:
				    	//fabricaPersonaje.crearPersonaje(posX, posY);
				    	juego.agregarPersonaje(fabricaPersonaje.crearPersonaje(fabricaSprite.getPersonaje(),posX,posY));
				        break;
						
				    case 1://ladrillosolido
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

				    case 31://moneda
				    	juego.agregarPowerUp(fabricaEstrella.crearPowerUp(fabricaSprite.getMoneda(), posX, posY));
				        break;
				    case 32://estrella
				    	juego.agregarPowerUp(fabricaEstrella.crearPowerUp(fabricaSprite.getEstrella(), posX, posY));
				        break;
				    case 33://superchampi
				    	juego.agregarPowerUp(fabricaEstrella.crearPowerUp(fabricaSprite.getSuperChampi(), posX, posY));
				        break;
				    case 34://flordfuego
				    	juego.agregarPowerUp(fabricaFlorDeFuego.crearPowerUp(fabricaSprite.getFlorDeFuego(), posX, posY));
				        break;
				    case 35://champiverde
				    	juego.agregarPowerUp(fabricaChampiVerde.crearPowerUp(fabricaSprite.getChampiVerde(), posX, posY));
				        break;
				    
				    case 61://piranha
				    	juego.agregarEnemigo(fabricaPiranhaPlant.crearEnemigo(fabricaSprite.getPiranhaPlant(), posX, posY));
				        break;
				    case 62://lakitu
				    	juego.agregarEnemigo(fabricaLakitu.crearEnemigo(fabricaSprite.getPiranhaPlant(), posX, posY));
				        break;
				    case 63://spiny
				    	juego.agregarEnemigo(fabricaSpiny.crearEnemigo(fabricaSprite.getSpiny(), posX, posY));
				        break;
				    case 64://buzzy
				    	juego.agregarEnemigo(fabricaBuzzyBeetle.crearEnemigo(fabricaSprite.getBuzzyBeetle(), posX, posY));
				        break;
				    case 65:
				    	juego.agregarEnemigo(fabricaGoomba.crearEnemigo(fabricaSprite.getGoomba(),posX, posY));
				        break;
				    case 66://koopa
				    	juego.agregarEnemigo(fabricaKoopaTroopa.crearEnemigo(fabricaSprite.getKoopaTroopa(), posX, posY));
				        break;
				    
						
				    case 100: //no se va a parsear nunca , mario las crea , no el parser
				    	fabricaBolaDeFuego.crearBolaDeFuego(posX, posY);
				        break;
				    
					
				    default:
				        System.out.println("Tipo no válido");
				        break;
				}
				contenido = lectura.readLine(); //Leo prox renglon del txt
			}//esta llave cierra el while
			//setReloj();
			setNivelActual(i);			
		}catch(IOException | NumberFormatException e) {
				System.out.println(e.getMessage());}
		
	}//llave cargarNivel
	

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
