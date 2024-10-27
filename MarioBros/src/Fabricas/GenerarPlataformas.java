package Fabricas;

import Enemigos.Enemigo;
import Plataformas.Plataforma;
import PowerUps.PowerUps;

public interface GenerarPlataformas extends GeneradorDeEntidades{
	
	
	public Plataforma crearPlataforma(Sprite s, int x, int y);
	public Plataforma crearPlataforma(Sprite s,int x , int y , PowerUps p , int i);
	public Plataforma crearPlataforma(Sprite s, int x, int y, Enemigo e,int reloj);

	
}
