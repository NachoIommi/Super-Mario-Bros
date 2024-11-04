package Logica;

import Enemigos.BuzzyBeetle;
import Enemigos.Goomba;
import Enemigos.KoopaTroopa;
import Enemigos.Lakitu;
import Enemigos.PiranhaPlant;
import Enemigos.Spiny;
import Fabricas.Sprite;
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

	@Override
	public void visitarBolaDeFuego(BolaDeFuego b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMoneda(Moneda m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarFlorDeFuego(FlorDeFuego f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperChampi(SuperChampi s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarEstrella(Estrella e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarChampiVerde(ChampiVerde c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBloqueDePregunta(BloqueDePregunta p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarLadrilloSolido(LadrilloSolido l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVacio(Vacio v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarTuberia(Tuberia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPiranhaPlant(PiranhaPlant p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarLakitu(Lakitu l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSpiny(Spiny s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBuzzyBeetle(BuzzyBeetle b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarGoomba(Goomba g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarKoopaTroopa(KoopaTroopa k) {
		k.morir();
		
	}

	@Override
	public void visitarMusica(Musica m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPantalla(Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSprite(Sprite s) {
		// TODO Auto-generated method stub
		
	}

}
