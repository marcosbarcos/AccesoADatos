package Ejercicio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class Pruebas {
    private File testFile;
    private Fichero fich;
    private Scanner entrada;

    @BeforeEach
    public void setUp() throws IOException {
        // Crea un fichero vacío para las pruebas
        testFile = new File("testAlumnos.txt");
        if (testFile.exists()) {
            testFile.delete(); // Elimina el fichero si ya existe
        }
        testFile.createNewFile();
        fich = new Fichero();
        entrada = new Scanner(System.in);
    }

    @AfterEach
    public void tearDown() {
        // Elimina el fichero de prueba después de cada prueba
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testAñadirYMostrarAlumnos() {
        // Añadir 2 alumnos
        Alumno a1 = new Alumno(1, "Juan", "Pérez", 'M', LocalDate.of(2000, 1, 1), "Ciclo1", "Curso1", "Grupo1");
        Alumno a2 = new Alumno(2, "Ana", "García", 'F', LocalDate.of(2001, 2, 2), "Ciclo2", "Curso2", "Grupo2");

        fich.cargarFichero(testFile, a1);
        fich.cargarFichero(testFile, a2);
        
        // Cerrar el programa
        System.exit(0);
        
        // Vuelve a abrir el programa y selecciona el fichero
        Main main = new Main();
        File selectedFile = fich.seleccionarFichero();

        // Asegúrate de que el fichero seleccionado es el correcto
        assertEquals(testFile.getName(), selectedFile.getName());

        // Añadir 1 alumno más
        Alumno a3 = new Alumno(3, "Luis", "Martínez", 'M', LocalDate.of(2002, 3, 3), "Ciclo3", "Curso3", "Grupo3");
        fich.cargarFichero(testFile, a3);
        
        // Cerrar el programa
        System.exit(0);
        
        // Vuelve a abrir el programa y selecciona el fichero
        Main main2 = new Main();
        File selectedFile2 = fich.seleccionarFichero();
        
        // Asegúrate de que el fichero seleccionado es el correcto
        assertEquals(selectedFile.getName(), selectedFile2.getName());
        
        // Mostrar todos los alumnos
        fich.imprimirFichero(testFile);
 
        //Info de los alumnos
        String alumnos = a1.toString() + System.lineSeparator() +
        				a2.toString() + System.lineSeparator() +
        				a3.toString() + System.lineSeparator();
        
        // Cerrar el programa
        System.exit(0);

    }
}