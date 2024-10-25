package Fabricas;

import Plataformas.Plataforma;
import PowerUps.PowerUps;

public interface GenerarPlataformas extends GeneradorDeEntidades{
	
	
	public Plataforma crearPlataforma(Sprite s, int x, int y);
	public Plataforma crearPlataforma(Sprite s,int x , int y , PowerUps p);
	
}
