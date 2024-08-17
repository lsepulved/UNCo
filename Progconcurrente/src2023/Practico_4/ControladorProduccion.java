package Practico_4;

public class ControladorProduccion implements Runnable{
	
	LineaEnsamblaje linea1;
	LineaEnsamblaje linea2;
	
	public ControladorProduccion(LineaEnsamblaje unaLinea1, LineaEnsamblaje unaLinea2) {
		this.linea1=unaLinea1;
		this.linea2=unaLinea2;
	}
	
	public void run() {
//		char tipo;
		while (true) {
//			System.out.println("Tipo Linea 1..................."+this.linea1.getTipo());
//			System.out.println("Tipo Linea 2..................."+this.linea2.getTipo());
			this.cambiar();
			this.linea1.detenerLineas(this.linea1,this.linea2);
//			tipo=this.linea1.getTipo();
			this.linea1.cambiarLineas(this.linea1,this.linea2);			
//			this.linea2.cambiarLinea(tipo,2);
//			System.out.println("Tipo Linea 1..................."+this.linea1.getTipo());
//			System.out.println("Tipo Linea 2..................."+this.linea2.getTipo());
			
		}
	}
	
	public void cambiar() {
		try {
			Thread.sleep(1500);
//			System.out.println(Thread.currentThread().getName()+"........Cambio de Linea de Ensamblaje");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
