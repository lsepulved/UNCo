package Practico_5;

public class Avion  implements Runnable{

	private Pista pista;
	
	public Avion(Pista unaPista) {
		this.pista=unaPista;
	}
	
	public void run() {
		
//		while (true) {
			this.volando();
			this.pista.entraAterrizar();
			this.usandoPista();
			this.pista.saleAterrizar();
			this.esperaFueraPista();
			this.pista.entraDespegar();
			this.usandoPista();
			this.pista.saleDespegar();
//		}			
	}
	
	public void volando() {
		try {
			System.out.println(Thread.currentThread().getName()+"...............VOLANDO!!!");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void usandoPista() {
		try {
			System.out.println(Thread.currentThread().getName()+"...............VOLANDO!!!");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void esperaFueraPista() {
		try {
			System.out.println(Thread.currentThread().getName()+"...............en el hangar...............................!!!");
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
