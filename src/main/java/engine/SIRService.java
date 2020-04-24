package engine;

import model.Patient;

import java.util.List;

public interface SIRService {
    List<Patient> calculateInfected(List<Patient> patientsList);
    List<Patient> calculateRecovered(List<Patient> patientsList);
    double calculateSusceptible(List<Patient> patientsList);
    int getAllSusceptible();
    int getAllInfected();
    int getAllRecovered();
}
