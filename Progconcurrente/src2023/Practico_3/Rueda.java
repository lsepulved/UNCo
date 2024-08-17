package Practico_3;

public class Rueda {
	boolean disponible=true;
	
	public Rueda() {
		
	}
	
	public synchronized boolean usarRueda() {
		boolean usar=false;
		
		if (disponible) {
			disponible=false;
			usar=true;
		}
		return usar;
	}

	public synchronized boolean dejarRueda() {
		boolean dejar=false;
		
		if (!disponible) {
			disponible=true;
			dejar=true;
		}
		return dejar;
	}
}
