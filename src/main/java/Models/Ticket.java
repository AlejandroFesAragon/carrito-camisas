package Models;

public class Ticket {

    private Camisa[] camisas;
    private Caja caja;

    public Ticket(Camisa[] camisas, Caja caja) {
        this.camisas = camisas;
        this.caja = caja;
    }

    public void imprimirTicket() {
        caja.calcularTotal();
        for (Camisa camisa : camisas) {
            System.out.println("Producto: " + camisa.getNombre() + " --- " + "Cantidad: " + camisa.getCantidad() + 
                    " --- " + "Precio: " + (camisa.getPrecio()));
        }
        System.out.println("Descuento: " + (caja.getDescuento() * 100) + "%");
        System.out.println("Total: " + caja.getPrecioTotal());
    }

}
