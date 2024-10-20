package Ejercicio;

import java.io.File;

/**
 * La clase Fichero se encarga de gestionar la creación de archivos.
 * Proporciona un metodo para crear archivos en una ubicación específica
 * utilizando un nombre de archivo y una dirección.
 *
 * <p>
 * @author Marcos Herrero Gonzalez
 * </p>
 */
public class Fichero {
    private String nombre; // Nombre del archivo
    private String direccion; // Dirección donde se creará el archivo

    /**
     * Crea un objeto File utilizando el nombre y la dirección proporcionados.
     *
     * @param nombre El nombre del archivo a crear.
     * @param direccion La dirección en la que se creará el archivo.
     * @return Un objeto File que representa el archivo creado.
     */
    public File crearFichero(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        File f = new File(direccion + nombre);
        return f;
    }
}