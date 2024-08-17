package Practico_7;

public class MainProgramadores {

	public static void main(String[]args) {
		
		int cantCompus=5;
		int cantLibros=3;
		
		
		GestorRecurso gestor=new GestorRecurso(cantCompus,cantLibros);
		
		int cantProgramadores=10;
		
		for (int i=0;i<cantProgramadores;i++) {
			Programador unProgramador=new Programador(gestor);
			Thread hiloProgramador=new Thread(unProgramador,"Programador"+i);
			hiloProgramador.start();
		}
	}
}
