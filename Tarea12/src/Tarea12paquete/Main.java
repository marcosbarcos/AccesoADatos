package Tarea12paquete;

public class Main {
	public static void main(String[] args) {
	MetodosSQL creador = new MetodosSQL();
	creador.crearConexion();
	creador.guardarenFichero();
//	creador.leerdeFichero();
	creador.guardarenJson();
	creador.leerdeJson();
}
}
