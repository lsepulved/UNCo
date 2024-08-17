package Practico_3;

public class Curandero implements Runnable  {

	Vida vida=new Vida();
	
	public Curandero (Vida unaVida) {
		this.vida=unaVida;
	}
	
	public void run() {
		for (int i=1;i<=4;i++) {
//			synchronized (vida) {
				this.vida.Curar();
				System.out.println(Thread.currentThread().getName()+ " Curo (+3 puntos), Puntos Actual: "+this.vida.getPuntos());				
//			}
		}
		
	}
	
}
