import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testFirstPlayerWin() {
        Player abas = new Player(1, "Абас", 120);
        Player rusik = new Player(2, "Русик", 100);
        Game game = new Game();

        game.register(abas);
        game.register(rusik);
        int actual = game.round("Абас", "Русик");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWin() {
        Player abas = new Player(1, "Абас", 100);
        Player rusik = new Player(2, "Русик", 120);
        Game game = new Game();

        game.register(abas);
        game.register(rusik);
        int actual = game.round("Абас", "Русик");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayersEqual() {
        Player abas = new Player(1, "Абас", 100);
        Player rusik = new Player(2, "Русик", 100);
        Game game = new Game();

        game.register(abas);
        game.register(rusik);
        int actual = game.round("Абас", "Русик");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player abas = new Player(1, "Абас", 100);
        Player rusik = new Player(2, "Русик", 100);
        Game game = new Game();

        game.register(abas);
        game.register(rusik);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ризван", "Русик")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player abas = new Player(1, "Абас", 100);
        Player rusik = new Player(2, "Русик", 100);
        Game game = new Game();

        game.register(abas);
        game.register(rusik);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Абас", "Ризван")
        );
    }
}