package org.gouveia.bancodigital;

import java.util.Scanner;

public class MenuBanco {
    private Banco banco;
    private Scanner scanner;

    public MenuBanco() {
        this.banco = new Banco("New Bank");
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        int opcao;
        do {
            System.out.println("=== BEM-VINDO AO " + banco.getNome().toUpperCase() + " ===");
            System.out.println("O que você deseja?");
            System.out.println("(1) Acessar sua conta");
            System.out.println("(2) Criar uma conta");
            System.out.println("(3) Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    acessarConta();
                    break;
                case 2:
                    criarConta();
                    break;
                case 3:
                    System.out.println("Obrigado por usar nossos serviços. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private void criarConta() {
        System.out.println("Digite o nome do titular da conta:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        System.out.println("Qual tipo de conta deseja criar?");
        System.out.println("(1) Conta Corrente");
        System.out.println("(2) Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine();

        Conta novaConta;
        if (tipoConta == 1) {
            novaConta = new ContaCorrente(cliente);
        } else if (tipoConta == 2) {
            novaConta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        banco.adicionarConta(novaConta);
        System.out.println("Conta criada com sucesso!");
        System.out.printf("Agência: %d | Conta: %d%n", novaConta.getAgencia(), novaConta.getNumero());
    }

    private void acessarConta() {
        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        banco.buscarContaPorNumero(numeroConta).ifPresentOrElse(
                conta -> {
                    MenuConta menuConta = new MenuConta(conta, this.banco);
                    menuConta.exibir();
                },
                () -> System.out.println("Conta não encontrada.")
        );

    }
}
