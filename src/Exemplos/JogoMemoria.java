package Exemplos;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.*;

public class JogoMemoria {
    private static Scanner scanner = new Scanner(System.in);
    public static Map<String, List<String>> colecoes = new HashMap<>();
    private static List<String> jogoAtual = new ArrayList<>();
    private static  int lances = 0;
    private static int acertos = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Criar uma coleção de cartas");
            System.out.println("2 - Iniciar um jogo");
            System.out.println("3 - Continuar um jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarColecao();
                    break;
                case 2:
                    iniciarJogo();
                case 3:
                    continuarJogo();
                case 4:
                    salvarEstado();
                    System.out.println("Saindo do jogo...");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void criarColecao() {
        System.out.println("Nome da coleção: ");
        String nome = scanner.nextLine();
        System.out.println("Quantidade de cartas (mínimo 10): ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade < 10){
            System.out.println("A coleção deve ter no mínimo 10 cartas.");
            return;
        }

        List<String> cartas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o conteúdo da carta " + (i + 1) + " : ");
            cartas.add(scanner.nextLine());
        }
        colecoes.put(nome,cartas);
        salvarEstado();
    }

    private static void iniciarJogo() {
        if (colecoes.isEmpty()){
            System.out.println("Nenhuma coleção disponivel.");
            return;
        }

        System.out.println("Coleções diponiveis");
        for (String nome: colecoes.keySet()) {
            System.out.println(" - " +nome);
        }
        System.out.println("Escolha uma coleção");
        String nomeColecao = scanner.nextLine();

        if (!colecoes.containsKey(nomeColecao)){
            System.out.println("Coleção não encontrada.");
            return;
        }

        jogoAtual = new ArrayList<>(colecoes.get(nomeColecao));
        Collections.shuffle(jogoAtual);
        lances = 0;
        acertos = 0;
        menuJogo();
    }

    private static void continuarJogo(){
        if (jogoAtual.isEmpty()) {
            System.out.println("Nenhum jogo salvo para continuar.");
            return;
        }
        Collections.shuffle(jogoAtual);
        menuJogo();
    }

    private static void menuJogo(){
        while (!jogoAtual.isEmpty()){
            System.out.println("\nJogo em andamento...");
            System.out.println("1 - Virar 2 cartas");
            System.out.println("2 - Pausar jogo");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao)  {
                case 1:
                    virarCartas();
                    break;
                case 2:
                    salvarEstado();
                    return;
                default:
                    System.out.println("Opção Inválida!!");
            }
        }
        System.out.println("Parabens! voce concluiu o jogo em " + lances + " lances");
        double percentualAcertos = (acertos / (double) lances) * 100;
        System.out.printf("Percentual de acertos: %.2f%%\n", percentualAcertos);
    }

    private static void virarCartas(){
        System.out.println("Escolha a primeira posição: ");
        int p1 = scanner.nextInt();
        System.out.println("Escolha a segunda posição: ");
        int p2 = scanner.nextInt();

        if (p1 < 0 || p2 < 0 || p1 >= jogoAtual.size() || p2 >= jogoAtual.size() || p1 == p2) {
            System.out.println("Posições inválidas.");
            return;
        }

        lances++;
        if (jogoAtual.get(p1).equals(jogoAtual.get(2))) {
            System.out.println("Acertou!!!");
            jogoAtual.set(p1, "");
            jogoAtual.set(p2, "");
            acertos++;
        } else {
            System.out.println("Errrouuuu!!!");
        }
    }

    private static void salvarEstado(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("jogoMemoria.dat"))){
            out.writeObject(colecoes);
            out.writeObject(jogoAtual);
            out.writeInt(lances);
            out.writeInt(acertos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void carregarEstado() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("jogoMemoria.dat"))) {
            colecoes = (Map<String, List<String>>) in.readObject();
            jogoAtual = (List<String>) in.readObject();
            lances = in.readInt();
            acertos = in.readInt();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum estado salvo encontrado.");
        }
    }

}
