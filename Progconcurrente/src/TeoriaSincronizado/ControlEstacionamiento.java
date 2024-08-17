package TeoriaSincronizado;

public class ControlEstacionamiento implements Runnable{
	
	private Estacionamiento estacionamiento;

	public ControlEstacionamiento (Estacionamiento unEstacionamiento) {
		estacionamiento=unEstacionamiento;
	}
	
	public void run() {
		
		 	 
		 for (int i = 1; i< 30; i++){
			 if (estacionamiento.ingresarAuto()){
				 System.out.println("Ingreso: "+i+" "+Thread.currentThread().getName()+ "==> "+estacionamiento.getCantAutos());				 
			 }else {
				 System.out.println("No Ingreso: "+i+" "+Thread.currentThread().getName());
			 }
			 
//			 if (estacionamiento.ingresarMoto()){
//				 System.out.println("Ingreso Moto: "+i+" "+Thread.currentThread().getName());				 
//			 }
//			 
//			 if (estacionamiento.salirAuto()){
//				 System.out.println("Salidad Auto: "+i+" "+Thread.currentThread().getName());				 
//			 }
//
//			 if (estacionamiento.salirMoto()){
//				 System.out.println("Salidad Moto:"+i+" "+Thread.currentThread().getName());				 
//			 }
			 
		 }		
		
	}
}
