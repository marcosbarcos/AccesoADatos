package Ejercicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Alumno tiene atributos como NIA, nombre, apellidos, género,
 * fecha de nacimiento, ciclo, curso y grupo. Además, proporciona métodos
 * para manipular y acceder a esta información.
 *
 * <p>
 * @author Marcos Herrero Gonzalez
 * </p>
 */
public class Alumno {
    private int nia; 
    private String nombre; 
    private String apellidos; 
    private char genero; 
    private LocalDate fecha_nacimiento; 
    private String ciclo; 
    private String curso; 
    private String grupo; 

    /**
     * Constructor vacío para la clase Alumno.
     */
    public Alumno() {
    }

    /**
     * Constructor que inicializa un nuevo objeto Alumno con los valores
     * proporcionados.
     *
     * @param nia Número de identificación del alumno.
     * @param nombre Nombre del alumno.
     * @param apellidos Apellidos del alumno.
     * @param genero Género del alumno.
     * @param fecha_nacimiento Fecha de nacimiento del alumno.
     * @param ciclo Ciclo académico del alumno.
     * @param curso Curso académico del alumno.
     * @param grupo Grupo académico del alumno.
     */
    public Alumno(int nia, String nombre, String apellidos, char genero, LocalDate fecha_nacimiento, String ciclo, String curso, String grupo) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ciclo = ciclo;
        this.curso = curso;
        this.grupo = grupo;
    }

    // Métodos getter y setter para cada atributo
    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * Imprime en consola la lista de alumnos proporcionada.
     *
     * @param prueba Lista de alumnos a imprimir.
     */
    public static void imprimirLista(ArrayList<Alumno> prueba) {
        for (Alumno a : prueba) {
            System.out.println(a.toString());
        }
    }

    /**
     * Crea 5 alumnos solicitando la información al usuario.
     *
     * @param prueba Lista de alumnos donde se agregarán los nuevos alumnos.
     */
    public static void crearAlumnos(ArrayList<Alumno> prueba) {
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (int i = 0; i < 5; i++) {
            Alumno nuevo = new Alumno();
            System.out.println("dame el nia del alumno nuevo");
            nuevo.setNia(entrada.nextInt());
            System.out.println("dame el nombre del alumno nuevo");
            nuevo.setNombre(entrada.next());
            System.out.println("dame el apellido del alumno nuevo");
            nuevo.setApellidos(entrada.next());
            System.out.println("dame el genero del alumno nuevo");
            nuevo.setGenero(entrada.next().charAt(0));
            System.out.println("dame la fecha de nacimiento del alumno nuevo");
            String fechanac = entrada.next();
            LocalDate fechanacimiento = LocalDate.parse(fechanac, formato);
            nuevo.setFecha_nacimiento(fechanacimiento);
            System.out.println("dame el ciclo del alumno nuevo");
            nuevo.setCiclo(entrada.next());
            System.out.println("dame el curso del alumno nuevo");
            nuevo.setCurso(entrada.next());
            System.out.println("dame el grupo del alumno nuevo");
            nuevo.setGrupo(entrada.next());
            prueba.add(nuevo); // Agrega el nuevo alumno a la lista
        }
    }

    /**
     * Devuelve una representación en cadena de un objeto Alumno.
     *
     * @return String que representa los atributos del alumno.
     */
    @Override
    public String toString() {
        return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
                + ", fecha_nacimiento=" + fecha_nacimiento + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo=" + grupo
                + "]";
    }
}