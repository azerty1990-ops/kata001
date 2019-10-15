package fr.sg.game;

import org.junit.Test;

import fr.sg.game.rules.Impl.TennisMatch;
import fr.sg.game.rules.Impl.TennisPlayer;
import fr.sg.game.rules.Impl.TennisSet;

import static junit.framework.TestCase.assertFalse;


public class TennisMatchTest {

    @Test(expected = NullPointerException.class)
    public void illegalFirstPlayer() {
        new TennisMatch(null, new TennisPlayer("test"), new TennisSet[2]);
    }


    @Test(expected = NullPointerException.class)
    public void illegalSecondPlayer() {
        new TennisMatch(new TennisPlayer("test"), null, new TennisSet[2]);
    }

    @Test(expected = NullPointerException.class)
    public void illegalSetInit() {
        new TennisMatch(new TennisPlayer("test"), new TennisPlayer("test"), null);
    }

    @Test
    public void isLastSet() throws Exception {
        TennisMatch match = new TennisMatch(new TennisPlayer("test"), new TennisPlayer("test"), new TennisSet[2]);
        assertFalse(match.isLastSet());
    }

}