package TPO_Sincronizacion;

public class PingPong extends Thread{

	private int delay;		 //info de las iteraciones
	private Dato miDato;	// para mantener el total
	private int miCta=0;	// para contar mis iteraciones
	
	// constructor 1, que refina al constructor heredado de Thread
	public PingPong(String cartel, int cantMs) {
		super(cartel);
		this.delay = cantMs;
	}
	
	// constructor 2, que utiliza al constructor 1
	public PingPong(String cartel, int cantMs, Dato ddato){
		this(cartel, cantMs);
		this.miDato = ddato;
	}
	
	
	public void run(){

		for (int i=1; i< delay * 2; i++){
			//System.out.print(this.getName() + " ");
			miCta ++;
			this.miDato.contar();

		}// del for
		
		System.out.println(miCta + " veces " + this.getName());

	} // del run	
}
