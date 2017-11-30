package app;

import persistencia.CarroPersistency;
import bean.Carro;

public class Main {

    public static void main(String[] args) {
        CarroPersistency c = new CarroPersistency();

        System.err.println("Todos");
        for (Carro carro : c.all()) {
            System.err.println(carro.toString());
        }

        System.err.println("Carro 2");
        Carro achado = c.findById(2);
        System.out.println(achado.toString());

        System.err.println("Carros de 2005");
        for (Carro carro : c.findByAno(2005)) {
            System.err.println(carro.toString());
        }
        
        System.err.println("Carros da Fiat");
        for (Carro carro : c.findByMarca("Fiat")) {
            System.err.println(carro.toString());
        }
    }
}
