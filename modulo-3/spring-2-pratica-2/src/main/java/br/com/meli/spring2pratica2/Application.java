package br.com.meli.spring2pratica2;

import br.com.meli.spring2pratica2.entities.Person;
import br.com.meli.spring2pratica2.entities.Sport;
import br.com.meli.spring2pratica2.entities.SportNivel;
import br.com.meli.spring2pratica2.repositories.PersonRepository;
import br.com.meli.spring2pratica2.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private SportRepository sportRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sport football = Sport.of("Football", SportNivel.EASY);
		Sport handball = Sport.of("Handball", SportNivel.HARD);
		Sport voleyball = Sport.of("Voleyball", SportNivel.HARD);
		Sport basketball = Sport.of("Basketball", SportNivel.MEDIUM);

		Arrays.asList(football, handball, voleyball, basketball)
				.forEach(sportRepository::create);

		Arrays.asList(
				Person.of("Weverton", "Bruno", 26, handball),
				Person.of("Valeria", "Damasceno", 25, basketball),
				Person.of("Gilberto", "Alves", 22, voleyball),
				Person.of("Thielli", "Alves", 24, football)
		).forEach(personRepository::create);
	}
}
