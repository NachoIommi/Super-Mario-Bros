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
	
	public Sprite getPersonajeNormalDerrapandoDerecha() {
		return new Sprite(rutaImagen + "/marioNormalDerrapandoDerecha.png");
	}
	
	public Sprite getPersonajeNormalDerrapandoIzquierda() {
		return new Sprite(rutaImagen + "/marioNormalDerrapandoIzquierda.png");
	}
	
	public Sprite getPersonajeNormalQuietoDerecha() {
		return new Sprite(rutaImagen + "/marioNormalQuietoDerecha.png");
	}
	
	public Sprite getPersonajeNormalQuietoIzquierda() {
		return new Sprite(rutaImagen + "/marioNormalQuietoIzquierda.png");
	}
	
	public Sprite getPersonajeNormalMuerto() {
		return new Sprite(rutaImagen + "/marioNormalMuerto.png");
	}
	
	public Sprite getPersonajeNormalSaltoDerecha() {
		return new Sprite(rutaImagen + "/marioNormalSaltoDerecha.png");
	}
	
	public Sprite getPersonajeNormalSaltoIzquierda() {
		return new Sprite(rutaImagen + "/marioNormalSaltoIzquierda.png");
	}
	
	public Sprite getPersonajeNormalCorriendoDerecha() {
		return new Sprite (rutaImagen + "/marioNormalCorriendoDerecha.gif");
	}
	
	public Sprite getPersonajeNormalCorriendoIzquierda() {
		return new Sprite (rutaImagen + "/marioNormalCorriendoIzquierda.gif");
	}
	
	public Sprite getSuperMarioDerrapandoDerecha() {
		return new Sprite(rutaImagen + "/superMarioDerrapandoDerecha.png");
	}
	
	public Sprite getSuperMarioDerrapandoIzquierda() {
		return new Sprite(rutaImagen + "/superMarioDerrapandoIzquierda.png");
	}
	
	public Sprite getSuperMario() {
		return new Sprite(rutaImagen + "/superMarioQuietoDerecha.png");
	}
	
	public Sprite getSuperMarioQuietoIzquierda() {
		return new Sprite(rutaImagen + "/superMarioQuietoIzquierda.png");
	}
	
	public Sprite getSuperMarioMuerto() {
		return new Sprite(rutaImagen + "/superMarioMuerto.png");
	}
	
	public Sprite getSuperMarioSaltoIzquierda() {
		return new Sprite(rutaImagen + "/superMarioSaltoIzquierda.png");
	}
	
	public Sprite getSuperMarioSaltoDerecha() {
		return new Sprite(rutaImagen + "/superMarioSaltoDerecha.png");
	}
	
	public Sprite getSuperMarioCorriendoIzquierda() {
		return new Sprite(rutaImagen + "/superMarioCorriendoIzquierda.gif");
	}
	
	public Sprite getSuperMarioCorriendoDerecha() {
		return new Sprite(rutaImagen + "/superMarioCorriendoDerecha.gif");
	}
	
	public Sprite getSuperMarioAgachadoIzquierda() {
		return new Sprite(rutaImagen + "/superMarioAgachadoIzquierda.png");
	}
	
	public Sprite getSuperMarioAgachadoDerecha() {
		return new Sprite(rutaImagen + "/superMarioAgachadoDerecha.png");
	}
	
	public Sprite getMarioEstrellaDerrapandoDerecha() {
		return new Sprite(rutaImagen + "/marioEstrellaDerrapandoDerecha.gif");
	}
	
	public Sprite getMarioEstrellaDerrapandoIzquierda() {
		return new Sprite(rutaImagen + "/marioEstrellaDerrapandoIzquierda.gif");
	}
	
	public Sprite getMarioEstrellaQuietoDerecha() {
		return new Sprite(rutaImagen + "/marioEstrellaQuietoDerecha.gif");
	}
	
	public Sprite getMarioEstrellaQuietoIzquierda() {
		return new Sprite(rutaImagen + "/marioEstrellaQuietoIzquierda.gif");
	}
	
	public Sprite getMarioEstrellaMuerto() {
		return new Sprite(rutaImagen + "/marioEstrellaMuerto.gif");
	}
	
	public Sprite getMarioEstrellaSaltoIzquierda() {
		return new Sprite(rutaImagen + "/marioEstrellaSaltoIzquierda.gif");
	}
	
	public Sprite getMarioEstrellaSaltoDerecha() {
		return new Sprite(rutaImagen + "/marioEstrellaSaltoDerecha.gif");
	}
	
	public Sprite getMarioEstrellaCorriendoIzquierda() {
		return new Sprite(rutaImagen + "/marioEstrellaCorriendoIzquierda.gif");
	}
	
	public Sprite getMarioEstrellaCorriendoDerecha() {
		return new Sprite(rutaImagen + "/marioEstrellaCorriendoDerecha.gif");
	}
	
	public Sprite getMarioEstrellaAgachadoIzquierda() {
		return new Sprite(rutaImagen + "/marioEstrellaAgachadoIzquierda.gif");
	}
	
	public Sprite getMarioEstrellaAgachadoDerecha() {
		return new Sprite(rutaImagen + "/marioEstrellaAgachadoDerecha.gif");
	}
	
	public Sprite getMarioFlorDeFuegoQuietoDerecha() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoQuietoDerecha.png");
	}
	
	public Sprite getMarioFlorDeFuegoDerrapandoDerecha() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoDerrapandoDerecha.png");
	}
	
	public Sprite getMarioFlorDeFuegoDerrapandoIzquierda() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoDerrapandoIzquierda.png");
	}
	
	public Sprite getMarioFlorDeFuegoQuietoIzquierda() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoQuietoIzquierda.png");
	}
	
	public Sprite getMarioFlorDeFuegoMuerto() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoMuerto.png");
	}
	
	public Sprite getMarioFlorDeFuegoSaltoIzquierda() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoSaltoIzquierda.png");
	}
	
	public Sprite getMarioFlorDeFuegoSaltoDerecha() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoSaltoDerecha.png");
	}
	
	public Sprite getMarioFlorDeFuegoCorriendoIzquierda() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoCorriendoIzquierda.gif");
	}
	
	public Sprite getMarioFlorDeFuegoCorriendoDerecha() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoCorriendoDerecha.gif");
	}
	
	public Sprite getMarioFlorDeFuegoAgachadoIzquierda() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoAgachadoIzquierda.png");
	}
	
	public Sprite getMarioFlorDeFuegoAgachadoDerecha() {
		return new Sprite(rutaImagen + "/marioFlorDeFuegoAgachadoDerecha.png");
	}
	
	public Sprite getBolaDeFuego() {
		return new Sprite(rutaImagen + "/bolaDeFuegoViajando.gif");
	}
	
	public Sprite getBolaDeFuegoColision() {
		return new Sprite(rutaImagen + "/bolaDeFuegoColision.png");
	}
	
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaImagen + "/piranhaPlant.gif");
	}
	
	public Sprite getPiranhaPlantSpawneando() {
		return new Sprite(rutaImagen + "/piranhaPlantSpawneando.gif");
	}
	
	public Sprite getLakitu() {
		return new Sprite(rutaImagen + "/lakituApuntandoDerecha.png");
	}
	
	public Sprite getLakituApuntandoIzquierda() {
		return new Sprite(rutaImagen + "/lakituApuntandoIzquierda.png");
	}
	
	public Sprite getLakituPorDisparar() {
		return new Sprite(rutaImagen + "/lakituPorDisparar.png");
	}
	
	public Sprite getSpinySpawneando() {
		return new Sprite(rutaImagen + "/spinySpawneando.gif");
	}
	
	public Sprite getSpinyCaminandoDerecha() {
		return new Sprite(rutaImagen + "/spinyCaminandoDerecha.gif");
	}
	
	public Sprite getSpinyCaminandoIzquierda() {
		return new Sprite(rutaImagen + "/spinyCaminandoIzquierda.gif");
	}
	
	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaImagen + "/buzzyCaminandoDerecha.gif");
	}
	
	public Sprite getBuzzyBeetleCaminandoIzquierda() {
		return new Sprite(rutaImagen + "/buzzyCaminandoDerecha.gif");
	}
	
	public Sprite getBuzzyBeetleRetraido() {
		return new Sprite(rutaImagen + "/buzzyCaminandoDerecha.gif");
	}
	
	public Sprite getGoomba() {
		return new Sprite(rutaImagen + "/goombaCaminando.gif");
	}
	
	public Sprite getGoombaMuerto() {
		return new Sprite(rutaImagen + "/goombaMuerto.png");
	}
	
	public Sprite getKoopaTroopa() {
		return new Sprite(rutaImagen + "/koopaCaminaDerecha.gif");
	}
	
	public Sprite getKoopaTroopaCaminandoIzquierda() {
		return new Sprite(rutaImagen + "/koopaCaminaIzquierda.gif");
	}
	
	public Sprite getKoopaTroopaRetraido() {
		return new Sprite(rutaImagen + "/koopaRetraido.png");
	}
	
	public Sprite getKoopaTroopaMuerto() {
		return new Sprite(rutaImagen + "/koopaMuerto.png");
	}
	
	public Sprite getMoneda() {
		return new Sprite(rutaImagen + "/monedaQuieta.gif");
	}
	
	public Sprite getMonedaSaltando() {
		return new Sprite(rutaImagen + "/monedaSaltando.gif");
	}
	
	public Sprite getEstrella() {
		return new Sprite(rutaImagen + "/estrella.gif");
	}
	public Sprite getEstrellaSpawneando() {
		return new Sprite(rutaImagen + "/estrellaSpawneando.gif");
	}
	
	public Sprite getSuperChampi() {
		return new Sprite(rutaImagen + "/superChampi.png");
	}
	
	public Sprite getSuperChampiSpawneando() {
		return new Sprite(rutaImagen + "/superChampiSpawneando.gif");
	}
	
	public Sprite getChampiVerde() {
		return new Sprite(rutaImagen + "/champiVerde.png");
	}
	
	public Sprite getChampiVerdeSpawneando() {
		return new Sprite(rutaImagen + "/champiVerdeSpawneando.gif");
	}
	
	public Sprite getFlorDeFuego() {
		return new Sprite(rutaImagen + "/florDeFuego.gif");
	}
	
	public Sprite getFlorDeFuegoSpawneando() {
		return new Sprite(rutaImagen + "/florDeFuegoSpawneando.gif");
	}
	
	public Sprite getBloqueSolido() {
		return new Sprite(rutaImagen + "/bloqueSolido1.png");
	}
	
	public Sprite getBloqueSolido2() {
		return new Sprite(rutaImagen + "/bloqueSolido2.png");
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
	
	public Sprite getBloqueDePreguntaRoto() {
		return new Sprite(rutaImagen + "/bloqueDePreguntaRoto.png");
	}
	
	public Sprite getTuberia() {
		return new Sprite(rutaImagen + "/tuberia.png");
	}
	
	public Sprite getTuberiaMini() {
		return new Sprite(rutaImagen + "/tuberiaMini.png");
	}
	
	public Sprite getTuberiaGrande() {
		return new Sprite(rutaImagen + "/tuberiaGrande.png");
	}
	
	
	
	
}
