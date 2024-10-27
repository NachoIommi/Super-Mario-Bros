package Logica;

import Enemigos.*; 
import Fabricas.*;
import Personaje.*;
import Plataformas.*;
import PowerUps.*;

public class VisitorEnemigoAfectado implements Visitor{
	protected Personaje personaje;
	
	public VisitorEnemigoAfectado(Personaje personaje) {
        this.personaje = personaje;
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

	public void visitarVacio(Vacio v) {		v.afectarPersonaje(personaje);
	}

	public void visitarTuberia(Tuberia t) {	
	}
		
	public void visitarPiranhaPlant(PiranhaPlant p) {		p.afectarPersonaje(personaje);
	}

	public void visitarLakitu(Lakitu l) {		l.serAfectadoPorPersonaje(personaje);
	}

	public void visitarSpiny(Spiny s) {
		s.serAfectadoPorPersonaje(personaje);
	}

	public void visitarBuzzyBeetle(BuzzyBeetle b) {
		b.serAfectadoPorPersonaje(personaje);
	}

	public void visitarGoomba(Goomba g) {
		g.serAfectadoPorPersonaje(personaje);
	}

	public void visitarKoopaTroopa(KoopaTroopa k) {
		k.serAfectadoPorPersonaje(personaje);
	}

	public void visitarMusica(Musica m) {
		
	}

	public void visitarPantalla(Juego j) {
		
	}

	public void visitarSprite(Sprite s) {
		
	}

	public void visitarAnimador(Animador a) {
		
	}

}
