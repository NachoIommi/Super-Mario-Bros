package Fabricas;

import Plataformas.Plataforma;

public interface GenerarPlataformas extends GeneradorDeEntidades{
	
	public Plataforma crearPlataforma(Sprite s, int x, int y);
	
}
