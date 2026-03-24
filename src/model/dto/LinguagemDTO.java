package model.dto;
public class LinguagemDTO {
    private int id_linguagem;
    private String nome;
    private String tipo;
    private int anoCriacao;
    private String criador;

    public int getId_linguagem() {
        return id_linguagem;
    }

    public void setId_linguagem(int id_linguagem) {
        this.id_linguagem = id_linguagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int ano_criacao) {
        this.anoCriacao = ano_criacao;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }
    
}
