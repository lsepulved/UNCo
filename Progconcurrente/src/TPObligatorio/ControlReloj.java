package TPObligatorio;

public class ControlReloj implements Runnable {

	Reloj reloj;
	
	public ControlReloj(Reloj unReloj) {
		this.reloj=unReloj;
	}
	
	public void run() {
		while (true) {
			try {
				
//				System.out.println(Thread.currentThread().getName()+" Hora Actual:"+this.reloj.getHora()+"hs");								
				Thread.sleep(5000);
				this.reloj.incrementarHora();
								
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
