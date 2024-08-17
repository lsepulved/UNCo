package Practico_3;

public class Sumador implements Runnable{
	private Arreglo arreglo;
	private int desde=0;
	private int hasta=0;
	private Suma suma;
	
	public Sumador(Arreglo unArreglo,int desde, int hasta, Suma unaSuma) {
		this.arreglo=unArreglo;
		this.desde=desde;
		this.hasta=hasta;
		this.suma=unaSuma;
	}
	
	public void run() {
		int subtotal=0;
		for(int i=desde;i<hasta;i++) {
			subtotal=subtotal+(this.arreglo.getArreglo()[i]);
		}
		this.suma.incrementar(subtotal);
		System.out.println("Subtotal "+Thread.currentThread().getName()+"="+subtotal);
	}
}
