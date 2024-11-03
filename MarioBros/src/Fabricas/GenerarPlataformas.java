package Fabricas;

import Enemigos.Enemigo;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public interface GenerarPlataformas extends GeneradorDeEntidades{
	
	
	public Plataforma crearPlataforma(Sprite s, int x, int y);
	public Plataforma crearPlataforma(Sprite s,int x , int y , PowerUp p , int i);
	public Plataforma crearPlataforma(Sprite s,int x , int y , Enemigo p);

	
}
