import superhero.Superhero;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Controller cl;
    public UserInterface(){
        this.cl = new Controller();
    }
    private Scanner scanner = new Scanner(System.in);

    public void startProgram(){
        int userSelection = 1;
        do{
            System.out.println("""
                    Velkommen til SUPERHERO UNIVERSET
                    
                    1.  Opret superhelt
                    2.  Vis superhelt liste
                    3.  Søg efter en superhelt
                    4.  Rediger en superhelt
                    9.  Afslut
                    """);
            System.out.println("Enter selection: ");
            userSelection = scanner.nextInt();
            scanner.nextLine();
            handleUserSelection(userSelection);
        }
        while(userSelection != 9);
    }


    private void handleUserSelection(int userSelection){
        switch (userSelection){
            case 1:
                opretSuperhelt();
            case 2:
                showSuperheroes();
            case 3:
                searchForSuperhero();
            case 4:
                editSuperhero();
            default:
                break;
        }
    }
    /*     if (scanner.hasNextInt()) {
           userSelection = scanner.nextInt();
           scanner.nextLine();
           handleUserSelection(userSelection);
       } else {
           System.out.println("Ugyldigt valg ... prøv igen");
           scanner.nextLine();
       }*/
    public void opretSuperhelt(){
        System.out.println("Indtast navn");
        String name = scanner.nextLine();
        System.out.println("Indtast rigtige navn");
        String realName = scanner.nextLine();
        System.out.println("Indtast super power");
        String superPower = scanner.nextLine();
        System.out.println("Indtast år skabt");
        int yearCreated = scanner.nextInt();
        System.out.println("Indtast om menneske eller ej");
        String isHuman = scanner.nextLine();
        System.out.println("Indtast styrke niveau");
        int strength = scanner.nextInt();
        cl.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);
    }
    public void showSuperheroes() {
        if (cl.getSuperheroes().isEmpty())
            System.out.println("Der er ingen personer i databasen");
        else {
            System.out.println("Personer i database");
            for (Superhero p : cl.getSuperheroes()) {
                System.out.println(p);
            }
        }
    }
    public void searchForSuperhero(){
        boolean fundet = false;
        System.out.println("Indtast et navn du vil søge efter");
        String nameSearch = scanner.nextLine();
        for (Superhero s : cl.getSuperheroes()) {
            if (s.getName().equals(nameSearch)) {
                System.out.println("Superhelt fundet: " + s);
                fundet = true;
            }
        }
        if (!fundet)System.out.println("Kunne ikke finde: " + nameSearch + " i listen");
    }

    // har et kommunikations problem jeg ikke kunne fixe i tide.

    public void editSuperhero() {
        System.out.println("Indtast søgekriterium for person");
        String userInput = scanner.nextLine();
        Superhero superHeroToEdit = null;

        ArrayList<Superhero> searchResult = cl.getSearchForMultipleSuperheroes(userInput);
        for (Superhero s: searchResult
             ) {
            System.out.println(s);
        }

        if (searchResult.isEmpty()) {
            System.out.println("Der findes ingen personer der opfylder søgekriterium");

        } else {
            System.out.println("Vælg person");
            int count = 0;
            for (Superhero s : searchResult) {
                System.out.println((1+count++) + ". " +
                        s.getName() + " " +
                        s.getRealName() + " " +
                        s.getSuperPower() + " " +
                        s.getYearCreated() + " " +
                        s.getIsHuman() + " " +
                        s.getStrength()
                );
            }
            int superheroChoice = scanner.nextInt();
            scanner.nextLine();
            superHeroToEdit = searchResult.get(superheroChoice -1);
        }


        if (superHeroToEdit != null) {
            System.out.println("Rediger superhelt. Tryk ENTER hvis information ikke skal redigeres.");
            String newValue;
            editName(scanner,superHeroToEdit);
            /*System.out.println("Superhelte navn: " + superHeroToEdit.getName());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superHeroToEdit.setName(newValue);
            }*/
            System.out.println("Rigtige navn: " + superHeroToEdit.getRealName());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superHeroToEdit.setRealName(newValue);
            }
            System.out.println("Superkraft: " + superHeroToEdit.getSuperPower());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superHeroToEdit.setSuperPower(newValue);
            }
            System.out.println("År skabt: " + superHeroToEdit.getYearCreated());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superHeroToEdit.setYearCreated(Integer.parseInt(newValue));
            }
            System.out.println("Er menneske [ja/nej]: " + superHeroToEdit.getIsHuman());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superHeroToEdit.setIsHuman(newValue);
            }
            System.out.println("Styrke: " + superHeroToEdit.getStrength());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superHeroToEdit.setStrength(Integer.parseInt(newValue));
            }
            System.out.println(superHeroToEdit + " er opdateret.");
        }
    }
    private void editName(Scanner scanner,Superhero superHeroToEdit){
        String newValue;
        System.out.println("Superhelte navn: " + superHeroToEdit.getName());
        newValue = scanner.nextLine();
        if (!newValue.isEmpty()) {
            superHeroToEdit.setName(newValue);
        }
    }
}
