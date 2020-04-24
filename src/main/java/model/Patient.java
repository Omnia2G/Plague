package model;

public class Patient {
    Status status;
    boolean isVaccinated;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Patient(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "status=" + status +
                '}';
    }
}
