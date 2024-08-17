package Practico5;

public class VendedorTickets implements Runnable{

	Tren tren;
	
	public VendedorTickets(Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {

		while(true) {			
			this.tren.abrirVenta();
			System.out.println("------------------Abrio boleteria");
			this.vender();
			this.tren.cerrarVenta();
			System.out.println("-------------------Finalizo la venta");
		}
	}
	
	public void vender() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
