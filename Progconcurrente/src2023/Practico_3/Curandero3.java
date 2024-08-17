package Practico_3;

public class Curandero3 implements Runnable{
	Vida3 vida;
	
	public Curandero3(Vida3 unaVida) {
		this.vida=unaVida;
	}
	
	public void run() {
		for(int i=0;i<4;i++) {
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.vida.curar();
			System.out.println(Thread.currentThread().getName() + " cura "+ i +" (+3 puntos), Puntos Actual: "+this.vida.obtenerVida());
			
		}
	}
}
