package EjemploTeoria;

public class PruebaRunnable{
	public static void main(String[] args){
		
		//2 objetos definen los métodos run
		PingPongRunnable o1 =new PingPongRunnable("PING",10);
		PingPongRunnable o2= new PingPongRunnable("PONG",5);
		
		//Se crean los hilos
		Thread t1 = new Thread (o1);
		Thread t2 = new Thread (o2);
		
		// se activan los hilos
		t1.start();
		t2.start();
		System.out.println("Main");
	} 
};