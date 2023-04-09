package Main;

import Models.Caja;
import Models.Camisa;
import Models.Ticket;

public class main {
    public static void main(String[]args){
        Camisa camisa1 = new Camisa(1, "Camisa Homero", 300, 3);
        Camisa camisa2 = new Camisa(2, "Camisa Manga Corta", 100, 5);
        Camisa camisa3 = new Camisa(3, "Camisa Morada", 500, 2);
        Camisa[] camisas = {camisa1, camisa2, camisa3};
                
        Caja caja = new Caja(camisas);
        Ticket ticket = new Ticket(camisas, caja);
        ticket.imprimirTicket();
        
    }
    
}
