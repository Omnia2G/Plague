package model;

public class Plague {
    private String name;
    private double beta;
    private double gama;

    public Plague(double beta, double gama) {
        this.beta = beta;
        this.gama = gama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getGama() {
        return gama;
    }

    public void setGama(double gama) {
        this.gama = gama;
    }
}
