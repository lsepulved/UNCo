package tp0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio8 {

	static int cantAlumnos=10;
	static int cantAsignaturas=5;
	
	/*  Alumnos.txt
	Alumno				Matematicas	Lengua Ingles Fisica Termodinamica
	Peter Parker			9         8		 8      2 	     5
	Maverick		   		3         3      10     3   	 5
	Wade Wilson             7         2      2      9     	 3
	Ricardo Tapia	        8         9      9      9      	 8  
	Diana de Temyscira      8         8      8      8        8
	Bruce Wayne             8         4      5      4        5
	*/
	
	public static void main(String[] args) {
		
		String[] alumnos=new String[cantAlumnos];
		int [][]notas=new int[cantAlumnos][cantAsignaturas];
	
		leerNotasArchivo(notas,alumnos);

        Double[] mediaAlumnos = new Double[cantAlumnos];
        Double[] mediaAsignaturas = new Double[cantAsignaturas];
	
        mediaAlumnos=getNotaMediaAlumnos(notas);
        mediaAsignaturas=getNotaMediaAsignaturas(notas);
		
        double mediaClase;
        mediaClase = getNotaMediaClase(mediaAlumnos);
		
        ordenarAlumnosPorMediaBurbuja(alumnos, mediaAlumnos);		
        ordenarAlumnosPorMediaSeleccion(alumnos, mediaAlumnos);
	}
	
	public static void leerNotasArchivo(int[][] notas, String[]alumnos) {
        FileReader lector = null;
        BufferedReader buffer = null;
        Scanner scan = null;
              
        try {
            String archivo = "src/tp0/Alumnos.txt";
            lector = new FileReader(archivo);
            buffer = new BufferedReader(lector);
            scan = new Scanner(buffer);
        	
        	
            int i= 0, j=0;
            
            scan.nextLine();
            
            for (i = 0; i < cantAlumnos; i++) {
            	
                //Avanzamos hasta encontrar notas
                while (!scan.hasNextInt()) {
                    alumnos[i] = scan.next();
                }
              
                //Cargamos las notas de alumno al arreglo
                for (j = 0; j < cantAsignaturas; j++) {
                    notas[i][j] = scan.nextInt();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lector.close();
                buffer.close();
                scan.close();
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }	
	
    public static Double[] getNotaMediaAlumnos(int[][] notas){
        //calculamos el promedio de notas de cada alumno
    	
        Double[] notaPromedio = new Double[cantAlumnos];
        
        for (int i = 0; i < cantAlumnos; i++){
            for (int j = 0; j < cantAsignaturas; j++){
                notaPromedio[i] = notaPromedio[i] + notas[i][j];
            }
        }
        return notaPromedio;
    }	
    
    public static Double[] getNotaMediaAsignaturas(int[][] notas){
        //calculamos el promedio de notas de la asignatura
        Double[] notaPromedio = new Double[cantAsignaturas];
        for (int i = 0; i < cantAlumnos; i++){
            for (int j = 0; j < cantAsignaturas; j++){
                notaPromedio[i] = notaPromedio[i] + notas[j][i];
            }
        }
        return notaPromedio;
    }
    
    public static double getNotaMediaClase(Double[] mediaAlumno){
    	
        double promedioClase = 0;
        for (int i = 0; i < cantAlumnos; i++){
                promedioClase = promedioClase + mediaAlumno[i];
        }
        promedioClase = promedioClase / cantAlumnos;
        
        return promedioClase;
    }
    
    public static void ordenarAlumnosPorMediaBurbuja(String[]alumno, Double[] nota){
        //Ordena los alumnos de forma descendente de acuerdo a sus notas medias
        //metodo de ordenamiento burbuja pues tiene buen rendimiento en cantidades de datos bajas
        
        for (int i = 0;i < cantAlumnos; i++){
            for (int j = 0; j < cantAlumnos; j++){
                if (nota[j] > nota[j+1]){
                    intercambiar(nota, j, j+1);
                    intercambiar(alumno, j, j+1);
                }
            }
        }
    }
    
    public static void ordenarAlumnosPorMediaSeleccion(String[]alumno, Double[] nota){
        //Ordena  por notas medias en forma descendente de los alumnos
        // Se utiliza el metodo de ordenamiento por seleccion, tambien es eficiente para cantidades pequeñas
    	
        int maximo;
        for (int i = 0; i < cantAlumnos; i++){
            maximo = i;
            for (int j = i+1; i < cantAsignaturas; j++){
                if (nota[j] > nota[maximo])
                    maximo = j;
            }
            intercambiar(nota,i, maximo);
            intercambiar(alumno,i, maximo);
        }
    }
 
    
    public static void intercambiar(Object [] x, int n, int k){
        Object aux = x[n];
        x[n] = x[k];
        x[k] = aux;
    }
    
}
