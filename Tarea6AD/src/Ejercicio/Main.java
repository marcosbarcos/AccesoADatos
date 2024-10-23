package Ejercicio;

import java.io.File;
import java.util.Scanner;

public class Main {
	
public static void generarMenu() {
	System.out.println("MENU FICHEROS:");
	System.out.println("1. Genera un fichero");
	System.out.println("2. Seleccionar un fichero");
	System.out.println("3. Cargar alumno");
	System.out.println("4. Mostrar alumnos");
}
	
public static void main(String[] args) {
	File enUso = null;
	Fichero fich = new Fichero();
	Scanner entrada = new Scanner(System.in);
	int respuesta;
	do {
		generarMenu();
		respuesta = entrada.nextInt();
		switch(respuesta) {
		case 1:
			String ruta, nombre;
			System.out.println("Dame la ruta del fichero");
			ruta = entrada.nextLine();
			System.out.println("Dame el nombre del fichero");
			nombre = entrada.nextLine();
			enUso = new File(ruta+nombre);
		case 2:
			fich.imprimirListaFicheros();
			fich.seleccionarFichero();
		case 3:
			Alumno a = Alumno.crearAlumno();
			fich.cargarFichero(enUso, a);
		case 4:
			fich.imprimirFichero(enUso);
		break;
		}
		
			
	}while(respuesta <= 4 && respuesta >= 1);
		
}
}
