package TPO_Sincronizacion;

public class Contador {

		public static void main(String[] args) throws InterruptedException {

		final Dato unContador = new Dato();

		RunnableCdor   unRunCdor = new RunnableCdor(unContador);
		RunnableCdor   unRunCdor2 = new RunnableCdor(unContador);
		
		Thread h1= new Thread( unRunCdor, "Hilo 1");
		Thread h2= new Thread( unRunCdor2, "Hilo 2");
		
		h1.start();
		h2.start();
		
		h1.join();
		h2.join();
		
		System.out.println("en main-" + unContador.obtenerValor());

		}	
}
