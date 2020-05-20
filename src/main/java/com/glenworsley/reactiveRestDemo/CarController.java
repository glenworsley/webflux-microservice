package com.glenworsley.reactiveRestDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CarController {

    private CarRepository carRepository;

    @GetMapping("/cars")
    public Flux<Car> all() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Mono<Car> getCar(@PathVariable String id) {
        return carRepository.findById(id);
    }

}
