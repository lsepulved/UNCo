package Practico_4;

public class Producto implements Runnable{
	
	char tipo;
	LineaEnsamblaje linea1;
	LineaEnsamblaje linea2;
	
	public Producto(char unTipo, LineaEnsamblaje unaLinea1, LineaEnsamblaje unaLinea2){
		this.tipo=unTipo;
		this.linea1=unaLinea1;
		this.linea2=unaLinea2;
	}
	
	public void run() {
		boolean band=true;
		while (band) {
			if (this.linea1.llega(this.tipo)) {
//				System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +"......llega Linea 1 "+this.linea1.getTipo());			
				this.linea1.ensambla();
				band=false;
				this.ensamblar(1);
				this.linea1.sale();
//				System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +" SALE Linea 1 "+this.linea1.getTipo());
			}else {
				if (this.linea2.llega(this.tipo)) {
//					System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +"..................llega Linea 2 "+this.linea1.getTipo());			
					this.linea2.ensambla();
					band=false;
					this.ensamblar(2);
					this.linea2.sale();			
//					System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +" SALE Linea 2 "+this.linea1.getTipo());
					
				}
			}
			
		}
	}
	
	public void ensamblar(int numLinea) {
		try {
			System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +"......ensamblando en Linea "+numLinea);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
