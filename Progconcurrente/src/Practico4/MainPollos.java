package Practico4;

public class MainPollos {

	public static void main(String []args) {

		int cantEmpleados=3;
		
		Mesa mesa=new Mesa();
		
		Thread[] empleados=new Thread[cantEmpleados];
		
		Mozo mozo=new Mozo(mesa);
		Thread hiloMozo=new Thread(mozo,"Mozo");
		
		for (int i=0;i<cantEmpleados;i++) {
			Empleado empleado=new Empleado(mesa);
			empleados[i]=new Thread(empleado, "Empleado"+i);
			empleados[i].start();
		}
		
		hiloMozo.start();
	}
}
