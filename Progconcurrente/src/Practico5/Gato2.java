package Practico5;

public class Gato2 implements Runnable{

	Comedero2 comedero;
	String especie;
	
	public Gato2(Comedero2 unComedero, String unaEspecie) {
		this.comedero=unComedero;
		this.especie=unaEspecie;
	}
	
	public void run() {
		boolean exito=false;
		
		while (!exito) {
			if (this.especie==this.comedero.getTurno()|| this.comedero.entrar(this.especie)) {
				
				if (this.comedero.comer(1)) {
					System.out.println("---G---"+Thread.currentThread().getName()+ " comiendo"+ " especie Comedero: "+this.comedero.getTurno());
					this.comer();
					System.out.println("---G---"+Thread.currentThread().getName()+ " termino de comer");				
					this.comedero.dejarComer(1);
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
