package Logica;

public class Reloj extends Thread{
	
	protected int segundos;
	protected final static int segundosIniciales = 300;
	private volatile boolean enEjecucion;
	
	public Reloj() {
		segundos = segundosIniciales;
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
	
	public int getSegundosIniciales() {
		return segundosIniciales;
	}
		
}
