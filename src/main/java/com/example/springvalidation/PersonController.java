package com.example.springvalidation;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @PutMapping
    Person putPerson(@RequestBody @Valid Person person) {
        if (person.firstname().equalsIgnoreCase("Pumuckl")) {
            throw new UnwantedUserException();
        }
        return person;
    }

    @ExceptionHandler(UnwantedUserException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ErrorMessage handleUnwantedUserException() {
        return new ErrorMessage("Leider nicht zugelassen");
    }
}
