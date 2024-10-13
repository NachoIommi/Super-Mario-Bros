package Fabricas;

public class GenerarPiranhaPlant implements GenerarEnemigos{
	public PiranhaPlant crearEnemigo(int x, int y) {
		return new PiranhaPlant(int x, int y);
	}
}
