package persistencia;

import bean.Titulo;
import dao.TituloDAO;
import java.util.List;

public class TituloPersistency {

    private final TituloDAO dao;

    public TituloPersistency() {
        this.dao = new TituloDAO();
    }

    public void insert(Titulo t) {
        dao.insert(t);
    }

    public void delete(String titulo) {
        dao.delete(titulo);
    }

    public void updatePoder(Titulo t) {
        dao.updateDiretor(t);
    }

    public List<Titulo> findByDiretor(String diretor) {
        return dao.findByDiretor(diretor);
    }

    public List<Titulo> all() {
        return dao.all();
    }

    public List<Titulo> findByDataLancamento(String dataLancamento) {
        return dao.findByDataLancamento(dataLancamento);
    }

    public List<Titulo> findByDataLancamentoFromTo(String from, String to) {
        return dao.findByDataLancamentoFromTo(from, to);
    }

}
