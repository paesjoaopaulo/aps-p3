package app;

import persistencia.CarroPersistency;
import bean.Carro;

public class Main {

    public static void main(String[] args) {
        CarroPersistency c = new CarroPersistency();

        System.err.println("Todos");
        for (Carro carro : c.all()) {
            System.out.println(carro.toString());
        }

        System.err.println("Carros de 2005");
        for (Carro carro : c.findByAno(2005)) {
            System.out.println(carro.toString());
        }
        
        System.err.println("Carros de 2005, 2006");
        for (Carro carro : c.findByAnoDeAte(2005, 2006)) {
            System.out.println(carro.toString());
        }
        
        System.err.println("Carros da Fiat");
        for (Carro carro : c.findByMarca("Fiat")) {
            System.out.println(carro.toString());
        }
    }
}
