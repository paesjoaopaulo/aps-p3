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

    public void insert(Carro c) {
        dao.insert(c);
    }

    public void delete(int codigo) {
        dao.delete(codigo);
    }

    public List<Carro> findByAno(int ano) {
        return dao.findByAno(ano);
    }

    public List<Carro> findByMarca(String marca) {
        return dao.findByMarca(marca);
    }

    public List<Carro> findByAnoDeAte(int de, int ate) {
        return dao.findByAnoDeAte(de, ate);
    }

    public void updateModelo(int codigo, Carro c) {
        dao.updateModelo(codigo, c);
    }
}
