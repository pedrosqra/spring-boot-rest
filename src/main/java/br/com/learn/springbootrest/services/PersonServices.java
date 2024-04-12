package br.com.learn.springbootrest.services;

import br.com.learn.springbootrest.data.vo.v1.PersonVO;
import br.com.learn.springbootrest.exceptions.ResourceNotFoundException;
import br.com.learn.springbootrest.mapper.DozerMapper;
import br.com.learn.springbootrest.model.Person;
import br.com.learn.springbootrest.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    PersonRepository repository;

    public PersonServices(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), Person.class);
        return DozerMapper.parseObject(vo, PersonVO.class);


    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), Person.class);
        return DozerMapper.parseObject(vo, PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));

        repository.delete(entity);
    }

    public List<PersonVO> findAll() {
        logger.info("Retrieving all people");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Find person by id: " + id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }
}
