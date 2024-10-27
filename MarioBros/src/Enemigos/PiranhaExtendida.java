package Enemigos;

import Logica.Hitbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Fabricas.*;


public class PiranhaExtendida extends EstadosDePiranhaPlant{
	//private PiranhaPlant piranha;
	protected int x;
	protected int y;
	protected Sprite s;
	protected Hitbox hitb;
	
	protected Timer timer;
	protected int tiempoTranscurrido = 0;
	
	
	public PiranhaExtendida(Sprite s,int x,int y,PiranhaPlant piranha) {
		super(piranha);
		//piranha = p;
		this.s = s;
		this.x = x;
		this.y = y;
	}
	public void cambiarEstado() {
		actualizarSprite();
		PiranhaInvulnerable estadoNuevo = new PiranhaInvulnerable(s, x, y, piranha);
		piranha.cambiarEstado(estadoNuevo);
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
	public void setPosX(int x) {
	}
	public void setPosY(int y) {
	}
	public void actualizarSprite() {
		GenerarSprite fabrica = new GenerarSpriteOriginal();
		this.s = fabrica.getPiranhaPlant();
		piranha.setSpriteActualizado(true);
	}

	public void moverse() {
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiempoTranscurrido < 15) {
                    y += 2; // Mover hacia abajo 2 píxeles
                    piranha.setPosY(y);
                    piranha.getHitbox().actualizar(x, y);
                    tiempoTranscurrido++;
                } else {
                    timer.stop();
                    cambiarEstado(); // Cambiar al estado invulnerable después de 15 segundos
                }
            }
        });
        timer.start();
    }
	

}
