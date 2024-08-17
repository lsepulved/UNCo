package Parcial_1_2023;

public class Embotellador implements Runnable {
	
	private Embotelladora embotelladora;
	private char tipo;
	
	public Embotellador (Embotelladora unaEmbotelladora, char unTipo) {
		this.embotelladora=unaEmbotelladora;
		this.tipo=unTipo;
	}
	
	public void run() {
		while (true) {
			if (this.tipo=='A') {
				this.embotelladora.embotellarAgua();	
			}else {
				this.embotelladora.embotellarVino();
			}			
		}
		
	}
}
