package Practico_3;

public class Surtidor {

	private int litrosMaximo=0;
	private int litrosActual=0;
	
	public Surtidor(int maximo){
		this.litrosMaximo=maximo;
		this.litrosActual=maximo;
	}
	
	public int getLitrosDisponible() {
		return this.litrosActual;
	}
	
	public int getLitrosMaximo() {
		return this.litrosMaximo;
	}
	
	public synchronized boolean consumirLitros(int litros) {
		boolean exito=false;
		
		if (this.litrosActual>=litros) {
			this.litrosActual=this.litrosActual-litros;
			exito=true;
		}else {
			exito=false;
		}
		
		return exito;
	}
}

