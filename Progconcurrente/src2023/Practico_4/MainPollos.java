package Practico_4;

public class MainPollos {

	public static void main(String[] args) {
		
		Silla silla=new Silla("Pollos Hermanos");
		
		
		Mozo mozo=new Mozo(silla);
		Thread hiloMozo=new Thread(mozo,"Mozo");
		hiloMozo.start();
		
		
		int cantHilos=5;
		
		for(int i=0;i<cantHilos;i++) {
			Empleado unEmpleado=new Empleado(silla);
			Thread hilo=new Thread(unEmpleado,"Empleado "+i);
			hilo.start();
		}
		
	}
}
