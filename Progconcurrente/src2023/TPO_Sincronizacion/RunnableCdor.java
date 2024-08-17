package TPO_Sincronizacion;

public class RunnableCdor implements Runnable{

	Dato unContador;  
	int prueba=0;

	public RunnableCdor (Dato elCdor){

		unContador = elCdor;

	}

	private synchronized void incrementar() {
		prueba++;
	}

	public void run() {

		for (int x=0; x<30; ++x) {
	
			unContador.contar();
			this.incrementar();
			System.out.println(Thread.currentThread().getName() + " contando "+unContador.obtenerValor()+ " - Prueba "+prueba);
		}
	}
	
}

