package exercicio2.entities.Resume;

public enum AbilityLevel {
    BEGGINER (1, "Begginer"),
    INTERMEDIATE (2, "Intermediate"),
    ADVANCED (3, "Advanced");

    private final Integer level;
    private final String description;

    AbilityLevel(Integer level, String description) {
        this.level = level;
        this.description = description;
    }
}
