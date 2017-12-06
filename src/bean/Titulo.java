package bean;

public class Titulo {
    private String titulo;
    private String dataLancamento;
    private String diretor;
    private int duracao;

    public Titulo() {
    }

    public Titulo(String titulo, String dataLancamento, String diretor, int duracao) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.diretor = diretor;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Titulo{" + "titulo=" + titulo + ", dataLancamento=" + dataLancamento + ", diretor=" + diretor + ", duracao=" + duracao + '}';
    }

    
}
