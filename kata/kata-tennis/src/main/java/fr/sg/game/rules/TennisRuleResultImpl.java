package fr.sg.game.rules;

import fr.sg.game.core.TennisRuleResult;
import fr.sg.game.core.TennisRuleResultType;
import fr.sg.game.rules.Impl.TennisPlayer;

public class TennisRuleResultImpl implements TennisRuleResult {

    private TennisRuleResultType type;
    private TennisPlayer scorer;

    public TennisRuleResultImpl(TennisRuleResultType type, TennisPlayer scorer) {
        this.type = type;
        this.scorer = scorer;
    }

    @Override
    public TennisRuleResultType getType() {
        return this.type;
    }

    @Override
    public TennisPlayer getScorer() {
        return this.scorer;
    }
}
