package Logica;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Fabricas.Sprite;
import Personaje.Personaje;
import Plataformas.BloqueDePregunta;
import Plataformas.LadrilloSolido;
import Plataformas.Tuberia;
import Plataformas.Vacio;
import PowerUps.ChampiVerde;
import PowerUps.Estrella;
import PowerUps.FlorDeFuego;
import PowerUps.Moneda;
import PowerUps.SuperChampi;

public class VisitorBolaDeFuego implements Visitor{
	protected Personaje personaje;
	protected BolaDeFuego bola;

	public VisitorBolaDeFuego(Personaje p,BolaDeFuego b) {
        personaje = p;
        bola=b;
    }
	
	public void setBolaDeFuego(BolaDeFuego b) {
		bola=b;
	}

	public void visitarBolaDeFuego(BolaDeFuego b) {
		
	}


	public void visitarMoneda(Moneda m) {
	
	}

	
	public void visitarFlorDeFuego(FlorDeFuego f) {
		
	}


	public void visitarSuperChampi(SuperChampi s) {
		
	}

	public void visitarEstrella(Estrella e) {
		
	}

	
	public void visitarChampiVerde(ChampiVerde c) {
		
	}

	public void visitarBloqueDePregunta(BloqueDePregunta p) {
		
	}


	public void visitarLadrilloSolido(LadrilloSolido l) {
		
	}

	public void visitarVacio(Vacio v) {
		v.afectarBola(bola);
	}


	public void visitarTuberia(Tuberia t) {
		
	}

	public void visitarGoomba(Goomba g) {
		g.morir();
		personaje.setPuntuacion(60);
	}
	public void visitarKoopaTroopa(KoopaTroopa k) {
		k.morir();
		personaje.setPuntuacion(90);
	}
	
	public void visitarPiranhaPlant(PiranhaPlant p) {
		p.morir();
		personaje.setPuntuacion(30);
	}

	public void visitarLakitu(Lakitu l) {
		l.morir();
		personaje.setPuntuacion(60);
	}


	public void visitarSpiny(Spiny s) {
		s.morir();
		personaje.setPuntuacion(60);
	}

	public void visitarBuzzyBeetle(BuzzyBeetle b) {
		b.morir();
		personaje.setPuntuacion(30);
	}

	public void visitarMusica(Musica m) {
		
	}


	public void visitarPantalla(Juego j) {
		
	}

	public void visitarSprite(Sprite s) {
		
	}

}
