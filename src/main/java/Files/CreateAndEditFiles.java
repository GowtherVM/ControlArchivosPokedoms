/*+
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class CreateAndEditFiles {

    private File file;
    private String contenido;
    private boolean opcion;

    public CreateAndEditFiles(String ruta, int efecto, String nombre, String familia, String ataque, String defensa) {
        this.file = new File(ruta);
        this.contenido = (nombre + " " + familia + " " + ataque + " " + defensa);

        if (efecto == 1) {
            this.opcion = true;
        } else if (efecto == 0) {
            this.opcion = false;
        }
    }

    public void comprobarRuta() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void añadirPokedom() throws IOException {
        FileWriter archivo = new FileWriter(this.file, this.opcion);
        PrintWriter write = new PrintWriter(archivo);
        write.println(this.contenido);
        write.close();
    }
}
