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

    private final Connection conn;

    public CarroDAO() {
        this.conn = Conexao.getConnection();
    }

    public boolean insert(Carro c) {
        String sql = "INSER INTO carros (id, marca, placa, ano) VALUES (?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getMarca());
            st.setString(3, c.getPlaca());
            st.setInt(4, c.getAno());
            return st.execute();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }
        return false;
    }

    public List<Carro> findByAno(int ano) {
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE ano = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, ano);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carro act = new Carro();
                act.setId(rs.getInt("id"));

                act.setAno(rs.getInt("ano"));
                act.setMarca(rs.getString("marca"));
                act.setPlaca(rs.getString("placa"));
                ls.add(act);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }
    
    public List<Carro> findByMarca(String marca) {
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE marca LIKE ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, marca);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carro act = new Carro();
                act.setId(rs.getInt("id"));
                act.setAno(rs.getInt("ano"));
                act.setMarca(rs.getString("marca"));
                act.setPlaca(rs.getString("placa"));
                ls.add(act);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public List<Carro> all() {
        List<Carro> ls = new ArrayList<>();
        String sql = "SELECT * FROM carros";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carro act = new Carro();
                act.setId(rs.getInt("id"));
                act.setAno(rs.getInt("ano"));

                act.setMarca(rs.getString("marca"));
                act.setPlaca(rs.getString("placa"));
                ls.add(act);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return ls;
    }

    public Carro findById(int id) {
        Carro carro = new Carro();
        String sql = "SELECT * FROM carros WHERE id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.first()) {
                carro.setId(rs.getInt("id"));
                carro.setAno(rs.getInt("ano"));
                carro.setMarca(rs.getString("marca"));
                carro.setPlaca(rs.getString("placa"));
                return carro;
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
        return null;
    }
}
