package Practico_3;

import java.util.Random;

public class Arreglo3 {
	int suma=0;
	int arreglo[];
	
	public Arreglo3(int tamanio) {
		this.arreglo= new int[tamanio];
		this.llenar();
	}
	
	public void llenar() {
		Random random=new Random();
		
		for(int i=0;i<this.arreglo.length;i++) {
			arreglo[i]=random.nextInt(10);
			System.out.println("arreglo["+i+"]="+arreglo[i]);
		}
	}
	
	public synchronized int getSuma() {
		return suma; 
	}
	
	public synchronized void sumar(int unValor) {
		suma=suma+unValor; 
	}
	
	public synchronized int getValorArreglo(int posicion) {
		return this.arreglo[posicion];
	}
	
}
