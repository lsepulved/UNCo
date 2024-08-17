package Practico_4;

public class Taxista implements Runnable{

	private Taxi taxi;
	public Taxista(Taxi unTaxi) {
		this.taxi=unTaxi;
	}
	
	public void run() {
		while(true) {
			this.taxi.iniciarViaje();
			System.out.println(Thread.currentThread().getName()+" inicio viaje");
			this.viajando();
			this.taxi.finalizarViaje();
			System.out.println(Thread.currentThread().getName()+" finalizo viaje, me voy a dormir siesta");			
		}
	}
	
	public void viajando() {
		System.out.println(Thread.currentThread().getName()+ " ...................manejando taxi");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
