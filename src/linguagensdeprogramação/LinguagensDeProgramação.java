package linguagensdeprogramação;

import model.Conexao;
import java.util.List;
import model.Conexao;
import model.dao.LinguagemDAO;
import java.util.Scanner;
import model.Conexao;
import model.dto.LinguagemDTO;
import model.dao.LinguagemDAO;

public class LinguagensDeProgramação {

    public static void main(String[] args) {
        
        Conexao con = new Conexao();
        con.conectaBD();
        
        Scanner Ler = new Scanner(System.in);
        LinguagemDAO dao = new LinguagemDAO(); 
        
        int opcao;
        
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar nova linguagem");
            System.out.println("2 - Selecionar e Listar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = Ler.nextInt();
            Ler.nextLine(); 

            if (opcao == 1) {
                String continuar = "S";
                
                while (continuar.equalsIgnoreCase("S")) {
                    LinguagemDTO novaLinguagem = new LinguagemDTO();

                    System.out.println("\nCadastro de nova linguagem");
                    
                    System.out.print("Nome: ");
                    novaLinguagem.setNome(Ler.nextLine());
                    
                    System.out.print("Tipo: ");
                    novaLinguagem.setTipo(Ler.nextLine());
                    
                    System.out.print("Ano de criacao: ");
                    novaLinguagem.setAno_Criacao(Ler.nextInt());
                    Ler.nextLine(); 
                    
                    System.out.print("Criador: ");
                    novaLinguagem.setCriador(Ler.nextLine());
                    
                    dao.cadastrarUsuario(novaLinguagem); 
                    System.out.println("Salvo com sucesso");
                    
                    System.out.print("\nDeseja cadastrar mais uma? S/N: ");
                    continuar = Ler.nextLine();
                }
                
            } else if (opcao == 2) {
                System.out.println("\nListando dados do banco:");
                dao.selecionarLinguagem();
                
            } else if (opcao == 3) {
                LinguagemDTO linguagemAtualizada = new LinguagemDTO();
                
                System.out.print("\nDigite o ID da linguagem que vai alterar: ");
                linguagemAtualizada.setId_linguagem(Ler.nextInt());
                Ler.nextLine(); 
                
                System.out.print("Novo Nome: ");
                linguagemAtualizada.setNome(Ler.nextLine());
                
                System.out.print("Novo Tipo: ");
                linguagemAtualizada.setTipo(Ler.nextLine());
                
                System.out.print("Novo Ano de criacao: ");
                linguagemAtualizada.setAno_Criacao(Ler.nextInt());
                Ler.nextLine(); 
                
                System.out.print("Novo Criador: ");
                linguagemAtualizada.setCriador(Ler.nextLine());
                
                dao.atualizarLinguagem(linguagemAtualizada);
                System.out.println("Atualizado");
                
            } else if (opcao == 4) {
                System.out.print("\nDigite o ID da linguagem que deseja excluir: ");
                int idParaExcluir = Ler.nextInt();
                Ler.nextLine(); 
                
                dao.excluirLinguagem(idParaExcluir);
                System.out.println("Excluido com sucesso");
                
            } else if (opcao != 0) {
                System.out.println("\nOpcao invalida, tente novamente.");
            }
        } while (opcao != 0);

        System.out.println("Tchau.");
        Ler.close();
    }
}

        
  


