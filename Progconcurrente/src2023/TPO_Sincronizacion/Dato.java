package TPO_Sincronizacion;

public class Dato {
	private int valor;
	
	public synchronized void contar() {
		valor=++valor;
	}
	
	public int obtenerValor() {
		return valor;
	}
}
