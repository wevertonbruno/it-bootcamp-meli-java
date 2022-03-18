package br.com.meli.spring2pratica2.services;

import br.com.meli.spring2pratica2.repositories.PersonRepository;
import br.com.meli.spring2pratica2.services.DTO.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> findAll(){
        return personRepository.findAll().stream()
                .map(PersonDTO::fromPerson)
                .collect(Collectors.toList());
    }
}
