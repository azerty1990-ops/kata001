package fr.sg.game.core;

public interface Score {
	
    boolean increment();

    int currentScore();

    public void reset();
}
