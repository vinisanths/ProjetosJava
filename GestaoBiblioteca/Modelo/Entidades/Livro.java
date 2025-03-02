package GestaoBiblioteca.Modelo.Entidades;

import GestaoBiblioteca.Modelo.Excecao.Excecao;

public class Livro {
    private String nome;
    private String autor;
    private Integer anoPublicacao;
    private Integer copiasDisponiveis;

    public Livro() {
    }

    public Livro(String nome, String autor, Integer anoPublicacao, int copiasDisponiveis) throws Excecao {
        if (anoPublicacao <= 0){
            throw new Excecao("Ano de Publicação Inválido!!!");
        }if (copiasDisponiveis < 0){
            throw new Excecao("Quantidade de Copias deve ser Positiva!");
        }
        this.nome = nome;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.copiasDisponiveis = copiasDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        if (anoPublicacao > 0) {
            this.anoPublicacao = anoPublicacao;
        } else {
            System.out.println("Ano de Publicação Invalido");
        }
    }

    public int getCopiasDisponiveis() {
        return copiasDisponiveis;
    }

    public void setCopiasDisponiveis(int copiasDisponiveis) {
        if (copiasDisponiveis > 0) {
            this.copiasDisponiveis = copiasDisponiveis;
        }else {
            System.out.println("Quantidade de Cópias Invalida");
        }
    }

    @Override
    public String toString() {
        return "Livro: " + ", Nome: " + nome + ", Autor: " + autor +", Ano de Publicação: " + anoPublicacao +", Copias Disponíveis: " + copiasDisponiveis;
    }
}
