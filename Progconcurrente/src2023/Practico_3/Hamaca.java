package Practico_3;

public class Hamaca {
	boolean disponible=true;
	
	public Hamaca() {
		
	}
	
	public synchronized boolean usarHamaca() {
		boolean usar=false;
		
		if (disponible) {
			disponible=false;
			usar=true;
		}
		return usar;
	}

	public synchronized boolean dejarHamaca() {
		boolean dejar=false;
		
		if (!disponible) {
			disponible=true;
			dejar=true;
		}
		return dejar;
	}
}
