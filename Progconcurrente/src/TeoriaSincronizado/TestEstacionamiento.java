package TeoriaSincronizado;

public class TestEstacionamiento {

	public static void main(String[] args){
		
		Estacionamiento estacionamiento =new Estacionamiento(5,2);
		
		ControlIngresoAuto ingresoNorte = new ControlIngresoAuto(estacionamiento);		
		ControlIngresoAuto ingresoSur = new ControlIngresoAuto(estacionamiento);
		ControlSalidaAuto salidaAutos = new ControlSalidaAuto(estacionamiento);
		ControlIngresoMoto entradaMotos = new ControlIngresoMoto(estacionamiento);
		ControlSalidaMoto salidaMotos = new ControlSalidaMoto(estacionamiento);

		
		//Se crean los hilos
		Thread controlIngresoNorte = new Thread (ingresoNorte,"IngresoNorte");
		Thread controlIngresoSur = new Thread (ingresoSur,"IngresoSur");
		Thread controlSalidaAutos = new Thread (salidaAutos,"SalidaAutos");
		Thread controlEntradaMotos = new Thread (entradaMotos,"Entrada Motos");
		Thread controlSalidaMotos = new Thread (salidaMotos,"SalidaMotos");
		
		// se activan los hilos
		controlIngresoNorte.start();
		controlIngresoSur.start();
		controlSalidaAutos.start();
		controlEntradaMotos.start();
		controlSalidaMotos.start();
		
//		System.out.println("Main");
	} 

}
