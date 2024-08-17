package Practico_8;

public class Paciente implements Runnable{

	CentroHemoterapia centro;
	
	public Paciente (CentroHemoterapia unCentro) {
		this.centro=unCentro;
	}
	
	public void run() {
		this.centro.entrarSala();
		this.centro.usarRevista();
//		this.esperando();
		this.centro.usarCamilla();
		this.centro.dejarRevista();
//		this.esperando();
		this.centro.dejarCamilla();
		this.centro.dejarSala();
	}
	
	
	public void esperando() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
