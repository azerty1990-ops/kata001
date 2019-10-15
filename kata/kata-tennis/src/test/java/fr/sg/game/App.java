package fr.sg.game;

import fr.sg.game.rules.Impl.TennisMatch;

public class App {

    public static void main(String[] args) {
        TennisMatch match = TennisMatch.tennisMatchPrompt();
        match.run();
    }
}
