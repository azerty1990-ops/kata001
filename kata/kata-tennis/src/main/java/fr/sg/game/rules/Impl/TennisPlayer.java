package fr.sg.game.rules.Impl;

import java.util.Objects;

import fr.sg.game.core.Player;
import fr.sg.game.core.Score;


public class TennisPlayer implements Player {

    private final String name;
    private final Score score;
    private boolean hasAdvantage;

    public TennisPlayer(String name) {
        this.name = Objects.requireNonNull(name, "TennisPlayer name should not be null");
        this.score = new TennisScore();
    }

    @Override
    public boolean incrementScore() {
        return score.increment();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score.currentScore();
    }

    public boolean hasAdvantage() {
        return hasAdvantage;
    }

    void setAdvantage(boolean advantage) {
        hasAdvantage = advantage;
    }

    void resetScore() {
        score.reset();
    }
}
