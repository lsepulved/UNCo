package Practico6;

import java.util.Random;

public class MainTemperatura {

	public static void main(String [] args) {
		
		GestorSala gestor =new GestorSala();
		
		ControlTemperatura control=new ControlTemperatura(gestor);
		Thread hiloControl=new Thread(control,"Control");
		
		int cantPersonas=10;
		Thread[] personas= new Thread[cantPersonas];
		
		Random random= new Random();
		
		for (int i=0;i<cantPersonas;i++) {
			boolean jubilado=random.nextBoolean();
//			System.out.println(jubilado);
			Persona persona= new Persona(gestor, jubilado);
			personas[i]= new Thread(persona,"Persona "+i);
			personas[i].start();
		}
		
		hiloControl.start();
	}
}
