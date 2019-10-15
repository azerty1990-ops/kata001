package fr.sg.game.rules.Impl;

import fr.sg.game.core.Game;
import fr.sg.game.core.Rule;
import fr.sg.game.rules.Advantage;
import fr.sg.game.rules.Deuce;
import fr.sg.game.rules.GameFinished;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TennisGame implements Game<TennisPlayer> {

    private static final int MAX_SCORE = 40;
    private final TennisPlayer firstPlayer;
    private final TennisPlayer secondPlayer;
    private WinningPlayer winningPlayer;
    private List<Rule> rules = new ArrayList<>();

    private TennisGame(TennisPlayer firstPlayer, TennisPlayer secondPlayer) {
        this.firstPlayer = Objects.requireNonNull(firstPlayer);
        this.secondPlayer = Objects.requireNonNull(secondPlayer);
        this.winningPlayer = WinningPlayer.NONE;
        this.rules.add(new Advantage(firstPlayer, secondPlayer));
        this.rules.add(new Deuce(firstPlayer, secondPlayer));
        this.rules.add(new GameFinished(firstPlayer, secondPlayer));
    }

    public static TennisGame between(String firstPlayer, String secondPlayer) {
        TennisPlayer one = new TennisPlayer(firstPlayer);
        TennisPlayer two = new TennisPlayer(secondPlayer);
        return new TennisGame(one, two);
    }

    public static TennisGame between(TennisPlayer firstPlayer, TennisPlayer secondPlayer) {
        return new TennisGame(firstPlayer, secondPlayer);
    }

    @Override
    public boolean incrementFirstPlayer() {
        return this.incrementPlayerScore(firstPlayer, secondPlayer);
    }

    @Override
    public boolean incrementSecondPlayer() {
        return this.incrementPlayerScore(secondPlayer, firstPlayer);
    }

    private boolean incrementPlayerScore(TennisPlayer toIncrement, TennisPlayer opponent) {
        if (isFinished()) {
            return false;
        }
        if (opponent.hasAdvantage()) {
            opponent.setAdvantage(false);
            return true;
        }
        if (isDeuce()) {
            toIncrement.setAdvantage(true);
            opponent.setAdvantage(false);
            return true;
        }
        if (toIncrement.getScore() == MAX_SCORE || toIncrement.hasAdvantage()) {
            winningPlayer = WinningPlayer.PLAYER_TWO;
            return false;
        }
        return toIncrement.incrementScore();
    }


    @Override
    public boolean isFinished() {
        return !winningPlayer.equals(WinningPlayer.NONE);
    }

    public boolean isDeuce() {
        if (firstPlayer.hasAdvantage() || secondPlayer.hasAdvantage()) {
            return false;
        }
        return (firstPlayer.getScore() == MAX_SCORE && secondPlayer.getScore() == MAX_SCORE);
    }

    @Override
    public TennisPlayer getFirstPlayer() {
        return firstPlayer;
    }

    @Override
    public TennisPlayer getSecondPlayer() {
        return secondPlayer;
    }

    @Override
    public int firstPlayerScore() {
        return firstPlayer.getScore();
    }

    @Override
    public int secondPlayerScore() {
        return secondPlayer.getScore();
    }

    @Override
    public WinningPlayer getWinningPlayer() {
        return winningPlayer;
    }

    void reset() {
        firstPlayer.resetScore();
        secondPlayer.resetScore();
        winningPlayer = WinningPlayer.NONE;
    }
}
