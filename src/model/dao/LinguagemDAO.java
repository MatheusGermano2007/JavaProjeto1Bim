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
        String sql = "INSERT INTO linguagem (nome, tipo, anoCriacao, criador) VALUES (?, ?, ?, ?)";
        ps = null;
        c = new Conexao().conectaBD();
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, linguagem.getNome());
            ps.setString(2, linguagem.getTipo());
            ps.setInt(3, linguagem.getAnoCriacao());
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
        ps = c.prepareStatement("select * from linguagem");
        rs = ps.executeQuery();

        while(rs.next())
        {
            System.out.println("#" + rs.getInt("id") + " " + rs.getString("nome"));
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
}
