package Plataformas;

import Fabricas.Sprite;
import Logica.Hitbox;
import Logica.Visitor;
import Personaje.Personaje;
import PowerUps.PowerUps;

public class BloqueGolpeable extends EstadoDeBloque{
	
	protected int golpesRestantes;
	protected int x;
	protected int y;
	protected Hitbox hitb;
	protected Sprite sprite;
	protected int vidaDelBloque=5;
	
	public BloqueGolpeable(BloqueDePregunta b,Sprite s , int x , int y) {
		super(b);
		this.x=x;
		this.y=y;
		hitb = new Hitbox(x ,y,30 ,30);
		sprite=s;		
	}
	
	public void recibirGolpe(Personaje p) {
	    System.out.println("visitado1 - bloque golpeable fue golpeado");  // Añadir log para ver si entra aquí
	    bloque.soltarContenido();  // Activar el contenido (moneda)
	    System.out.println("visitado2 - contenido soltado");
	    //bloque.cambiarEstado(new BloqueGolpeado(bloque, sprite, x, y));  // Cambiar el estado del bloque
	}
	
	public void soltarContenido() {
		this.getContenido().activarPowerUp();
		System.out.println("visitado4");
		
	}
	
	public BloqueDePregunta getBloque() {
		return bloque;
	}
	
	public int getGolpesRestantes() {
		return golpesRestantes;
	}

	@Override
	public void setContenido(PowerUps p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarEstado(EstadoDeBloque e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptarVisita(Visitor v) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public EstadoDeBloque getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PowerUps getContenido() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
