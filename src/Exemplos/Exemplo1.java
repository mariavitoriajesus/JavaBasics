package Exemplos;

import java.util.Scanner;

public class Exemplo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Receber o nome e o ano de nascimento e calcular a idade
        System.out.println("Digite o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu ano de nascimento: ");
        int anoNasc = scanner.nextInt();
        int idade = 2025 - anoNasc;
        System.out.println("Seu nome é " + nome + " é sua idade é " + anoNasc);

        // 2. Calcular a área de um quadrado
        System.out.println("Digite o valor do lado do quadrado: ");
        double lado = scanner.nextDouble();
        double areaQuad = lado * lado;
        System.out.println("O valor do quadrado é de: " + areaQuad);

        // 3. Calcular a área de um retângulo
        System.out.println("Digite o valor da base do retângulo: ");
        double base = scanner.nextDouble();
        System.out.println("Digite o valor da altura do retângulo: ");
        double altura = scanner.nextDouble();
        double areaRe = base * altura;
        System.out.println("A área do retângulo é de: " + areaRe);

        // 4. Diferença de idade entre duas pessoas
        scanner.nextLine();
        System.out.println("Digite o nome da pessoa1: ");
        String nome1 = scanner.nextLine();
        System.out.println("Digite a idade da pessaoa2: ");
        int idade1 = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Digite o nome da pessoa2: ");
        String nome2 = scanner.nextLine();
        System.out.println("Digite a idade da pessoa2: ");
        int idade2 = scanner.nextInt();
        int diferenca = Math.abs(idade1 - idade2);
        System.out.println("A diferença de idade da " + nome1 + " é da " + nome2 + " e de " + diferenca);

        scanner.close();
    }

}
