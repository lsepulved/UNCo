package Practico2;

public class MiHiloThread extends Thread{

	public MiHiloThread (String nombre) {
		super(nombre);
	}
	
	public void run(){
		System.out.println("Comenzando "+Thread.currentThread().getName());
		
		for (int contar=0; contar<10; contar++){
			System.out.println("En "+Thread.currentThread().getName()+", el recuento "+contar);
			}
		
		try {
			for (int contar=0; contar<10; contar++){
				Thread.sleep(400);
				System.out.println("En "+Thread.currentThread().getName()+", el recuento "+contar);
			}
		}catch (InterruptedException exc){
			System.out.println(Thread.currentThread().getName() + "Interrumpido.");
		}
		System.out.println("Terminando "+Thread.currentThread().getName());
	}
}
