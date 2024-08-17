package TPObligatorio;

public class Atomo implements Runnable{

	String tipo="";
	Espacio espacio;
	
	public Atomo (Espacio unEspacio,String unTipo) {
		this.tipo=unTipo;
		this.espacio=unEspacio;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+" de  "+this.tipo +" en el espacio");
			Thread.sleep(3000);
			
			if (this.tipo=="Oxigeno") {
				this.espacio.liberarOxigeno();								
			}else {
				this.espacio.liberarHidrogeno();
			}
						
			
			if (this.tipo=="Oxigeno") {
				this.espacio.usarOxigeno();								
			}else {
				this.espacio.usarHidrogeno();
			}
			System.out.println(Thread.currentThread().getName()+" de  "+this.tipo +" usado");			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
