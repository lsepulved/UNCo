package TPObligatorio;

public class Auto implements Runnable {

	private Transbordador transbordador;
	
	public Auto(Transbordador unTransbordador){
		this.transbordador=unTransbordador;
		
	}
	
	public void run(){
			try {
				this.transbordador.subir();
				System.out.println(Thread.currentThread().getName()+ " subio al transbordador");
				this.transbordador.puedeSubir();
				
				this.transbordador.bajar();
				System.out.println(Thread.currentThread().getName()+ " bajo al transbordador");
				this.transbordador.puedeBajar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
}
