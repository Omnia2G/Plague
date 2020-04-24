package model;

import engine.RandomEvent;

public class Virus extends Plague implements RandomEvent {
    public Virus(double beta, double gama) {
        super(beta, gama);
    }

    public void increaseInfectionRate() {
        setBeta(getBeta() * 1.005);
    }

    @Override
    public void generateRandomEvent() {
        increaseInfectionRate();
    }
}
