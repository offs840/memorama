
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 
 */
public class TablaPuntaje {
    private String datos;
    private File archivo;
    
    public TablaPuntaje() {
        try {
            String ruta = "registros/puntajes.txt";            
            File file = new File(ruta);            
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void crearRegistro() {        
        try {
            FileWriter fw;
            fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(datos);
            bw.close();
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error con el archivo");
        }

    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
    
}


