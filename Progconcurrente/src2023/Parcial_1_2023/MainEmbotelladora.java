package Parcial_1_2023;

public class MainEmbotelladora {

	public static void main (String[]args) {
		
		int cantEmbotelladoresVino=1;
		int cantEmbotelladoresAgua=1;
		int limiteBotellas=10;
		int limiteCajas=3;
		
		Embotelladora embotelladora=new Embotelladora(limiteBotellas,limiteCajas);
		
		Empaquetador empaquetador=new Empaquetador(embotelladora);
		Thread hiloEmpaquetador=new Thread(empaquetador,"Empaquetador");
		hiloEmpaquetador.start();

		Transportador transportador=new Transportador(embotelladora);
		Thread hiloTransportador=new Thread(transportador,"Transportador");
		hiloTransportador.start();
		
		
		for (int i=0;i<cantEmbotelladoresVino;i++) {
			Embotellador unEmbotellador=new Embotellador(embotelladora,'V');
			Thread hiloEmboVino=new Thread (unEmbotellador,"EmbotelladorVino"+i);
			hiloEmboVino.start();
		}
		
		for (int i=0;i<cantEmbotelladoresAgua;i++) {
			Embotellador unEmbotellador=new Embotellador(embotelladora,'A');
			Thread hiloEmboAgua=new Thread (unEmbotellador,"EmbotelladorAgua"+i);
			hiloEmboAgua.start();
		}
		
		
		
	}
}
