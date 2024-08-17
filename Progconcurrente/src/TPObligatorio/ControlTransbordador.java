package TPObligatorio;

public class ControlTransbordador implements Runnable{

	private Transbordador transbordador;
	
	
	public ControlTransbordador(Transbordador unTransbordador) {
		this.transbordador=unTransbordador;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("=============================================================");
				this.transbordador.liberarEntrada();
				this.transbordador.viajando();
				
				System.out.println(Thread.currentThread().getName() + " viajando con autos");
				Thread.sleep(5000);
				
				this.transbordador.llegoOeste();
				this.transbordador.liberarSalida();
				
				System.out.println(Thread.currentThread().getName() + " viajando sin autos");
				this.transbordador.viajando();
				Thread.sleep(5000);
				
				this.transbordador.llegoEste();
				System.out.println("--------------------------------------------------------------");				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
