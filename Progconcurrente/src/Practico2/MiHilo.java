package Practico2;

class MiHilo implements Runnable {
	String nombreHilo;
	
	public void unHilo(String nombre){
	nombreHilo=nombre;
	}
	
	//Punto de entrada del hilo
	//Los hilos comienzan a ejecutarse aquí
	public void run(){
		System.out.println("Comenzando "+nombreHilo);
		
		for (int contar=0; contar<10; contar++){
			System.out.println("En "+nombreHilo+", el recuento "+contar);
			}
		
//		try {
//			for (int contar=0; contar<10; contar++){
//				Thread.sleep(400);
//				System.out.println("En "+nombreHilo+", el recuento "+contar);
//			}
//		}catch (InterruptedException exc){
//			System.out.println(nombreHilo + "Interrumpido.");
//		}
		System.out.println("Terminando "+nombreHilo);
	}
}