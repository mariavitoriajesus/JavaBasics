package Exemplos;

import java.util.Scanner;

public class Exemplo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Gerar a tabuada de um número
        System.out.println("Digite o número que será gerado a tabuada: ");
        int numero = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

        // 2. Calcular o IMC
        System.out.println("Digite o seu peso(Kg): ");
        double peso = scanner.nextDouble();
        System.out.println("Digite a sua altura(cm): ");
        double altura = scanner.nextDouble();
        double imc = peso / (altura * altura);
        System.out.printf("Seu IMC é: %.2f\n", imc);
        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc <= 24.9) {
            System.out.println("Peso ideal");
        } else if (imc <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if (imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if (imc <= 39.9) {
            System.out.println("Obesidade Grau II (Severa)");
        } else {
            System.out.println("Obesidade III (Mórbida)");
        }

        // 3. Números pares ou ímpares em um intervalo
        System.out.println("Digite o primeiro número: ");
        int primeiro = scanner.nextInt();
        System.out.println("Digite um segundo número maior que o primero: ");
        int segundo = scanner.nextInt();
        System.out.println("Escola par ou impar: ");
        String escolha = scanner.next();
        for (int i = segundo; i < primeiro; i++) {
            if ("par".equalsIgnoreCase(escolha) && i % 2 != 0) {
                System.out.println(i);
            } else if ("impar".equalsIgnoreCase(escolha) && i % 2 !=0) {
                System.out.println(i);
            }
        }

        // 4. Repetição até um número ter resto diferente de 0
        System.out.println("Digite um número inicial: ");
        int numInicial = scanner.nextInt();
        int novoNumero = numInicial;
        while (novoNumero % numInicial == 0) {
            System.out.println("Digite um novo número: ");
            novoNumero = scanner.nextInt();
            if (novoNumero >= numInicial && novoNumero % numInicial ==0) {
                System.out.println("Número aceito: " + novoNumero);
            }
        }

        System.out.println("Encerrando a execução!!");

        scanner.close();
    }
}
