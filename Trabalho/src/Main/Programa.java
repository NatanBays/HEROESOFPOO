package Main;

import Personagem.Dragao;
import Personagem.Personagem;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import Jogador.Jogador;

public class Programa {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String iniciar;

    Personagem dragao = new Dragao();

    Jogador jogador1 = new Jogador(null, null);
    Jogador jogador2 = new Jogador(null, null);
    Jogador jogador3 = new Jogador(null, null);

    Random random = new Random();

    Menu menu = new Menu();

    String nome;

    System.out.println("SEJA BEM VINDO(A) AO HEROES OF POO.");
    System.out.println("DESEJA INICIAR UMA PARTIDA ?");
    System.out.println("DIGITE (SIM) PARA INCIAR E (NÃO) PARA FECHAR O JOGO.");
    iniciar = scanner.next();

    if (Objects.equals(iniciar, "sim")) {
      System.out.println("O JOGO IRA INICIAR.");
    }

    if (Objects.equals(iniciar, "não")) {
      System.out.println("SAINDO DO JOGO.");
      System.exit(0);
    }

    System.out.println("PARA CRIAR UM PERSONAGEM DIGITE (CRIAR):");
    System.out.println("PARA INICIAR A PARTIDA DIGITE (INICIAR):");
    System.out.println("PARA SAIR DO JOGO DIGITE (SAIR):");
    iniciar = scanner.next();
    menu.criarPersonagem(jogador1, iniciar);

    if(jogador1.getPersonagem() == null && Objects.equals(iniciar,"iniciar")){
      System.out.println("ATENÇÃO!!!! VOCÊ DEVE TER NO MINIMO UM(1) PERSONAGEM CRIADO PARA INICIAR O JOGO!");
      System.out.println("PARA CRIAR UM PERSONAGEM DIGITE (CRIAR):");
      System.out.println("PARA SAIR DO JOGO DIGITE (SAIR):");
      iniciar = scanner.next();
      menu.criarPersonagem(jogador1, iniciar);
    }

    if (jogador2.getPersonagem() == null) {
      System.out.println("DESEJA CRIAR OUTRO PERSONAGEM?");
      System.out.println("PARA CRIAR UM PERSONAGEM DIGITE (CRIAR):");
      System.out.println("PARA INICIAR A PARTIDA DIGITE (INICIAR):");
      System.out.println("PARA SAIR DO JOGO DIGITE (SAIR):");
      iniciar = scanner.next();
      menu.criarPersonagem(jogador2, iniciar);
    }

    if (jogador2.getPersonagem() != null) {
      System.out.println("DESEJA CRIAR OUTRO PERSONAGEM?");
      System.out.println("PARA CRIAR UM PERSONAGEM DIGITE (CRIAR):");
      System.out.println("PARA INICIAR A PARTIDA DIGITE (INICIAR):");
      System.out.println("PARA SAIR DO JOGO DIGITE (SAIR):");
      iniciar = scanner.next();
      menu.criarPersonagem(jogador3, iniciar);
    }

    if(jogador3.getPersonagem() != null){
      System.out.println("DESEJA INICIAR OU SAIR DO JOGO?");
      System.out.println("PARA INICIAR A PARTIDA DIGITE (INICIAR):");
      System.out.println("PARA SAIR DO JOGO DIGITE (SAIR):");
      iniciar = scanner.next();
    }

    if (Objects.equals(iniciar, "iniciar")) {
      for (var i = 1; 0 <= dragao.getPontosDeVida(); i++) {

        int ataqueDragaoAleatorio = random.nextInt(3);

        System.out.println("COMEÇANDO A RODADA");

        for (var j = 1; j <= 3; j++) {

          System.out.println("PARA SAIR DO JOGO DIGITE (SAIR):");
          System.out.println("PARA ATACAR DIGITE(ATACAR):");
          System.out.println("PARA DEFENDER DIGITE(DEFENDER):");
          iniciar = scanner.next();

          if (Objects.equals(iniciar, "sair")) {
            System.out.println("SAINDO DO JOGO.");
            System.exit(0);
          }

          menu.escolherAtaque(iniciar, jogador1, jogador2, jogador3, dragao, j);

          if (jogador2.getPersonagem() == null) {
            break;
          }

          if (j == 2 && jogador3.getPersonagem() == null) {
            break;
          }

        }

        if (ataqueDragaoAleatorio == 0) {
          menu.ataqueDragao(jogador1, dragao);
          System.out.println("O DRAGÃO ATACOU " + jogador1.getNome() + " DANDO " + (dragao.getAtaque() - jogador1.getPersonagem().getDefesa()) + " DE DANO!!");
          if (Objects.equals(iniciar, "defender")) {
            menu.recomecarRound(jogador1);
          }
        }

        if (ataqueDragaoAleatorio == 1) {
          if (jogador2.getPersonagem() != null && jogador2.getPersonagem().getPontosDeVida() > 0) {
            menu.ataqueDragao(jogador2, dragao);
            System.out.println("O DRAGÃO ATACOU " + jogador2.getNome() + " DANDO " + (dragao.getAtaque() - jogador2.getPersonagem().getDefesa()) + " DE DANO!!");
            if (Objects.equals(iniciar, "defender")) {
              menu.recomecarRound(jogador2);
            }
          } else {
            if (jogador1.getPersonagem().getPontosDeVida() > 0) {
              menu.atacar(jogador1, dragao);
              System.out.println("O DRAGÃO ATACOU " + jogador1.getNome() + " DANDO " + (dragao.getAtaque() - jogador1.getPersonagem().getDefesa()) + " DE DANO!!");
              if (Objects.equals(iniciar, "defender")) {
                menu.recomecarRound(jogador1);
              }
            }
          }
        }

        if (ataqueDragaoAleatorio == 2) {
          if (jogador3.getPersonagem() != null && jogador3.getPersonagem().getPontosDeVida() > 0) {
            menu.ataqueDragao(jogador3, dragao);
            System.out.println("O DRAGÃO ATACOU " + jogador3.getNome() + " DANDO " + (dragao.getAtaque() - jogador3.getPersonagem().getDefesa()) + " DE DANO!!");
            if (Objects.equals(iniciar, "defender")) {
              menu.recomecarRound(jogador3);
            }
          } else {
            if (jogador2.getPersonagem() != null && jogador2.getPersonagem().getPontosDeVida() > 0) {
              menu.atacar(jogador2, dragao);
              System.out.println("O DRAGÃO ATACOU " + jogador2.getNome() + " DANDO " + (dragao.getAtaque() - jogador2.getPersonagem().getDefesa()) + " DE DANO!!");
              if (Objects.equals(iniciar, "defender")) {
                menu.recomecarRound(jogador2);
              }
            } else {
              if(jogador3.getPersonagem().getPontosDeVida() > 0) {
                menu.ataqueDragao(jogador1, dragao);
                System.out.println("O DRAGÃO ATACOU " + jogador1.getNome() + " DANDO " + (dragao.getAtaque() - jogador1.getPersonagem().getDefesa()) + " DE DANO!!");
                if (Objects.equals(iniciar, "defender")) {
                  menu.recomecarRound(jogador1);
                }
              }
            }
          }
        }

        float vidaTotal = 0;
        
        if(jogador1.getPersonagem().getPontosDeVida() < 0){
          vidaTotal += 0;
        }else {
          vidaTotal += jogador1.getPersonagem().getPontosDeVida();
        }

        System.out.println("APÓS ESSA RODADA O DRAGÃO FICOU COM " + dragao.getPontosDeVida() + " PONTOS DE VIDA");
        System.out.println(jogador1.getNome() + " FICOU COM " + jogador1.getPersonagem().getPontosDeVida() + " PONTOS DE VIDA");

        if (jogador2.getPersonagem() != null) {
          if(jogador2.getPersonagem().getPontosDeVida() < 0){
            vidaTotal += 0;
          }else {
            vidaTotal += jogador2.getPersonagem().getPontosDeVida();
          }
          System.out.println(jogador2.getNome() + " FICOU COM " + jogador2.getPersonagem().getPontosDeVida() + " PONTOS DE VIDA");
        }

        if (jogador3.getPersonagem() != null) {
          if(jogador3.getPersonagem().getPontosDeVida() < 0){
            vidaTotal += 0;
          }else {
            vidaTotal += jogador3.getPersonagem().getPontosDeVida();
          }
          System.out.println(jogador3.getNome() + " FICOU COM " + jogador3.getPersonagem().getPontosDeVida() + " PONTOS DE VIDA");
        }

        if (vidaTotal <= 0) {
          break;
        }
      }
      if (dragao.getPontosDeVida() <= 0) {

        System.out.println("PARABENS VOCÊ DERROTOU O DRAGÃO!");

      } else {

        System.out.println("DESCULPE VOCÊ FOI DERROTADO PELO DRAGÃO! TENTE NOVAMENTE!");
      }
    }

    if (Objects.equals(iniciar, "sair")) {
      System.out.println("SAINDO DO JOGO.");
      System.exit(0);
    }
  }
}
