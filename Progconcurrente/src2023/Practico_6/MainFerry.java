package Practico_6;

public class MainFerry {

	public static void main (String[] args) {
		
		int limite=5;
		int espacioAuto=2;
		
		Ferry ferry=new Ferry(limite,espacioAuto);
		
		int cantPersonas=5;
		int cantAutos=4;
		
		int total=cantPersonas+cantAutos;
		
		for (int i=0;i<total;i++) {
			if (i<cantPersonas) {
				Persona unaPersona=new Persona(ferry);
				Thread hiloPesona=new Thread(unaPersona,"Persona"+i);
				hiloPesona.start();
			}else {
				Automovil unAutomovil=new Automovil(ferry);
				Thread hiloAutomovil=new Thread(unAutomovil,"Automovil"+i);
				hiloAutomovil.start();
				
			}
		}
	}
}
