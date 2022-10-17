package Main;

import Personagem.Arqueiro;
import Personagem.Dragao;
import Personagem.Guerreiro;
import Personagem.Mago;
import Personagem.Personagem;

import java.util.Objects;
import java.util.Scanner;

import Arma.ArcoLongo;
import Arma.Arma;
import Arma.Balestra;
import Arma.Cajado;
import Arma.Espada;
import Arma.Machado;
import Arma.Varinha;
import Jogador.Jogador;

public class Menu {


  public void atacar(Jogador jogador, Personagem dragao){
    float dano = jogador.getPersonagem().getAtaque() - dragao.getDefesa();
    dragao.setPontosDeVida((int) (dragao.getPontosDeVida() - dano));
  }

  public void recomecarRound(Jogador jogador){
    int defesa = (int) (jogador.getPersonagem().getDefesa() - jogador.getPersonagem().getDefesaInicial() * 0.1);
    jogador.getPersonagem().setDefesa(defesa);
  }

  public void defender(Jogador jogador){
    jogador.getPersonagem().setDefesa((float) (jogador.getPersonagem().getDefesa() + jogador.getPersonagem().getDefesa() * 0.1)); ;
  }

  public void ataqueDragao(Jogador jogador, Personagem dragao){
    float dano = dragao.getAtaque() - jogador.getPersonagem().getDefesa();
    jogador.getPersonagem().setPontosDeVida(jogador.getPersonagem().getPontosDeVida() - dano);
  }

  public void jogadorMorto(String iniciar, Jogador jogador1, Jogador jogador2, Jogador jogador3, Personagem dragao, int i){

      if (Objects.equals(iniciar, "atacar")) {

        if (i == 1) {
          System.out.println("JOGADOR 1 ASSUMIU POSIÇÃO DE ATAQUE!");
          assert jogador1 != null;
          atacar(jogador1, dragao);
          if (jogador2 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 2 && jogador2 != null) {
          System.out.println("JOGADOR 2 ASSUMIU POSIÇÃO DE ATAQUE!");
          atacar(jogador2, dragao);
          if (jogador3 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0 && jogador2.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 3 && jogador3 != null) {
          System.out.println("JOGADOR 3 ASSUMIU POSIÇÃO DE ATAQUE!");
          atacar(jogador3, dragao);
          i -= 2;
        }
      }

      if (Objects.equals(iniciar, "defender")) {

        if (i == 1) {
          System.out.println("JOGADOR 1 ASSUMIU A POSIÇÃO DE DEFESA!");
          defender(jogador1);
          if (jogador2 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 2 && jogador2.getPersonagem() != null) {
          System.out.println("JOGADOR 2 ASSUMIU A POSIÇÃO DE DEFESA!");
          defender(jogador2);
          if (jogador3 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0 && jogador2.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 3 && jogador3.getPersonagem() != null) {
          System.out.println("JOGADOR 3 ASSUMIU A POSIÇÃO DE DEFESA!");
          defender(jogador3);
          i -= 2;
        }
      }
    }


  public void escolherAtaque(String iniciar, Jogador jogador1, Jogador jogador2, Jogador jogador3, Personagem dragao, int i){

    if(i == 1) {
      if (jogador1.getPersonagem().getPontosDeVida() <= 0){
        System.out.println("O JOGADOR " + jogador1.getNome() + " ESTÁ MORTO!");
        return;
      }
      jogadorMorto(iniciar, jogador1, jogador2, jogador3, dragao, i);
    }

    if(i == 2) {
      if (jogador2.getPersonagem().getPontosDeVida() <= 0){
        System.out.println("O JOGADOR " + jogador2.getNome() + " ESTÁ MORTO!");
        return;
      }
      jogadorMorto(iniciar, jogador1, jogador2, jogador3, dragao, i);
    }

    if(i == 3) {
      if (jogador3.getPersonagem().getPontosDeVida() <= 0){
        System.out.println("O JOGADOR " + jogador3.getNome() + " ESTÁ MORTO!");
        return;
      }
      jogadorMorto(iniciar, jogador1, jogador2, jogador3, dragao, i);
    }

  }


  public void criarPersonagem(Jogador jogador1, String iniciar){
    Scanner scanner = new Scanner(System.in);

    Personagem mago = new Mago();
    Personagem arqueiro = new Arqueiro();
    Personagem guerreiro = new Guerreiro();

    String nome;
    String personagem;

    int arma;

    if (Objects.equals(iniciar, "criar")) {
      System.out.println("DIGITE O NOME DO SEU PERSONAGEM:");
      nome = scanner.next();
      System.out.println("SELECIONE A CLASSE DO SEU PERSONAGEM");
      System.out.println("DIGITE 1 PARA ESCOLHER O MAGO\n");
      System.out.println("DIGITE 2 PARA ESCOLHER O GUERREIRO\n");
      System.out.println("DIGITE 3 PARA ESCOLHER O ARQUEIRO\n");
      personagem = scanner.next();

      if (Objects.equals(personagem, "1")) {
        jogador1.setNome(nome);
        jogador1.setPersonagem(mago);
        System.out.println("ESCOLHA A ARMA QUE DESEJE PARA O MAGO:");
        System.out.println("VARINHA - ATQ:+16 / DEF:+9 (Digite 1)\n");
        System.out.println("CAJADO - ATQ:+13 / DEF:+12  (Digite 2)\n");
        arma = scanner.nextInt();

        if (Objects.equals(arma, 1)) {
          mago.escolherArma(arma);

        }

        if (Objects.equals(arma, 2)) {
          mago.escolherArma(arma);

        }
      }

      if (Objects.equals(personagem, "2")) {
        jogador1.setNome(nome);
        jogador1.setPersonagem(guerreiro);
        System.out.println("ESCOLHA A ARMA QUE DESEJE PARA O GURREIRO:");
        System.out.println("ESPADA - ATQ:+10 / DEF:+15 (Digite 1)\n");
        System.out.println("MACHADO - ATQ:+17 / DEF:+8  (Digite 2)\n");
        arma = scanner.nextInt();
        if (Objects.equals(arma, 1)) {
          guerreiro.escolherArma(arma);

        }

        if (Objects.equals(arma, 2)) {
          guerreiro.escolherArma(arma);

        }
      }

      if (Objects.equals(personagem, "3")) {
        jogador1.setNome(nome);
        jogador1.setPersonagem(arqueiro);
        System.out.println("ESCOLHA A ARMA QUE DESEJE PARA O ARQUEIRO:");
        System.out.println("ARCO LONGO - ATQ:+12 / DEF:+13 (Digite 1)\n");
        System.out.println("BALESTRA - ATQ:+15 / DEF:+10  (Digite 2)\n");
        arma = scanner.nextInt();
        if (Objects.equals(arma, 1)) {

          arqueiro.escolherArma(arma);

        }

        if (Objects.equals(arma, 2)) {

          arqueiro.escolherArma(arma);

        }


      }
      System.out.println("PERSONAGEM CRIADO COM SUCESSO");

    }
  }
}