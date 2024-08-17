package Parcial_1_2023;

public class Transportador implements Runnable{
	
	private Embotelladora embotelladora;
	
	public Transportador(Embotelladora unaEmborelladora) {
		this.embotelladora=unaEmborelladora;
	}

	public void run() {
		while (true) {
			this.embotelladora.transpotarCajas();
			this.transportando();			
		}
	}
	
	public void transportando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}

