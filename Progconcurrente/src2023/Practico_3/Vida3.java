package Practico_3;

public class Vida3 {
	private int puntos=0;
	
	public Vida3(int unosPuntos) {
		this.puntos=unosPuntos;
	}

	
	public synchronized int obtenerVida() {
		return this.puntos;
	}
	
	public synchronized void golpear() {
//		System.out.println("Golpeando");
		this.puntos=this.puntos-3;
//		System.out.println(Thread.currentThread().getName() + " golpea (-3 puntos), Puntos Actual: "+this.obtenerVida());
	};
	
	public synchronized void curar() {
//		System.out.println("Curando");
		this.puntos=this.puntos+3;
//		System.out.println(Thread.currentThread().getName() + " cura (+3 puntos), Puntos Actual: "+this.obtenerVida());
	};
	
//	public synchronized int obtenerVida() {
//		return this.puntos;
//	}
//	
//	public synchronized void golpear() {
//		System.out.println("Golpeando");
//		this.puntos=this.puntos-3;
//	};
//	
//	public synchronized void curar() {
//		System.out.println("Curando");
//		this.puntos=this.puntos+3;
//	};
	
}
