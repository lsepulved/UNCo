package EjemploTeoria;

public class TestRunAlfaBeta {

	public static void main (String[] args) {
		RunnableAlfaBeta alfaBetaRunnable = new RunnableAlfaBeta();
		
		Thread alfa = new Thread ( alfaBetaRunnable, "Hilo Alfa");
		Thread beta = new Thread ( alfaBetaRunnable);		
		beta.setName("Hilo Beta");
		
		alfa.start();
		beta.start();
	}
}
