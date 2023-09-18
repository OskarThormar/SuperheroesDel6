package superhero;

import java.util.Objects;

public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private int strength;

    public Superhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength){
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }
    public String getName(){
        return name;
    }
    public String getRealName(){
        return realName;
    }
    public String getSuperPower(){
        return superPower;
    }
    public int getYearCreated(){
        return yearCreated;
    }
    public String getIsHuman(){
        return isHuman;
    }
    public int getStrength(){
        return strength;
    }

    public String toString(){
        return "Superhero{" +
                "name='" + name +'\'' +
                ", realName='" + realName + '\'' +
                ", superPower='" + superPower + '\'' +
                ", isHuman='" + isHuman + '\'' +
                ", strength='" + strength + '\'' +
                '}';
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public void setSuperPower(String superPower){
        this.superPower = superPower;
    }
    public void setYearCreated(int yearCreated){
        this.yearCreated = yearCreated;
    }
    public void setIsHuman(String isHuman){
        this.isHuman = isHuman;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero superhero = (Superhero) o;
        return Objects.equals(name, superhero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
