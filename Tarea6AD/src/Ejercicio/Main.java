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
		entrada.nextLine();
		switch(respuesta) {
		case 1:
			String ruta, nombre;
			System.out.println("Dame la ruta del fichero");
			ruta = entrada.nextLine();
			System.out.println("Dame el nombre del fichero");
			nombre = entrada.nextLine();
			enUso = new File(ruta+nombre);
		break;
		case 2:
			enUso = fich.seleccionarFichero();
		break;
		case 3:
			if (enUso == null) {
				System.out.println("No hay ningun fichero seleccionado");
				break;
			}
			Alumno a = Alumno.crearAlumno();
			fich.cargarFichero(enUso, a);
		break;
		case 4:
			if (enUso == null) {
                System.out.println("Primero debes seleccionar o crear un fichero.");
            } 
			else {
			fich.imprimirFichero(enUso);	
			}
        break;
		}
		
			
	}while(respuesta <= 4 && respuesta >= 1);
		
	
}
}
