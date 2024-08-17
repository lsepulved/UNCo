package Parcial_1_2023;

public class Hidrogeno implements Runnable {

	Espacio espacio;
	
	public Hidrogeno(Espacio unEspacio) {
		this.espacio=unEspacio;
	}
	
	public void run() {
		this.enElEspacio();
		this.espacio.Hlisto();
	}
	
	public void enElEspacio() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

