package Practico_3;

import java.util.Random;

public class AreasParque {
	int areas[];
	
	public AreasParque(int tamanio) {
		this.areas=new int[tamanio];
		llenarAreas();
	}
	
	public void llenarAreas() {
		Random random=new Random();
		int espacios=0;
		
		for (int i=0;i<this.areas.length;i++) {
			espacios=random.nextInt(5)+1;
			areas[i]=espacios;
			System.out.println("areas["+i+"]="+espacios);
		}
	}
	
	public synchronized boolean reservarEspacio(int area) {
		boolean band=false;
		
		if (areas[area]>0) {		
			areas[area]--;
			band=true;
		}
		return band;
	}
	
	public int[] getAreas() {
		return this.areas;
	}
	
}

