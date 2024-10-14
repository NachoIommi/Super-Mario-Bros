package Fabricas;

public abstract class GenerarSprite implements GeneradorDeEntidades{
	
	protected String rutaImagen;
	
	public GenerarSprite(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String ruta() {
		return rutaImagen;
	}
	
	public Sprite getNivel(int n) {
		return new Sprite(rutaImagen + "/nivel-"+n+".png");
	}
	
	public Sprite getPersonaje() {
		return new Sprite(rutaImagen + "/quietoNormal.png");
	}
	
	public Sprite getBolaDeFuego() {
		return new Sprite(rutaImagen + "/sprites/bolaDeFuego.png");
	}
	
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaImagen + "/spritesEnemigos/piranhaPlant.png");
	}
	
	public Sprite getLakitu() {
		return new Sprite(rutaImagen + "/spritesEnemigos/lakitu.png");
	}
	
	public Sprite getSpiny() {
		return new Sprite(rutaImagen + "/spritesEnemigos/Spiny.png");
	}
	
	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaImagen + "/spritesEnemigos/BuzzyBeetle.png");
	}
	
	public Sprite getGoomba() {
		return new Sprite(rutaImagen + "/spritesEnemigos/Goomba.png");
	}
	
	public Sprite getKoopaTroopa() {
		return new Sprite(rutaImagen + "/spritesEnemigos/KoopaTroopa.png");
	}
	
	public Sprite getMoneda() {
		return new Sprite(rutaImagen + "/spritesPowerUps/moneda.png");
	}
	
	public Sprite getEstrella() {
		return new Sprite(rutaImagen + "/spritesPowerUps/estrella.png");
	}
	
	public Sprite getSuperChampi() {
		return new Sprite(rutaImagen + "/spritesPowerUps/superChampi.png");
	}
	
	public Sprite getChampiVerde() {
		return new Sprite(rutaImagen + "/spritesPowerUps/champiVerde.png");
	}
	
	public Sprite getBloqueSolido() {
		return new Sprite(rutaImagen + "/spritesPlataformas/bloqueSolido.png");
	}
	
	public Sprite getLadrilloSolido() {
		return new Sprite(rutaImagen + "/spritesPlataforma/ladrilloSolido.png");
	}
	
	public Sprite getVacio() {
		return new Sprite(rutaImagen + "/spritesPlataformas/vacio.png");
	}
	
	public Sprite getBloqueDePregunta() {
		return new Sprite(rutaImagen + "/spritesPlataformas/bloqueDePregunta.png");
	}
	
	
	
	
}
