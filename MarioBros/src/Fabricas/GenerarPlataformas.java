package Fabricas;

import Enemigos.Enemigo;
import Enemigos.PiranhaPlant;
import Logica.Entidad;
import Plataformas.Plataforma;

public interface GenerarPlataformas extends GeneradorDeEntidades{
	
	public Plataforma crearPlataforma(Sprite s, int x, int y);

	public Plataforma crearPlataforma(Sprite tuberia, int posX, int posY, PiranhaPlant p);
	
}
