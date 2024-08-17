package Practico5;

public class ControlTren implements Runnable{

	Tren tren;
	
	public ControlTren(Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {
		while (true) {
			this.tren.comenzarViaje();
			System.out.println("*****************"+Thread.currentThread().getName()+" comienza el viaje");
//			this.viajar();			
			this.tren.finalizarViaje();
			System.out.println("*****************"+Thread.currentThread().getName()+" viaje finalizado");
			
		}
	}
	
	public void viajar() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
