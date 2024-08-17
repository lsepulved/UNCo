package Practico2;

public class TestEjemploRunnable{
	
	
	public static void main (String [] args) {
		EjemploRunnable maria= new EjemploRunnable() ;
		EjemploRunnable jose= new EjemploRunnable() ;
		
		Thread hiloMaria= new Thread(maria,"Maria Jose");
		Thread hiloJose= new Thread(jose,"Jose Maria");
		
		hiloMaria.start();		
		hiloJose.start();
		
		System.out.println("Termina thread main");
	}
}