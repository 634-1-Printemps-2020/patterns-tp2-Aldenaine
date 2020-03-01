package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    int i = 0;
    for(CoinState coin : states){
      if(coin.equals(CoinState.HEADS)){i++;}
      if(i==3){return true;}
    }
    return false;
  }
}
