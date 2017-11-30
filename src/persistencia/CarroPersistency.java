package persistencia;

import bean.Carro;
import dao.CarroDAO;
import java.util.List;

public class CarroPersistency {

    private final CarroDAO dao;

    public CarroPersistency() {
        this.dao = new CarroDAO();
    }

    public List<Carro> all() {
        return dao.all();
    }

    public boolean insert(Carro c) {
        return dao.insert(c);
    }

    public List<Carro> findByAno(int ano) {
        return dao.findByAno(ano);
    }

    public Carro findById(int id) {
        return dao.findById(id);
    }

    public List<Carro> findByMarca(String marca) {
        return dao.findByMarca(marca);
    }

}
