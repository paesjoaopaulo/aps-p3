package persistencia;

import bean.Heroi;
import dao.HeroiDAO;
import java.util.List;

public class HeroiPersistency {

    private final HeroiDAO dao;

    public HeroiPersistency() {
        this.dao = new HeroiDAO();
    }

    public void insert(Heroi c) {
        dao.insert(c);
    }

    public void delete(String nome) {
        dao.delete(nome);
    }

    public void updatePoder(Heroi c) {
        dao.updatePoder(c);
    }

    public List<Heroi> findByPais(String pais) {
        return dao.findByPais(pais);
    }

    public List<Heroi> all() {
        return dao.all();
    }

    public List<Heroi> findBy(String poder) {
        return dao.findByPoder(poder);
    }

    public List<Heroi> findByDataNascimentoFromTo(String from, String to) {
        return dao.findByDataNascimentoFromTo(from, to);
    }

}
