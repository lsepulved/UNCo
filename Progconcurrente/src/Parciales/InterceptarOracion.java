package Parciales;

public class InterceptarOracion implements Runnable{

	private Armada armada;
	
	public InterceptarOracion(Armada unaArmada) {
		this.armada=unaArmada;
	}
	
	public void run() {
			for(int i=1;i<=this.armada.getDivisiones();i++) {
				synchronized (armada) {
				this.armada.imprimirOracion();					
			}
	
//		synchronized (division) {
//			this.division.imprimirOracion2();	
		}
//		
	}
}
