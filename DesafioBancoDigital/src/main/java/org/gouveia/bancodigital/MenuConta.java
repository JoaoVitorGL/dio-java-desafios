package org.gouveia.bancodigital;

import java.util.Optional;
import java.util.Scanner;

public class MenuConta {

    private Conta conta;
    private Banco banco;
    private Scanner scanner;

    public MenuConta(Conta conta, Banco banco) {
        this.conta = conta;
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("--- Olá, " + conta.cliente.getNome() + "! ---");
            System.out.printf("Agência: %d | Conta: %d%n", + conta.getAgencia(), conta.getNumero());
            System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());
            System.out.println("O que você deseja?");
            System.out.println("(1) Depositar");
            System.out.println("(2) Sacar");
            System.out.println("(3) Transferir");
            System.out.println("(4) Imprimir extrato");
            System.out.println("(5) Voltar ao Menu Principal");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    depositar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    transferir();
                    break;
                case 4:
                    imprimirExtrato();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private void depositar() {
        System.out.println("Digite um valor para depósito:");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);
    }

    private void sacar() {
        System.out.println("Digite um valor para saque:");
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);
    }

    private void transferir() {
        System.out.println("Digite o número da conta de destino:");
        int numeroDestino = scanner.nextInt();

        if (numeroDestino == conta.getNumero()) {
            System.out.println("Não é possível transferir para a mesma conta.");
            return;
        }

        Optional<Conta> contaDestino = banco.buscarContaPorNumero(numeroDestino);

        if (contaDestino.isPresent()) {
            System.out.println("Digite o valor para transferência:");
            double valorTransferencia = scanner.nextDouble();
            conta.transferir(valorTransferencia, contaDestino.get());
        } else {
            System.out.println("Conta de destino não encontrada.");
        }
    }

    private void imprimirExtrato() {
        conta.imprimirExtrato();
    }
}
