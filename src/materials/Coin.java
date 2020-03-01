package materials;

import java.util.Random;

public class Coin {

  private CoinState coinState;

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    Random randomNum = new Random();
    int result = randomNum.nextInt(2);
    if(result==0) {this.coinState = CoinState.HEADS;}
    else{this.coinState=CoinState.TAILS;}
  }

  public CoinState getState() {
    return coinState;
  }


}
