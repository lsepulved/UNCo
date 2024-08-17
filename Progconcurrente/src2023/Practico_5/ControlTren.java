package Practico_5;

public class ControlTren implements Runnable {

	Tren tren;
	
	public ControlTren (Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {
		while (true) {
			this.tren.iniciarViaje();
			this.viajando();
			this.tren.terminaViaje();	
			this.tren.volverTerminal();
		}
	}
	
	public void viajando() {
		try {
			System.out.println(Thread.currentThread().getName()+"......VIAJANDO");
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
