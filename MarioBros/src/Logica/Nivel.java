package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Nivel {
	
	private int reloj;
	 
	
	public Nivel(int tiempo) {
			reloj = tiempo;
			GenerarPersonaje fabricaPersonaje = new GenerarPersonaje();
			
			GenerarBolaDeFuego fabricaBolaDeFuego = new GenerarBolaDeFuego();
			
			GenerarPlataforma fabricaLadrilloSolido = new GenerarLadrilloSolido();
			GenerarPlataforma fabricaBloqueDePregunta = new GenerarBloqueDePregunta();
			GenerarPlataforma fabricaBloqueSolido = new GenerarBloqueSolido();
			GenerarPlataforma fabricaTuberia = new GenerarTuberia();
			GenerarPlataforma fabricaVacio = new GenerarVacio();
			
			GenerarEnemigos fabricaPiranhaPlant = new GenerarPiranhaPlant();
			GenerarEnemigos fabricaLakitu = new GenerarLakitu();
			GenerarEnemigos fabricaSpiny = new GenerarSpiny();
			GenerarEnemigos fabricaBuzzyBeetle = new GenerarBuzzyBeetle();
			GenerarEnemigos fabricaGoomba = new GenerarGoomba();
			GenerarEnemigos fabricaKoopaTroopa = new GenerarKoopaTroopa();
			

			GenerarPowerUps fabricaMoneda = new GenerarMoneda();
			GenerarPowerUps fabricaEstrella = new GenerarEstrella();
			GenerarPowerUps fabricaSuperChampi = new GenerarSuperChampi();
			GenerarPowerUps fabricaFlorDeFuego = new GenerarFlorDeFuego();
			GenerarPowerUps fabricaChampiVerde = new GenerarChampiVerde();
			
			GenerarSprite fabricaSpriteOriginal = new GenerarSpriteOriginal();
			GenerarSprite fabricaSpriteReemplazo = new GenerarSpriteReemplazo();
				
	}
		
		
	
	public void cargarNivel(int i) {
		
		try {
			String ruta = "ruta al archivo"+i+".txt"; //Por ejemplo: C:/Desktop/ParserNivel+i+.txt con i = 1,2,3.
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
				if(partes.length == 4) {                 //Si tiene long cuatro, la cuarta posicion es el PUp contenido
					tipoPUp = Integer.parseInt(partes[3]); 
				}
				
				switch (tipoEntidad) {
				
			    case 0:
			    	fabricaPersonaje.crearPersonaje(posX, posY);
			        break;
			    case 1:
			    	fabricaBolaDeFuego.crearBolaDeFuego(posX, posY);
			        break;
			    case 2:
			    	fabricaLadrilloSolido.crearLadrilloSolido(posX, posY);
			        break;
			    case 3:
			    	fabricaBloqueDePregunta.crearBloqueDePregunta(posX, posY, tipoPUp);
			        break;
			    case 4:
			    	fabricaBloqueSolido.crearBloqueSolido(posX, posY);
			        break;
			    case 5:
			    	fabricaTuberia.crearTuberia(posX, posY, tipoPUp); //3er parametro determina piranha si/no
			        break;
			    case 6:
			    	fabricaVacio.crearVacio(posX, posY);
			        break;
			    case 7:
			    	fabricaPiranhaPlant.crearPiranhaPlant(posX, posY);
			        break;
			    case 8:
			    	fabricaLakitu.crearLakitu(posX, posY);
			        break;
			    case 9:
			    	fabricaSpiny.crearSpiny(posX, posY);
			        break;
			    case 10:
			    	fabricaBuzzyBeetle.crearBuzzyBeetle(posX, posY);
			        break;
			    case 11:
			    	fabricaGoomba.crearGoomba(posX, posY);
			        break;
			    case 12:
			    	fabricaKoopaTroopa.crearKoopaTroopa(posX, posY);
			        break;
			    case 13:
			    	fabricaMoneda.crearMoneda(posX, posY);
			        break;
			    case 14:
			    	fabricaEstrella.crearEstrella(posX, posY);
			        break;
			    case 15:
			    	fabricaSuperChampi.crearSuperChampi(posX, posY);
			        break;
			    case 16:
			    	fabricaFlorDeFuego.crearFlorDeFuego(posX, posY);
			        break;
			    case 17:
			    	fabricaChampiVerde.crearChampiVerde(posX, posY);
			        break;
			    case 18:
			    	fabricaSpriteOriginal.crearSpriteOriginal(posX, posY);
			        break;
			    case 19:
			    	fabricaSpriteReemplazo.crearSpriteReemplazo(posX, posY);
			        break;
			    default:
			        System.out.println("Tipo no válido");
			        break;
				}
				
			}
				
				//generar entidad segun tipoEntidad
				//pos x de entidad
				//pos y de entidad
				// si tiene PUp asignarselo
				
				contenido = lectura.readLine(); //Leo prox renglon del txt
				
	
				
			}catch(IOException | NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		
	}
	

}
