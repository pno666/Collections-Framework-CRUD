import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Player player1 = new Player(1, "Petya", 10);
    Player player2 = new Player(2, "Vasya", 15);
    Player player3 = new Player(3, "Kolya", 10);
    Player player4 = new Player(4, "Anya", 19);
    Player player5 = new Player(5, "Gaji", 3);
    ArrayList<Player> players = new ArrayList<>();
    Game game = new Game(players);

    @BeforeEach
    public void setPl() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void ShouldFindByIdIfPlayerIsRegistered() {
       Player expected = player3;
       Player actual = game.findById(3);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void ShouldFindByIdIfPlayerIsNotRegistered() {
        Player expected = null;
        Player actual = game.findById(77);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldExceptionForFirstPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Philip", "Vasya");
        });
    }

    @Test
    public void shouldExceptionForSecondPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Philip");
        });
    }

    @Test
    public void shouldWinFirstPlayer() {
        int expected = 1;
        int actual = game.round("Anya", "Gaji");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        int expected = 2;
        int actual = game.round("Petya", "Vasya");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldDraw() {
        int expected = 0;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

}
