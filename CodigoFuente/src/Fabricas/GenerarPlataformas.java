package Fabricas;

import Enemigos.Enemigo;
import Logica.Nivel;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public interface GenerarPlataformas extends GeneradorDeEntidades{
	
	
	public Plataforma crearPlataforma(Sprite s, int x, int y, Nivel nivelActual);
	public Plataforma crearPlataforma(Sprite s,int x , int y , PowerUp p , int i, Nivel nivelActual);
	public Plataforma crearPlataforma(Sprite s,int x , int y , Enemigo p, Nivel nivelActual);

	
}
