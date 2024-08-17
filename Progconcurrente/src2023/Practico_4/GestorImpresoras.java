package Practico_4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GestorImpresoras {
	private Impresora []arreglo;
	private Semaphore mutex=new Semaphore(1);
	
	public GestorImpresoras(int tamanio) {
		this.arreglo=new Impresora[tamanio];
		this.cargarImpresoras();
	}
	
	public void cargarImpresoras() {
		int cant=this.arreglo.length;
		char unTipo;
		Random random=new Random();
		int valor;
		
		for (int i=0;i<cant;i++) {
			valor=random.nextInt(2)+1;
			switch (valor) {
			case 1:
				unTipo='A';
				break;
				
			default:
				unTipo='B';
				break;
			}
			Impresora unaImpresora=new Impresora("Impresora "+i,unTipo);
			System.out.println("=================IMPRESORA TIPO: "+unaImpresora.getTipo());
			this.arreglo[i]=unaImpresora;
		}
	}
	public boolean usarImpresora(int posicion,char tipo) {
		boolean band=false;
		
		try {
			this.mutex.acquire();
			
			if (this.arreglo[posicion].isDisponible()&& ((this.arreglo[posicion].getTipo()==tipo)||tipo=='X')) {				
				this.arreglo[posicion].usoImpresora();
				band=true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.mutex.release();
		
		return band;
	}	

	public boolean liberarImpresora(int posicion) {
		boolean band=false;
		
		try {
			this.mutex.acquire();
			
			if (!this.arreglo[posicion].isDisponible()) {				
				this.arreglo[posicion].liberoImpresora();
				band=true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.mutex.release();
		
		return band;
	}	

	public char tipoImpresora(int posicion) {		
		return this.arreglo[posicion].getTipo();				
	}	
	
	
	public Impresora[] getImpresoras() {
		return this.arreglo;
	}
}
