package Stiven;
import Stiven.base.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Gym {
    private static List<Socio> socios = new ArrayList<>();
    private static List<Clase> clases = new ArrayList<>();
    private static List<Instructor> instructores = new ArrayList<>();
    private static List<Pago> pagos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        inicializarDatos(); // Carga instructores y clases
        System.out.println("----- BIENVENIDO  -----");
        Socio socioActivo = null;
        while (socioActivo == null) {
            System.out.println("¿Tienes una cuenta?");
            System.out.println("1. iniciar sesión");
            System.out.println("2. iegistrarse");
            System.out.print("seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            if (opcion == 2) {
                registrarSocio();
                System.out.println("registro exitoso , ahora inicia sesión para continuar.");
            } else if (opcion == 1) {
                socioActivo = iniciarSesion();
            } else {
                System.out.println("opción inválida , vuelve a intentar");
            }
        }
        menuPrincipal(socioActivo);
    }
    private static void menuPrincipal(Socio socioActivo) {
        while (true) {
            System.out.println("----- REGISTRO DE GYM -----");
            System.out.println("1. ver clases disponibles");
            System.out.println("2. ver membresías disponibles");
            System.out.println("3. reservar una clase");
            System.out.println("4. cancelar reserva");
            System.out.println("5. consultar historial de reservas");
            System.out.println("6. realizar pago");
            System.out.println("7. cerrar sesión");
            System.out.print("seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1 -> listarClases();
                case 2 -> listarMembresias();
                case 3 -> reservarClase(socioActivo);
                case 4 -> cancelarReserva(socioActivo);
                case 5 -> socioActivo.consultarHistorial();
                case 6 -> realizarPago(socioActivo);
                case 7 -> {
                    System.out.println("sesión cerrada , ¡Hasta luego, " + socioActivo.getNombreCompleto() + "!");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
    private static void inicializarDatos() {
        // Crear instructores
        Instructor instructor1 = new Instructor(101, "Carlos Pérez", "Yoga", "123456789", "carlos@email.com", "8:00-12:00");
        Instructor instructor2 = new Instructor(102, "Marta Gómez", "Crossfit", "987654321", "marta@email.com", "14:00-18:00");
        instructores.add(instructor1);
        instructores.add(instructor2);
        // Crear clases
        clases.add(new Clase("C001", "Yoga Avanzado", 5, "10:00 AM", instructor1, 60, "Sala A"));
        clases.add(new Clase("C002", "Crossfit Intensivo", 5, "6:00 PM", instructor2, 45, "Sala B"));
    }
    private static void listarMembresias() {
        System.out.println("\n--- MEMBRESÍAS DISPONIBLES ---");
        System.out.println("1. Básica - 6 meses, $200 - Acceso limitado a máquinas y clases grupales.");
        System.out.println("2. Premium - 12 meses, $500 - Acceso ilimitado a todas las áreas y entrenadores personales.");
        System.out.println("3. Personalizada - Precio y duración a convenir - Plan ajustado a tus necesidades.");
    }
    private static Socio iniciarSesion() {
        System.out.print("Ingrese su número de socio: ");
        int numeroSocio = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        for (Socio socio : socios) {
            if (socio.getNumeroSocio() == numeroSocio) {
                System.out.println("Bienvenido " + socio.getNombreCompleto() + "!");
                return socio;
            }
        }
        System.out.println("número de socio no encontrado , intente de nuevo");
        return null;
    }
    private static void registrarSocio() {
        System.out.print("ingrese su nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("ingrese su número de teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("ingrese su email: ");
        String email = scanner.nextLine();
        Socio nuevoSocio = new Socio(socios.size() + 1, nombre, telefono, email);
        socios.add(nuevoSocio);
        System.out.println(" felicidades ahora eres socio. Tu número de socio es: " + nuevoSocio.getNumeroSocio());
    }
    private static void reservarClase(Socio socio) {
        listarClases();
        System.out.print("ingrese  código de la clase que desea reservar: ");
        String codigoClase = scanner.nextLine();
        for (Clase clase : clases) {
            if (clase.getCodigo().equals(codigoClase)) {
                socio.reservarClase(clase);
                return;
            }
        }
        System.out.println("Clase no encontrada.");
    }
    private static void cancelarReserva(Socio socio) {
        System.out.print(" ingresar  código de la clase que desea cancelar: ");
        String codigoClase = scanner.nextLine();
        for (Clase clase : clases) {
            if (clase.getCodigo().equals(codigoClase)) {
                socio.cancelarReserva(clase);
                return;
            }
        }
        System.out.println("clase no encontrada.");
    }
    private static void realizarPago(Socio socio) {
        System.out.print("ingresar  método de pago de preferencia (Tarjeta - Efectivo - PayPal) : ");
        String metodoPago = scanner.nextLine();
        double monto = 500; // Simulando el pago de membresía
        Pago pago = new Pago(socio, monto, metodoPago);
        pagos.add(pago);
        System.out.println("pago realizado con éxito ✅");
    }
    private static void listarClases() {
        System.out.println("\n--- CLASES DISPONIBLES ---");
        for (Clase clase : clases) {
            System.out.println(clase.getCodigo() + "-" + clase.getNombre() + " (" + clase.getHorario() + ")");
        }
    }
}
