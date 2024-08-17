package TPO2023;

public class Pasajero implements Runnable{

	private Tren tren;
	private ExpendedoraTickets expendedora;
	
	public Pasajero(Tren unTren,ExpendedoraTickets unaExpendedora) {
		this.tren=unTren;
		this.expendedora=unaExpendedora;
	}
	
	public void run() {
		boolean band=true;
		while (band) {
//			this.tren.subirTren();
			if (this.tren.subirTren()) { 
				
				this.expendedora.vender();
//				System.out.println(Thread.currentThread().getName()+" subio al Tren");
				this.tren.bajarTren();
				band=false;
//				System.out.println(Thread.currentThread().getName()+" bajo del Tren");
			}else {
				System.out.println(Thread.currentThread().getName()+" ..........................No pudo subir al Tren, intentara nuevamente");
			}
		}
	}
}
