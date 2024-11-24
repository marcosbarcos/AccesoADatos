package Tarea12paquete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class generadorAlumnos {
	
	public Alumno crearAlumno() {
	Scanner entrada = new Scanner(System.in);
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Alumno nuevo = new Alumno();
		System.out.println("dame el nia del alumno nuevo");
		nuevo.setNia(entrada.nextInt());
		System.out.println("dame el nombre del alumno nuevo");
		nuevo.setNombre(entrada.next());
		System.out.println("dame el apellido del alumno nuevo");
		nuevo.setApellidos(entrada.next());
		System.out.println("dame el genero del alumno nuevo");
		nuevo.setGenero(entrada.next());
		System.out.println("dame la fecha de nacimineto del alumno nuevo");
		String fechanac = entrada.next();
		Date fechanacimiento;
		try {
			fechanacimiento = formato.parse(fechanac);
			nuevo.setFecha_nacimiento(fechanacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dame el ciclo del alumno nuevo");
		nuevo.setCiclo(entrada.next());
		System.out.println("dame el curso del alumno nuevo");
		nuevo.setCurso(entrada.next());
		System.out.println("dame el grupo del alumno nuevo");
		nuevo.setGrupo(entrada.nextInt());
		return nuevo;
	}
}
