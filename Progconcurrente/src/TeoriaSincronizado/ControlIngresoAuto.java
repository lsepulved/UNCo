package TeoriaSincronizado;

public class ControlIngresoAuto implements Runnable{

	private Estacionamiento estacionamiento;
	
	public ControlIngresoAuto (Estacionamiento unEstacionamiento) {
		this.estacionamiento=unEstacionamiento;
	}
	
	public void run() {
		for (int i=1;i<10;i++) {
//			System.out.println(Thread.currentThread().getName());
			this.estacionamiento.ingresarAuto();
		}
	}
}