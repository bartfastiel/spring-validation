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
        return person;
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, Object> handleException() {
        return Map.of("reason", "Invalid input");
    }
}
