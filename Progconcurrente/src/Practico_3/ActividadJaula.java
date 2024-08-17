package Practico_3;
import java.util.Random;

public class ActividadJaula implements Runnable{
	
	private Jaula jaula;

	public ActividadJaula(Jaula unaJaula) {
		this.jaula=unaJaula;
	}
	
	public void run() {
		
		for(int i=1;i<10;i++) {
			
			Random random = new Random();
			
			int numero=random.nextInt(3);
			
			switch(numero) {
			  case 0:
				    if (this.jaula.ocuparPlato()) {
//						System.out.println(Thread.currentThread().getName()+" ocupo el plato");							
						try {
							Thread.sleep(1000);			
							this.jaula.liberarPlato();
							System.out.println(Thread.currentThread().getName()+" libero el plato");
						}catch (Exception e){
							e.printStackTrace();
							}
					}else {
						System.out.println(Thread.currentThread().getName()+" no pudo ocupar el plato");
					}
				    	
				    break;
			  case 1:
				    if (this.jaula.ocuparRueda()) {
//						System.out.println(Thread.currentThread().getName()+" ocupo la rueda");							
						try {
							Thread.sleep(1000);			
							this.jaula.liberarRueda();
							System.out.println(Thread.currentThread().getName()+" libero la rueda");
						}catch (Exception e){
							e.printStackTrace();
							}
					}else {
						System.out.println(Thread.currentThread().getName()+" no pudo ocupar la rueda");
					}
				    break;
			  case 2:
				    if (this.jaula.ocuparHamaca()) {
//						System.out.println(Thread.currentThread().getName()+" ocupo la hamaca");							
						try {
							Thread.sleep(1000);			
							this.jaula.liberarHamaca();
							System.out.println(Thread.currentThread().getName()+" libero la hamaca");							
						}catch (Exception e){
							e.printStackTrace();
							}
					}else {
						System.out.println(Thread.currentThread().getName()+" no pudo ocupar la hamaca");
					}
				    break;
			  default:
				  break;
			}	
			
		}
	}
}
