package engine.gui;

import engine.SIRService;
import engine.impl.SIRServiceImpl;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    public UserInterface() {
        runTheGame();
    }

    private void runTheGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            int population = 1000000;
            Bacteria bacteria = new Bacteria(0.1, 0.01);
            Virus virus = new Virus(0.1, 0.01);
            bacteria.setName("Corona20");
            virus.setName("Corona20");

            System.out.print("Play as bacteria or virus? B/V (default is V)");
            String isbacteria = scanner.nextLine();
            SIRService sirService;
            if(isbacteria.toLowerCase().equals("b")) {
                sirService = new SIRServiceImpl(bacteria);
            } else {
                sirService = new SIRServiceImpl(virus);
            }


            List<Patient> patientsList = new ArrayList<>();

            System.out.print("Use SIRF model? Y/N (default is SIR)");
            String isSirf = scanner.nextLine();
            if (isSirf.toLowerCase().equals("y")) {
                for (int i = 0; i < population; i++) {
                    patientsList.add(new Patient(Status.susceptible));
                    if (i <= population / 10) {
                        patientsList.get(i).setVaccinated(true);
                    } else {
                        patientsList.get(i).setVaccinated(false);
                    }

                }
            } else {
                for (int i = 0; i < 1000000; i++) {
                    patientsList.add(new Patient(Status.susceptible));
                    patientsList.get(i).setVaccinated(false);
                }
            }


            patientsList.add(new Patient(Status.infected));


            int day = 0;
            while (true) {
                System.out.print("Day: " + day++);
                System.out.print("Press enter for the next day");
                String input = scanner.nextLine();  // Read user input

                patientsList = sirService.calculateInfected(patientsList);
                patientsList = sirService.calculateRecovered(patientsList);
                System.out.println(sirService.getAllSusceptible());
                System.out.println(sirService.getAllInfected());
                System.out.println(sirService.getAllRecovered());
                Random random = new Random();
                int numberOfMutation = random.nextInt(10 - 1 + 1) + 1;
                if(numberOfMutation < 4) {
                    virus.generateRandomEvent();
                    bacteria.generateRandomEvent();
                    System.out.print("OOOOOOO " + virus.getName() + " has mutated ruuuuuuuun!!!");
                }

            }

        }

    }
}
