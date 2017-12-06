package dao;

import java.sql.Connection;
import bean.Titulo;
import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TituloDAO {

    private final Connection conn;

    public TituloDAO() {
        this.conn = Conexao.getConnection();
    }

    public void insert(Titulo c) {
        String sql = "INSER INTO titulos (titulo, data_lancamento, diretor, duracao) VALUES (?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, c.getTitulo());
            st.setString(2, c.getDataLancamento());
            st.setString(3, c.getDiretor());
            st.setInt(4, c.getDuracao());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
    }

    public void delete(String titulo) {
        String sql = "DELETE FROM titulos WHERE titulo = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, titulo);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na exclusão: " + ex.getMessage());
        }
    }

    public void updateDiretor(Titulo t) {
        String sql = "UPDATE titulos SET diretor = ? WHERE nome = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, t.getDiretor());
            st.setString(2, t.getTitulo());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na atualização: " + ex.getMessage());
        }
    }

    public List<Titulo> findByDiretor(String diretor) {
        List<Titulo> ls = new ArrayList<>();
        String sql = "SELECT * FROM titulos WHERE diretor like ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + diretor + "%");
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Titulo> all() {
        List<Titulo> ls = new ArrayList<>();
        String sql = "SELECT * FROM titulos";
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

    public List<Titulo> findByDataLancamento(String dataLancamento) {
        String sql = "SELECT * FROM titulos WHERE dataLancamento = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, dataLancamento);
            ResultSet rs = st.executeQuery();
            return processResults(rs);
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return null;
    }

    public List<Titulo> findByDataLancamentoFromTo(String from, String to) {
        List<Titulo> ls = new ArrayList<>();
        String sql = "SELECT * FROM titulos WHERE data_lancamento BETWEEN ? AND ?";
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

    protected List<Titulo> processResults(ResultSet rs) throws SQLException {
        List<Titulo> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(
                    new Titulo(
                            rs.getString("titulo"),
                            rs.getString("data_lancamento"),
                            rs.getString("diretor"),
                            rs.getInt("duracao")
                    )
            );
        }
        return ls;
    }
}
