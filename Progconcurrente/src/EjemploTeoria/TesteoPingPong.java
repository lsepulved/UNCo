package EjemploTeoria;

public class TesteoPingPong {

	public static void main(String[] args){
		
		 PingPong t1 =new PingPong("PING",10);
		 PingPong t2= new PingPong("PONG",5);
		 
		 // Activación
		 t1.start();
		 t2.start();

	 
		 // Espera unos segundos
		 try{
//			 t1.join();
			 System.out.println("soy el hilo: "+Thread.currentThread().getName());
			 	Thread.sleep(5000);
		 	}catch (InterruptedException e){
		 		e.printStackTrace();
		 	};
		 	// Finaliza la ejecución de los threads
	
			 for (int i = 1; i< 10; i++){
				 System.out.println("Codigo main");
			 }
		 	
//		 System.out.println("soy main");
	}
	
}


