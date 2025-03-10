package Stiven.base;
import java.util.ArrayList;
import java.util.List;
public class Socio {
    private int numeroSocio;
    private String nombreCompleto;
    private String telefono;
    private String email;
    private List<Clase> historialReservas = new ArrayList<>();
    public Socio(int numeroSocio, String nombreCompleto, String telefono, String email) {
        this.numeroSocio = numeroSocio;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
    }
    public int getNumeroSocio() {
        return numeroSocio;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void reservarClase(Clase clase) {
        historialReservas.add(clase);
        System.out.println("✅ Clase reservada con éxito: " + clase.getNombre());
    }
    public void cancelarReserva(Clase clase) {
        if (historialReservas.remove(clase)) {
            System.out.println("❌ Reserva cancelada: " + clase.getNombre());
        } else {
            System.out.println("⚠️ No tienes una reserva para esta clase.");
        }
    }
    public void consultarHistorial() {
        System.out.println("📅 Historial de reservas de " + nombreCompleto + ":");
        for (Clase clase : historialReservas) {
            System.out.println("- " + clase.getNombre());
        }
    }
}
