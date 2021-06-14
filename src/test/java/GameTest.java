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

    @Test
    public void Roll_Spare_ShouldReturnNumberOfPointsForSpare(){

        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(4);
        game.roll(10);

        assertEquals(34, game.score());
    }

    @Test
    public void Roll_Strike_ShouldReturnNumberOfPointsForStrike(){

        game.roll(10);
        game.roll(3);
        game.roll(2);

        assertEquals(20, game.score());
    }
}
