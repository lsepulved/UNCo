package Practico4;
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
				    this.jaula.usarPlato();
					System.out.println(Thread.currentThread().getName()+" ocupo el plato");							
					try {
						Thread.sleep(1000);			
					}catch (Exception e){
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+" libero el plato");
					this.jaula.liberarPlato();
					
				    break;
			  case 1:
				    this.jaula.usarRueda();
					System.out.println(Thread.currentThread().getName()+" ocupo la rueda");							
					try {
						Thread.sleep(1000);			
					}catch (Exception e){
						e.printStackTrace();
					}
											
					System.out.println(Thread.currentThread().getName()+" libero la rueda");
					this.jaula.liberarRueda();
					
				    break;
			  case 2:
				    this.jaula.usarHamaca();
					System.out.println(Thread.currentThread().getName()+" ocupo la hamaca");							
						try {
							Thread.sleep(1000);			
						}catch (Exception e){
							e.printStackTrace();
							}
						System.out.println(Thread.currentThread().getName()+" libero la hamaca");
						this.jaula.liberarHamaca();
						
				    break;
			  default:
				  break;
			}	
			
		}
	}
}
