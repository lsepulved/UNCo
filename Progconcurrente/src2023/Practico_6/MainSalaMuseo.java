package Practico_6;

public class MainSalaMuseo {

	public static void main(String[] args) {
		
		int capacidad=10;
		int umbral=30;
		
		GestorSala unGestor=new GestorSala(capacidad, umbral);
		
		ControlSalaMuseo control=new ControlSalaMuseo(unGestor);
		Thread hiloControl=new Thread(control,"Control");
		hiloControl.start();
		
		int cantJubilados=5;
		int cantPersonas=15;
		int total=cantJubilados+cantPersonas;
		
		for (int i=0;i<total;i++) {
			if (i<cantPersonas) {
				PersonaSalaMuseo unaPersona=new PersonaSalaMuseo(unGestor, 'P');
				Thread hiloPersona= new Thread(unaPersona,"Persona"+i);
				hiloPersona.start();
			}else {
				PersonaSalaMuseo unaJubilado=new PersonaSalaMuseo(unGestor, 'J');
				Thread hiloJubilado= new Thread(unaJubilado,"Jubilado"+i);
				hiloJubilado.start();				
			}
		}
		
	}
}
