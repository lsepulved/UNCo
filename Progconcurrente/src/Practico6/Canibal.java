package Practico6;

public class Canibal implements Runnable{

	Olla olla;
	
	public Canibal(Olla unaOlla) {
		this.olla=unaOlla;
	}
	
	public void run() {
		this.olla.comer();
//		System.out.println("-----"+Thread.currentThread().getName()+" comiendo");
		this.comer();		
	}
	
	public void comer(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

