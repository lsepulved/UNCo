package Practico_4;

public class ClienteTaxi implements Runnable {

	private Taxi taxi;
	public ClienteTaxi(Taxi unTaxi) {
		this.taxi=unTaxi;
	}
	
	public void run() {
		boolean exito=true;
		while (exito) {
			this.buscandoTaxi();
			if (this.taxi.subirTaxi()) {
				exito=false;
				System.out.println(Thread.currentThread().getName()+ " se subio al taxi");
				this.taxi.bajarTaxi();											
//				System.out.println(Thread.currentThread().getName()+ " pago y se bajo del taxi");
			}
		}
	}
	
	public void buscandoTaxi() {
		System.out.println(Thread.currentThread().getName()+ " ...................buscando taxi");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
