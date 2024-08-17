package Practico_5;

public class TorreControl implements Runnable{

	private Pista pista;
	
	public TorreControl(Pista unaPista) {
		this.pista=unaPista;
	}
	
	public void run() {
		while(true) {
			this.pista.controlarPista();		
		}
	}
}
