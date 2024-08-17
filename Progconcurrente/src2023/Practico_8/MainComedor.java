package Practico_8;

public class MainComedor {

	public static void main (String[] args) {
		
		int capacidad=10;
		int cantBandejasComida=5;
		int cantAbridores=10;
		int cantBandejasPostre=3;
		Comedor comedor=new Comedor(capacidad,cantBandejasComida,cantAbridores,cantBandejasPostre);
		
		int cantSoldados=15;
		
		for (int i=0;i<cantSoldados;i++) {
			Soldado unSoldado=new Soldado(comedor);
			Thread hiloSoldado=new Thread(unSoldado,"Hilo"+i);
			hiloSoldado.start();
		}
	}
}
