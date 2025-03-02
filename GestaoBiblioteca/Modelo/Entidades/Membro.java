package GestaoBiblioteca.Modelo.Entidades;

import GestaoBiblioteca.Modelo.Excecao.Excecao;

public class Membro {
    private String nome;
    private Integer id;
    private Integer idade;
    private Integer quantiLivrosEmprestados;

    public Membro() {
    }

    public Membro(String nome, Integer id, Integer idade, Integer quantiLivrosEmprestados) throws Excecao {
        if (quantiLivrosEmprestados > 3) {
            throw new Excecao("Quantidade Máxima por vez: 3");
        }
        this.nome = nome;
        this.id = id;
        this.idade = idade;
        this.quantiLivrosEmprestados = quantiLivrosEmprestados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) throws Excecao {
        if (idade > 0) {
            this.idade = idade;
        } else {
            throw new Excecao("Idade não pode ser Negativa!!");
        }
    }

    public Integer getQuantiLivrosEmprestados() {
        return quantiLivrosEmprestados;
    }

    public void setQuantiLivrosEmprestados(Integer quantiLivrosEmprestados) throws Excecao {
        if (quantiLivrosEmprestados > 3 || quantiLivrosEmprestados <= 0) {
            throw new Excecao("Erro no Empréstimo!");

        } else {
            this.quantiLivrosEmprestados = quantiLivrosEmprestados;
        }
    }

    @Override
    public String toString() {
        return "Membro: " + nome + ", id: " + id + ", idade: " + idade + ", quantiLivrosEmprestados: " + quantiLivrosEmprestados;
    }
}
