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
		return new Sprite("/img/nivel-1.png");
	}
	
	public Sprite getPersonajeNormalQuietoDerecha() {
		return new Sprite(rutaImagen + "/marioNormalQuietoDerecha.png");
	}
	
	public Sprite getPersonajeNormalQuietoIzquierda() {
		return new Sprite(rutaImagen + "/marioNormalQuietoIzquierda.png");
	}
	
	public Sprite getPersonajeNormalCorriendoDerecha() {
		return new Sprite (rutaImagen + "/marioNormalCorriendoDerecha.gif");
	}
	
	public Sprite getPersonajeNormalCorriendoIzquierda() {
		return new Sprite (rutaImagen + "/marioNormalCorriendoIzquierda.gif");
	}
	
	public Sprite getBolaDeFuego() {
		return new Sprite(rutaImagen + "/bolaDeFuegoViajando.gif");
	}
	
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaImagen + "/piranhaPlant.gif");
	}
	
	public Sprite getLakitu() {
		return new Sprite(rutaImagen + "/lakituApuntandoDerecha.png");
	}
	
	public Sprite getSpiny() {
		return new Sprite(rutaImagen + "/spinyCaminandoDerecha.gif");
	}
	
	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaImagen + "/buzzyCaminandoDerecha.gif");
	}
	
	public Sprite getGoomba() {
		return new Sprite(rutaImagen + "/goombaCaminando.gif");
	}
	
	public Sprite getKoopaTroopa() {
		return new Sprite(rutaImagen + "/koopaCaminaDerecha.gif");
	}
	
	public Sprite getMoneda() {
		return new Sprite(rutaImagen + "/monedaQuieta.gif");
	}
	
	public Sprite getEstrella() {
		return new Sprite(rutaImagen + "/estrella.gif");
	}
	
	public Sprite getSuperChampi() {
		return new Sprite(rutaImagen + "/superChampi.png");
	}
	
	public Sprite getChampiVerde() {
		return new Sprite(rutaImagen + "/champiVerde.png");
	}
	
	public Sprite getFlorDeFuego() {
		return new Sprite(rutaImagen + "/florDeFuego.gif");
	}
	
	public Sprite getBloqueSolido() {
		return new Sprite(rutaImagen + "/bloqueSolido1.png");
	}
	
	public Sprite getLadrilloSolido() {
		return new Sprite(rutaImagen + "/ladrilloSolido.png");
	}
	
	public Sprite getVacio() {
		return new Sprite(rutaImagen + "/vacio.png");
	}
	
	public Sprite getBloqueDePregunta() {
		return new Sprite(rutaImagen + "/bloqueDePregunta.gif");
	}
	
	public Sprite getTuberia() {
		return new Sprite(rutaImagen + "/tuberia.png");
	}
	
	public Sprite getSuperMario() {
		return new Sprite(rutaImagen + "/superMarioQuietoDerecha.png");
	}
	
	public Sprite getSuperMarioCorriendoIzquierda() {
		return new Sprite(rutaImagen + "/superMarioCorriendoIzquierda.gif");
	}
	
	public Sprite getSuperMarioCorriendoDerecha() {
		return new Sprite(rutaImagen + "/superMarioCorriendoDerecha.gif");
	}
	
}
