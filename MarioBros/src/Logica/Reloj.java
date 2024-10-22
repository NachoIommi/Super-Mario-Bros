package Logica;

public class Reloj extends Thread{
	
	protected int segundos;
	
	public Reloj() {
		segundos = 300;
	}
	
	public void run() {
		while(segundos > 0) {
			try {
				segundos--;
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Segundos: "+ segundos);
		}
	}
	
	public int getSegundos() {
		return segundos;
	}

		
}
