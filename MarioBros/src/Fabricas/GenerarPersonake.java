package Fabricas;

public class GenerarPersonaje implements GeneradorDeEntidades{
	
	public Personaje crearPersonaje(int x, int y) {
		return new Personaje();
	}
}
