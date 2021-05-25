

import java.io.File;

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
    


    public void setDatos(String datos) {
        this.datos = datos;
    }
    
}


