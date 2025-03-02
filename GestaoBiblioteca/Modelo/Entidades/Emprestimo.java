package GestaoBiblioteca.Modelo.Entidades;

import GestaoBiblioteca.Modelo.Excecao.Excecao;

import java.util.Date;
import java.util.List;

public class Emprestimo {
    private Membro membro;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Membro membro, Livro livro, Date dataEmprestimo, Date dataDevolucao) throws Excecao {
        if (dataDevolucao.before(dataEmprestimo)) {
            throw new Excecao("Data de Devolução deve ser posterior a de Empréstimo");
        }
        this.membro = membro;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) throws Excecao {
        if (dataDevolucao.before(dataEmprestimo)) {
            throw new Excecao("Data de Devolução deve ser Posterior a de Empréstimo!");
        } else {
            this.dataDevolucao = dataDevolucao;
        }
    }

    public void emprestarLivro(Membro membro, Integer quantidade, List<Livro> livroList) throws Excecao {
        if (membro.getQuantiLivrosEmprestados() > 3) {
            throw new Excecao("Quantidade Máxima de Empréstimos realizados!");
        } else {
            membro.setQuantiLivrosEmprestados(quantidade);
        }
    }

    @Override
    public String toString() {
        return "Membro: " + membro.getNome() + "Livro: " + livro.getNome() +
                ", Data de Empréstimo: " + dataEmprestimo +", Data de Devolução=" + dataDevolucao;
    }
}
