package Stiven.base;
public class Instructor {
    private int id;
    private String nombre;
    private String especializacion;
    private String telefono;
    private String email;
    private String horario;
    public Instructor(int id, String nombre, String especializacion, String telefono, String email, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.especializacion = especializacion;
        this.telefono = telefono;
        this.email = email;
        this.horario = horario;
    }
    public String getNombre() {
        return nombre;
    }
}