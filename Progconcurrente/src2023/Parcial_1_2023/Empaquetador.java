package Parcial_1_2023;

public class Empaquetador implements Runnable{

	private Embotelladora embotelladora;
	
	public Empaquetador(Embotelladora unaEmbotelladora) {
		this.embotelladora=unaEmbotelladora;
	}
	
	public void run() {
		while (true) {
			this.embotelladora.empaquetar();
			this.empaquetando();
			this.embotelladora.dejarCaja();			
		}
	}
	
	public void empaquetando() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
