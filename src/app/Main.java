package app;

import persistencia.CarroPersistency;
import persistencia.HeroiPersistency;
import persistencia.TituloPersistency;

public class Main {

    public static void main(String[] args) {
        CarroPersistency c = new CarroPersistency();
        HeroiPersistency h = new HeroiPersistency();
        TituloPersistency t = new TituloPersistency();
        
        //TODO: Testar o funcionamento das classes
        
        System.out.println("O repositório desse projeto se encontra em https://github.com/paesjoaopaulo/aps-p3. Confira!");
    }
}
