package Practico_3;

public class SalaConcierto3 {
	boolean[] arreglo;
	
	public SalaConcierto3(int tamanio) {
		this.arreglo=new boolean[tamanio];
		this.vaciarSala();
	}
	
	public void vaciarSala() {
		for (int i=0;i<arreglo.length;i++) {
			arreglo[i]=true;
		}
	}

	public synchronized boolean asientoDisponible() {
		boolean disponible=false;
		
		for (int i=0;i<arreglo.length;i++) {
			if(arreglo[i]) {
				disponible=true;
				break;
			}
		}
		
		return disponible;
	}
	
	public synchronized boolean reservarAsiento(int asiento) {
		boolean disponible=false;
		
		if (arreglo[asiento]) {
			disponible=true;
			arreglo[asiento]=false;
		}
		
		return disponible;
	}
	
}
