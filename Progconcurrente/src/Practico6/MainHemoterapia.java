package Practico6;

public class MainHemoterapia {
	
	public static void main (String []args) {
		
		int camillas=4;
		int lugares=10;
		int revistas=9;
	
		CentroHemoterapia centro=new CentroHemoterapia(camillas,lugares,revistas);
	
		int cantPacientes=10;
		Thread[] pacientes=new Thread[cantPacientes];
	
	
//	for (int i=0;i<cantSoldados;i++) {
//		Soldado soldado=new Soldado(cuartel);
//		soldados[i]=new Thread(soldado,"Soldado"+i);
//		soldados[i].start();
//	}

	
		for (int i=0;i<cantPacientes;i++) {
			Paciente paciente=new Paciente(centro);
			pacientes[i]=new Thread(paciente, "Paciente "+i);
			pacientes[i].start();
		}
	}
}
