package Practico_8;

import java.util.Random;

public class MainObservatorio {

	public static void main(String[] args) {
		
		int limite=7;
		int capacidad=5;
		int espacioSilla=2;
		

		Observatorio observatorio=new Observatorio(limite,capacidad,espacioSilla);
				
		int cantVisitante=8;
		int cantMantenimiento=4;
		int cantInvestigadores=3;
		
		int total=cantVisitante+cantMantenimiento+cantInvestigadores;
		Random random=new Random();
		boolean valor;
		String nombre;
		
		for (int i=0;i<total;i++) {
			if (i<cantVisitante) {
				valor=random.nextBoolean();
				if (valor) {
					nombre="VisitanteSilla";
				}else {
					nombre="Visitante";
				}
					
				Visitante unVisitante=new Visitante(observatorio, valor);
				Thread hiloVisitante= new Thread(unVisitante,nombre+i);
				hiloVisitante.start();
			}else {
				if(i<(cantVisitante+cantMantenimiento)) {
					PersonalMantenimiento unMantenimiento=new PersonalMantenimiento(observatorio);
					Thread hiloMantenimiento= new Thread(unMantenimiento,"Mantenimiento"+i);
					hiloMantenimiento.start();
				}else {
					Investigador unInvestigador=new Investigador(observatorio);
					Thread hiloInvestigador= new Thread(unInvestigador,"Investigador"+i);
					hiloInvestigador.start();
				}
			}
		}
		
	}
}
