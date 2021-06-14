import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game = new Game();

    @Test
    public void Roll_Should_ReturnNumberOfKnockedPins(){
        game.roll(5);
        assertEquals(5, game.score());
    }
}
