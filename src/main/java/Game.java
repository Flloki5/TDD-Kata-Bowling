import java.util.ArrayList;

public class Game {

    private ArrayList<Integer> rolls;
    private int roll;
    private int score;

    public Game() {
        this.rolls = new ArrayList();
        this.roll = 0;
        this.score = 0;
    }

    public void roll(int knockedPins){
        rolls.add(knockedPins);
        roll++;
    }

    private void calculateScore(){
        for (int index = 0; index < roll; index += 2) {
            if (index + 2 < roll ) {
                int frameKnockedPins = rolls.get(index) + rolls.get(index + 1);
                if (index % 2 == 0 && frameKnockedPins == 10) {
                    this.score += getScoreForSpare(index);
                } else {
                    this.score += frameKnockedPins;
                }
            }else if(index + 1 < roll){
                this.score += rolls.get(index) + rolls.get(index + 1);
            }else{
                this.score += rolls.get(index);
            }
        }
    }

    private int getScoreForSpare(int frameStartIndex){
        return rolls.get(frameStartIndex) + rolls.get(frameStartIndex + 1) + rolls.get(frameStartIndex + 2);
    }

    public int score(){
        calculateScore();
        return this.score;
    }
}
