package Logica;

import Enemigos.*; 
import Fabricas.*;
import Personaje.*;
import Plataformas.*;
import PowerUps.*;

public class VisitorEntidad implements Visitor{
	protected Personaje personaje;
	
	public VisitorEntidad(Personaje personaje) {
        this.personaje = personaje;
    }
	
	public void visitarBolaDeFuego(BolaDeFuego b) {
    	
    } 
    public void visitarMoneda(Moneda m) {
    	m.afectarPersonaje(personaje);
    }
    public void visitarFlorDeFuego(FlorDeFuego f) {
    	f.afectarPersonaje(personaje);
    }
    public void visitarSuperChampi(SuperChampi s) {
    	s.afectarPersonaje(personaje);
    }
    public void visitarEstrella(Estrella e) {
    	e.afectarPersonaje(personaje);
    }
    public void visitarChampiVerde(ChampiVerde c) {
    	c.afectarPersonaje(personaje);
    }
    public void visitarBloqueDePregunta(BloqueDePregunta p) {
    	p.recibirGolpe();
    }
    public void visitarLadrilloSolido(LadrilloSolido l) {
    	l.recibirGolpe(personaje);
    }
    public void visitarVacio(Vacio v) {
    	v.afectarPersonaje(personaje);
    }
    public void visitarTuberia(Tuberia t) {
    	
    }
    public void visitarPiranhaPlant(PiranhaPlant p) {
    	p.moverse();
    }
    public void visitarLakitu(Lakitu l) {
    	l.moverse();
    }
    public void visitarSpiny(Spiny s) {
    	s.moverse();
    }
    public void visitarBuzzyBeetle(BuzzyBeetle b) {
    	b.moverse();
    }
    public void visitarGoomba(Goomba g) {
    	g.moverse();
    }
    public void visitarKoopaTroopa(KoopaTroopa k) {
    	k.moverse();
    }
    public void visitarSprite(Sprite s) {
    	
    }
	public void visitarMusica(Musica m) {
		
	}
	public void visitarPantalla(Juego j) {
		
	}
	public void visitarAnimador(Animador a) {
		
	}
}
