package fr.sg.game.core;

import fr.sg.game.rules.Impl.TennisPlayer;

public interface TennisRuleResult {

    TennisRuleResultType getType();

    TennisPlayer getScorer();

}
