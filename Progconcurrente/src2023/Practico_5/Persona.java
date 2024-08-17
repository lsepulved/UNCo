package Practico_5;

public class Persona implements Runnable{
	
	private Piscina piscina;
	
	public Persona(Piscina unaPiscina) {
		this.piscina=unaPiscina;
	}

	
	public void run() {
		this.piscina.entrarPiscina();
		this.disfrutar();
		this.piscina.salirPiscina();
	}
	
	public void disfrutar() {
		try {
			System.out.println(Thread.currentThread().getName()+ " ........nadando");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
