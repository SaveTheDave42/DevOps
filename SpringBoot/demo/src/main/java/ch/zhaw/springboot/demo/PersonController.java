package ch.zhaw.springboot.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class PersonController {
    private Map<Integer, Person> persons = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.persons.put(1, new Person(1, "Hans"));
        this.persons.put(2, new Person(2, "Peter"));
        System.out.println("Init Data");
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return this.persons.get(id);
    }

    @PostMapping("/person")
    public void createPerson(@RequestBody Person todo) {
        var newId = this.persons.keySet ().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        todo.setId(newId);
        this.persons.put(newId, todo);
    }

    @PutMapping("/person/{id}")
    public void updatePerson(@PathVariable Integer key, @RequestBody Person person) {
        person.setId(key);
        this.persons.put(key, person);
    }

    @DeleteMapping("/person/{id}")
    public Person deletePerson(@PathVariable Integer id) {
        return this.persons.remove(id);
    }
}
