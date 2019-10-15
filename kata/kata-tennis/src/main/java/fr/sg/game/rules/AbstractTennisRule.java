package fr.sg.game.rules;

import fr.sg.game.core.Rule;
import fr.sg.game.core.TennisRuleResult;
import fr.sg.game.rules.Impl.TennisPlayer;

public abstract class AbstractTennisRule implements Rule {
    static final int MAX_SCORE = 40;
    private final TennisPlayer playerOne;
    private final TennisPlayer playerTwo;
    protected TennisRuleResult ruleResult;

    AbstractTennisRule(TennisPlayer playerOne, TennisPlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public TennisRuleResult getResult() {
        return ruleResult;
    }

    protected TennisPlayer getPlayerOne() {
        return this.playerOne;
    }

    protected TennisPlayer getPlayerTwo() {
        return playerTwo;
    }

}
