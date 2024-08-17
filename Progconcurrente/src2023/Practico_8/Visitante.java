package Practico_8;

public class Visitante implements Runnable{
	
	boolean usaSilla;
	Observatorio observatorio;
	
	public Visitante(Observatorio unObservatorio, boolean usaSilla) {
		this.observatorio=unObservatorio;
		this.usaSilla=usaSilla;
	}
	
	public void run() {
		this.esperando();
		if (this.usaSilla) {
			this.observatorio.entrarVisitanteSilla();
			this.visitando();
			this.observatorio.salirVisitanteSilla();
		}else {
			this.observatorio.entrarVisitante();
			this.visitando();
			this.observatorio.salirVisitante();
		}
	}

	public void esperando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void visitando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
