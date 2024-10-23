package Ejercicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Alumno{
	private int nia;
	private String nombre;
	private String apellidos;
	private char genero;
	private LocalDate fecha_nacimiento;
	private String ciclo;
	private String curso;
	private String grupo;
	
public Alumno() {
}

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

public static void imprimirLista(ArrayList<Alumno> prueba) {
	for(Alumno a : prueba) {
		System.out.println(a.toString());
	}
}

public static Alumno crearAlumno() {
	Scanner entrada = new Scanner(System.in);
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Alumno nuevo = new Alumno();
		System.out.println("dame el nia del alumno nuevo");
		nuevo.setNia(entrada.nextInt());
		System.out.println("dame el nombre del alumno nuevo");
		nuevo.setNombre(entrada.next());
		System.out.println("dame el apellido del alumno nuevo");
		nuevo.setApellidos(entrada.next());
		System.out.println("dame el genero del alumno nuevo");
		nuevo.setGenero(entrada.next().charAt(0));
		System.out.println("dame la fecha de nacimineto del alumno nuevo");
		String fechanac = entrada.next();
		LocalDate fechanacimiento = LocalDate.parse(fechanac, formato);
		nuevo.setFecha_nacimiento(fechanacimiento);
		System.out.println("dame el ciclo del alumno nuevo");
		nuevo.setCiclo(entrada.next());
		System.out.println("dame el curso del alumno nuevo");
		nuevo.setCurso(entrada.next());
		System.out.println("dame el grupo del alumno nuevo");
		nuevo.setGrupo(entrada.next());
		return nuevo;
}

@Override
public String toString() {
	return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
			+ ", fecha_nacimiento=" + fecha_nacimiento + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo=" + grupo
			+ "]";
}



}
