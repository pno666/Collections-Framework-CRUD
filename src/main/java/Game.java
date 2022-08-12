import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();

    public Game(ArrayList<Player> players) {
        this.players = players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }
    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (player2 == null) {
            throw  new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегестрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;
    }
}
