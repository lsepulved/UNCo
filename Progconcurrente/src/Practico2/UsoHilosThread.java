package Practico2;

public class UsoHilosThread {

	public static void main(String[] args) {
		
		System.out.println("Hilo principal iniciando.");
	
		//Primero, construye un objeto unHilo.
		MiHiloThread mh1=new MiHiloThread("#1");
		MiHiloThread mh2=new MiHiloThread("#2");
		MiHiloThread mh3=new MiHiloThread("#3");
		
	
		//Finalmente, comienza la ejecución del hilo.
		mh1.start();
		mh2.start();
		mh3.start();	
	
		for (int i=0; i<50;i++){
			System.out.print(" .");
		}
		try{
			Thread.sleep(100);
		}catch (InterruptedException exc){
			System.out.println("Hilo principal interrumpido.");
		}
	
		System.out.println("Hilo principal finalizado.");
}
	
}
