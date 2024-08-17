package Practico_3;

public class ReservarAsiento implements Runnable{

	private SalaConcierto sala;
	
	public ReservarAsiento(SalaConcierto unaSala) {
		this.sala=unaSala;	
	}
	
	public void run() {
		int asiento;
		double numero;
		for (int i=0;i<10;i++) {
			numero=Math.random()*10;
			asiento=(int) numero;
			synchronized (sala) {
				if (this.sala.reservarAsiento(asiento)) {				
					System.out.println(Thread.currentThread().getName()+" reservo asiento "+asiento);									
				}else {
					System.out.println(Thread.currentThread().getName()+" no pudo reservar asiento "+asiento);
				}
				
			}
		}
	}
}
