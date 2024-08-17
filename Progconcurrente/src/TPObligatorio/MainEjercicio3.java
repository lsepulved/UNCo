package TPObligatorio;

import java.util.Random;

public class MainEjercicio3 {

	public static void main(String args[]){
		
		int cantidadDurmientes=10;
		

		Reloj reloj=new Reloj(cantidadDurmientes);
		
		ControlReloj control=new ControlReloj(reloj);

		Thread hiloControl=new Thread(control,"Control Reloj");
		
		
		Thread [] durmientes= new Thread[cantidadDurmientes];
		
		int cantHoras=5;
		int desde=0;
		Random random=new Random();
		
		for (int i=0;i<cantidadDurmientes;i++) {			
			desde=random.nextInt(24);	
			Durmiente unDurmiente=new Durmiente(reloj,desde,cantHoras);			
			durmientes[i]= new Thread(unDurmiente,"Durmiente "+i);
			durmientes[i].start();
		}
		
		hiloControl.start();		
		
	}
	
}
