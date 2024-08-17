package Practico4;

public class Pasajero implements Runnable{
	
	public Taxi taxi;
	
	public Pasajero(Taxi unTaxi) {
		this.taxi=unTaxi;
	}
	
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+ " Buscando taxi disponible");
		this.buscandoTaxi();
		
		this.taxi.tomar();
//		System.out.println(Thread.currentThread().getName()+ " Despierto al Taxista");
		
		this.taxi.iniciarViaje();
//		System.out.println(Thread.currentThread().getName()+ " Viajando.....");		
		
//		System.out.println(Thread.currentThread().getName()+ " Viaje terminado");
		this.taxi.terminarViaje();
	}
	
	public void buscandoTaxi() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
