package Logica;
import javax.swing.JLabel;

public abstract class Entidad extends JLabel{
	
	public abstract void aceptarVisita(Visitor v);
	
	public abstract void cargarSprite(Sprite s);
	
}
