package Practico_6;

public class Productor implements Runnable{

	Almacen almacen;
	
	public Productor(Almacen unAlmacen) {
		this.almacen=unAlmacen;
	}
	
	public void run() {
		while (true) {
			this.esperar();
//			this.almacen.ponerProducto();
			this.almacen.ponerProductoIlimitado();
		}
	}
	
	public void esperar() {
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
