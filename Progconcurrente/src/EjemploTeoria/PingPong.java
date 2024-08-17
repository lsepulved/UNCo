package EjemploTeoria;

public class PingPong extends Thread{
	
	 private String cadena; // Lo que va a escribir.
	 private int delay; // Tiempo entre escritura
	 
	 public PingPong(String cartel,int cantMs){
		 
		 super(cartel);
		 cadena = cartel;
		 delay = cantMs;
	 
	 };
	 
	 public void run(){
		 
		 System.out.println("soy el hilo: "+Thread.currentThread().getName());
		 
		 for (int i = 1; i< delay * 10; i++){	 
			 System.out.print(cadena + " ");
			 try {
				 Thread.sleep(delay);
			 	 } catch(InterruptedException e) {
			 		 e.printStackTrace();
			 	 }
		 }
		 
	 } //fin método run()
	 
} //fin clase PingPong 