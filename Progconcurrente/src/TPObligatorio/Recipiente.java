package TPObligatorio;

import java.util.concurrent.Semaphore;

public class Recipiente {
	private int capacidad;
	private int capacidadTotal;
	private Semaphore llenar;
	private Semaphore distribuir;
	
	public Recipiente(int unTotal) {
		this.capacidad=0;
		this.capacidadTotal=unTotal;
		this.llenar=new Semaphore(1);
		this.distribuir=new Semaphore(0);
	}
	
	public void agregarAguar() throws InterruptedException {
		this.llenar.acquire();
		this.capacidad++;
		
		if (this.capacidad==this.capacidadTotal) {
			this.distribuir.release();
		}else {
			this.llenar.release();
		}
		
		
	}
	
	public boolean lleno() {
		boolean exito=false;
		if (this.capacidad==this.capacidadTotal) {
			exito=true;
		}
		return exito;
	}
	
	public void distribuirAgua() throws InterruptedException {
		this.distribuir.acquire();
//		System.out.println("===================Distribuye Agua");
		this.capacidad=0;
		System.out.println("===================Recipiente Vacio");
		System.out.println("");
		this.llenar.release();
	}
	
}
