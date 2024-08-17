package Practico6;

public class Paciente implements Runnable{

	private CentroHemoterapia centro;
	
	public Paciente (CentroHemoterapia unCentro) {
		this.centro=unCentro;
	}
	
	public void run() {
		this.centro.entrarCentro();
		System.out.println("****"+Thread.currentThread().getName()+ " entra al Centro");
		this.centro.usarCamilla();
		System.out.println("****"+Thread.currentThread().getName()+ " usa camilla para donar sangre");
		this.donar();
		this.centro.salirCentro();
		System.out.println("****"+Thread.currentThread().getName()+ " salio del Centro");
	}
	
	public void donar() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
