package Practico_5;

public class MainPollo {

	public static void main(String[]args) {
		
		int cantEmpleados=10;
		
		Silla unaSilla=new Silla("Silla");
		
		Mozo unMozo=new Mozo(unaSilla);
		Thread hiloMozo=new Thread(unMozo,"Mozo");
		hiloMozo.start();
		
		Cocinero unCocinero= new Cocinero(unaSilla);
		Thread hiloCocinero=new Thread(unCocinero,"Cocinero");
		hiloCocinero.start();
		
		for (int i=0;i<cantEmpleados;i++) {
			Empleado unEmpleado=new Empleado(unaSilla);
			Thread hiloEmpleado=new Thread(unEmpleado,"Empleado "+i);
			hiloEmpleado.start();
		}
	}

}
