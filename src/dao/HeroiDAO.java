package dao;

import java.sql.Connection;
import bean.Heroi;
import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroiDAO {

    private final Connection conn;

    public HeroiDAO() {
        this.conn = Conexao.getConnection();
    }

    public void insert(Heroi c) {
        String sql = "INSER INTO herois (nome, poder, data_nascimento, pais) VALUES (?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setString(2, c.getPoder());
            st.setString(3, c.getDataNascimento());
            st.setString(4, c.getPais());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
    }

    public void delete(String nome) {
        String sql = "DELETE FROM herois WHERE nome = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, nome);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na exclusão: " + ex.getMessage());
        }
    }

    public void updatePoder(Heroi c) {
        String sql = "UPDATE herois SET poder = ? WHERE nome = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, c.getPoder());
            st.setString(2, c.getNome());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na atualização: " + ex.getMessage());
        }
    }

    public List<Heroi> findByPoder(String poder) {
        List<Heroi> ls = new ArrayList<>();
        String sql = "SELECT * FROM herois WHERE marca like ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + poder + "%");
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Heroi> all() {
        List<Heroi> ls = new ArrayList<>();
        String sql = "SELECT * FROM herois";
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

    public List<Heroi> findByPais(String pais) {
        String sql = "SELECT * FROM herois WHERE pais = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, pais);
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return null;
    }

    public List<Heroi> findByDataNascimentoFromTo(String from, String to) {
        List<Heroi> ls = new ArrayList<>();
        String sql = "SELECT * FROM herois WHERE data_nascimento BETWEEN ? AND ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, from);
            st.setString(2, to);
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    protected List<Heroi> processResults(ResultSet rs) throws SQLException {
        List<Heroi> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(
                    new Heroi(
                            rs.getString("nome"),
                            rs.getString("poder"),
                            rs.getString("data_nascimento"),
                            rs.getString("pais")
                    )
            );
        }
        return ls;
    }
}
