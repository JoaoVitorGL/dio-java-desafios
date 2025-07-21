package org.gouveia;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String clientName = readString(scanner, "Por favor, digite o nome do cliente:");
            String branchNumber = readString(scanner, "Por favor, digite o número da agência:");
            int accountNumber = readAccountNumber(scanner, "Por favor, digite o número da conta:");
            double balance = readBalance(scanner, "Por favor, digite o saldo:");

            System.out.println("Olá " + clientName + ", obrigado por criar uma conta em nosso banco, sua agência é "
                               + branchNumber + ", conta " + accountNumber + " e seu saldo de " + balance + " já está disponível para saque.");
        }
    }

    private static String readString(Scanner scanner, String msg) {
        System.out.println(msg);
        String input;
        do {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Entrada inválida. Por favor, digite um valor não vazio:");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int readAccountNumber(Scanner scanner, String msg) {
        System.out.println(msg);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double readBalance(Scanner scanner, String msg) {
        System.out.println(msg);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, digite um número:");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}