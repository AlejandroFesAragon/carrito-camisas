package Controlador;

import Modelo.Camisa;

public class Caja {

    private Camisa[] camisas;
    private double descuento;
    private double precioTotal;

    public Caja() {
    }

    public Caja(Camisa[] camisas) {
        this.camisas = camisas;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setPrecioTotal(double total) {
        this.precioTotal = total;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double calcularDescuento(int cantidadCamisas) throws NullPointerException {
        double porcentaje = 0;
        if (cantidadCamisas <= 2) {
            porcentaje = 0;
        } else if (cantidadCamisas >= 3 && cantidadCamisas <= 5) {
            porcentaje = 0.05;
        } else if (cantidadCamisas > 5) {
            porcentaje = 0.08;
        }
        setDescuento(porcentaje);
        return porcentaje;
    }

    public double calcularTotal() throws NullPointerException {
        int cantidadCamisas = 0;
        double precioTotalDescuento = 0;
        for (Camisa camisa : camisas) {
            camisa.setPrecio(camisa.getPrecio() * camisa.getCantidad());
            cantidadCamisas += camisa.getCantidad();
            precioTotalDescuento += camisa.getPrecio();
        }
        double precioTotalFinal = precioTotalDescuento - (precioTotalDescuento * this.calcularDescuento(cantidadCamisas));
        setPrecioTotal(precioTotalFinal);
        return precioTotalFinal;
    }

}
