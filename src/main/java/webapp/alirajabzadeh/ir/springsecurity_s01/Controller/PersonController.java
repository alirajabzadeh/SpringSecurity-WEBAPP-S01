package webapp.alirajabzadeh.ir.springsecurity_s01.Controller;

import org.springframework.web.bind.annotation.*;
import webapp.alirajabzadeh.ir.springsecurity_s01.Exception.PersonNotFoundException;
import webapp.alirajabzadeh.ir.springsecurity_s01.Model.Person;
import webapp.alirajabzadeh.ir.springsecurity_s01.Model.Phone;
import webapp.alirajabzadeh.ir.springsecurity_s01.Repository.PersonRepository;
import webapp.alirajabzadeh.ir.springsecurity_s01.Repository.PhoneRepository;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PhoneRepository phoneRepository;

    public PersonController(PersonRepository personRepository, PhoneRepository phoneRepository) {
        this.personRepository = personRepository;
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/persons")
    List<Person> getAll(){
        return personRepository.findAll();
    }

    @GetMapping("/persons/{pid}")
    Person getOne(@PathVariable Long pid) {
        return personRepository.findById(pid)
                .orElseThrow(() -> new PersonNotFoundException(pid));
    }

    @PostMapping("/persons")
    Person createOne(@RequestBody Person person) {
        return personRepository.save(person);
    }


    @DeleteMapping("/persons/{pid}")
    void deleteOne(@PathVariable Long pid) {
        personRepository.deleteById(pid);
    }

    @PutMapping("/persons/{pid}")
    Person updateOne(@RequestBody Person newPerson, @PathVariable Long pid) {
        return personRepository.findById(pid)
                .map(person -> {
                    person.setFIRST_NAME(newPerson.getFIRST_NAME());
                    person.setLAST_NAME(newPerson.getLAST_NAME());
                    person.setAddress(newPerson.getAddress());
                    person.setNationalIdentity(newPerson.getNationalIdentity());
                    person.setPhoneList(newPerson.getPhoneList());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(pid);
                    return personRepository.save(newPerson);
                });
    }

    @PutMapping("/persons/{pid}/phones")
    Person assignPhone(@PathVariable Long pid, @RequestBody Phone phone) {
        Person person = personRepository.findById(pid).orElseThrow(() -> new PersonNotFoundException(pid));
        person.assignPhone(phone);
        phoneRepository.save(phone);
        return person;
    }
}
