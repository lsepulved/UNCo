package EjemploTeoria;

public class HiloAlfaBeta extends Thread{

	public HiloAlfaBeta(String nombre) {
		super(nombre);
	}
	
	 // completar con constructores
	 public void run() {
		 
		 for (int i=0; i <30; i++){
			 System.out.println(this.getName()+ "en ejecucion");
		 }
	 }
}