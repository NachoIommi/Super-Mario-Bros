package Logica;
import javax.swing.JLabel;
import Fabricas.Sprite;

public abstract class Entidad extends JLabel{
	protected boolean spriteActualizado;
	protected Visitor v;
	public abstract void aceptarVisita(Visitor v);
	public abstract void cargarSprite(Sprite s);
	public abstract Sprite getSprite();
	public abstract Hitbox getHitbox();
	public abstract boolean necesitaActualizarSprite();
	public abstract void setSpriteActualizado(boolean actualizada);
	
}
