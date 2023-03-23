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
    

    public CreateAndEditFiles(String ruta,String contenido) {
        this.file = new File(ruta);
        this.contenido = contenido;


    }

    public int comprobarRuta() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            return 11;
        }
        return 10;
    }

    public void añadirPokedom() throws IOException {
        FileWriter archivo = new FileWriter(this.file, true);
        PrintWriter write = new PrintWriter(archivo);
        write.println(this.contenido);
        write.close();
    }
}
