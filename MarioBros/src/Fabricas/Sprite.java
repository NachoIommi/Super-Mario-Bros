package Fabricas;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


public class Sprite {
	
	protected String rutaImagen;
	protected BufferedImage imagen;
	
	public Sprite(String rutaImagen) {
		this.rutaImagen = rutaImagen;
		cargarImagen();
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}
	
	public void setRutaImagen(String s) {
		rutaImagen = s
	}
	
	public void cargarImagen() {
		try {
			imagen = ImageIO.read(new File(rutaImagen));
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error al cargar la imagen: "+ rutaImagen);
		}
	}
	
	public BufferedImage getImagen() {
		return imagen;
	}
}
