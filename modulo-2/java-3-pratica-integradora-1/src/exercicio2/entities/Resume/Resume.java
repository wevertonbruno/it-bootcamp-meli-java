package exercicio2.entities.Resume;

import exercicio2.entities.Printable;

import java.util.ArrayList;
import java.util.List;

public class Resume implements Printable {
    private PersonalData personalData;
    List<Ability> abilities = new ArrayList<Ability>();

    public Resume(PersonalData personalData, List<Ability> abilities) {
        this.personalData = personalData;
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "personalData=" + personalData +
                ", abilities=" + abilities +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
