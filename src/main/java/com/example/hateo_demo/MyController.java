package com.example.hateo_demo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MyController {

    public static final String TEMPLATE ="Hello, %s!";

    @GetMapping("/greeting")
    public HttpEntity<Greeting> greeting(@RequestParam(defaultValue = "world") String name) {
        Greeting greeting = new Greeting(String.format(TEMPLATE,name));
        Link link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController.class).greeting(name)).withSelfRel();
        greeting.add(link1);
        Link link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController.class).randomNumberGreeting()).withRel("random_number_greeting");
        greeting.add(link2);

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @GetMapping("/random")
    public HttpEntity<Double> randomNumberGreeting(){
        double res = 0;
        Random random = new Random();
        double rand1 = random.nextDouble();
        double rand2 = random.nextDouble();
        res = Math.pow(rand1, rand2);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
//