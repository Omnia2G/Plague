package engine.impl;

import model.Patient;
import model.Plague;
import model.Status;
import engine.SIRService;

import java.util.ArrayList;
import java.util.List;

public class SIRServiceImpl implements SIRService {
    private double Beta;
    private double Gamma;
    private int susceptible;
    private int infected;
    private int recovered;

    public SIRServiceImpl(Plague plague) {
        Beta = plague.getBeta();
        Gamma = plague.getGama();
    }



    public List<Patient> calculateInfected(List<Patient> patientsList) {
        getPatientNumbers(patientsList);

        if(susceptible >= infected) {
            int newlyInfected = (int) (susceptible * getBeta());
            infected += newlyInfected;
            susceptible -= newlyInfected;

        } else {
            infected += susceptible;
            susceptible = 0;
        }
        return setPatientNumbers();
    }

    public List<Patient> calculateRecovered(List<Patient> patientsList) {
        getPatientNumbers(patientsList);
        int newlyRecovered = (int) (getGamma() * infected);
        recovered += newlyRecovered;
        infected -= newlyRecovered;

        return setPatientNumbers();
    }

    public double calculateSusceptible(List<Patient> patientsList) {

        return susceptible;
    }

    @Override
    public int getAllSusceptible() {
        return getSusceptible();
    }

    @Override
    public int getAllInfected() {
        return getInfected();
    }

    @Override
    public int getAllRecovered() {
        return getRecovered();
    }


    private void getPatientNumbers(List<Patient> patientsList) {
        susceptible = 0;
        infected = 0;
        recovered = 0;
        for (Patient patient : patientsList) {
            if (patient.getStatus() == Status.infected && !patient.isVaccinated()) {
                infected++;
            }
            if (patient.getStatus() == Status.susceptible) {
                susceptible++;
            }
            if (patient.getStatus() == Status.recovered) {
                recovered++;
            }
        }
    }

    private List<Patient> setPatientNumbers() {
        List<Patient> patientsList = new ArrayList<>();
        for (int i = 0; i < susceptible; i++) {
            patientsList.add(new Patient(Status.susceptible));
        }
        for (int i = 0; i < infected; i++) {
            patientsList.add(new Patient(Status.infected));
        }
        for (int i = 0; i < recovered; i++) {
            patientsList.add(new Patient(Status.recovered));
        }
        return  patientsList;
    }


    public double getBeta() {
        return Beta;
    }

    public void setBeta(double beta) {
        Beta = beta;
    }

    public double getGamma() {
        return Gamma;
    }

    public void setGamma(double gamma) {
        Gamma = gamma;
    }

    public int getSusceptible() {
        return susceptible;
    }

    public int getInfected() {
        return infected;
    }

    public int getRecovered() {
        return recovered;
    }
}
