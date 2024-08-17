package Practico5;

public class Perro implements Runnable{

	Comedero comedero;
	String especie;
	
	public Perro(Comedero unComedero, String unaEspecie) {
		this.comedero=unComedero;
		this.especie=unaEspecie;
	}
	
	public void run() {
		boolean exito=false;
		
		while (!exito) {
			if (this.especie==this.comedero.getTurno()|| this.comedero.entrar(this.especie)) {
				
				if (this.comedero.comer()) {
					System.out.println("---P---"+Thread.currentThread().getName()+ " comiendo"+ " especie Comedero: "+this.comedero.getTurno());
					this.comer();
					System.out.println("---P---"+Thread.currentThread().getName()+ " termino de comer");				
					this.comedero.dejarComer();
					exito=true;						
				}
			}
		}
		
	}
	
	public void comer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
