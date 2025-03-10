package Stiven.base;
public class Pago {
    private Socio socio;
    private double monto;
    private String metodoPago;
    public Pago(Socio socio, double monto, String metodoPago) {
        this.socio = socio;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }
    public void procesarPago() {
        System.out.println("✅ Pago procesado con éxito para " + socio.getNombreCompleto() + " por $" + monto);
    }
}