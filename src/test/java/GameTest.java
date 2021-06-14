import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;

    @BeforeEach
    public void beforeEachTestMethod(){
        this.game = new Game();
    }

    @Test
    public void roll_Should_ReturnNumberOfKnockedPins(){

        game.roll(5);

        assertEquals(5, game.getKnockedPins());
    }

    @Test
    public void roll_3Times_ShouldReturnNumberOfKnockedPins(){

        game.roll(2);
        game.roll(3);
        game.roll(4);

        finishGame(17, 0);

        assertEquals(9, game.getKnockedPins());
    }

    @Test
    public void roll_Spare_ShouldReturnNumberOfPointsForSpare(){

        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(4);
        game.roll(10);

        finishGame(15, 0);

        assertEquals(34, game.score());
    }

    @Test
    public void roll_Strike_ShouldReturnNumberOfPointsForStrike(){

        game.roll(10);
        game.roll(3);
        game.roll(2);

        finishGame(17, 0);

        assertEquals(20, game.score());
    }

    private void finishGame(int rolls, int value){
        for(int i = 0; i < rolls; i++){
            game.roll(value);
        }
    }
}
