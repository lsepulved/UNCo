package Practico_2;

public class Cajero {
	private String nombre;
	private int tiempo=0;
	
	// Agregar Constructor, y métodos de acceso
	public Cajero(String unNombre) {
		this.nombre=unNombre;
	}
	
	public void procesarCompra(ClienteSuper cliente, long timeStamp) {
		
		System.out.println ("El cajero " + this.nombre +" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + 
				cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +"seg");
		
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
//			System.out.println("Procesado el producto " + (i + 1) +	"->Tiempo: " + (System.currentTimeMillis() - timeStamp)/1000 + "seg");
			tiempo+=cliente.getCarroCompra()[i];
			System.out.println("Procesado el producto " + (i + 1) +	"->Tiempo: " + tiempo + "seg");
		}
		
//		System.out.println("El cajero " + this.nombre +" HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +(System.currentTimeMillis() - timeStamp) / 1000 + "seg");
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