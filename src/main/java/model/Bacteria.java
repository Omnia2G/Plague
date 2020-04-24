package model;

import engine.RandomEvent;

public class Bacteria extends Plague implements RandomEvent {

    public Bacteria(double beta, double gama) {
        super(beta, gama);
    }

    public void increaseDeathRate() {
        setGama(getGama() * 1.005);
    }

    @Override
    public void generateRandomEvent() {
        increaseDeathRate();
    }
}
