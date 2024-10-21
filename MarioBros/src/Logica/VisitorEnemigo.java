package Logica;


import Enemigos.*;  
import Fabricas.Sprite;
import Personaje.*;
import Plataformas.*;
import PowerUps.*;

public class VisitorEnemigo implements Visitor {
	protected Personaje  personaje;
	
	public VisitorEnemigo(Personaje personaje) {
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
    public void visitarVacio(Vacio v) {
    	
    }
    public void visitarTuberia(Tuberia t) {
    	
    }
    public void visitarPiranhaPlant(PiranhaPlant p) {
    	p.afectarPersonaje(personaje);
    }
    public void visitarLakitu(Lakitu l) {
    	l.afectarPersonaje(personaje);
    }
    public void visitarSpiny(Spiny s) {
    	s.afectarPersonaje(personaje);
    }
    public void visitarBuzzyBeetle(BuzzyBeetle b) {
    	b.afectarPersonaje(personaje);
    }
    public void visitarGoomba(Goomba g) {
    	g.afectarPersonaje(personaje);
    }
    public void visitarKoopaTroopa(KoopaTroopa k) {
    	k.afectarPersonaje(personaje);
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
