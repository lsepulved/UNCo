package Practico_3;

public class MainEjercicio5 {

	public static void main (String[]args) {

		Surtidor unSurtidor = new Surtidor(100);
		
		int cantAutos=5;
		Thread[] autos=new Thread[cantAutos];
		
		for (int i=0;i<cantAutos;i++) {			
			UsarSurtidor usar=new UsarSurtidor(unSurtidor);
			Auto automovil=new Auto("Auto"+i,i,"Marca "+i,i*100,usar);			
			autos[i]=new Thread(automovil.getUsaSurtidor(),automovil.getPatente());
			autos[i].start();
		}
	}

}
