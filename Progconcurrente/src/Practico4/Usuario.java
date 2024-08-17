package Practico4;

public class Usuario implements Runnable{

	private CentroImpresion centro;
	private char tipo;
	
	public Usuario(CentroImpresion unCentro, char unTipo) {
		this.centro=unCentro;
		this.tipo=unTipo;
	}
		
	public void run() {
		System.out.println(Thread.currentThread().getName() + " generando trabajo "+ this.tipo);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " trabajo listo"+ this.tipo +", yendo a imprimir" );
		imprimir();
	}
	
	public void imprimir() {
		boolean exito=false;
		
		switch (this.tipo) {
		case 'A':
				this.centro.usarImpresoraA();
				System.out.println("==================="+Thread.currentThread().getName() + " tipo: "+ this.tipo +", uso impresora A" );				
			break;

		case 'B':
				this.centro.usarImpresoraB();
				System.out.println("==================="+Thread.currentThread().getName() + " tipo: "+ this.tipo +", uso impresora B" );				
			break;
			
		case 'X':
			
			 while (!exito) {
				if (this.centro.usarImpresoraA()) {
					System.out.println("==================="+Thread.currentThread().getName() + " tipo: "+ this.tipo +", uso impresora A" );					
					exito=true;
				}else {
					if (this.centro.usarImpresoraB()) {
						System.out.println("==================="+Thread.currentThread().getName() + " tipo: "+ this.tipo +", uso impresora B" );						
						exito=true;
					}
				}				
			}
			break;
			
		default:
			break;
		}
	}
}
