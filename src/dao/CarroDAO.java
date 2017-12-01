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
        this.conn = Conexao.getConnection();
        String sql = "INSERT INTO carros (codigo, marca, ano, modelo, fabricante, nome, chassi) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
    }

    public void delete(int id) {
        this.conn = Conexao.getConnection();
        String sql = "DELETE FROM carros WHERE id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
    }

    public void updateModelo(int id, Carro c) {
        this.conn = Conexao.getConnection();
        String sql = "UPDATE carros SET modelo = ? WHERE id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, c.getModelo());
            st.setInt(2, id);
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
    }

    public List<Carro> findByAno(int ano) {
        this.conn = Conexao.getConnection();
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE ano = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, ano);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carro act = new Carro();
                act.setCodigo(rs.getInt("codigo"));
                act.setMarca(rs.getString("marca"));
                act.setAno(rs.getInt("ano"));
                act.setModelo(rs.getInt("modelo"));
                act.setFabricante(rs.getString("fabricante"));
                act.setNome(rs.getString("nome"));
                act.setChassi(rs.getString("chassi"));
                ls.add(act);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Carro> findByMarca(String marca) {
        this.conn = Conexao.getConnection();
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE marca LIKE ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + marca + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carro act = new Carro();
                act.setCodigo(rs.getInt("codigo"));
                act.setMarca(rs.getString("marca"));
                act.setAno(rs.getInt("ano"));
                act.setModelo(rs.getInt("modelo"));
                act.setFabricante(rs.getString("fabricante"));
                act.setNome(rs.getString("nome"));
                act.setChassi(rs.getString("chassi"));
                ls.add(act);
            }
            st.close();
            conn.close();
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
            while (rs.next()) {
                Carro act = new Carro();
                act.setCodigo(rs.getInt("codigo"));
                act.setMarca(rs.getString("marca"));
                act.setAno(rs.getInt("ano"));
                act.setModelo(rs.getInt("modelo"));
                act.setFabricante(rs.getString("fabricante"));
                act.setNome(rs.getString("nome"));
                act.setChassi(rs.getString("chassi"));
                ls.add(act);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Carro> findByAnoDeAte(int anoDe, int anoAte) {
        this.conn = Conexao.getConnection();
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE ano BETWEEN ? AND ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, anoDe);
            st.setInt(2, anoAte);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carro act = new Carro();
                act.setCodigo(rs.getInt("codigo"));
                act.setMarca(rs.getString("marca"));
                act.setAno(rs.getInt("ano"));
                act.setModelo(rs.getInt("modelo"));
                act.setFabricante(rs.getString("fabricante"));
                act.setNome(rs.getString("nome"));
                act.setChassi(rs.getString("chassi"));
                ls.add(act);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }
}
