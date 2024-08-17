package Practico_5;

public class MainBabuinos {

	public static void main(String[]args) {
		
		int cantBabuinosNorte=7;
		int cantBabuinosSur=12;
		
		int limite=5;
		
		int total=cantBabuinosNorte+cantBabuinosSur;
		
		Cuerda cuerda=new Cuerda(limite);
		
		for(int i=0;i<total;i++) {
			if (i<cantBabuinosNorte) {
				Babuino unBabuino=new Babuino(cuerda, 'N');
				Thread hiloBabuinoNorte=new Thread(unBabuino,"BabuinoNorte"+i);
				hiloBabuinoNorte.start();
			}else {
				Babuino unBabuino=new Babuino(cuerda, 'S');
				Thread hiloBabuinoSur=new Thread(unBabuino,"BabuinoSur"+i);
				hiloBabuinoSur.start();
				
			}
		}
	}
}
