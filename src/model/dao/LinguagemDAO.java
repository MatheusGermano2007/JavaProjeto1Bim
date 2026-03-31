package model.dao;
import model.Conexao;
import model.dto.LinguagemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class LinguagemDAO {
    Connection c;
    PreparedStatement ps;
    ResultSet rs;
    
        public void cadastrarUsuario(LinguagemDTO linguagem) {
        String sql = "INSERT INTO linguagens (nome, tipo, ano_Criacao, criador) VALUES (?, ?, ?, ?)";
        ps = null;
        c = new Conexao().conectaBD();
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, linguagem.getNome());
            ps.setString(2, linguagem.getTipo());
            ps.setInt(3, linguagem.getAno_Criacao());
            ps.setString(4, linguagem.getCriador());
            
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void selecionarLinguagem() {
        rs = null;
        ps = null;
        c = new Conexao().conectaBD();
        try {
            ps = c.prepareStatement("select * from linguagens");
            rs = ps.executeQuery();

            while(rs.next())
            {
                System.out.println("#" + rs.getInt("id_linguagem") + " " + rs.getString("nome") +rs.getString("tipo") + " | Ano: " + rs.getInt("ano_Criacao") + " | Criador: " + rs.getString("criador"));
 
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void atualizarLinguagem(LinguagemDTO linguagem) {
        String sql = "UPDATE linguagens SET nome = ?, tipo = ?, ano_Criacao = ?, criador = ? WHERE id_linguagem = ?";
        ps = null;
        c = new Conexao().conectaBD();
        
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, linguagem.getNome());
            ps.setString(2, linguagem.getTipo());
            ps.setInt(3, linguagem.getAno_Criacao());
            ps.setString(4, linguagem.getCriador());
            ps.setInt(5, linguagem.getId_linguagem());
            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void excluirLinguagem(int id) {
        String sql = "DELETE FROM linguagens WHERE id_linguagem = ?";
        ps = null;
        c = new Conexao().conectaBD();
        
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                Logger.getLogger(LinguagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
