package TPObligatorio;

import java.util.Random;

public class GeneradorAtomo implements Runnable{

	private Espacio espacio;
	
	public GeneradorAtomo(Espacio unEspacio) {
		this.espacio=unEspacio;
	}
	
	public void run() {
		int cont=0;
		
		while (true) {
						
			int resultado;
			Random random= new Random();
			resultado=random.nextInt(2);
			
			Atomo unAtomo;
			
			try {
				this.espacio.hacerAtomo();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//if (resultado==0) && this.espacio.getCantHidrogeno()<2) {
			if (resultado==0)  {				
				if (this.espacio.getCantHidrogeno()<10) {
					unAtomo=new Atomo(this.espacio,"Hidrogeno");				
					this.espacio.incrementarHidrogeno();
					Thread hiloAtomo= new Thread(unAtomo,"Atomo "+cont);				
					hiloAtomo.start();
					cont++;					
				}
			}else {
				if (this.espacio.getCantOxigeno()<5) {
					unAtomo=new Atomo(this.espacio,"Oxigeno");
					this.espacio.incrementarOxigeno();
					Thread hiloAtomo= new Thread(unAtomo, "Atomo "+cont);
					hiloAtomo.start();
					cont++;
				}
			}			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
