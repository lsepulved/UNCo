package Practico_3;

public class Plato {
	boolean disponible=true;
	
	public Plato() {
		
	}
	
	public synchronized boolean usarPlato() {
		boolean usar=false;
		
		if (disponible) {
			disponible=false;
			usar=true;
		}
		return usar;
	}

	public synchronized boolean dejarPlato() {
		boolean dejar=false;
		
		if (!disponible) {
			disponible=true;
			dejar=true;
		}
		return dejar;
	}
	
}
