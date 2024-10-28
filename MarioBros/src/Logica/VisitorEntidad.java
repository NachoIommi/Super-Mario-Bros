package Logica;

import Enemigos.*; 
import Fabricas.*;
import Personaje.*;
import Plataformas.*;
import PowerUps.*;

public class VisitorEntidad implements Visitor{
	protected Personaje personaje;
	protected KoopaTroopa koopa;
	
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
    	p.recibirGolpe(personaje);
    }
    
    public void visitarLadrilloSolido(LadrilloSolido l) {
    	l.recibirGolpe(personaje);
    }
    
    public void visitarVacio(Vacio v) {    	
    }
    
    public void visitarTuberia(Tuberia t) {
    	
    }
    
    public void visitarPiranhaPlant(PiranhaPlant p) {
    
    }
    
    public void visitarLakitu(Lakitu l) {
    
    }
    
    public void visitarSpiny(Spiny s) {
    
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle b) {
    
    }
    
    public void visitarGoomba(Goomba g) {
    	
    }
    
    public void visitarKoopaTroopa(KoopaTroopa k) {
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
