import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game = new Game();

    @Test
    public void Roll_Should_ReturnNumberOfKnockedPins(){
        game.roll(5);
        assertEquals(5, game.score());
    }

    @Test
    public void Roll_3Times_ShouldReturnNumberOfKnockedPins(){
        game.roll(2);
        game.roll(3);
        game.roll(4);
        assertEquals(9, game.score());
    }
}
