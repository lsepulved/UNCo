package TeoriaSincronizado;

public class ControlIngresoMoto implements Runnable{
	
	private Estacionamiento estacionamiento;
	
	public ControlIngresoMoto (Estacionamiento unEstacionamiento) {
		this.estacionamiento=unEstacionamiento;
	}
	
	public void run() {
		for (int i=1;i<10;i++) {
			this.estacionamiento.ingresarMoto();
		}
		
	}
}

