package Logica;

public class Mundo {
	
	protected Nivel nivel;
	
	public Mundo() {
		
	}
	
	public void cargarPrimerNivel() {
		nivel.cargarNivel(0);
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
