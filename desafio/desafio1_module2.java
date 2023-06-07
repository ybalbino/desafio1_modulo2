package desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class desafio1_module2 {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao jogo de adivinhação!");
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        int pontuacao = 0;
        List<Integer> numerosCertos = new ArrayList<>();
        List<Integer> numerosErrados = new ArrayList<>();
        List<Integer> numerosSorteados = new ArrayList<>();
        int dificuldadeSelecionada = selecionarDificuldade();

        while (continuar){
            pontuacao += jogar(numerosCertos, numerosErrados, numerosSorteados,dificuldadeSelecionada);
            System.out.println("Quer continuar jogando? (Digite N para terminar o Jogo.)");

            String confirmacao = entrada.next();
            if (confirmacao.equals("n") || confirmacao.equals("N")) {
                continuar = false;
            }

        }
        System.out.println("Numeros que você acertou:");
        System.out.println(numerosCertos);
        System.out.println("Numeros que você errou:");
        System.out.println(numerosErrados);
        System.out.println("Numeros sorteados: ");
        System.out.println(numerosSorteados);
        System.out.println("Pontuação final: " + pontuacao);
    }
    public static int jogar(List<Integer> acertos, List<Integer> erros, List<Integer> sorteados, int dificuldade) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int pontuacao = 0;

        int numeroSorteado = 0;

        switch (dificuldade){
            case 1:
                numeroSorteado = random.nextInt(10) + 1;
                System.out.print("Digite um número de 1 a 10: ");
                break;
            case 2:
                numeroSorteado = random.nextInt(100) + 1;
                System.out.print("Digite um número de 1 a 100: ");
                break;
            case 3:
                numeroSorteado = random.nextInt(1000) + 1;
                System.out.print("Digite um número de 1 a 1000: ");
                break;
            default:
                System.out.println("Dificuldade selecionada não encontrada.");
        }

        sorteados.add(numeroSorteado);


        int numeroEscolhido = scanner.nextInt();

        if (numeroEscolhido == numeroSorteado) {
            pontuacao += 10;
            acertos.add(numeroEscolhido);
            System.out.println("Parabéns! Você acertou e ganhou 10 pontos.");
        } else if (numeroEscolhido == numeroSorteado - 1 || numeroEscolhido == numeroSorteado + 1) {
            pontuacao += 5;
            acertos.add(numeroEscolhido);
            System.out.println("Quase lá! Você ganhou 5 pontos.");
        } else {
            erros.add(numeroEscolhido);
            System.out.println("Que pena! Você errou e não ganhou pontos.");
        }

        System.out.println("Sua pontuação: " + pontuacao);
        return pontuacao;
    }

    public static int selecionarDificuldade(){

        int dificuldade;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escolha a dificuldade:");
        System.out.println("1 - Facil. (1 a 10)");
        System.out.println("2 - Médio. (1 a 100)");
        System.out.println("3 - Dificil. (1 a 1000)");

        dificuldade = entrada.nextInt();

        return dificuldade;
    }
}