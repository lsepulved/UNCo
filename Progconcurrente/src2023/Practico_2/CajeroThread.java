package Practico_2;

public class CajeroThread extends Thread {
	private String nombre;
	private ClienteSuper cliente;
	private long initialTime;
	private int tiempo=0;
	
	// Constructor, y métodos de acceso
	public CajeroThread(ClienteSuper unCliente,String unNombre, long unTime) {
		super(unNombre);
		this.cliente=unCliente;		
		this.nombre=unNombre;
		this.initialTime=unTime;
	}
		
	
	public void run() {
		System.out.println("El cajero " + this.nombre +" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
				+ this.cliente.getNombre() + " EN EL TIEMPO: "+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		
		for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
			
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
//			System.out.println("Procesado el producto " + (i + 1) + "del cliente " + this.cliente.getNombre() + "->Tiempo: " 
//			+(System.currentTimeMillis() - this.initialTime) / 1000+ "seg");
	
			tiempo+=cliente.getCarroCompra()[i];
			System.out.println("Procesado el producto " + (i + 1) +	"->Tiempo: " + tiempo + "seg");
			
			}
		
//		System.out.println("El cajero" + this.nombre + "HA TERMINADO DE PROCESAR"+ this.cliente.getNombre() + " EN EL TIEMPO: " +
//				(System.currentTimeMillis() - this.initialTime) / 1000 +"seg");
		System.out.println("El cajero " + this.nombre +" HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +tiempo + "seg");		
	}
	
	public void esperarXsegundos(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

