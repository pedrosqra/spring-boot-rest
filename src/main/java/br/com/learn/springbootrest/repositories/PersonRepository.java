package br.com.learn.springbootrest.repositories;

import br.com.learn.springbootrest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {








}
