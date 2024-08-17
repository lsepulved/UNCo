package Practico5;

public class MainPollos {

	public static void main(String []args) {

		int cantEmpleados=3;
		
		Mesa mesa=new Mesa();
		
		Thread[] empleados=new Thread[cantEmpleados];
		
		Mozo mozo=new Mozo(mesa);
		Thread hiloMozo=new Thread(mozo,"Mozo");

		Cocinero cocinero=new Cocinero(mesa);
		Thread hiloCocinero=new Thread(cocinero,"Cocinero");
		
		for (int i=0;i<cantEmpleados;i++) {
			Empleado empleado=new Empleado(mesa);
			empleados[i]=new Thread(empleado, "Empleado"+i);
			empleados[i].start();
		}
		
		hiloMozo.start();
		hiloCocinero.start();
	}
}
