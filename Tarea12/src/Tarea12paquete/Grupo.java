package Tarea12paquete;

import java.util.ArrayList;

public class Grupo {
	private int codigo;
	private String nombre;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	
	public Grupo(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public Grupo(int codigo, String nombre, ArrayList<Alumno> alumnos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void añadiraLista(Alumno a) {
		this.alumnos.add(a);
	}

	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", nombre=" + nombre + ", alumnos=" + alumnos.toString() + "]";
	}
	
	
	
}
