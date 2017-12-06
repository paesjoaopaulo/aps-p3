package bean;

public class Carro {

    private int codigo;
    private String marca;
    private int ano;
    private int modelo;
    private String fabricante;
    private String nome;
    private String chassi;

    public Carro(int codigo, String marca, int ano, int modelo, String fabricante, String nome, String chassi) {
        this.codigo = codigo;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.nome = nome;
        this.chassi = chassi;
    }

    public Carro() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Override
    public String toString() {
        return "Carro{" + "codigo=" + codigo + ", marca=" + marca + ", ano=" + ano + ", modelo=" + modelo + ", fabricante=" + fabricante + ", nome=" + nome + ", chassi=" + chassi + '}';
    }
    
    
}
