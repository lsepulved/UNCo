package Practico_3;

import java.util.Random;

public class Arreglo {

	private int[] arreglo;
	
	public Arreglo(int tamanio) {
		this.arreglo=new int[tamanio];
	}
	
	public int[] getArreglo() {
		return this.arreglo;
	}

	public void llenarArreglo() {
		Random random=new Random();
		
		for(int i=0; i<this.arreglo.length;i++) {
			this.arreglo[i]=random.nextInt(10);
		}		
	}
	
	public void mostrarArreglo() {
		
		for(int i=0; i<this.arreglo.length;i++) {
			System.out.println("arreglo["+i+"]="+this.arreglo[i]);
		}
		
	}
	
	
}



