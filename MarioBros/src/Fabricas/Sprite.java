package Fabricas;

public class Sprite {
	
	protected String rutaImagen;
	
	public Sprite(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}
	
	public void setRutaImagen(String nuevaRuta) {
		rutaImagen = nuevaRuta;
	}
}
