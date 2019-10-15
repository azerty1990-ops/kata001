package fr.sg.game.rules;

import fr.sg.game.core.TennisRuleResultType;
import fr.sg.game.rules.Impl.TennisPlayer;

public class Deuce extends AbstractTennisRule {
    public Deuce(TennisPlayer playerOne, TennisPlayer playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public boolean canBeApplied() {
        if (getPlayerOne().hasAdvantage() || getPlayerTwo().hasAdvantage()) {
            return false;
        }
        this.ruleResult = new TennisRuleResultImpl(TennisRuleResultType.DEUCE, null);
        return (getPlayerOne().getScore() == MAX_SCORE && getPlayerTwo().getScore() == MAX_SCORE);
    }
}
