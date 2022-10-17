package Personagem;

import Arma.Arma;
import Arma.Espada;
import Arma.Machado;

public class Guerreiro extends Personagem {

  private static int ataque = 30;
  private static float defesa = 20;
  private static float pdv = 180;
  private static Arma arma1 = new Espada();
  private static Arma arma2 = new Machado();

  public Guerreiro() {
    super(ataque,defesa,pdv,arma1,arma2);
  }

  @Override
  public void escolherArma(int arma) {
    super.escolherArma(arma);
    if(arma == 1) {
      System.out.println("O GUERREIRO FOI EQUIPADO COM A ESPADA E SEU ATAQUE FOI AUMENTADO EM 10 E SUA FEFESA EM 15 ");
    }

    if(arma == 2) {
      System.out.println("O GUERREIRO FOI EQUIPADO COM O MACHADO E SEU ATAQUE FOI AUMENTADO EM 17 E SUA FEFESA EM 8 ");
    }
  }

}
