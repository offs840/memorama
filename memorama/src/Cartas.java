import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Aarón
 */
public class Cartas extends JButton implements ActionListener {
    private int id;
    private boolean encontrado;
    private boolean destapado;
    private String imagen;
    private String imagenTapada;
    private ImageIcon icono;
    private ImageIcon iconoTapado;    

    
    public Cartas(int id) {        
        this.id = id;
        this.destapado=false;
        this.encontrado=false;
        this.setBackground(Color.darkGray);          
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {  
        
     if(!Tablero.diferentes()) {         
        if(!destapado) {
            destapar();  
            if(Tablero.getCartaVolteada1() == null){                
                Tablero.setCartaVolteada1(this);
                if(Tablero.getCartaVolteada1().isEncontrado()){
                    Tablero.setCartaVolteada1(null);
                }
            }
            else if(Tablero.getCartaVolteada2() == null){
                Tablero.setCartaVolteada2(this);
                if(Tablero.getCartaVolteada2().isEncontrado()){
                    Tablero.setCartaVolteada1(null);
                }
            }
            if (Tablero.getCartaVolteada1() != null && Tablero.getCartaVolteada2() != null) {
                    if(!Tablero.comparaCasillas()){
                        Tablero.cambiaTurno();
                    }
                    Tablero.setCartaVolteada1(null);
                    Tablero.setCartaVolteada2(null);
            }
        }            
   
        }       
        
    }  
    
    
    public void destapar() {
        setIcon(icono);        
        destapado = true;
    }
    
    public void tapar(){        
        setIcon(iconoTapado);
        destapado = false;
    }

    public String getImagen() {
        return imagen;
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setImagenTapada(String imagenTapada) {
        this.imagenTapada = imagenTapada;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }

    public void setIconoTapado(ImageIcon iconoTapado) {
        this.iconoTapado = iconoTapado;
    }

    public String getImagenTapada() {
        return imagenTapada;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public ImageIcon getIconoTapado() {
        return iconoTapado;
    }

    public boolean isDestapado() {
        return destapado;
    }

    public void setDestapado(boolean destapado) {
        this.destapado = destapado;
    }
                
}
