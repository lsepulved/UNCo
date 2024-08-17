package Practico_2;

public class UsoHilosThread {
	public static void main (String[] args) {
		
		System.out.println("Hilo principal iniciando.");
				
		//Luego, construye un hilo de ese objeto.
		MiHiloThread nuevoHiloUno=new MiHiloThread("#1");
		MiHiloThread nuevoHiloDos=new MiHiloThread("#2");
		MiHiloThread nuevoHiloTres=new MiHiloThread("#3");
		
		//Finalmente, comienza la ejecución del hilo.
		nuevoHiloUno.start();
		nuevoHiloDos.start();
		nuevoHiloTres.start();		
		
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
