package Fabricas;

import Plataformas.BloqueDePregunta;

public class GenerarBloqueDePreguntas implements GenerarPlataformas{
	
	public BloqueDePregunta crearPlataforma(int x, int y){
		return new BloqueDePregunta(x,y);
		
	}
}
