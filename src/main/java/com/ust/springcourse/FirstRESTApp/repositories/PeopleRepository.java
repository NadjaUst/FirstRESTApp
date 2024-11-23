package com.ust.springcourse.FirstRESTApp.repositories;

import com.ust.springcourse.FirstRESTApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
