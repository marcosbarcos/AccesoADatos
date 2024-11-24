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
		PrintWriter pw = null;
		try {
			FileWriter fos = new FileWriter(f);
			if (!ficheros.contains(f)) {
				pw = new PrintWriter(fos);
				pw.println(a.toString());
				ficheros.add(f);
			}
			else {
				fos = new FileWriter(f, true);
				pw = new PrintWriter(fos);
				pw.println(a.toString());
			}
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
				}
			}
		}
	
	public void imprimirListaFicheros() {
		int contador = 0;
		for(File fi : ficheros) {
			contador++;
			System.out.println(fi.getName());
		}
	}
	
	public File seleccionarFichero() {
		imprimirListaFicheros();
		String ficheroSolicitado;
		System.out.println("Que fichero quieres seleccionar? Escriba el nombre:");
		ficheroSolicitado = entrada.nextLine();
		for(File fi : ficheros) {
			if (fi.getName().equals(ficheroSolicitado)) {
				return fi;
			}
		}
		System.out.println("Fichero no encontrado, pruebe de nuevo");
		return null;
	}
	
	public void imprimirFichero(File e) {
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(e);
			br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			fr.close();
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
			
		}
		
	}
	
}
