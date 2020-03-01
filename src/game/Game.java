package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;
    private int total, fewer, most;
    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
        List<CoinState> lst = new ArrayList<>();
         history.put(player, lst);

    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        List<CoinState> lst;
        total = 0;
        fewer = -1;
        most = -1;
        coin = Coin.getCoin();
        rules = Rules.getRules();
        for(Player p : history.keySet()){
            lst=history.get(p);
            while(!rules.checkWin(lst)){
                p.play(coin);
                lst.add(coin.getState());
                total++;
            }
            if(lst.size()<fewer){fewer=lst.size();}
            if(lst.size()>most){most=lst.size();}
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {

      return new Statistics(total/history.size(), fewer, most, total);
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      return this.history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      return history.get(player);
    }

}
