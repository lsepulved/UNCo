package Practico_2;

public class ClienteSuper {
	private String nombre;
	private int[] carroCompra;
	
	public ClienteSuper(String unNombre, int[]unCarrito) {
		this.nombre=unNombre;
		this.carroCompra=unCarrito;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int[] getCarroCompra() {
		return this.carroCompra;
	}
	// Constructor y métodos de acceso	
}



