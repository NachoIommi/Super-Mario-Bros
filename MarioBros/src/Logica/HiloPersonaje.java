package Logica;

public class HiloPersonaje extends Thread {
	
	Juego juego;
	
	public HiloPersonaje(Juego j) {
		juego = j;
	}
	
	public void run() {
		while(true) {
			try {
				juego.getPersonaje().moverPersonaje();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}
	}
	
	

}
