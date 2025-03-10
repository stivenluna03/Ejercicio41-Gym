package Stiven.base;
public class Equipo {
    private int codigo;
    private String nombre;
    private String estado;
    private String fechaUltimaRevision;
    private String ubicacion;
    public Equipo(int codigo, String nombre, String estado, String fechaUltimaRevision, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaUltimaRevision = fechaUltimaRevision;
        this.ubicacion = ubicacion;
    }
    public String getNombre() {
        return nombre;
    }
}