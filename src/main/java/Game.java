public class Game {

    private int score;

    public void roll(int knockedPins){
        this.score += knockedPins;
    }

    public int score(){
        return this.score;
    }
}
