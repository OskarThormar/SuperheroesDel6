package database;
import superhero.Superhero;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database db;
    private Superhero superhero1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        db = new Database();
        superhero1 = new Superhero("Clark Kent", "Superman", "Flyve, styrke, laserstråler og røntgensyn", 1938, "ja", 100);
        //db.addSuperhero(superhero1);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        db = null;
    }

    @org.junit.jupiter.api.Test
    void addSuperhero() {
        Superhero expectedName = superhero1;
        Superhero actualName = db.superhero1
    }

    @org.junit.jupiter.api.Test
    void searchForSuperheroes() {
        // Arrange
        String name = "Superman";
        String realName = "Clark Kent";
        String superPower = "flyve, laserstråler, styrke og røntgensyn";
        int yearCreated = 1938;
        String isHuman = "ja";
        int strength = 100;
        // Act
        Superhero actualName = db.searchForSuperheroes(name);
        // Assert
        Superhero expectedName = superhero1;
        assertEquals(expectedName, actualName);
    }
}