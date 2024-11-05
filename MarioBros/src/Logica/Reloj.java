package Logica;

public class Reloj extends Thread{
	
	protected int segundos;
	private volatile boolean enEjecucion;
	
	public Reloj() {
		segundos = 300;
	}
	
	public void detener() {
    	enEjecucion = false;
    }
	
	public void run() {
		enEjecucion = true;
		segundos = 300;
		while(enEjecucion) {
			try {
				segundos--;
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getSegundos() {
		return segundos;
	}

		
}
