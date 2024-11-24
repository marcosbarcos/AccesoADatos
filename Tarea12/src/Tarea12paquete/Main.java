package Tarea12paquete;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	MetodosSQL creador = new MetodosSQL();
	creador.crearConexion();
	Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1. Insertar alumnos.");
        System.out.println("2. Insertar grupos.");
        System.out.println("3. Mostrar todos los alumnos (en consola).");
        System.out.println("4. Guardar todos los alumnos en un fichero.");
        System.out.println("5. Leer alumnos de un fichero y guardarlos en la BD.");
        System.out.println("6. Modificar el nombre de un alumno en la BD (por PK).");
        System.out.println("7. Eliminar un alumno por PK.");
        System.out.println("8. Eliminar los alumnos de un curso indicado.");
        System.out.println("9. Guardar todos los grupos en un fichero XML o JSON.");
        System.out.println("10. Leer un fichero XML o JSON de grupos y guardarlos en la BD.");
        System.out.println("0. Salir.");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                System.out.println("Opción seleccionada: Insertar alumnos.");
                	creador.insertarAlumno(null);
                break;
            case 2:
                System.out.println("Opción seleccionada: Insertar grupos.");
                	creador.insertarGrupo();
                break;
            case 3:
                System.out.println("Opción seleccionada: Mostrar todos los alumnos (en consola).");
                	creador.mostrarAlumnos();
                break;
            case 4:
                System.out.println("Opción seleccionada: Guardar todos los alumnos en un fichero.");
                	creador.guardarenFichero();
                break;
            case 5:
                System.out.println("Opción seleccionada: Leer alumnos de un fichero y guardarlos en la BD.");
                	creador.leerdeFichero();
                break;
            case 6:
                System.out.println("Opción seleccionada: Modificar el nombre de un alumno en la BD (por PK).");
                	creador.modificarAlumno();
                break;
            case 7:
                System.out.println("Opción seleccionada: Eliminar un alumno por PK.");
                	creador.borrarAlumno();
                break;
            case 8:
                System.out.println("Opción seleccionada: Eliminar los alumnos de un curso indicado.");
                	creador.borrarAlumnoporCurso();
                break;
            case 9:
                System.out.println("Opción seleccionada: Guardar todos los grupos en un fichero XML o JSON.");
                	creador.guardarenJson();;
                break;
            case 10:
                System.out.println("Opción seleccionada: Leer un fichero XML o JSON de grupos y guardarlos en la BD.");
                	creador.leerdeJson();
                break;
            case 0:
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    } while (opcion != 0);
    
}
}
