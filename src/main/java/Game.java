import java.util.ArrayList;

public class Game {

    private ArrayList<Integer> rolls;
    private int knockedPins;
    private int score;

    public int getKnockedPins() {
        return knockedPins;
    }

    public Game() {
        this.rolls = new ArrayList();
        this.knockedPins = 0;
        this.score = 0;
    }

    public void roll(int knockedPins){
        rolls.add(knockedPins);
        this.knockedPins += knockedPins;
    }

    private void calculateScore(){

        int roll = 0;

        for(int frame = 0; frame < 10; frame++){
            if(isStrike(roll)){
                this.score += rolls.get(roll) + rolls.get(roll + 1) + rolls.get(roll + 2);
                roll++;
            }else if(isSpare(roll)){
                this.score += 10 + rolls.get(roll + 2);
                roll += 2;
            }else {
                this.score += rolls.get(roll) + rolls.get(roll + 1);
                roll += 2;
            }
        }
    }

    private boolean isSpare(int roll){
        return rolls.get(roll) + rolls.get(roll + 1) == 10;
    }

    private boolean isStrike(int roll){
        return rolls.get(roll) == 10;
    }

    public int score(){
        calculateScore();
        return this.score;
    }
}
