package br.com.meli.spring2pratica2.services.DTO;

import br.com.meli.spring2pratica2.entities.Person;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private String name;
    private String surname;
    private String sportName;

    private PersonDTO(String name, String surname, String sportName) {
        this.name = name;
        this.surname = surname;
        this.sportName = sportName;
    }

    public static PersonDTO fromPerson(Person person){
        return new PersonDTO(
                person.getName(),
                person.getSurname(),
                person.getSport().getName()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public String   toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sportName='" + sportName + '\'' +
                '}';
    }
}
