package Parcial_1_2023;

public class Oxigeno implements Runnable{

	Espacio espacio;
	
	public Oxigeno(Espacio unEspacio) {
		this.espacio=unEspacio;
	}
	
	public void run() {
		this.enElEspacio();
		this.espacio.Olisto();
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
