package Fabricas;

public interface GenerarSpriteOriginal implements GenerarSprite{
	
	public SpriteOriginal crearSprite() {
		return new SpriteOriginal();
	}
}
