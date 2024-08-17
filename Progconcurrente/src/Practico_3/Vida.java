package Practico_3;

public class Vida {

	private int puntos=10;
	
	public Vida () {
			
	}
	
	public void Curar() {
		this.puntos+=3;
	}
	
	public void Golpear() {
		this.puntos-=3;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
}
