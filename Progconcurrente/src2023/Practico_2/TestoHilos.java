package Practico_2;

public class TestoHilos {
	
	public static void main (String[] args){
		
		Thread miHilo= new MiEjecucion();
		miHilo.start();
		try {
			miHilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("En el main");
		
	}

}
