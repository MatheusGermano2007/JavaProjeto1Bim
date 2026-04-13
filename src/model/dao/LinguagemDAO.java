package model.dao;
import model.Conexao;
import model.dto.LinguagemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

    // Essa classe eh o nosso DAO. O papel dela eh concentrar toda a conversa com o banco de dados
public class LinguagemDAO {
    
    public void cadastrarLinguagem(LinguagemDTO linguagem) {
        
        String sql = "INSERT INTO linguagens (nome, tipo, ano_Criacao, criador) VALUES (?, ?, ?, ?)";
        
        try (Connection c = new Conexao().conectaBD(); PreparedStatement ps = c.prepareStatement(sql);){
           
            // Aqui a gente troca cada interrogacao do SQL pelo dado correspondente que veio no objeto
            ps.setString(1, linguagem.getNome());
            ps.setString(2, linguagem.getTipo());
            ps.setInt(3, linguagem.getAno_Criacao());
            ps.setString(4, linguagem.getCriador());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
    public void selecionarLinguagem() {
        
        String sql = "select * from linguagens";
        // Mesma pegada de conexao automatica, mas agora adicionando o ResultSet, que eh o cara que guarda os dados que o banco devolveu do select
        try (Connection c = new Conexao().conectaBD(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();){
            
            // O while fica rodando em loop enquanto tiver uma proxima linha no resultado do banco
            while(rs.next())
            {
                // Pega o dado de cada coluna pelo nome e ja imprime formatado na tela
                System.out.println("-" + rs.getInt("id_linguagem") + " | " + rs.getString("nome") + " | Tipo: " + rs.getString("tipo") + " | Ano: " + rs.getInt("ano_Criacao") + " | Criador: " + rs.getString("criador"));  
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    
    public void atualizarLinguagem(LinguagemDTO linguagem) {
        
        String sql = "UPDATE linguagens SET "
                    + "nome = ?,"
                    + " tipo = ?, "
                    + "ano_Criacao = ?,"
                    + " criador = ? "
                    + "WHERE id_linguagem = ?";
        
        try (Connection c = new Conexao().conectaBD(); PreparedStatement ps = c.prepareStatement(sql);){
            
            // Substitui as interrogacoes pelos dados novos, sendo a ultima interrogacao (posicao 5) o ID de quem vai sofrer a alteracao
            ps.setString(1, linguagem.getNome());
            ps.setString(2, linguagem.getTipo());
            ps.setInt(3, linguagem.getAno_Criacao());
            ps.setString(4, linguagem.getCriador());
            ps.setInt(5, linguagem.getId_linguagem());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }
   
    public void excluirLinguagem(int id) {
        
        String sql = "DELETE FROM linguagens WHERE id_linguagem = ?";
        
        try (Connection c = new Conexao().conectaBD(); PreparedStatement ps = c.prepareStatement(sql);){
            
            // Joga o ID recebido no lugar da interrogacao e passa a faca no banco
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}
