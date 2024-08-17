package Practico5;

import java.util.Random;

public class Empleado implements Runnable{

	public Mesa mesa;
	
	public Empleado(Mesa unaMesa) {
		this.mesa=unaMesa;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " esperando una mesa disponible");
		
		try {
			this.mesa.ocuparMesa();
			System.out.println(Thread.currentThread().getName()+ " ocupa mesa");
			Random random= new Random(); 
			int valor= random.nextInt(2);
			
			switch (valor) {
			case 0:
				System.out.println(Thread.currentThread().getName()+ " pide para beber");
				this.beber();
				
				break;
			case 1:
				System.out.println(Thread.currentThread().getName()+ " pide para comer");				
				this.comer();
				
				break;
			case 2:
				System.out.println(Thread.currentThread().getName()+ " pide para beber y comer");
				this.mesa.beber();				
				this.mesa.comer();
				
				break;
				
			default:
				break;
			}
			this.mesa.dejarMesa();;
			System.out.println(Thread.currentThread().getName()+ " llama a mozo para pagar");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void beber() {
		this.mesa.pedirBebida();
		this.mesa.beber();
		System.out.println(Thread.currentThread().getName()+ " bebiendo");
		this.consumir();
		System.out.println(Thread.currentThread().getName()+ " termino de beber");		
	}
	
	public void comer() {
		this.mesa.pedirComida();
		this.mesa.comer();		
		System.out.println(Thread.currentThread().getName()+ " comiendo");				
		this.consumir();
		System.out.println(Thread.currentThread().getName()+ " termino de comer");		
	}
	public void consumir() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
