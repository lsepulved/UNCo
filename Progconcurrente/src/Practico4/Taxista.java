package Practico4;

public class Taxista implements Runnable{

	public Taxi taxi;
	
	public Taxista (Taxi unTaxi) {
		this.taxi=unTaxi;
	}
	
	public void run() {
		while (true) {
//			System.out.println(Thread.currentThread().getName() + " durmiendo mientras espera pasajero");
			this.taxi.durmiendoEnBase();
//			System.out.println(Thread.currentThread().getName() + " conduce a destino");
			this.taxi.conduciendo();
			this.conducir();
//			System.out.println(Thread.currentThread().getName() + " llega a destino");
			this.taxi.llegoAdestino();
			this.taxi.volverAbase();
		}
	}
	
	public void conducir() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
