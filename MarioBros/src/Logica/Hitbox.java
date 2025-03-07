package Logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hitbox extends Rectangle{
	protected int x, y;
	protected int width, height;

	
	public Hitbox(int x, int y, int width, int height) {
		super(x, y, width, height); 
	    this.width = width;
	    this.height = height;    
	}
	
	public void actualizar(int x, int y) {
		setBounds(x, y, width, height);
	} 
	
	public boolean colisionaCon(Hitbox otraHitbox) {
	    return this.intersects(otraHitbox);
	}

	
	public void drawHitbox(Graphics g) {
		g.setColor(Color.RED);  
		g.drawRect(x,y,width,height);  
	}
	
	public Hitbox getHitbox() {
		return this;
	}

}
