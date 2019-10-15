package fr.sg.game.core;

public interface Rule {

    boolean canBeApplied();

    TennisRuleResult getResult();
}
