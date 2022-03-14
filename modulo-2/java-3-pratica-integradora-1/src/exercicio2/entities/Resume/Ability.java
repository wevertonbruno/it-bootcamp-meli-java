package exercicio2.entities.Resume;

public class Ability {
    private String name;
    private AbilityLevel level;

    public Ability(String name, AbilityLevel level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
