package Personagem;

import Personagem.Personagem;

public class Dragao extends Personagem {

  private static int ataque = 100;
  private static int defesa = 30;
  private static float pdv = 300;



  public Dragao() {
    super(ataque,defesa,pdv,null,null);
  }

}
