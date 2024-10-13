package Logica;
import GUI.ControladorVistas;

public class Juego {
	//protected Ranking ranking;
	protected Mundo mundos;
	protected int modoDeJuego;
	
	protected ControladorVistas controladorVistas;
	
	
	public Juego() {
		//Creo las fabricas de entidades. TO DO
	}
	
	public void setControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	
	public void iniciarJuego() {
		controladorVistas.mostrarPantallaJuego();
	}
	public void perderJuego() {
		controladorVistas.mostrarPantallaPerder();
	}
	
	public void seleccionarMundo(Mundo m) {
		
	}
	
	public void agregarMundo(Mundo m) {
		
	}
	
	public void eliminarMundo(Mundo m) {
		
	}
	
	public Mundo getMundo() {
		return mundos;
	}
	
	public int getModoDeJuego() {
		
	}
	
	public void setModoDeJuego(int n) {
		
	}
	
	public Ranking getRanking() {
		
	}
	
	public void setRanking(Ranking r) {
		
	}
	
	
}
