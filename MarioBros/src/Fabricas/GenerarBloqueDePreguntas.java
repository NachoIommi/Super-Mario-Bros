package Fabricas;

import Enemigos.PiranhaPlant;
import Plataformas.BloqueDePregunta;
import Plataformas.Plataforma;

public class GenerarBloqueDePreguntas implements GenerarPlataformas{
	
	public BloqueDePregunta crearPlataforma(Sprite sprite, int x, int y){
		return new BloqueDePregunta(sprite, x, y);
	}

	@Override
	public Plataforma crearPlataforma(Sprite tuberia, int posX, int posY, PiranhaPlant p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
