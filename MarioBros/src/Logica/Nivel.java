package Logica;

import java.io.BufferedReader; 
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
			
			fabricaSprite = new GenerarSpriteOriginal();
			
	}

	public int getNivelActual(){
		return nivel_actual;
	}

	public void setNivelActual(int i){
		nivel_actual=i;
	}
		
	public void cargarNivel(int i) {
		try {
			//String ruta = "ruta al archivo"+i+".txt"; //Por ejemplo: C:/Desktop/ParserNivel+i+.txt con i = 1,2,3.
			String ruta = "C:/Users/juans/OneDrive/Desktop/Niveles/nivel-1.txt";
			String contenido; //es el renglon leido por iteracion
			
			FileReader lector = new FileReader(ruta);  //Indico el archivo a leer
			BufferedReader lectura = new BufferedReader(lector); //Nos permite leer
			
			contenido = lectura.readLine(); //leo 1 renglon
			
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
				    	juego.agregarPersonaje(fabricaPersonaje.crearPersonaje(posX,posY));
				        break;
						
				    case 1:
				    	fabricaLadrilloSolido.crearPlataforma(posX, posY);
				        break;
				    case 2:
				    	fabricaBloqueDePregunta.crearPlataforma(posX, posY);
				        break;
				   /*
				    case 3:
				    	fabricaBloqueSolido.crearBloqueSolido(posX, posY);
				        break;
				    case 4:
				    	fabricaTuberia.crearTuberia(posX, posY, tipoPUp); //3er parametro determina piranha si/no
				        break;
				    case 5:
				    	fabricaVacio.crearVacio(posX, posY);
				        break;

				    case 31:
				    	fabricaMoneda.crearMoneda(posX, posY);
				        break;
				    case 32:
				    	fabricaEstrella.crearEstrella(posX, posY);
				        break;
				    case 33:
				    	fabricaSuperChampi.crearSuperChampi(posX, posY);
				        break;
				    case 34:
				    	fabricaFlorDeFuego.crearFlorDeFuego(posX, posY);
				        break;
				    case 35:
				    	fabricaChampiVerde.crearChampiVerde(posX, posY);
				        break;
				    
				    case 61:
				    	fabricaPiranhaPlant.crearPiranhaPlant(posX, posY);
				        break;
				    case 62:
				    	fabricaLakitu.crearLakitu(posX, posY);
				        break;
				    case 63:
				    	fabricaSpiny.crearSpiny(posX, posY);
				        break;
				    case 64:
				    	fabricaBuzzyBeetle.crearBuzzyBeetle(posX, posY);
				        break;
				    case 65:
				    	fabricaGoomba.crearGoomba(posX, posY);
				        break;
				    case 66:
				    	fabricaKoopaTroopa.crearKoopaTroopa(posX, posY);
				        break;
				    
						
				    case 100: //no se va a parsear nunca , mario las crea , no el parser
				    	fabricaBolaDeFuego.crearBolaDeFuego(posX, posY);
				        break;
				    case 101://podemos usarlo para cargar el fondo
				    	fabricaSpriteOriginal.crearSpriteOriginal(posX, posY);
				        break;
				    case 102:
				    	fabricaSpriteReemplazo.crearSpriteReemplazo(posX, posY);
				        break;
					*/
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
