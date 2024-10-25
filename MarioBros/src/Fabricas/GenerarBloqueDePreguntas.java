package Fabricas;

import Plataformas.BloqueDePregunta;

public class GenerarBloqueDePreguntas implements GenerarPlataformas{
	
	public BloqueDePregunta crearPlataforma(Sprite sprite, int x, int y){
		return new BloqueDePregunta(sprite, x, y);
	}
	
}
