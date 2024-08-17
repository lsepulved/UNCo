package Practico_3;

public class MainArreglo {
	
	public static void main(String [] args) {
		
		int tamanio=20;
		Arreglo3 arreglo= new Arreglo3(tamanio);
		
		int cantHilos=6;
		int cantNum=0;
		int i=0;
		
		cantNum=tamanio/cantHilos;
		
		
		for (i=0;i<cantHilos-1;i++) {
			SumadorParcial sumador=new SumadorParcial(i*cantNum, (i+1)*cantNum, arreglo);
			Thread unHilo= new Thread(sumador,"Hilo "+i);
			unHilo.start();
//			try {
//				unHilo.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
//		cantNum=tamanio - (cantHilos-1)*cantNum;
//		System.out.println(i*cantNum);
//		System.out.println(i);
		SumadorParcial sumador=new SumadorParcial(i*cantNum, tamanio, arreglo);
		Thread hilo= new Thread(sumador,"Hilo "+i);
		hilo.start();
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(5500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>>>>>>>>><Suma Total= "+arreglo.getSuma());
	}
}
