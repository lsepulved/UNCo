package Practico_6;

public class Consumidor implements Runnable{

	Almacen almacen;
	
	public Consumidor(Almacen unaAlmacen) {
		this.almacen=unaAlmacen;
	}
	
	public void run() {
		while (true) {
			this.esperar();
			this.almacen.sacarProducto();
		}
	}
	
	public void esperar() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
