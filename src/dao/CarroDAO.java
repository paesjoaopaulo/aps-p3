package dao;

import java.sql.Connection;
import bean.Carro;
import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    private Connection conn;

    public CarroDAO() {
    }

    public void insert(Carro c) {
        String sql = "INSER INTO carros (codigo, marca, ano, modelo, fabricante, nome, chassi) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, c.getCodigo());
            st.setString(2, c.getMarca());
            st.setInt(3, c.getAno());
            st.setInt(4, c.getModelo());
            st.setString(5, c.getFabricante());
            st.setString(6, c.getNome());
            st.setString(7, c.getChassi());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM carros WHERE id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na exclusão: " + ex.getMessage());
        }
    }

    public void updateMarca(Carro c) {
        String sql = "UPDATE carros SET marca = ? WHERE id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, c.getMarca());
            st.setInt(2, c.getCodigo());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na atualização: " + ex.getMessage());
        }
    }

    public List<Carro> findByMarca(String marca) {
        this.conn = Conexao.getConnection();
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE marca like ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + marca + "%");
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Carro> all() {
        this.conn = Conexao.getConnection();
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Carro> findByAno(int ano) {
        String sql = "SELECT * FROM carros WHERE ano = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, ano);
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return null;
    }

    public List<Carro> findByModeloFromTo(int from, int to) {
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE modelo BETWEEN ? AND ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, from);
            st.setInt(2, to);
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    protected List<Carro> processResults(ResultSet rs) throws SQLException {
        List<Carro> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(
                    new Carro(
                            rs.getInt("codigo"),
                            rs.getString("marca"),
                            rs.getInt("ano"),
                            rs.getInt("modelo"),
                            rs.getString("fabricante"),
                            rs.getString("nome"),
                            rs.getString("chassi")
                    )
            );
        }
        return ls;
    }
}
