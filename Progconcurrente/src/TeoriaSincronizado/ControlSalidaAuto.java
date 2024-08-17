package TeoriaSincronizado;

public class ControlSalidaAuto implements Runnable{

	private Estacionamiento estacionamiento;
	
	public ControlSalidaAuto (Estacionamiento unEstacionamiento) {
		this.estacionamiento=unEstacionamiento;
	}
	
	public void run() {
		for (int i=1;i<10;i++) {
			this.estacionamiento.salirAuto();
		}		
	}
	
}

