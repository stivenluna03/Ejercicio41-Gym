package Stiven.base;
import java.util.Date;
public class Reserva {
    private int id;
    private Socio socio;
    private Clase clase;
    private Date fecha;
    private String estado; // Confirmada, Cancelada
    public Reserva(int id, Socio socio, Clase clase, Date fecha, String estado) {
        this.id = id;
        this.socio = socio;
        this.clase = clase;
        this.fecha = fecha;
        this.estado = estado;
    }
}