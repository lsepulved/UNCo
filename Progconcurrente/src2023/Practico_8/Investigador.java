package Practico_8;

public class Investigador implements Runnable {

	Observatorio observatorio;
	
	public Investigador (Observatorio unObservatorio) {
		this.observatorio=unObservatorio;
	}
	
	
	public void run() {
		this.esperando();
		this.observatorio.entrarInvestigador();
		this.investigando();
		this.observatorio.salirInvestigador();
	}
	
	public void esperando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void investigando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
