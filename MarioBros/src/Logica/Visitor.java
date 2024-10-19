package Logica;

import Enemigos.*; 
import Fabricas.Sprite;
import Logica.Entidad;
import Personaje.*;
import Plataformas.*;
import PowerUps.*;
public interface Visitor {
	
	
	public void visitarBolaDeFuego(BolaDeFuego b);
	public void visitarMoneda(Moneda m);
	public void visitarFlorDeFuego(FlorDeFuego f);
	public void visitarSuperChampi(SuperChampi s);
	public void visitarEstrella(Estrella e);
	public void visitarChampiVerde(ChampiVerde c);
	public void visitarBloqueDePregunta(BloqueDePregunta p);
	public void visitarLadrilloSolido(LadrilloSolido l);
	public void visitarVacio(Vacio v);
	public void visitarTuberia(Tuberia t);
	public void visitarPiranhaPlant(PiranhaPlant p);
	public void visitarLakitu(Lakitu l);
	public void visitarSpiny(Spiny s);
	public void visitarBuzzyBeetle(BuzzyBeetle b);
	public void visitarGoomba(Goomba g);
	public void visitarKoopaTroopa(KoopaTroopa k);
	public void visitarMusica(Musica m);
	public void visitarPantalla(Juego j);//Visitaba a la pantalla
	public void visitarSprite(Sprite s);
	public void visitarAnimador(Animador a);
	

}
