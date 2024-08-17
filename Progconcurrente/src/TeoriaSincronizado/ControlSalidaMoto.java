package TeoriaSincronizado;

public class ControlSalidaMoto implements Runnable{

	private Estacionamiento estacionamiento;
	
	public ControlSalidaMoto (Estacionamiento unEstacionamiento) {
		this.estacionamiento=unEstacionamiento;
	}
	
	public void run() {
		for (int i=1;i<10;i++) {
			this.estacionamiento.salirMoto();
		}
		
	}
	
}
