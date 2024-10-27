package Enemigos;

import Logica.Hitbox;
import Logica.Visitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.Timer;

import Fabricas.*;

public class PiranhaInvulnerable extends EstadosDePiranhaPlant {
   // private PiranhaPlant piranha;
    protected int x;
	protected int y;
	protected Sprite s;
	protected Hitbox hitb;
	protected int tiempoTranscurrido = 0;
	private Timer timer;

    public PiranhaInvulnerable(Sprite s,int x,int y,PiranhaPlant p) {
        super(p);
       // piranha = p;
		this.s = s;
		this.x = x;
		this.y = y;
    }
    
    public void cambiarEstado() {
    	actualizarSprite();
    	PiranhaExtendida estadoNuevo = new PiranhaExtendida(s, x, y, piranha);
		piranha.cambiarEstado(estadoNuevo);
		
    }
    
    public void moverse() {
    	timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiempoTranscurrido < 15) {
                    y -= 2; // Mover hacia arriba 2 píxeles
                    piranha.setPosY(y);
                    piranha.getHitbox().actualizar(x, y);
                    tiempoTranscurrido++;
                } else {
                    timer.stop();
                    //cambiarEstado(); // Cambiar al estado extendido después de 15 segundos
                }
            }
        });
        timer.start();
    }
    
    
    public PiranhaPlant getPiranhaPlant() {
		return piranha;
	}
	public void setPiranhaPlant(PiranhaPlant p) {
		piranha = p;
	}
	public Hitbox getHitbox() {
		return null;
	}
	public void actualizarSprite() {		
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.s = fabrica.getPiranhaPlantSpawneando();
		piranha.setSpriteActualizado(true);
	}
	public void setPosX(int x) {
	}
	public void setPosY(int y) {
	}

	



}

