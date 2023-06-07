package com.example.springvalidation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @PutMapping
    Person putPerson(@RequestBody @Valid Person person) {
        if (person.firstname().equalsIgnoreCase("Pumuckl")) {
            throw new IllegalStateException("Darf nicht rein");
        }
        return person;
    }

    @ExceptionHandler({IllegalStateException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    Map<String, Object> handleIllegalStateException(IllegalStateException e) {
        return Map.of("reason", e.getMessage());
    }
}
