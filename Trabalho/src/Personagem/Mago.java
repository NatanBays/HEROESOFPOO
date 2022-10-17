package Personagem;

import Arma.Arma;
import Arma.Cajado;
import Arma.Varinha;

public class Mago extends Personagem {

  private static int ataque = 20;
  private static float defesa = 10;
  private static float pdv = 200;
  private static Arma arma1 = new Varinha();
  private static Arma arma2 = new Cajado();

  public Mago() {
    super(ataque,defesa,pdv,arma1,arma2);
  }

  @Override
  public void escolherArma(int arma) {
    super.escolherArma(arma);
    if(arma == 1) {
      System.out.println("O MAGO FOI EQUIPADO COM A VARINHA E SEU ATAQUE FOI AUMENTADO EM 16 E SUA FEFESA EM 9 ");
    }

    if(arma == 2) {
      System.out.println("O MAGO FOI EQUIPADO COM O CAJADO E SEU ATAQUE FOI AUMENTADO EM 13 E SUA FEFESA EM 12 ");
    }
  }
}
