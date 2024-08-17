package Practico_4;

import java.util.Random;

public class Cliente implements Runnable{

	private GestorImpresoras gestor;
	char tipo;
	
	public Cliente (GestorImpresoras unGestor, char unTipo) {
		this.gestor=unGestor;
		this.tipo=unTipo;
	}
	
	
	public void run() {
		Random random=new Random();
		int valor;
		
		while (true) {
			valor= random.nextInt(this.gestor.getImpresoras().length);
			
			if (this.gestor.usarImpresora(valor,this.tipo)) {
				System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +" Uso Impresora "+valor+" tipo:"+this.gestor.tipoImpresora(valor));
				this.Imprimir(valor);
				this.gestor.liberarImpresora(valor);
			}else {
				try {
					System.out.println(Thread.currentThread().getName()+" tipo "+this.tipo +" Impresora "+valor+" tipo:"+this.gestor.tipoImpresora(valor)+ " ocupada o de Tipo distinto..........buscando impresora disponible");
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
	public void Imprimir(int numero) {
		System.out.println(Thread.currentThread().getName() +" Imprimiendo en impresora "+numero+" .................");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
