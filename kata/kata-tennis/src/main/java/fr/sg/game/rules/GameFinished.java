package fr.sg.game.rules;

import fr.sg.game.core.TennisRuleResultType;
import fr.sg.game.rules.Impl.TennisPlayer;

public class GameFinished extends AbstractTennisRule {


    public GameFinished(TennisPlayer playerOne, TennisPlayer playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    public boolean canBeApplied() {
        boolean canBeApplied = getPlayerOne().getScore() > AbstractTennisRule.MAX_SCORE || getPlayerTwo().getScore() > MAX_SCORE;
        this.ruleResult = getPlayerOne().getScore() > getPlayerTwo().getScore()
                ? new TennisRuleResultImpl(TennisRuleResultType.FINISHED, getPlayerOne())
                : new TennisRuleResultImpl(TennisRuleResultType.FINISHED, getPlayerTwo());
        return canBeApplied;
    }
}
