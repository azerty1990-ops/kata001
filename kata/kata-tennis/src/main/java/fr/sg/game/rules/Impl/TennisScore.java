package fr.sg.game.rules.Impl;


import fr.sg.game.core.Score;

public class TennisScore implements Score {

    private int score;

    public TennisScore(){
        this.score = 0;
    }

    public TennisScore(int score) {
        if( score != 0 && score != 15 && score != 30 && score != 40){
            throw new IllegalArgumentException(String.format("%d is not a tennis score", score));
        }
        this.score = score;
    }

    @Override
    public boolean increment() {
        if( score >= 40 ){
            return false;
        }
        if (score == 0 || score == 15) {
            score += 15;
        } else if (score == 30) {
            score = 40;
        }
        return true;
    }

    @Override
    public int currentScore() {
        return score;
    }

    public void reset(){
        score = 0;
    }
}
