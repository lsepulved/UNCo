package Practico_3;

import java.util.Random;

public class UsarSurtidor implements Runnable{
	
	Surtidor surtidor;

	public UsarSurtidor(Surtidor unSurtidor) {
		this.surtidor=unSurtidor;
	}
	
	public void run() {
		Random random = new Random();		
		int numero=0;
		
		for (int i=1;i<=3;i++) {
			recorrer();
			numero=(random.nextInt(40)+1);			
			if (this.surtidor.consumirLitros(numero)) {				
				System.out.println(Thread.currentThread().getName()+ " cargo "+numero+" litros de combustible"+" quedan "+this.surtidor.getLitrosDisponible()+" disponibles");	
			}else {
				System.out.println(Thread.currentThread().getName()+ " no cargo "+numero+" litros de combustible, supera los "+this.surtidor.getLitrosDisponible()+" disponibles");
			}					
		}
	}
	
	public void recorrer() {
		
		Random random = new Random();		
		int numero=0;		
		numero=(random.nextInt(5)+1)*1000;
		
		try {
			System.out.println(Thread.currentThread().getName()+" recorrio "+numero+ " kms");
			Thread.sleep(numero);				
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
}
