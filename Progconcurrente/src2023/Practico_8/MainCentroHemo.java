package Practico_8;

public class MainCentroHemo {

	public static void main (String[] args) {
		
		int limiteCamillas=4;
		int limiteSala=12;		
		int limiteRevistas=9;

		
		CentroHemoterapia centro=new CentroHemoterapia(limiteCamillas, limiteSala, limiteRevistas);
		
		int cantPacientes=20;
		
		for (int i=0;i<cantPacientes;i++) {
			Paciente unPaciente=new Paciente(centro);
			Thread hiloPaciente=new Thread(unPaciente, "Paciente"+i);
			hiloPaciente.start();
		}
		
	}
}
