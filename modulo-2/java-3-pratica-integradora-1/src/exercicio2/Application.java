package exercicio2;

import exercicio2.entities.Book;
import exercicio2.entities.Printable;
import exercicio2.entities.Report;
import exercicio2.entities.Resume.Ability;
import exercicio2.entities.Resume.AbilityLevel;
import exercicio2.entities.Resume.PersonalData;
import exercicio2.entities.Resume.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Printable> printerQueue = new ArrayList<>();
        Resume resume = new Resume(
                new PersonalData("Weverton Bruno", "oieusouweverton@hotmail.com", "Engenheiro da Computacao"),
                Arrays.asList(
                        new Ability("Java", AbilityLevel.INTERMEDIATE),
                        new Ability("PHP", AbilityLevel.ADVANCED),
                        new Ability("Javascript", AbilityLevel.ADVANCED)
                )
        );
        Book book = new Book("Java Efetivo", "Joshua Bloch", "Education", 405);
        Report report = new Report("Relatorio de gastos mensais", "Weverton Bruno", "Valeria Damasceno", 10);

        printerQueue.addAll(Arrays.asList(resume, book, report));
        printerQueue.forEach(doc -> doc.print());
    }
}
