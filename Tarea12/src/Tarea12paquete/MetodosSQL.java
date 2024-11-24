package Tarea12paquete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MetodosSQL {
	
	Scanner entrada = new Scanner(System.in);
	private generadorAlumnos gestorAlumnos;
	private static Connection conexion;
	
	public void crearConexion() {
        final String URL = "jdbc:mysql://localhost:3306/alumnos23";
        final String USUARIO = "root";
        final String PASSW = "familia3773";
        try {
        	conexion = DriverManager.getConnection(URL, USUARIO, PASSW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void insertarAlumno(Alumno nuevo) {
		String insertarAlumno = "INSERT INTO alumno(NIA , Nombre, Apellidos, Genero, FechaDeNacimiento, Ciclo, Curso, Grupo) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			try(PreparedStatement sentenciaSQL = conexion.prepareStatement(insertarAlumno)) {
				sentenciaSQL.setInt(1, nuevo.getNia());
				sentenciaSQL.setString(2, nuevo.getNombre());
				sentenciaSQL.setString(3, nuevo.getApellidos());
				sentenciaSQL.setString(4, nuevo.getGenero());
				sentenciaSQL.setDate(5, (Date)nuevo.getFecha_nacimiento());
				sentenciaSQL.setString(6, nuevo.getCiclo());
				sentenciaSQL.setString(7, nuevo.getCurso());
				sentenciaSQL.setInt(8, nuevo.getGrupo());
				if(sentenciaSQL.executeUpdate() == 1) {
					System.out.println("Creado con exito");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void insertarGrupo() {
		String insertarGrupo = "INSERT INTO grupo(codigo, nombre) VALUES(?,?)";
		try(PreparedStatement sentenciaSQL = conexion.prepareStatement(insertarGrupo)) {
			System.out.println("Dame el codigo del nuevo grupo");
			int codigo = entrada.nextInt();
			System.out.println("Dame el nombre del grupo");
			String grupo = entrada.next();
			sentenciaSQL.setInt(1, codigo);
			sentenciaSQL.setString(2, grupo);
			if(sentenciaSQL.executeUpdate() == 1) {
				System.out.println("Creado con exito");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarAlumnos() {
		String sql = "SELECT NIA , Nombre, Apellidos, Genero, FechaDeNacimiento, Ciclo, Curso, Grupo FROM alumno";
		try(Statement consulta = conexion.createStatement()) {
			ResultSet resultado = consulta.executeQuery(sql);
			while(resultado.next()) {
				int nia = resultado.getInt("NIA");
				String nombre = resultado.getString("Nombre");
				String apellidos = resultado.getString("Apellidos");
				String genero = resultado.getString("Genero");
				Date fecha = resultado.getDate("FechaDeNacimiento");
				String ciclo = resultado.getString("Ciclo");
				String curso = resultado.getString("Curso");
				int grupo = resultado.getInt("Grupo");
				Alumno nuevo = new Alumno(nia, nombre, apellidos, genero, fecha, ciclo, curso, grupo);
				System.out.println(nuevo.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarenFichero() {
		try(ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(new File("alumnos.bin")))) {
				String sql = "SELECT NIA , Nombre, Apellidos, Genero, FechaDeNacimiento, Ciclo, Curso, Grupo FROM alumno";
					Statement consulta = conexion.createStatement();
					ResultSet resultado = consulta.executeQuery(sql);
					while(resultado.next()) {
						int nia = resultado.getInt("NIA");
						String nombre = resultado.getString("Nombre");
						String apellidos = resultado.getString("Apellidos");
						String genero = resultado.getString("Genero");
						Date fecha = resultado.getDate("FechaDeNacimiento");
						String ciclo = resultado.getString("Ciclo");
						String curso = resultado.getString("Curso");
						int grupo = resultado.getInt("Grupo");
						Alumno nuevo = new Alumno(nia, nombre, apellidos, genero, fecha, ciclo, curso, grupo);
						dos.writeObject(nuevo);
				} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leerdeFichero() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("alumnos.bin")))) {
			while(true) {
				 try {
	                    Alumno a = (Alumno) ois.readObject();
	                    System.out.println(a.toString());
	                    insertarAlumno(a);
	                } catch (EOFException e) {
	                    break;
	                }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarAlumno() {
		System.out.println("Dame el NIA del alumno a modificar");
		int niaAlumno = entrada.nextInt();
		System.out.println("Que nombre quieres ponerle?");
		String nombreNuevo = entrada.nextLine();
		String cambio = "UPDATE alumno SET Nombre = ? WHERE NIA = ?";
		try(PreparedStatement sql = conexion.prepareStatement("")) {
			sql.setString(1, nombreNuevo);
			sql.setInt(2, niaAlumno);
			System.out.println("Modificado con exito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrarAlumno() {
		System.out.println("Dame el NIA del alumno a modificar");
		int niaAlumno = entrada.nextInt();
		String borrar = "DELETE FROM alumno WHERE NIA = ?";
		try(PreparedStatement ps =  conexion.prepareStatement(borrar)) {
			ps.setInt(1, niaAlumno);
			System.out.println("Borrado con exito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrarAlumnoporCurso() {
		System.out.println("Dame el Curso de los alumnos a modificar");
		String cursoAlumno = entrada.next();
		String borrar = "DELETE FROM alumno WHERE Curso = ?";
		try(PreparedStatement ps =  conexion.prepareStatement(borrar)) {
			ps.setString(1, cursoAlumno);
			System.out.println("Borrados con exito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarenJson() {
		List<Grupo> gruposLista = new ArrayList<Grupo>();
		try(Statement sentencia = conexion.createStatement()) {
			String grupos = "SELECT codigo, nombre FROM grupo";
			ResultSet result = sentencia.executeQuery(grupos);
			while (result.next()) {
				Grupo a = new Grupo(result.getInt("codigo"), result.getString("nombre"));
				gruposLista.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Statement sentencia = conexion.createStatement()) {
			for(int i = 0; i < gruposLista.size(); i++) {
				String alumnosGrupo = "SELECT NIA, Nombre, Apellidos, Genero, FechaDeNacimiento, Ciclo, Curso, Grupo FROM alumno WHERE Grupo = " + (i+1);
				ResultSet result = sentencia.executeQuery(alumnosGrupo);
				while (result.next()) {
					int nia = result.getInt("NIA");
					String nombre = result.getString("Nombre");
					String apellidos = result.getString("Apellidos");
					String genero = result.getString("Genero");
					Date fecha = result.getDate("FechaDeNacimiento");
					String ciclo = result.getString("Ciclo");
					String curso = result.getString("Curso");
					int grupo = result.getInt("Grupo");
					Alumno nuevo = new Alumno(nia, nombre, apellidos, genero, fecha, ciclo, curso, grupo);
					gruposLista.get(i).añadiraLista(nuevo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
		try(BufferedWriter bf = new BufferedWriter(new FileWriter("alumnitos.json"))) {
			gson.toJson(gruposLista, bf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leerdeJson() {
		try(BufferedReader br = new BufferedReader(new FileReader("alumnitos.json"))) {
			Gson gson = new Gson();
			Type tipoRespuesta = new TypeToken<ArrayList<Grupo>>() {}.getType();
			ArrayList<Grupo> respuesta = gson.fromJson(br, tipoRespuesta);
				for (Grupo grupo : respuesta) {
					System.out.println(grupo.toString());
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
