package Stiven.base;
public class Clase {
    private String codigo;
    private String nombre;
    private int capacidad;
    private String horario;
    private Instructor instructor;
    private int duracion;
    private String ubicacion;
    public Clase(String codigo, String nombre, int capacidad, String horario, Instructor instructor, int duracion, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.horario = horario;
        this.instructor = instructor;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getHorario() {
        return horario;
    }
}