import database.Database;
import superhero.Superhero;

import java.util.ArrayList;

public class Controller {
    private Database db;
    public Controller() {
        this.db = new Database();
        db.addSuperhero("Scarlet Witch", "Wanda Maximoff", "Psionics og magiker", 1968, "ja", 79);
        db.addSuperhero("Black Widow", "Natasha Romanoff", "Ingen", 1968, "ja", 22);
        db.addSuperhero("Iron man", "Tony Stark", "Ingen", 1963, "ja", 74);
        db.addSuperhero("Captain America", "Steve Rogers", "Artificial Enhanded Physiology", 1940, "ja", 85);
        db.addSuperhero("Thor", "Thor", "Asgardian Physiology, Mjølnir", 1962, "nej", 100);
    }


    public void addSuperhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        db.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);
    }
    public ArrayList<Superhero> getSuperheroes() {
        return db.getSuperheroes();
    }
    public String getIndexedSuperheroes(){
        return db.getIndexedSuperheroes();
    }
    // search funktion problem i database -> controller -> UI kæden.
    public Superhero getSearchForSingleSuperhero(String name){
        return db.searchForSuperheroes(name);
    }
    public ArrayList<Superhero> getSearchForMultipleSuperheroes(String name){
        return db.getSearchForMultipleSuperheroes(name);
    }
}
