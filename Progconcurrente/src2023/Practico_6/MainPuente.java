package Practico_6;

public class MainPuente {

	public static void main (String [] args) {
		
		int limite=5;
		
		Puente unPuente=new Puente(limite);
		
		int cantAutosNorte=10;
		int cantAutosSur=5;
		int total=cantAutosNorte+cantAutosSur;
		
		for (int i=0;i<total;i++) {
			if (i<cantAutosNorte) {
				Coche unCoche=new Coche(unPuente,'N');
				Thread hiloCocheNorte=new Thread(unCoche,"CocheNorte"+i);
				hiloCocheNorte.start();
			}else {

				Coche unCoche=new Coche(unPuente,'S');
				Thread hiloCocheSur=new Thread(unCoche,"CocheSur"+i);
				hiloCocheSur.start();
			}
		}
		
	}
	
}
