package GestaoBiblioteca.Aplicacao;

import GestaoBiblioteca.Modelo.Entidades.Emprestimo;
import GestaoBiblioteca.Modelo.Entidades.Livro;
import GestaoBiblioteca.Modelo.Entidades.Membro;
import GestaoBiblioteca.Modelo.Excecao.Excecao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Programa {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        List<Livro> livroList = new ArrayList<>();
        List<Membro> membroList = new ArrayList<>();
        List<Emprestimo> emprestimoList = new ArrayList<>();

        int opcao;

        try {
            do {
                System.out.print(
                        """
                                ========== Biblioteca =========
                                1 - Cadastrar Livro
                                2 - Cadastrar Membro
                                3 - Realizar Empréstimo
                                4 - Listar Livros 
                                5 - Listar Membros
                                6 - Listar Empréstimos
                                0 - Sair
                                ===============================
                                Digite uma Opção: 
                                """

                );
                opcao = sc.nextInt();
                switch (opcao){
                    case 1:
                        sc.nextLine();
                        System.out.println("Dados do Livro: ");
                        System.out.print("Nome: ");
                        String nomeLivro = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Ano de Publicação: (AAAA): ");
                        Integer anoPublicacao = sc.nextInt();
                        System.out.println("Quantidade de Copias Disponíveis: ");
                        int copiasDisponiveis = sc.nextInt();
                        livroList.add(new Livro(nomeLivro, autor, anoPublicacao, copiasDisponiveis));
                        System.out.println("Livro Cadastrado Com Sucesso!");
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.print("Nome do Usuário: ");
                        String nomeUsuario = sc.nextLine();
                        System.out.print("Id: ");
                        int id = sc.nextInt();
                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        System.out.print("Quantidade de Livros Emprestados: ");
                        int quantiLivrosEmprestados = sc.nextInt();
                        membroList.add(new Membro(nomeUsuario, id, idade, quantiLivrosEmprestados));
                        break;

                    case 3:
                        sc.nextLine();
                        System.out.print("Data de Empréstimo: ");
                        Date dataEmprestimo = sdf.parse(sc.next());
                        System.out.print("Data de Devolução: ");
                        Date dataDevolucao = sdf.parse(sc.next());
                        sc.nextLine();
                        System.out.println("Nome do membro: ");
                        String nome = sc.nextLine();
                        System.out.print("Livro a ser Emprestado: ");
                        String livro = sc.nextLine();

                        emprestimoList.add(new Emprestimo(membroList.stream().filter(x -> x.getNome() == nome).findFirst().orElse(null), livroList.stream().filter(x-> x.getNome() == livro).findFirst().orElse(null), dataEmprestimo, dataDevolucao));
                        break;

                    case 4:
                        for (Livro livros : livroList){
                            System.out.println(livros);
                        }
                        break;

                    case 5:
                        for (Membro membro : membroList){
                            System.out.println(membro);
                        }
                    break;

                    case 6:
                        for (Emprestimo emprestimo : emprestimoList){
                            System.out.println(emprestimo);
                        }
                        break;

                    case 0:
                        System.out.println("Obrigado por usar nossos Serviços!");
                    break;

                    default:
                        System.out.println("Opção inválida!");
                    break;
                }
            }
            while (opcao != 0);
        }
        catch (Excecao e) {
            System.out.println("Erro: " + e.getMessage());
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
        catch (InputMismatchException e){
            System.out.println("Dados de Entrada Inválidos!");
        }

        sc.close();
    }
}
