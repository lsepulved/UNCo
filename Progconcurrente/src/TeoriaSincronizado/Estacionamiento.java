package TeoriaSincronizado;

public class Estacionamiento{
	
	private int maxAutos;
	private int maxMotos;
	private int cantAutosActual= 0;
	private int cantMotosActual= 0;
	
	public Estacionamiento (int autos, int motos){
		 maxAutos = autos;
		 maxMotos = motos;
	 } 
		
	public synchronized boolean ingresarAuto(){
		 boolean puede = false;
		 if (cantAutosActual < maxAutos) {
			 cantAutosActual ++;
			 puede = true;
			 System.out.println(Thread.currentThread().getName()+" Ingreso auto N°"+cantAutosActual);
		 }else {
			 System.out.println(Thread.currentThread().getName()+" Estacionamiento de autos lleno, N°"+cantAutosActual);
		 }
		 
		 return (puede);
	}
	
	public synchronized boolean ingresarMoto(){
		 boolean puede = false;
		 if (cantMotosActual < maxMotos) {
			 cantMotosActual ++;
			 puede = true;
			 System.out.println(Thread.currentThread().getName()+" Ingreso moto N°"+cantMotosActual);			 
		 }else {
			 System.out.println(Thread.currentThread().getName()+" Estacionamiento de motos lleno, N°"+cantMotosActual);
		 }
		 
		 return (puede);
	}
	
	public synchronized boolean salirAuto(){
		 boolean puede = false;
		 if (cantAutosActual > 0) {
			 System.out.println(Thread.currentThread().getName()+" Salida auto N°"+cantAutosActual);			 
			 cantAutosActual --;
			 puede = true;			 
		 }else {
			 System.out.println(Thread.currentThread().getName()+" Estacionamiento de autos vacio, N°"+cantAutosActual);
		 }
		 
		 return (puede);
	}
	
	public synchronized boolean salirMoto(){
		 boolean puede = false;
		 if (cantMotosActual > 0) {
			 System.out.println(Thread.currentThread().getName()+" Salida Moto N°"+cantMotosActual);			 
			 cantMotosActual --;
			 puede = true;
		 }else {
			 System.out.println(Thread.currentThread().getName()+" Estacionamiento de motos vacio, N°"+cantMotosActual);
		 }
		 
		 return (puede);
	}
		
	public int getCantMotos() {
		return this.cantMotosActual;
	}

	public int getCantAutos() {
		return this.cantAutosActual;
	}
	
}

