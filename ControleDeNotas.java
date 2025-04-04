import java.util.Scanner;

public class ControleDeNotas {
    public static void main(String[] args) {
        // Variáveis
        String aluno;
        int opc;
        int aprovados = 0;
        int recuperacao = 0;
        int reprovados = 0;
        double maiorNota = 0;
        double menorNota = 11;
        double nota;
        double mediaTurma = 0;

        // Scanner
        Scanner entrada = new Scanner(System.in);

        // Entrada da quantidade de alunos
        int quantidadedAlunos;
        do {
            System.out.println("Quantos Alunos Deseja Cadastrar? ");
            quantidadedAlunos = entrada.nextInt();
            entrada.nextLine();

            if (quantidadedAlunos <= 0) {
                System.out.println("Erro! Mínimo 1 Aluno!");
            }
        } while (quantidadedAlunos <= 0);

        // Entrada da quantidade de notas
        int notasPorAluno;
        do {
            System.out.println("Quantas Notas Por Aluno? ");
            notasPorAluno = entrada.nextInt();
            entrada.nextLine();

            if (notasPorAluno <= 0) {
                System.out.println("Erro! Mínimo 1 Nota!");
            }
        } while (notasPorAluno <= 0);

        // Listas
        String[] alunos = new String[quantidadedAlunos];
        double[][] notas = new double[quantidadedAlunos][notasPorAluno];

        // Cadastrar Turma
        for (int i = 0; i < quantidadedAlunos; i++) {
            // Coletando Nomes
            System.out.println("Nome do " + (i + 1) + "º Aluno:");
            aluno = entrada.nextLine();
            alunos[i] = aluno;

            // Coletando Notas
            for (int j = 0; j < notasPorAluno; j++) {
                while (true) {
                    System.out.println("Digite a " + (j + 1) + "º Nota de " + aluno + ":");
                    nota = entrada.nextDouble();

                    if (nota < 0 || nota > 10) {
                        System.out.println("-----------------------------------");
                        System.out.println("Erro! Digite uma nota entre 0 e 10.");
                        System.out.println("-----------------------------------");
                    } else {
                        notas[i][j] = nota;

                        if (nota > maiorNota) {
                            maiorNota = nota;
                        }
                        if (nota < menorNota) {
                            menorNota = nota;
                        }
                        break;
                    }
                }
            }
            entrada.nextLine();
        }

        // Loop Do Menu
        while (true) {
            System.out.println(" ");
            System.out.println("Escolha uma opção a seguir:");
            System.out.println("[1] Média da Turma.");
            System.out.println("[2] Notas da Turma.");
            System.out.println("[3] Sair.");
            opc = entrada.nextInt();
            entrada.nextLine();
            System.out.println(" ");

            // Acesso Menu
            switch (opc) {

                // Exibir Media Da Turma
                case 1:
                    System.out.println("-----Média-----");
                    for (int z = 0; z < quantidadedAlunos; z++) {
                        double soma = 0;
                        for (int j = 0; j < notasPorAluno; j++) {
                            soma += notas[z][j];
                            mediaTurma += notas[z][j];
                        }
                        double media = soma / notasPorAluno;
                        System.out.print(alunos[z] + " - Média: " + media);

                        if (media >= 7){
                            aprovados += 1;
                            System.out.println(" - Aprovado");
                        } else if (media >= 5) {
                            recuperacao += 1;
                            System.out.println(" - Recuperação");
                        }else {
                            reprovados += 1;
                            System.out.println(" - Reprovado");
                        }
                    }
                    System.out.println(" ");
                    System.out.println("Media Da Turma: " + (mediaTurma / (quantidadedAlunos * notasPorAluno)));
                    System.out.println("Maior Nota Registrada: " + maiorNota);
                    System.out.println("Menor Nota Registrada: " + menorNota);
                    System.out.println("Aprovados: " + aprovados);
                    System.out.println("Recuperação: " + recuperacao);
                    System.out.println("Reprovados: " + reprovados);
                    break;

                // Exibir Notas Individuamente
                case 2:
                    System.out.println("-----Dados da Turma-----");
                    for (int x = 0; x < quantidadedAlunos; x++) {
                        System.out.println("Aluno: " + alunos[x]);
                        System.out.print("Notas: ");
                        for (int y = 0; y < notasPorAluno; y++) {
                            System.out.print(notas[x][y]);
                            if (y < notasPorAluno - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("\n--------------------");
                    }
                    break;

                // Encerrando Programa
                case 3:
                    System.out.println("Saindo...");
                    entrada.close();
                    System.exit(0);

                // sem Uso
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
