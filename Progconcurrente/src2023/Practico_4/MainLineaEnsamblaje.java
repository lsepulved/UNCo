package Practico_4;

public class MainLineaEnsamblaje {

	public static void main (String[] args) {
		
		
		int capacidad1=3;
		char tipo1='A';
		LineaEnsamblaje linea1=new LineaEnsamblaje(capacidad1, tipo1,1);
				
		int capacidad2=5;
		char tipo2='B';
		LineaEnsamblaje linea2=new LineaEnsamblaje(capacidad2, tipo2,2);
		
		int cantProdTipo1=5;
		int cantProdTipo2=15;
		
		ControladorProduccion controlador=new ControladorProduccion(linea1, linea2);
		Thread hiloControl=new Thread(controlador,"Controlador");
		hiloControl.start();
		

		for (int i=0;i<cantProdTipo1;i++) {
			Producto unProductoA=new Producto(tipo1, linea1, linea2);
			Thread hiloA=new Thread(unProductoA,"Producto"+tipo1+" "+i);
			hiloA.start();
		}

		for (int i=0;i<cantProdTipo2;i++) {
			Producto unProductoB=new Producto(tipo2, linea1, linea2);
			Thread hiloB=new Thread(unProductoB,"Producto"+tipo2+" "+i);
			hiloB.start();
		}
		
	}
}
