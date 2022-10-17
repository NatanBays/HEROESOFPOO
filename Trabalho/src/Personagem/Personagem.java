package Personagem;
import Arma.Arma;

public class Personagem {

  private int ataque;
  private float defesa;
  private float pdv;
  private float defesaInicial;
  Arma arma1;
  Arma arma2;

  public Personagem(int ataque, float defesa, float pdv, Arma arma1, Arma arma2){
    this.arma1 = arma1;
    this.arma2 = arma2;
    this.ataque = ataque;
    this.defesa = defesa;
    this.pdv = pdv;

  }

  public void setPontosDeVida(float pdv) {
    this.pdv = pdv;
  }

  public int getAtaque() {
    return ataque;
  }

  public void setDefesaInicial(float defesaInicial) {
    this.defesaInicial = defesaInicial;
  }

  public float getDefesaInicial() {
    return defesaInicial;
  }

  public float getDefesa() {
    return defesa;
  }

  public void escolherArma(int arma){
    if(arma == 1){
      setAtaque(getAtaque() + arma1.getAtaque());
      setDefesa(getDefesa() + arma1.getDefesa());
      setDefesaInicial(getDefesa());
    }
    if(arma == 2){
      setAtaque(getAtaque() + arma2.getAtaque());
      setDefesa(getDefesa() + arma2.getDefesa());
      setDefesaInicial(getDefesa());
    }
    if(arma != 1 && arma != 2){
      System.out.println("ATENÇÃO: VOCÊ DIGITOU O NÚMERO ERRADO! ESCOLHA O NÚMERO 1, 2");
    }
  }

  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  public void setDefesa(float defesa) {
    this.defesa = defesa;
  }

  public float getPontosDeVida() {
    return pdv;
  }

  @Override
  public String toString() {
    return "Personagem{" +
        "ataque=" + ataque +
        ", defesa=" + defesa +
        ", pdv=" + pdv +
        ", arma1=" + arma1 +
        ", arma2=" + arma2 +
        '}';
  }
}
