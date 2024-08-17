package Practico_6;

public class MainSalaEstudio {

	public static void main (String []args) {
		
		int cantMesas=5;
		SalaEstudio sala=new SalaEstudio(cantMesas);
		
		int cantAlumnos=15;
		
		for (int i=0;i<cantAlumnos;i++) {
			Alumno unAlumno=new Alumno(sala);
			Thread hiloAlumno=new Thread (unAlumno,"Alumno"+i);	
			hiloAlumno.start();
		}
	}
}
