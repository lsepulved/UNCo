package TPObligatorio;

public class Durmiente implements Runnable{

	Reloj reloj;
	int horaDesde=0;
	int cantHoras=0;
	
	public Durmiente (Reloj unReloj, int desde, int cantHoras) {
		this.reloj=unReloj;
		this.horaDesde=desde;
		this.cantHoras=cantHoras;
	}
	
	public void run() {
		while (true) {
			
			this.reloj.trabajar(this.horaDesde);
			this.reloj.decrementarTotalDurmientes();
			System.out.println("***********"+Thread.currentThread().getName()+"===============Entre a trabajar");

			try {
				Thread.sleep(this.cantHoras*5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("/////////////"+Thread.currentThread().getName()+"===============Sali de trabajar, me fui a dormir");
			this.reloj.incrementarTotalDurmientes();
			
		}
	}
}
