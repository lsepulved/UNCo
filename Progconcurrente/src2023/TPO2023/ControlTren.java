package TPO2023;

public class ControlTren implements Runnable{
	
	private Tren tren;
	
	public ControlTren(Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {
		while(true) {
//			System.out.println(Thread.currentThread().getName()+ " Tren listo");
			System.out.println(Thread.currentThread().getName()+ " =========inicia viaje=========");
			this.tren.iniciarViaje();
			this.viajar();
//			System.out.println(Thread.currentThread().getName()+ " =======Finaliza viaje==========");
			this.tren.finalizarViaje();
			
		}
	}
	
	public void viajar() {
		try {
			System.out.println();
			System.out.println("................Viajando a destino");
			System.out.println();
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
