package Practico_3;

public class Orco implements Runnable{

	Vida vida=new Vida();
	
	public Orco (Vida unaVida) {
	
		this.vida=unaVida;
	
	}
	
	
	public void run() {
		for (int i=1;i<=4;i++) {
//			synchronized (vida) {
				if (this.vida.getPuntos()>0){
					this.vida.Golpear();
					System.out.println(Thread.currentThread().getName()+ " Golpeo (-3 puntos), Puntos Actual: "+this.vida.getPuntos());			
				}else {
					System.out.println(Thread.currentThread().getName()+ " No Golpeo, Puntos:"+this.vida.getPuntos());
				}				
//			}
				
		}
	}
	
}
