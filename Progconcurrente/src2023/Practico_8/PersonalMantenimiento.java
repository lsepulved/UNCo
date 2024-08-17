package Practico_8;

public class PersonalMantenimiento implements Runnable {

	Observatorio observatorio;
	
	public PersonalMantenimiento (Observatorio unObservatorio) {
		this.observatorio=unObservatorio;
	}
	
	public void run() {
		this.esperando();
		this.observatorio.entrarMantenimiento();
		this.trabajando();
		this.observatorio.salirMantenimiento();
	}
	
	public void esperando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void trabajando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
