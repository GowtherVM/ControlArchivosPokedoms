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

    public int comprobarRuta(String ruta) throws IOException {
        file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
            return 11;
        }
        return 10;
    }

    public void añadirPokedom(String ruta, String contenido) throws IOException {
        file = new File(ruta);
        FileWriter archivo = new FileWriter(file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(contenido);
        write.close();
    }
}
