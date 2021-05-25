import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pablo
 */
public class Tablero {
    private int filas;
    private int columnas;    
    private static  int totalCartas;
    private static Baraja baraja;  
    private static Cartas cartaVolteada1;
    private static Cartas cartaVolteada2;
    private static int puntajeTotal;


    public Tablero() {
        puntajeTotal = 0;
    }
    public static void main (String[] args) {                        
        Tablero t = new Tablero();        
        t.crearTablero();                        
        
    }
    public void crearTablero() {            
        int cartas;
        baraja = new Baraja();          
        JFrame frame = new JFrame("Memorama ICO G-02");        
        Imagenes img = new Imagenes();
        cartas = img.getCantidadImagenes();
        calculaGrid(cartas);
        JPanel panel = new JPanel(new GridLayout(filas,columnas));
        panel.setBackground(Color.darkGray); 
        for(int i=0;i<totalCartas;i++) {
            int fils = 700/filas;
            int cols = 700/columnas;        
            asignarIcono(baraja.consultaCarta(i), cols, fils);
            baraja.consultaCarta(i).setIcon(baraja.consultaCarta(i).getIconoTapado());                        
            baraja.consultaCarta(i).setPreferredSize(new Dimension(cols, fils));
            panel.add(baraja.consultaCarta(i));
        }        
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700,700);                
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void calculaGrid(int numeroCartas) {
        double raiz;
        totalCartas = numeroCartas * 2;
        raiz = Math.sqrt(totalCartas);
        columnas = (int)raiz;
        filas = columnas;
        if( raiz > columnas ) {
            filas = columnas+1;
        }
        if(columnas*filas < totalCartas) {
            columnas += 1;
        }
    }

    public void asignarIcono(Cartas carta,int width,int height) {                
        ImageIcon imageIcon = new ImageIcon(carta.getImagen());
        Image iconoActual = imageIcon.getImage(); 
        Image nuevoIcono = iconoActual.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
        imageIcon = new ImageIcon(nuevoIcono); 
        carta.setIcono(imageIcon);
        
        imageIcon = new ImageIcon(carta.getImagenTapada());
        iconoActual = imageIcon.getImage(); // transform it 
        nuevoIcono = iconoActual.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(nuevoIcono); 
        carta.setIconoTapado(imageIcon);                        
    }
    
       public static boolean diferentes() {
       int i=0;
       boolean impar=false;
       for(Cartas c:baraja.getCartas()){
            if(!c.isEncontrado()&& c.isDestapado()) {
                i++;
            }                                    
        }           
           
        if(i>=2){
            for(Cartas c:baraja.getCartas()){
            if(!c.isEncontrado()&& c.isDestapado()) {
                c.tapar();
                impar=true;
            }                        
            }
        }       
        
            return impar;    
    }
       
    public static boolean comparaCasillas() {
        boolean iguales = false;
        if(cartaVolteada1.getId() == cartaVolteada2.getId()) {            
            iguales = true;
            cartaVolteada1.setEncontrado(true);
            cartaVolteada2.setEncontrado(true);            
            sumaPuntoTotal();
            finalizarJuego();
        }
        return iguales;
    }    

    public static Cartas getCartaVolteada1() {
        return cartaVolteada1;
    }

    public static void setCartaVolteada1(Cartas cartaVolteada1) {
        Tablero.cartaVolteada1 = cartaVolteada1;
    }

    public static Cartas getCartaVolteada2() {
        return cartaVolteada2;
    }

    public static void setCartaVolteada2(Cartas cartaVolteada2) {
        Tablero.cartaVolteada2 = cartaVolteada2;
    }
    
    public static void cambiaTurno() {      // TODO: implementar cambio de turno

    }
    
    public static void aumentaPuntuación() {      // TODO: Implementar metodo aumenta puntuación

    }
    
    public static void sumaPuntoTotal() {
        puntajeTotal++;
        System.out.println(puntajeTotal);
    }
    
    public static void finalizarJuego() {
        if(puntajeTotal == (totalCartas/2)) {
            System.out.println("El juego ha terminado");
        }        
    }
    
    public void menuPrincipal() {
        JFrame frameMenu = new JFrame("Menú principal");
        JPanel panelMenu = new JPanel();
        JLabel titulo = new JLabel("MEMORAMA GAME"); 
        JButton iniciar = new JButton("Iniciar juego");
        panelMenu.setLayout(new BoxLayout(panelMenu,BoxLayout.Y_AXIS));
        titulo.setAlignmentX(titulo.CENTER_ALIGNMENT);              
        titulo.setFont(new Font("Calibri", Font.BOLD, 30));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(Color.decode("#253340"));
        titulo.setBorder(new EmptyBorder(50, 10, 10, 10));
        iniciar.setBackground(Color.white);
        iniciar.setAlignmentX(iniciar.CENTER_ALIGNMENT);   
                
        panelMenu.setBackground(Color.decode("#949DA6"));
        panelMenu.add(titulo);
        panelMenu.add(iniciar);
        frameMenu.setContentPane(panelMenu);
        frameMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMenu.setSize(600,400);        
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setVisible(true);
        
    }
                    
}