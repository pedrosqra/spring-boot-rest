package br.com.rest.services;

import br.com.rest.data.vo.v1.PersonVO;
import br.com.rest.data.vo.v2.PersonVOV2;
import br.com.rest.exceptions.ResourceNotFoundException;
import br.com.rest.mapper.DozerMapper;
import br.com.rest.mapper.custom.PersonMapper;
import br.com.rest.model.Person;
import br.com.rest.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    PersonRepository repository;

    PersonMapper mapper;

    public PersonServices(PersonRepository personRepository, PersonMapper personMapper) {
        this.repository = personRepository;
        this.mapper = personMapper;
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), Person.class);
        return DozerMapper.parseObject(vo, PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person (V2)");

        var entity = mapper.convertVOToEntity(person);

        var vo = mapper.convertEntityToVO(repository.save(entity));
        return DozerMapper.parseObject(vo, PersonVOV2.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), Person.class);
        return DozerMapper.parseObject(vo, PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));

        repository.delete(entity);
    }

    public List<PersonVO> findAll() {
        logger.info("Retrieving all people");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Find person by id: " + id);

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }
}
