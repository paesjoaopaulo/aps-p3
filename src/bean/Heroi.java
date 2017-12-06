package bean;

public class Heroi {
    private String nome;
    private String poder;
    private String dataNascimento;
    private String pais;

    public Heroi(String nome, String poder, String dataNascimento, String pais) {
        this.nome = nome;
        this.poder = poder;
        this.dataNascimento = dataNascimento;
        this.pais = pais;
    }

    public Heroi() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Heroi{" + "nome=" + nome + ", poder=" + poder + ", dataNascimento=" + dataNascimento + ", pais=" + pais + '}';
    }
    
    
}
