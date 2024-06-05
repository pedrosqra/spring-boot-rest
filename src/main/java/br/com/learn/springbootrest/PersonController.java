package br.com.learn.springbootrest;

import br.com.learn.springbootrest.data.vo.v1.PersonVO;
import br.com.learn.springbootrest.data.vo.v2.PersonVOV2;
import br.com.learn.springbootrest.services.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findPersonVO(@PathVariable(value = "id") Long id) {
        return personServices.findById(id);
    }

    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return personServices.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO person) {
        return personServices.create(person);
    }

    @PostMapping(
            value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return personServices.createV2(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO person) {
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
