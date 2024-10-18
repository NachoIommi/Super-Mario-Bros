package Logica;


import Enemigos.*;
import Fabricas.Sprite;
import Personaje.*;
import Plataformas.*;
import PowerUps.*;

public class CollisionVisitor implements Visitor {
	protected Personaje personaje;
    public void visitarPersonaje(Personaje p) {
    	
    }
    public void visitarPowerUp(PowerUps p) {
    	
    }
    public void visitarBolaDeFuego(BolaDeFuego b) {
    	
    } // ???????
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
