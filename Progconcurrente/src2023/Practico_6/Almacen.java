package Practico_6;

public class Almacen {

	private int capacidad;
	private int cantProductos;
	
	
	public Almacen(int unaCapacidad) {
		this.capacidad=unaCapacidad;
		this.cantProductos=0;
	}
	
	
	public synchronized void sacarProducto() {
		try {
			while(this.cantProductos==0) {
				System.out.println(Thread.currentThread().getName()+"......almacen vacio----------------------");							
				this.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"......saca producto");
		this.cantProductos--;
		this.notify();
	}

	public synchronized void ponerProducto() {
		try {
			while(this.cantProductos>=this.capacidad) {
				System.out.println(Thread.currentThread().getName()+"......almacen lleno");							
				this.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"......pone producto");
		this.cantProductos++;
		this.notify();
	}
	
	public synchronized void ponerProductoIlimitado() {
	
		System.out.println("====================="+Thread.currentThread().getName()+"......pone producto");
		this.cantProductos++;
		this.notify();
	}
	
}
