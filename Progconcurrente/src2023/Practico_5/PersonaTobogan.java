package Practico_5;

public class PersonaTobogan implements Runnable{

	Tobogan tobogan;
	
	public PersonaTobogan(Tobogan unTobogan) {
		this.tobogan=unTobogan;
	}
	
	public void run() {
		boolean band=false;
		
		this.tobogan.usarEscalera();
		this.esperandoEnEscalera();

		
		while(band==false) {			
			band=this.tobogan.dejarEscalera();
		}			
		this.tobogan.entrarTobogan();
		this.usandoTobogan();
		this.tobogan.salirTobogan();
		
	}
	
	public void usandoTobogan() {
		try {
//			System.out.println(Thread.currentThread().getName()+"..............bajando por el tobogaaaaaaaaan!!!");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void esperandoEnEscalera() {
		try {
			System.out.println(Thread.currentThread().getName()+"...................................esperando en escalera!!!");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
