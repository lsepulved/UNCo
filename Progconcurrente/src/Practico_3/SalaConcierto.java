package Practico_3;

public class SalaConcierto {
	private boolean []asientos;

	public SalaConcierto(int tamanio) {
		this.asientos=new boolean[tamanio];
	}
	
	public void liberarAsiento(int posicion) {
		if (posicion>=0 && posicion<this.asientos.length) {
			this.asientos[posicion]=true;	
		}		
	}

	public void ocuparAsiento(int posicion) {
		if (posicion>=0 && posicion<this.asientos.length) {
			this.asientos[posicion]=false;	
		}		
	}
	
	public boolean reservarAsiento(int posicion) {
		boolean exito=false;
				
		if (posicion>=0 && posicion<this.asientos.length) {
			if (this.getEstado(posicion)) {
				this.ocuparAsiento(posicion);
				exito=true;
			}
				
		}		
		return exito;
	}
	
	public void iniciarSala() {
		for (int i=0; i<this.asientos.length;i++) {
			this.asientos[i]=true;
		}
	}	
	
	public boolean getEstado(int posicion) {
		
		boolean estado=true;
		
		if (posicion>=0 && posicion<this.asientos.length) {
			estado=this.asientos[posicion];	
		}		
		return estado;

	}
	
}

