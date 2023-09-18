package database;
import superhero.Superhero;

import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    Superhero superhero1 = new Superhero("Superman", "Clark Kent", "Flyve, Styrke, laserstråler og røntgensyn", 1938, "ja", 100);


    public void addSuperhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        superheroes.add(new Superhero(name, realName, superPower, yearCreated, isHuman, strength));
    }
    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }


    public Superhero searchForSuperheroes(String name) {
        for (Superhero S : superheroes) {
            if (S.getName().equals(name)) {
                return S;
            }
        }
        return null;
    }
    public ArrayList<Superhero> getSearchForMultipleSuperheroes(String name){
            ArrayList<Superhero> temp = new ArrayList<>();
        for (Superhero S : superheroes) {
            if (S.getName().startsWith(name)) {
                temp.add(S);
            }
        }
        return temp;
    }
    public String getIndexedSuperheroes(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Superhero IS : superheroes){
            stringBuilder.append(superheroes.indexOf(IS) + 1);
            stringBuilder.append(" ");
            stringBuilder.append(IS);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
