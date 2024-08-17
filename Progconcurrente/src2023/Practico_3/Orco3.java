package Practico_3;

public class Orco3 implements Runnable {
	Vida3 vida;
	
	public Orco3(Vida3 unaVida) {
		this.vida=unaVida;
	}
	
	public void run() {
		for(int i=0;i<4;i++) {
			if (vida.obtenerVida()>=3) {
				this.vida.golpear();
				System.out.println(Thread.currentThread().getName() + " golpea "+ i+" (-3 puntos), Puntos Actual: "+this.vida.obtenerVida());
				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println(Thread.currentThread().getName() + " no golpea, Puntos Actual: "+this.vida.obtenerVida());
			}			
//			
		}
	}
}
