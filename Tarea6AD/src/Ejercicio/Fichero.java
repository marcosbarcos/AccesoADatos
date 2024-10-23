package Ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Fichero {
	ArrayList<File> ficheros = new ArrayList<File>();
	Scanner entrada = new Scanner(System.in);
	
	public void cargarFichero(File f, Alumno a) {
		FileWriter fos = null;
		PrintWriter pw = null;
		try {
			if (!ficheros.contains(f)) {
				fos = new FileWriter(f);
				pw = new PrintWriter(fos);
				pw.println(a.toString());
				ficheros.add(f);
			}
			else {
				fos = new FileWriter(f, true);
				pw = new PrintWriter(fos);
				pw.println(a.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
	
	public void imprimirListaFicheros() {
		int contador = 0;
		for(File fi : ficheros) {
			contador++;
			System.out.println(contador + " " + fi.getName());
		}
	}
	
	public File seleccionarFichero() {
		String ficheroSolicitado;
		System.out.println("Que fichero quieres seleccionar? Escriba el nombre:");
		ficheroSolicitado = entrada.nextLine();
		for(File fi : ficheros) {
			if (fi.getName().equals(ficheroSolicitado)) {
				return fi;
			}
			else {
				System.out.println("Fichero no encontrado, pruebe de nuevo");
				seleccionarFichero();
			}
		}
		return null;
	}
	
	public void imprimirFichero(File e) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(e);
			br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException er) {
			er.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	
}
