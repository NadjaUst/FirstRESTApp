package com.ust.springcourse.FirstRESTApp.services;

import com.ust.springcourse.FirstRESTApp.models.Person;
import com.ust.springcourse.FirstRESTApp.repositories.PeopleRepository;
import com.ust.springcourse.FirstRESTApp.util.PersonNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundExeption::new);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);

    }
}
