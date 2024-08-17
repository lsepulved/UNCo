package Practico_7;

public class MainMuseo {

	public static void main(String[] args) {
		
		int limite=10;
		int umbralTemp=30;
		SalaMuseo sala=new SalaMuseo(limite,umbralTemp);
		
		ControlMuseo control=new ControlMuseo(sala);
		Thread hiloControl=new Thread(control,"Control");
		hiloControl.start();
		
		int cantJubilados=5;
		int cantPersonas=15;
		int total=cantJubilados+cantPersonas;
		
		for (int i=0;i<total;i++) {
			if (i<cantPersonas) {
				PersonaMuseo unaPersona=new PersonaMuseo(sala, 'P');
				Thread hiloPersona= new Thread(unaPersona,"Persona"+i);
				hiloPersona.start();
			}else {
				PersonaMuseo unaJubilado=new PersonaMuseo(sala, 'J');
				Thread hiloJubilado= new Thread(unaJubilado,"Jubilado"+i);
				hiloJubilado.start();				
			}
		}

	}
}
