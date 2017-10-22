package terekhin.person;

/**
 * Created by Nick on 22.10.17.
 */
public class Person {
    private String name;
    private Person spouse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }
}
