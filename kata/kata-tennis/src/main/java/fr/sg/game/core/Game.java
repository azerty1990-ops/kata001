package fr.sg.game.core;

import java.util.Optional;

import fr.sg.game.rules.Impl.WinningPlayer;

public interface Game<E extends Player> {

    boolean incrementFirstPlayer();

    boolean incrementSecondPlayer();

    boolean isFinished();

    E getFirstPlayer();

    E getSecondPlayer();

    int firstPlayerScore();

    int secondPlayerScore();

    WinningPlayer getWinningPlayer();

    default Optional<Player> getWinner(){
        if (getWinningPlayer().equals(WinningPlayer.NONE)) {
            return Optional.empty();
        }
        return getWinningPlayer().equals(WinningPlayer.PLAYER_ONE) ?
                Optional.of(getFirstPlayer()) :
                Optional.of(getSecondPlayer());
    }
}
