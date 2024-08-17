package Practico_8;

public class Empaquetador implements Runnable{

	private Pasteleria pasteleria;
	
	public Empaquetador(Pasteleria unaPasteleria) {
		this.pasteleria=unaPasteleria;
	}
	
	public void run() {
		int peso;
		peso=this.pasteleria.tomarPastel();
		
	}
}
