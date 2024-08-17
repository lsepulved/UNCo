package Practico_3;

public class Surtidor3 {
	int cantMaxLitros=0;
		
	public Surtidor3(int unaCantMaxima) {
		this.cantMaxLitros=unaCantMaxima;
	}
	
	public synchronized boolean cagarCombustible(int cantidad) {
		boolean band=false;
		if(cantidad<=this.cantMaxLitros) {
			this.cantMaxLitros=this.cantMaxLitros-cantidad;
			band=true;
		}
		
		return band;
	}
	
	public int getCantLitros() {
		return this.cantMaxLitros;
	}
}
