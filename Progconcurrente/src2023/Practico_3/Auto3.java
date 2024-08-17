package Practico_3;

import java.util.Random;

public class Auto3 extends Vehiculo implements Runnable{
	private int nivelReserva=0;
	private int cantidadlitros=0;
	private int maxlitros=0;
	private Surtidor3 surtidor;
	
	public Auto3(String unaPatente, int unModelo, String unaMarca, int unosKms,int unNivel,int unosLitros,int unosMaxLitros,Surtidor3 unSurtidor) {
		super(unaPatente,unModelo,unaMarca,unosKms);
		this.nivelReserva=unNivel;
		this.cantidadlitros=unosLitros;
		this.maxlitros=unosMaxLitros;
		this.surtidor=unSurtidor;
	}
	
	public void run() {
		Random random=new Random();
		int cargaLitros=0;
		
		while (true) {
			cargaLitros=random.nextInt(this.maxlitros)+1;
			
			consumirCombustible();
			if (this.cantidadlitros<=this.nivelReserva) {
				if (this.surtidor.cagarCombustible(cargaLitros)) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+Thread.currentThread().getName()+" cargo "+cargaLitros+", Litros disponibles en el surtidor: "+this.surtidor.getCantLitros());
				}else {
//					System.out.println("|||||||||||||||||||||||||||||||"+Thread.currentThread().getName()+" NO pudo cargar "+cargaLitros+", Litros disponibles en el surtidor: "+this.surtidor.getCantLitros());
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}
			
		}
	}
	
	public void consumirCombustible() {
		Random random=new Random();

		if (this.cantidadlitros>=1) {
			
			int consumo=random.nextInt(this.cantidadlitros)+1;
			
			this.cantidadlitros=this.cantidadlitros-consumo;
			
//			System.out.println("======="+Thread.currentThread().getName()+" consumio "+consumo+", queda en el tanque: "+this.cantidadlitros+" litros");
			
			try {
				Thread.sleep(consumo*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
