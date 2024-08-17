package Practico_4;

public class MainEjercicio3 {
	
	public static void main (String[] args) {
		
		RecursoEjercicio3 unRecurso=new RecursoEjercicio3();
		
		int tamanio=10;
		
		for(int i=0;i<tamanio;i++) {
			RunnableEjercicio3 unRunnable=new RunnableEjercicio3(unRecurso);
			Thread hilo= new Thread(unRunnable,"Hilo "+i);
			hilo.start();
		}
	}
}
