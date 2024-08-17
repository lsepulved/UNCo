package Practico_5;

public class MainTobogan {
	
	public static void main (String []args) {
		
		int limite=10;
		
		Tobogan tobogan=new Tobogan(limite);
		
		Responsable unResponsable=new Responsable(tobogan);
		Thread hiloResponsable=new Thread(unResponsable,"Responsable");
		hiloResponsable.start();
		
		for(int i=0;i<limite;i++) {
			PersonaTobogan unaPersona=new PersonaTobogan(tobogan);
			Thread hiloPersona=new Thread(unaPersona,"Persona"+i);
			hiloPersona.start();
		}
		
	}

}
