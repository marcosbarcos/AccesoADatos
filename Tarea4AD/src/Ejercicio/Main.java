package Ejercicio;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase utiliza un objeto {@link Fichero} para gestionar la
 * creación del archivo y un objeto {@link Scanner} para recibir la
 * entrada del usuario. Los datos de cada alumno son escritos en un
 * formato binario utilizando {@link DataOutputStream}.
 * 
 * <p>
 * @author Marcos Herrero Gonzalez
 * </p>
 */
public class Main {
    
    /**
     * En el metodo main el usuario puede
     * ingresar la ruta y el nombre del archivo donde se guardarán
     * los datos de los alumnos. También gestiona la entrada de
     * información sobre cada alumno.
     * 
     * @param args Los argumentos de línea de comando (no se utilizan en esta aplicación).
     * @throws IOException Si ocurre un error al intentar crear o escribir en el archivo.
     */
    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);  
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        String ruta, nombrefich;

        System.out.println("Dame la ruta del archivo binario donde guardar los datos de los alumnos");
        ruta = entrada.nextLine();

        System.out.println("Dame le nombre del fichero");
        nombrefich = entrada.next();
        
        Fichero f = new Fichero();
        FileOutputStream fos = new FileOutputStream(f.crearFichero(nombrefich, ruta));
        
        try {
            DataOutputStream dos = new DataOutputStream(fos);
            Alumno.crearAlumnos(alumnos);

            for (int i = 0; i < alumnos.size(); i++) {
                System.out.println("Quieres guardar los datos del alumno " + i + " ?");
                if (entrada.next().equalsIgnoreCase("si")) {
                    dos.writeInt(alumnos.get(i).getNia());
                    dos.writeUTF(alumnos.get(i).getNombre());
                    dos.writeUTF(alumnos.get(i).getApellidos());
                    dos.writeChar(alumnos.get(i).getGenero());
                    dos.writeLong(alumnos.get(i).getFecha_nacimiento().toEpochDay());
                    dos.writeUTF(alumnos.get(i).getCiclo());
                    dos.writeUTF(alumnos.get(i).getCurso());
                    dos.writeUTF(alumnos.get(i).getGrupo());
                } else {
                    break;
                }
            }

            dos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entrada.close();
        }
    }
}