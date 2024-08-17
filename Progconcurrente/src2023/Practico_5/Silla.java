package Practico_5;

import java.util.concurrent.Semaphore;

public class Silla {

	private String nombre;
	private Semaphore mesa;
	private Semaphore pedirBebida;
	private Semaphore pedirComida;
	private Semaphore servirBebida;
	private Semaphore servirComida;
	
	public Silla(String unNombre) {
		this.nombre=unNombre;
		this.mesa=new Semaphore(2);
		this.pedirBebida=new Semaphore(0);
		this.pedirComida=new Semaphore(0);
		this.servirBebida=new Semaphore(0);
		this.servirComida=new Semaphore(0);
	}

	//empleado
	public void ocuparMesa() {
		try {
			this.mesa.acquire();
			System.out.println(Thread.currentThread().getName()+".....ocupando mesa");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//empleado
	public void pedirBebida() {
		System.out.println(Thread.currentThread().getName()+".....pidiendo bebida");		
		this.pedirBebida.release();
	}
	
	public void pedirComida() {
		System.out.println(Thread.currentThread().getName()+".....pidiendo comida");		
		this.pedirComida.release();
	}
	
	public void tomarPedidoBebida() {
		try {			
			this.pedirBebida.acquire();
			System.out.println(Thread.currentThread().getName()+".....toma pedido BEBIDA");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void tomarPedidoComida() {
		try {
			this.pedirComida.acquire();
			System.out.println(Thread.currentThread().getName()+".....toma pedido COMIDA");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void servirBebida() {
		System.out.println(Thread.currentThread().getName()+".....SIRVIENDO BEBIDA");
		this.servirBebida.release();
	}
	
	public void servirComida() {
		System.out.println(Thread.currentThread().getName()+".....SIRVIENDO COMIDA");
		this.servirComida.release();
	}
	
	public void tomar() {
		try {
			this.servirBebida.acquire();
			System.out.println(Thread.currentThread().getName()+".....tomando BEBIDA");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comer() {
		try {			
			this.servirComida.acquire();
			System.out.println(Thread.currentThread().getName()+".....comiendo COMIDA");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dejarMesa() {
		System.out.println(Thread.currentThread().getName()+".....dejando mesa");
		this.mesa.release();
	}
}
