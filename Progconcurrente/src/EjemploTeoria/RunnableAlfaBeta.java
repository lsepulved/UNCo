package EjemploTeoria;


public class RunnableAlfaBeta implements Runnable {
	
	 public void run() {
		 
		 for (int i=0; i <30; i++){
			 String threadNombre = Thread.currentThread().getName();
			 System.out.println(threadNombre + " en ejecucion");
		 }
	 }
}