package Practico_4;

public class Empleado implements Runnable{
	
	Silla silla;
	
	public Empleado(Silla unaSilla) {
		this.silla=unaSilla;
	}
	
	public void run() {
		boolean band=true;
		while (band)
		if (this.silla.ocuparMesa()) {
			band=false;
			System.out.println(Thread.currentThread().getName()+" ocupa mesa y llama al mozo");
			this.silla.llamarMozo();
			this.silla.comer();
			this.comiendo();
			
			this.silla.terminarComer();
			System.out.println(Thread.currentThread().getName()+" termino de comer, llama al mozo para pagar");
		}
	}
	
	public void comiendo() {
		System.out.println(Thread.currentThread().getName()+"...............comiendo");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
