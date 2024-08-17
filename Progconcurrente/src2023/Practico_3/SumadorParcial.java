package Practico_3;

public class SumadorParcial implements Runnable{
	int desde=0;
	int hasta=0;
	Arreglo3 arreglo;
	
	public SumadorParcial(int unaPosicion,int otraPosicion, Arreglo3 unArreglo) {
		this.desde=unaPosicion;
		this.hasta=otraPosicion;
		this.arreglo=unArreglo;
	}
	
	public void run() {
		for(int i=desde;i<hasta;i++) {
			this.arreglo.sumar(this.arreglo.getValorArreglo(i));
			System.out.println("Suma parcial de "+Thread.currentThread().getName()+"= " +this.arreglo.getSuma()); 
		}
		
	}
}
