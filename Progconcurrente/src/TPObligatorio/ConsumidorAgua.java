package TPObligatorio;

public class ConsumidorAgua implements Runnable{

	private Espacio espacio;
	private Recipiente recipiente;
	
	public ConsumidorAgua (Espacio unEspacio, Recipiente unRecipiente) {
		this.espacio=unEspacio;
		this.recipiente=unRecipiente;
		
	}
	
	public void run() {
		
		while (true) {
			try {
				if (this.recipiente.lleno()) {
					System.out.println(Thread.currentThread().getName()+ "=================Recipiente LLENO, distribuye Agua");
					this.recipiente.distribuirAgua();
				}
								
				this.espacio.hacerAgua();
				System.out.println(Thread.currentThread().getName()+ "================HACE Agua");
				this.recipiente.agregarAguar();
				System.out.println(Thread.currentThread().getName()+ "================AGREGA Agua");
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
}
