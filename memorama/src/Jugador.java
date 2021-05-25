 public class Jugador {
    private  int puntaje;
    private  boolean turno;
    private String nombre;

    public Jugador(boolean turno) {
        this.puntaje = 0;
        this.turno = turno;
    }

    //Suma puntos al jugador que tiene turno al encontrar las cartas correctas
    public  void sumaPunto() {
        puntaje++;
    }
    //regresa el puntaje del jugador que tiene el turno
    public  int getPuntaje() {
        return puntaje;
    }

    public  void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }  
    //Le da el turno al jugador que le toca mover cartas
    public  boolean isTurno() {
        return turno;
    }

    public  void setTurno(boolean turno) {
       this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}

