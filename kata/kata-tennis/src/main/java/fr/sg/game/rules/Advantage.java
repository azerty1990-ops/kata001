package fr.sg.game.rules;

import fr.sg.game.core.TennisRuleResultType;
import fr.sg.game.rules.Impl.TennisPlayer;

public class Advantage extends AbstractTennisRule {
    public Advantage(TennisPlayer playerOne, TennisPlayer playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public boolean canBeApplied() {
        boolean canBeApplied = getPlayerOne().getScore() == AbstractTennisRule.MAX_SCORE || getPlayerTwo().getScore() == AbstractTennisRule.MAX_SCORE;
        this.ruleResult = getPlayerOne().getScore() == AbstractTennisRule.MAX_SCORE
                ? new TennisRuleResultImpl(TennisRuleResultType.ADVANTAGE, getPlayerOne())
                : new TennisRuleResultImpl(TennisRuleResultType.ADVANTAGE, getPlayerTwo());
        return canBeApplied;
    }
}
