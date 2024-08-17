package Practico_3;


public class MainParque {

	public static void main (String[] args) {

		int tamanio=5;
		AreasParque areas=new AreasParque(tamanio);
		
		int cantVisitantes=0;
		
//		for(int i=0;i<tamanio;i++) {
////			Random random=new Random();
////			cantVisitantes=random.nextInt(10)+1;
//			cantVisitantes=15;
//			System.out.println("===============>>>>>>Visitantes para el area "+i+": "+cantVisitantes);
//			for (int j=0;j<cantVisitantes;j++) {
//				Visitante visita=new Visitante(areas);
//				Thread hiloVisita=new Thread(visita,"Visitante "+j);
//				hiloVisita.start();
//			}			
//		}
		
		cantVisitantes=20;
		for (int j=0;j<cantVisitantes;j++) {
			Visitante visita=new Visitante(areas);
			Thread hiloVisita=new Thread(visita,"Visitante "+j);
			hiloVisita.start();
		}			
		
		
	}
	
	
}
