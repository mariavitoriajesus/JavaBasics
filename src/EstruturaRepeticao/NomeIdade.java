package EstruturaRepeticao;

import java.util.Scanner;

/*
Faça um programa qua leia conjuntos de dois valores, o primeiro representando o nome do aluno(String) e
o segundo reprensentando a sua idade(int).
(Para o programa inserindo o valor 0 no campo nome)
 */
public class NomeIdade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nome;
        int idade;

        while (true){
            System.out.println("Nome: ");
            nome = scan.next();
            if (nome.equals("0")) break;;
            System.out.println("Idade: ");
            idade = scan.nextInt();
        }
        System.out.println("Continua aqui...");

    }

}
