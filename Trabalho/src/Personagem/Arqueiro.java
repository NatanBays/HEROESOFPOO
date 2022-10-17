package Personagem;

import Arma.ArcoLongo;
import Arma.Arma;
import Arma.Balestra;

public class Arqueiro extends Personagem {

  private static int ataque = 100;
  private static int defesa = 30;
  private static float pdv = 160;
  private static Arma arma1 = new ArcoLongo();
  private static Arma arma2 = new Balestra();

  public Arqueiro() {
    super(ataque,defesa,pdv,arma1,arma2);
  }

  @Override
  public void escolherArma(int arma) {
    super.escolherArma(arma);
    if(arma == 1) {
      System.out.println("O ARQUEIRO FOI EQUIPADO COM O ARCO LONGO E SEU ATAQUE FOI AUMENTADO EM 12 E SUA DEFESA EM 13 ");
    }

    if(arma == 2) {
      System.out.println("O ARQUEIRO FOI EQUIPADO COM A BALESTRA E SEU ATAQUE FOI AUMENTADO EM 15 E SUA FEFESA EM 10 ");
    }
  }

}
