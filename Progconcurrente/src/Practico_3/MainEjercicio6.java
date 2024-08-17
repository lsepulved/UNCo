package Practico_3;

public class MainEjercicio6 {

	public static void main (String[]args) {
		int desde=0;
		int hasta=0;
		int cantHilos=7;
		int tamanio=50000;
		
		Arreglo arreglo=new Arreglo(tamanio);
		arreglo.llenarArreglo();
//		arreglo.mostrarArreglo();
		
		Suma sumaTotal=new Suma();
		
		Thread[] hilos= new Thread[cantHilos];
		int fraccion=tamanio/cantHilos;
//		System.out.println(fraccion);
		
		int restante=tamanio % cantHilos;
//		System.out.println(restante);
		
		for (int i=0;i<cantHilos-1;i++) {
			desde=i*fraccion;
			hasta=desde+fraccion;
			Sumador unSumador= new Sumador(arreglo,desde,hasta,sumaTotal);
			hilos[i]=new Thread(unSumador, "Hilo "+i);
			hilos[i].start();
		}
		
		//el resto
		desde=hasta;
		hasta=desde+fraccion+restante;
		Sumador unSumador= new Sumador(arreglo,desde,hasta,sumaTotal);
		hilos[cantHilos-1]=new Thread(unSumador, "Hilo "+cantHilos);
		hilos[cantHilos-1].start();

		int sumaSecuencial=0;
		for (int i=0;i<arreglo.getArreglo().length;i++) {
			sumaSecuencial+=arreglo.getArreglo()[i];
		}
		
		try {
			for (int i=0;i<cantHilos;i++) {
				hilos[i].join();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Suma Secuencial= "+sumaSecuencial);
		System.out.println("Suma Total Hilos= "+sumaTotal.getSuma());
	}
}
