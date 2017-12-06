package persistencia;

import bean.Carro;
import dao.CarroDAO;
import java.util.List;

public class CarroPersistency {

    private final CarroDAO dao;

    public CarroPersistency() {
        this.dao = new CarroDAO();
    }

    public void insert(Carro c) {
        dao.insert(c);
    }

    public void delete(int codigo) {
        dao.delete(codigo);
    }

    public void updateMarca(Carro c) {
        dao.updateMarca(c);
    }

    public List<Carro> findByMarca(String marca) {
        return dao.findByMarca(marca);
    }

    public List<Carro> all() {
        return dao.all();
    }

    public List<Carro> findByAno(int ano) {
        return dao.findByAno(ano);
    }

    public List<Carro> findByModeloFromTo(int from, int to) {
        return dao.findByModeloFromTo(from, to);
    }

}
